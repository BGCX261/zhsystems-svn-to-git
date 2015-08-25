package com.ehs;

import com.ehs.pm.beans.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.WriterAppender;

import com.ehs.common.HSConstantsI;
import com.ehs.common.PropertiesLoader;
import com.ehs.pm.gui.LoginDialog;
import com.ehs.pm.gui.PatientFrame;
import com.ehs.pm.gui.PhysicianDesktopFrame;
import com.ehs.pm.gui.UserFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AppFrame extends JFrame implements HSConstantsI, ActionListener {

    private static final long serialVersionUID = -8943168824533253080L;
    private static Logger logger = Logger.getLogger(AppFrame.class);
    private PatientFrame patientFrame = null;
    private PhysicianDesktopFrame physicianDesktopFrame = null;
    private UserFrame userFrame;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuEntry;
    private JMenuItem menuPhysicianDesktop;
    private JMenuItem menuPatientMangement;
    private JMenu menuFunctions;
    
    private JMenu menuMaintance;
    private JMenuItem menuUserMaintenance;

//    private JPanel pnlButtons;
//    private JButton btnPatientManagement;
//    private JButton btnPhysicianDesktop;

    private JDesktopPane desktopPane;

    public AppFrame() {
        this.setLookAndFeel();
        try {
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(HS_APP_WIDTH, HS_APP_HEIGHT);
        this.setIconImage(new ImageIcon(this.getClass().getResource(TITLE_ICON)).getImage());
        this.setTitle("Electronic Hospital System");
        this.setVisible(true);
        
        //@ TODO Enable the login dialog
        //new LoginDialog(this).launchDialog();
    }

    private void initComponents() throws Exception {
        this.startLogging();
        desktopPane = new JDesktopPane();
//        btnPatientManagement = new JButton("Patient Management");
//        btnPhysicianDesktop = new JButton("Physician Desktop");
//        getContentPane().setLayout(new BorderLayout());
//        pnlButtons = new JPanel();
//        pnlButtons.setBackground(Color.GRAY);
//        pnlButtons.setBorder(BorderFactory.createEtchedBorder());
//        getContentPane().add(pnlButtons, BorderLayout.WEST);
//        getContentPane().add(desktopPane, BorderLayout.CENTER);
        this.setContentPane(desktopPane);
        
//        pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
//        pnlButtons.add(btnPatientManagement);
//        btnPatientManagement.setPreferredSize(new Dimension(100, 40));
        
        this.setUpMenu();
    }

    private void setUpMenu() {

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        menuEntry = new JMenu("Entry");
        menuBar.add(menuEntry);
        
        menuMaintance = new JMenu("Maintenance");
        menuBar.add(menuMaintance);
        menuUserMaintenance = new JMenuItem("User Maintenance");
        menuMaintance.add(menuUserMaintenance);

        menuFunctions = new JMenu("Functions");
        menuBar.add(menuFunctions);

        menuPatientMangement = new JMenuItem("Patient Management");
        menuPhysicianDesktop = new JMenuItem("Physician Desktop");

        menuEntry.add(menuPatientMangement);
        menuEntry.add(menuPhysicianDesktop);

        menuPatientMangement.addActionListener(this);
        menuPhysicianDesktop.addActionListener(this);
        menuUserMaintenance.addActionListener(this);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            // UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            // UIManager.setLookAndFeel("com.easynth.lookandfeel.EaSynthLookAndFeel");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {

                public void run() {
                    new AppFrame();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuPatientMangement) {
            logger.debug("************Starting the patient managment system***********");
            patientFrame = new PatientFrame();
            desktopPane.add(patientFrame);
            patientFrame.setVisible(true);
        } else if(e.getSource() == menuPhysicianDesktop) {
            logger.debug("*********** Starting the desktop documentation system *******");
            physicianDesktopFrame = new PhysicianDesktopFrame();
            desktopPane.add(physicianDesktopFrame);
            physicianDesktopFrame.setVisible(true);
        } else if(e.getSource() == menuUserMaintenance) {
            logger.debug("************ Starting the user maaintenance ***************");
            userFrame = new UserFrame();
            desktopPane.add(userFrame);
            userFrame.setVisible(true);
        }
    }

    public void setUserTitle(User user) {
        if(user != null) {
            this.setTitle(this.getTitle()+" - "+user.getUserName() +" - Logged on: "+new Date());
        }
    }

    /**
     * Get the log4j.properties and create log file to log message
     */
    private void startLogging() {
        try {
            Properties props = PropertiesLoader.getPropertiesFromFile("com/ehs/log4j.properties");
            PropertyConfigurator.configure(props);
        } catch (Exception exp) {
            System.err.println("Could not load properties from classpath");
            exp.printStackTrace();;
        }

        // get filename based on today's date
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        DateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");

        String file_name = "HSystem-" + format1.format(date) + ".log";
        Writer appender_output = null;
        try {
            appender_output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_name, true)));
        } catch (FileNotFoundException fex) {
            System.err.println("File exception in logger " + fex.getMessage());
        }

        WriterAppender file_appendar = (WriterAppender) logger.getAppender("file_appender");
        file_appendar.setWriter((appender_output));
    }

    public static Logger getLogger() {
        if (logger != null) {
            return logger;
        }
        return null;
    }
}
