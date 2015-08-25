package com.ehs.pm.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.ehs.AppFrame;

import com.ehs.pm.beans.Patient;
import com.ehs.common.HSConstantsI;
import com.ehs.common.gui.HPanel;

import com.ehs.pm.dblayer.PatientActions;
import com.ehs.pm.tables.PatientTable;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This panel display the patient information
 * 
 * @author rnim
 * 
 */
public class PnlPatient extends HPanel implements ActionListener, HSConstantsI {

    private static final long serialVersionUID = 2842953675098235574L;
    private static final int FIELD_HEIGHT = 20;
    private static Logger logger = AppFrame.getLogger();
    private JLabel lblMedRecNo;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblSex;
    private JButton btnPatientImage;
    private JRadioButton rbtnMale;
    private JRadioButton rbtnFemale;
    private JLabel lblWeight;
    private JLabel lblHeight;
    private JLabel lblDateOfBirth;
    private JLabel lblHomePhone;
    private JLabel lblCellPhone;
    private JLabel lblEmail;
    private JLabel lblAddress;
    private JLabel lblCity;
    private JLabel lblState;
    private JLabel lblZipCode;
    private JTextField txfMedRecNo;
    private JTextField txfFirstName;
    private JTextField txfLastName;
    private JComboBox cmbSex;
    private JTextField txfWeight;
    private JTextField txfHeight;
    private JTextField txfDateOfBirth;
    private JTextField txfHomePhone;
    private JTextField txfCellPhone;
    private JTextField txfEmail;
    private JTextField txfAddress;
    private JTextField txfCity;
    private JTextField txfState;
    private JTextField txfZipCode;
    // Panels
    private JPanel pnlMain;
    private JPanel pnlSearch;
    private JPanel pnlPersonal;
    private JPanel pnlContact;
    private JPanel pnlButtons;
    private JPanel pnlLeftPersonalLabels;
    private JPanel pnlRightPersonalFields;
    private JPanel pnlLeftContactLabels;
    private JPanel pnlRightContactFields;
    // Buttons
    private JButton btnSearch;
    private JButton btnNew;
    private JButton btnApply;
    private JButton btnOk;
    private JButton btnPrint;
    private JButton btnCancel;
    private Patient patient = null;
    private JInternalFrame parent = null;

    public PnlPatient() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PnlPatient(JInternalFrame parent) {
        this.parent = parent;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initPanel();
    }

    /**
     * Initilization of the components
     *
     * @throws Exception
     */
    private void jbInit() throws Exception {

        pnlMain = new JPanel();
        pnlSearch = new JPanel();
        pnlPersonal = new JPanel();
        pnlContact = new JPanel();
        pnlButtons = new JPanel();

        pnlLeftPersonalLabels = new JPanel();
        pnlRightPersonalFields = new JPanel();
        pnlLeftContactLabels = new JPanel();
        pnlRightContactFields = new JPanel();

        rbtnMale = new JRadioButton("Male");
        rbtnFemale = new JRadioButton("Female");
        JPanel pnlSex = new JPanel();
        pnlSex.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlSex.add(rbtnMale);
        pnlSex.add(rbtnFemale);
        ButtonGroup group = new ButtonGroup();
        group.add(rbtnMale);
        group.add(rbtnFemale);

        btnSearch = new JButton("...");
        btnNew = new JButton("New");
        btnApply = new JButton("Apply");
        btnOk = new JButton("OK");
        btnCancel = new JButton("Cancel");
        btnPrint = new JButton("Print");

        lblMedRecNo = new JLabel("EMR Number:");
        lblMedRecNo.setToolTipText("Electronic Medical Record Number");
        lblFirstName = new JLabel("First Name:");
        lblLastName = new JLabel("Last Name:");
        lblSex = new JLabel("Sex:");
        btnPatientImage = new JButton("");
        lblDateOfBirth = new JLabel("Date of birth:");
        lblHomePhone = new JLabel("Home Phone:");
        lblCellPhone = new JLabel("Cell Phone:");
        lblEmail = new JLabel("Email:");
        lblAddress = new JLabel("Address:");
        lblCity = new JLabel("City:");
        lblState = new JLabel("State:");
        lblZipCode = new JLabel("Zip Code:");
        lblWeight = new JLabel("Weight");
        lblHeight = new JLabel("Height  ");

        txfMedRecNo = new JTextField();
        txfFirstName = new JTextField();
        txfLastName = new JTextField();
        cmbSex = new JComboBox();
        txfDateOfBirth = new JTextField();
        txfHomePhone = new JTextField();
        txfCellPhone = new JTextField();
        txfEmail = new JTextField();
        txfAddress = new JTextField();
        txfCity = new JTextField();
        txfState = new JTextField();
        txfZipCode = new JTextField();
        txfWeight = new JTextField();
        txfHeight = new JTextField();

        this.setLayout(new BorderLayout());
        this.add(pnlMain, BorderLayout.CENTER);

        pnlMain.setLayout(new BorderLayout());
        pnlMain.add(pnlSearch, BorderLayout.NORTH);

        // pnlSearch.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlSearch.setPreferredSize(new Dimension(600, 100));
        pnlSearch.setBorder(BorderFactory.createTitledBorder("Base Info"));
        pnlSearch.setLayout(null);
        pnlSearch.add(lblMedRecNo);
        pnlSearch.add(txfMedRecNo);
        pnlSearch.add(lblFirstName);
        pnlSearch.add(txfFirstName);
        pnlSearch.add(lblLastName);
        pnlSearch.add(txfLastName);
        pnlSearch.add(btnSearch);
        pnlSearch.add(btnPatientImage);

        btnPatientImage.setBounds(new Rectangle(350, 15, 100, 75));
        btnPatientImage.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        lblMedRecNo.setBounds(new Rectangle(10, 15, 80, FIELD_HEIGHT));
        txfMedRecNo.setBounds(new Rectangle(85, 15, 120, FIELD_HEIGHT));

        btnSearch.setBounds(new Rectangle(210, 15, 40, FIELD_HEIGHT));

        lblFirstName.setBounds(new Rectangle(10, 40, 80, FIELD_HEIGHT));
        txfFirstName.setBounds(new Rectangle(85, 40, 250, FIELD_HEIGHT));

        lblLastName.setBounds(new Rectangle(10, 65, 60, FIELD_HEIGHT));
        txfLastName.setBounds(new Rectangle(85, 65, 250, FIELD_HEIGHT));

        JPanel pnlPer = new JPanel();
        pnlPer.setLayout(new BorderLayout());

        pnlMain.add(pnlPer, BorderLayout.CENTER);

        JPanel pnlCont = new JPanel();
        pnlCont.setLayout(new BorderLayout());

        pnlPer.add(pnlCont, BorderLayout.CENTER);
        pnlCont.add(pnlContact, BorderLayout.NORTH);
        pnlPer.add(pnlPersonal, BorderLayout.NORTH);
        pnlPersonal.setLayout(new BorderLayout());
        pnlPersonal.add(pnlLeftPersonalLabels, BorderLayout.WEST);
        pnlPersonal.add(pnlRightPersonalFields, BorderLayout.CENTER);

        pnlLeftPersonalLabels.setLayout(new GridLayout(3, 1, 5, 5));
        pnlRightPersonalFields.setLayout(new GridLayout(3, 1, 5, 5));
        pnlPersonal.setBorder(BorderFactory.createTitledBorder("Personal Information:"));

        pnlContact.setLayout(new BorderLayout());
        pnlContact.add(pnlLeftContactLabels, BorderLayout.WEST);
        pnlContact.add(pnlRightContactFields, BorderLayout.CENTER);

        pnlLeftContactLabels.setLayout(new GridLayout(7, 1, 5, 5));
        pnlRightContactFields.setLayout(new GridLayout(7, 1, 5, 5));
        pnlContact.setBorder(BorderFactory.createTitledBorder("Contact Details:"));

        this.add(pnlButtons, BorderLayout.SOUTH);

        pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnlButtons.setBorder(BorderFactory.createEtchedBorder());

        pnlButtons.add(btnNew);
        pnlButtons.add(btnOk);
        pnlButtons.add(btnApply);
        pnlButtons.add(btnCancel);
        pnlButtons.add(btnPrint);

        btnNew.setPreferredSize(new Dimension(65, FIELD_HEIGHT));
        btnOk.setPreferredSize(new Dimension(65, FIELD_HEIGHT));
        btnApply.setPreferredSize(new Dimension(65, FIELD_HEIGHT));
        btnCancel.setPreferredSize(new Dimension(70, FIELD_HEIGHT));
        btnPrint.setPreferredSize(new Dimension(65, FIELD_HEIGHT));

        pnlLeftPersonalLabels.add(lblSex);
        lblSex.setPreferredSize(new Dimension(80, FIELD_HEIGHT));
        pnlRightPersonalFields.add(cmbSex);
        cmbSex.setPreferredSize(new Dimension(80, FIELD_HEIGHT));

        JPanel pnlHeightWight = new JPanel();
        pnlHeightWight.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlHeightWight.add(txfWeight);
        pnlHeightWight.add(new JLabel("       "));
        pnlHeightWight.add(lblHeight);
        pnlHeightWight.add(txfHeight);

        pnlLeftPersonalLabels.add(lblWeight);
        pnlRightPersonalFields.add(pnlHeightWight);
        pnlHeightWight.setPreferredSize(new Dimension(200, FIELD_HEIGHT));
        txfWeight.setPreferredSize(new Dimension(80, FIELD_HEIGHT));
        txfHeight.setPreferredSize(new Dimension(80, FIELD_HEIGHT));

//		pnlLeftPersonalLabels.add(lblHeight);
//		pnlRightPersonalFields.add(txfHeight);
//		cmbSex.setPreferredSize(new Dimension(150, FIELD_HEIGHT));

        pnlLeftPersonalLabels.add(lblDateOfBirth);
        pnlRightPersonalFields.add(txfDateOfBirth);
        txfDateOfBirth.setPreferredSize(new Dimension(150, FIELD_HEIGHT));

        pnlLeftContactLabels.add(lblHomePhone);
        lblHomePhone.setPreferredSize(new Dimension(80, FIELD_HEIGHT));
        pnlRightContactFields.add(txfHomePhone);
        txfHomePhone.setPreferredSize(new Dimension(150, FIELD_HEIGHT));

        pnlLeftContactLabels.add(lblCellPhone);
        pnlRightContactFields.add(txfCellPhone);
        txfCellPhone.setPreferredSize(new Dimension(150, FIELD_HEIGHT));

        pnlLeftContactLabels.add(lblEmail);
        pnlRightContactFields.add(txfEmail);
        txfEmail.setPreferredSize(new Dimension(150, FIELD_HEIGHT));

        pnlLeftContactLabels.add(lblAddress);
        pnlRightContactFields.add(txfAddress);
        txfAddress.setPreferredSize(new Dimension(150, FIELD_HEIGHT));

        pnlLeftContactLabels.add(lblCity);
        pnlRightContactFields.add(txfCity);
        txfCity.setPreferredSize(new Dimension(150, FIELD_HEIGHT));

        pnlLeftContactLabels.add(lblState);
        pnlRightContactFields.add(txfState);
        txfState.setPreferredSize(new Dimension(150, FIELD_HEIGHT));

        pnlLeftContactLabels.add(lblZipCode);
        pnlRightContactFields.add(txfZipCode);
        txfZipCode.setPreferredSize(new Dimension(150, FIELD_HEIGHT));

        txfMedRecNo.setEditable(false);

        btnNew.addActionListener(this);
        btnSearch.addActionListener(this);
        btnCancel.addActionListener(this);
        btnPatientImage.addActionListener(this);
    }

    private void initPanel() {
        cmbSex.removeAllItems();

        cmbSex.addItem("<Select>");
        cmbSex.addItem("Male");
        cmbSex.addItem("Female");
    }

    /**
     * Load the patient data
     *
     * @param patient
     */
    public void load(Patient patient) {
        logger.debug("Load patient");
        if (patient != null) {
            this.patient = patient;
            // load the data
            loadData();
        }
    }

    /**
     * Load the data into panel
     */
    private void loadData() {
        logger.debug("Load data");
        txfMedRecNo.setText(patient.getMedRecNo());
        txfFirstName.setText(patient.getFirstName());
        txfLastName.setText(patient.getLastName());
        txfHomePhone.setText(patient.getHomePhone());
        txfCellPhone.setText(patient.getCellPhone());
        txfAddress.setText(patient.getAddress());
        cmbSex.setSelectedItem(patient.getSex());
        txfDateOfBirth.setText(patient.getDateOfBirth());
        txfCity.setText(patient.getCity());
        txfState.setText(patient.getState());
        txfZipCode.setText(patient.getZipCode());
        txfEmail.setText(patient.getEmail());
        txfWeight.setText(String.valueOf(patient.getWeight()));
        txfHeight.setText(String.valueOf(patient.getHeight()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PatientActions pActions = new PatientActions(this.patient);
        //DataManager
        if (e.getSource() == btnApply) {
            pActions.saveAction();
        }
        if (e.getSource() == btnSearch) {
            PatientTable pTable = new PatientTable();
            pTable.launchDialog();
            if (pTable.getSelectedPatient() != null) {
                this.patient = pTable.getSelectedPatient();
                this.load(patient);
            }
        }
        if (e.getSource() == btnNew) {
            this.newAction();
        }
        if (e.getSource() == btnCancel) {
            this.closeAction();
        }
        if (e.getSource() == btnPatientImage) {
            this.loadPatientImage();
        }
    }

    private void newAction() {
        // Clear all fields
        txfMedRecNo.setText(EMPTY_STR);
        txfFirstName.setText(EMPTY_STR);
        txfLastName.setText(EMPTY_STR);
        cmbSex.setSelectedIndex(0);
        txfWeight.setText(EMPTY_STR);
        txfHeight.setText(EMPTY_STR);
        txfDateOfBirth.setText(EMPTY_STR);
        txfHomePhone.setText(EMPTY_STR);
        txfCellPhone.setText(EMPTY_STR);
        txfEmail.setText(EMPTY_STR);
        txfAddress.setText(EMPTY_STR);
        txfCity.setText(EMPTY_STR);
        txfState.setText(EMPTY_STR);
        txfZipCode.setText(EMPTY_STR);
    }

    private void closeAction() {
        if (parent != null) {
            parent.dispose();
        }
    }

    private void loadPatientImage() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            logger.debug("Selected File name ------->:" + selectedFile.getAbsolutePath());
            ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
            btnPatientImage.setIcon(icon);
        }

    }
}
