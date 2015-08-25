/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehs.pm.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.ehs.AppFrame;
import com.ehs.auth.SecurityManager;
import com.ehs.common.gui.HDialog;
import com.ehs.common.gui.HPanel;
import com.ehs.common.HSConstantsI;
import com.ehs.hiber.HibernateManager;
import com.ehs.hiber.beans.User;
import com.ehs.pm.dblayer.DataManager;

/**
 *
 * @author E15567
 */
public class LoginDialog extends HDialog implements HSConstantsI {

    private static final long serialVersionUID = -6693311337186004336L;
    Logger log = AppFrame.getLogger();
    private HPanel pnlMain;
    private JLabel lblUserId;
    private JLabel lblPassword;
    private JTextField txfUserId;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JButton btnCancel;
    private JPanel pnlButtons;
    private AppFrame parent = null;

    public LoginDialog(AppFrame parent) {
        this.parent = parent;
        try {
            initComponents();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        init();
    }

    private void initComponents() throws Exception {

        pnlMain = new HPanel();

        lblUserId = new JLabel();
        lblPassword = new JLabel();

        txfUserId = new JTextField();
        passwordField = new JPasswordField();

        pnlMain.setLayout(new GridLayout(2, 2, 5, 5));
        pnlMain.add(lblUserId);
        lblUserId.setText("Username:");
        pnlMain.add(txfUserId);
        pnlMain.add(lblPassword);
        lblPassword.setText("Password:");
        pnlMain.add(passwordField);
        pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");
        pnlButtons.add(btnLogin);
        pnlButtons.add(btnCancel);
        this.setLayout(new BorderLayout());
        this.add(pnlMain, BorderLayout.CENTER);
        this.add(pnlButtons, BorderLayout.SOUTH);

        pnlMain.setBorder(BorderFactory.createTitledBorder("Login in to Hospital Sytem:"));
        pnlButtons.setBorder(BorderFactory.createEtchedBorder());
    }

    private void init() {
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                processUser();
            }
        });

        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

    }

	private void processUser() {
		String userId = txfUserId.getText();
		char[] pw = passwordField.getPassword();
		User user = getUser(userId);
		try {
			if (user != null) {
				String pwd = new String(pw);
				String encryptPwd = SecurityManager.encrypt(pwd);
				if (encryptPwd.equalsIgnoreCase(user.getPassword())) {
					success(user);
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"Username/password wrong, please try again");
			}
		} catch (Exception e) {
			log.error("Error while validating the user :" + e.toString());
			JOptionPane.showMessageDialog(this,
					"Username/password wrong, please try again");
		}
	}

    private void success(User user) {
        if(user != null && parent != null) {
            parent.setUserTitle(user);
            com.ehs.auth.SecurityManager.getInstance().setUser(user);
        }
        LoginDialog.this.dispose();

    }

    public void launchDialog() {
        this.setSize(300, 140);
        this.setModal(true);
        this.setLocationRelativeTo(parent);
        this.setTitle("Login");
        this.setVisible(true);

    }

//    private User getUser(String userId) {
//        User result = null;
//        try {
//            File pFile = new File(USER_BASE_XML_PATH + "/" + userId + ".xml");
//            if (pFile != null) {
//            	
//            	result = (User) DataManager.getInstance().getObject(pFile);
////            	
////                HashMap hints = new HashMap();
////                hints.put(User.class.getSimpleName(), User.class);
////                SlashHandler handler = new SlashHandler(hints, true);
////                SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
////                parser.parse(pFile, handler);
////                result = (User) handler.getResult();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
    
    
	private User getUser(final String userId) {
		User result = null;
		try {
			final String key = "username";
			List<Object> listUsers = HibernateManager.getInstance().getObjects(new User(), key, userId);
			if (listUsers != null && !listUsers.isEmpty()) {
				result = (User) listUsers.iterator().next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
    
}
