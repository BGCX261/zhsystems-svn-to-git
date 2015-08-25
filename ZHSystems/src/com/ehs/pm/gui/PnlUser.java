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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import com.ehs.AppFrame;
import com.ehs.auth.SecurityManager;
import com.ehs.common.gui.HPanel;
import com.ehs.common.gui.HPanelInterface;
import com.ehs.exceptions.InvalidDataException;
import com.ehs.hiber.HibernateManager;
import com.ehs.hiber.beans.Role;
import com.ehs.hiber.beans.User;

/**
 * 
 * @author swaram
 */
public class PnlUser extends HPanel implements HPanelInterface {

	private static final long serialVersionUID = 7660939183313957956L;
	
	private Logger log = AppFrame.getLogger();
	
	private HPanel pnlMain;
	private HPanel pnlButtons;
	private JLabel lblUserName;
	private JTextField txfUserName;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JLabel lblFirstName;
	private JTextField txfFirstName;
	private JLabel lblLastName;
	private JTextField txfLastName;
	private JLabel lblActive;
	private JCheckBox chbActive;
	private JLabel lblRole;
	private JComboBox cmbRole;
	private JButton btnOK;
	private JButton btnCancel;
	private JInternalFrame parent;
	private HPanel pnlLabels;
	private HPanel pnlFields;
	
	private User user = null;

	public PnlUser() {
		try {
			initComponents();
		} catch (Exception ex) {
			log.error("Error while initializing the components"+ex.toString());
		}
	}

	public PnlUser(JInternalFrame parent) {
		this.parent = parent;
		try {
			initComponents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		init();
	}

	private void initComponents() throws Exception {
		pnlMain = new HPanel();
		pnlButtons = new HPanel();
		pnlLabels = new HPanel();
		pnlFields = new HPanel();

		lblUserName = new JLabel();
		txfUserName = new JTextField();
		lblPassword = new JLabel();
		passwordField = new JPasswordField();
		lblFirstName = new JLabel();
		txfFirstName = new JTextField();
		lblLastName = new JLabel();
		txfLastName = new JTextField();

		lblActive = new JLabel();
		chbActive = new JCheckBox();
		lblRole = new JLabel();
		cmbRole = new JComboBox();
		btnOK = new JButton();
		btnCancel = new JButton();

		this.setLayout(new BorderLayout());
		this.add(pnlMain, BorderLayout.CENTER);

		pnlMain.setLayout(new BorderLayout());
		pnlMain.add(pnlLabels, BorderLayout.WEST);
		pnlMain.add(pnlFields, BorderLayout.CENTER);

		pnlMain.setBorder(BorderFactory
				.createTitledBorder("Enter Information:"));
		pnlLabels.setLayout(new GridLayout(6, 1, 5, 5));
		pnlFields.setLayout(new GridLayout(6, 1, 5, 5));
		lblUserName.setText("User Name: ");
		pnlLabels.add(lblUserName);
		pnlFields.add(txfUserName);
		lblPassword.setText("Password: ");
		pnlLabels.add(lblPassword);
		pnlFields.add(passwordField);
		lblFirstName.setText("First Name: ");
		pnlLabels.add(lblFirstName);
		pnlFields.add(txfFirstName);
		lblLastName.setText("Last Name: ");
		pnlLabels.add(lblLastName);
		pnlFields.add(txfLastName);
		lblActive.setText("Active: ");
		pnlLabels.add(lblActive);
		pnlFields.add(chbActive);
		lblRole.setText("Role: ");
		pnlLabels.add(lblRole);
		pnlFields.add(cmbRole);

		this.add(pnlButtons, BorderLayout.SOUTH);
		pnlButtons.setBorder(BorderFactory.createEtchedBorder());
		pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlButtons.add(btnOK);
		btnOK.setText("OK");
		pnlButtons.add(btnCancel);
		btnCancel.setText("Cancel");

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				closePanel();
			}
		});

		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (saveData()) {
					closePanel();
				}
			}
		});

		txfUserName.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				loadData();
			}
		});
	}

	private void init() {
		// load the roles
		List<Object> listRoles = HibernateManager.getInstance().getObjects(new Role());
		if(listRoles != null && !listRoles.isEmpty()) {
			for(Object obj: listRoles) {
				cmbRole.addItem(obj);
			}
		}
	}
	

	
	private void loadData() {
		final String key = "username";
		final String value = txfUserName.getText().trim();
		List<Object> listUsers = HibernateManager.getInstance().getObjects(new User(), key, value);
		if (listUsers != null && !listUsers.isEmpty()) {
			loadData(listUsers.iterator().next());
		}
	}

	public void loadData(Object obj) {
		if (obj != null && obj instanceof User) {
			user = (User) obj;

			txfUserName.setText(user.getUsername());
			passwordField.setText(user.getPassword());
			txfFirstName.setText(user.getFirstName());
			txfLastName.setText(user.getLastName());
			chbActive.setSelected(user.getActive() == 'Y' ? true : false);
		}
	}

	public boolean saveData() {
		boolean result = false;
		User usr = this.user;
		if(usr == null) {
			usr = new User();
		}
		
		usr.setUsername(txfUserName.getText().trim());
		try {
			usr.setPassword(SecurityManager.encrypt(new String(passwordField.getPassword())));
		} catch (Exception e) {
			log.error("Error while encrypting the password"+e.toString());
		}
		usr.setFirstName(txfFirstName.getText().trim());
		usr.setLastName(txfLastName.getText().trim());
		usr.setRoldId("Admin");
		usr.setActive(chbActive.isSelected() ? 'Y' : 'N');
		usr.setCreatedDate(new Date());
		usr.setUpdatedDate(new Date());
		usr.setUpdatedBy(usr.getUsername());
		usr.setCreatedBy(usr.getUsername());
		if (isValidData()) {
			if(usr.getId() == -1) {
				result = HibernateManager.getInstance().saveObject(usr);
			} else {
				result = HibernateManager.getInstance().updateObject(usr);
			}
		}
		return result;
	}

	public boolean isValidData() throws InvalidDataException {
		if (txfUserName.getText().trim().length() == 0) {
			return false;
		}
		return true;
	}

	public void closePanel() {
		if (parent != null) {
			parent.dispose();
		}

	}
}
