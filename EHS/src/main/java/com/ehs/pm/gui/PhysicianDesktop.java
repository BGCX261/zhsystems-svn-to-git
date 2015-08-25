/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehs.pm.gui;

import com.ehs.AppFrame;
import com.ehs.pm.beans.Patient;
import com.ehs.common.HSConstantsI;
import com.ehs.pm.utils.PatientUtils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

/**
 *This class holds all the physician documentation
 * 
 * On the top of the this panel contains the patient information.
 * 
 * In the tabbed pane all the information physician can enter.
 * 
 * Below buttons for controlling
 *
 *
 * @author E15567
 */
public class PhysicianDesktop extends JPanel implements HSConstantsI {

    private static final long serialVersionUID = -3815592975478359283L;
    private Logger logger = AppFrame.getLogger();
    // Search components
    private JPanel pnlSearch = null;
    private JLabel lblMedRecNum;
    private JTextField txfMedRecNum;
    private JButton btnSearch;
    private JPanel pnlNorth = null;
    private PnlPatientLite pnlPatientLite = null;
    private JPanel pnlButtons = null;
    private JInternalFrame parent = null;
    private JButton btnSave;
    private JButton btnCancel;
    // Tabbed panels
    private JTabbedPane tabbedPane = null;
    private PnlVisits pnlVisits;
    private PnlHistory pnlHistory;
    private PnlMedications pnlMedications;
    private PnlLabRecords pnlLabRecords;
    private PnlNotes pnlNotes;
    private PnlReport pnlReport;

    public PhysicianDesktop(JInternalFrame parent) {
        this.parent = parent;

        try {
            initComponents();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.toString());
        }

        init();
    }

    private void initComponents() throws Exception {
        this.setLayout(new BorderLayout());

        pnlVisits = new PnlVisits();
        pnlHistory = new PnlHistory();
        pnlMedications = new PnlMedications();
        pnlLabRecords = new PnlLabRecords();
        pnlNotes = new PnlNotes();
        pnlReport = new PnlReport();

        pnlSearch = new JPanel();
        pnlNorth = new JPanel();

        lblMedRecNum = new JLabel("Medical Record Number:");
        txfMedRecNum = new JTextField();
        btnSearch = new JButton("Search");

        pnlSearch.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlSearch.add(lblMedRecNum);
        pnlSearch.add(txfMedRecNum);
        pnlSearch.setBorder(BorderFactory.createEtchedBorder());
        txfMedRecNum.setPreferredSize(new Dimension(100, 20));
        pnlSearch.add(btnSearch);


        pnlPatientLite = new PnlPatientLite();
        tabbedPane = new JTabbedPane();
        pnlButtons = new JPanel();

        tabbedPane.setBorder(BorderFactory.createEtchedBorder());

        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(tabbedPane, BorderLayout.CENTER);
        this.add(pnlButtons, BorderLayout.SOUTH);

        btnSave = new JButton("Save");
        btnCancel = new JButton("Cancel");

        tabbedPane.add(pnlVisits, VISITS_TAB_TITLE, VISIT_TABE_INDEX);
        tabbedPane.add(pnlHistory, HISTORY_TAB_TITLE, HISTORY_TAB_INDEX);
        tabbedPane.add(pnlMedications, MEDICATIONS_TAB_TITLE, MEDICATIONS_TAB_INDEX);
        tabbedPane.add(pnlLabRecords, LAB_RECORDS_TAB_TITLE, LAB_RECORDS_TAB_INDEX);
        tabbedPane.add(pnlNotes, NOTES_TAB_TITLE, NOTES_TAB_INDEX);
        tabbedPane.add(pnlReport, REPORT_TAB_TITLE, REPORT_TAB_INDEX);

        pnlNorth.setLayout(new BorderLayout());
        pnlNorth.add(pnlSearch, BorderLayout.NORTH);
        pnlNorth.add(pnlPatientLite, BorderLayout.CENTER);

        pnlButtons.setBorder(BorderFactory.createEtchedBorder());
        pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnlButtons.add(btnSave);
        pnlButtons.add(btnCancel);


        txfMedRecNum.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String medRecNo = txfMedRecNum.getText();
                PhysicianDesktop.this.load(PatientUtils.getPatient(medRecNo));

            }
        });

        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                closeAction();

            }
        });
    }

    private void init() {
        if(tabbedPane != null) {
            tabbedPane.setIconAt(VISIT_TABE_INDEX, new ImageIcon(this.getClass().getResource(VISITS_ICON)));
            tabbedPane.setIconAt(HISTORY_TAB_INDEX, new ImageIcon(this.getClass().getResource(HISTORY_ICON)));
            tabbedPane.setIconAt(MEDICATIONS_TAB_INDEX, new ImageIcon(this.getClass().getResource(MEDICATIONS_ICON)));
            tabbedPane.setIconAt(LAB_RECORDS_TAB_INDEX, new ImageIcon(this.getClass().getResource(LAB_RECORDS_ICON)));
            tabbedPane.setIconAt(NOTES_TAB_INDEX, new ImageIcon(this.getClass().getResource(NOTES_ICON)));
            tabbedPane.setIconAt(REPORT_TAB_INDEX, new ImageIcon(this.getClass().getResource(REPORTS_ICON)));

//            tabbedPane.setEnabledAt(HISTORY_TAB_INDEX, false);
//            tabbedPane.setEnabledAt(MEDICATIONS_TAB_INDEX, false);
//            tabbedPane.setEnabledAt(LAB_RECORDS_TAB_INDEX, false);
//            tabbedPane.setEnabledAt(NOTES_TAB_INDEX, false);
//            tabbedPane.setEnabledAt(REPORT_TAB_INDEX, false);
        }
    }

    private void load(Patient patient) {
        logger.debug("Load the patient information");

        //load patient information
        if (patient != null) {
            this.pnlPatientLite.load(patient);
        }

        //load visits
        if(patient!= null) {
            this.pnlVisits.load(patient.getMedRecNo());
            this.pnlNotes.load(patient.getMedRecNo());
        }
    }

    /**
     * Close the patient desktop internal frame
     */
    private void closeAction() {
        if (parent != null) {
            parent.dispose();
        }
    }
}
