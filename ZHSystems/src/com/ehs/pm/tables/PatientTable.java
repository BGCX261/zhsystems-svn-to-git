package com.ehs.pm.tables;

import com.ehs.pm.beans.Patient;
import com.ehs.common.gui.HDialog;
import com.ehs.common.HSConstantsI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXPanel;

import com.ehs.common.gui.HTable;
import com.ehs.pm.dblayer.DataManager;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.bind.JAXBException;

public class PatientTable extends JXPanel implements HSConstantsI {

    private static final long serialVersionUID = 8045634475305784266L;
    private HTable tablePatient;
    private JScrollPane scrollPatient;
    private PatientTableModel patientModel;

    private JXPanel pnlButtons;
    private JButton btnOk;
    private JButton btnCancel;
    private Patient sPatient = null;

    private HDialog hDialog = null;

    public PatientTable() {
        try {
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setUpTable();
    }

    private void initComponents() throws Exception {
        pnlButtons = new JXPanel();
        btnOk = new JButton(BUTTON_OK);
        btnCancel = new JButton(BUTTON_CANCEL);
        tablePatient = new HTable();
        scrollPatient = new JScrollPane(tablePatient);
        this.setLayout(new BorderLayout());
        this.add(scrollPatient, BorderLayout.CENTER);
        this.add(pnlButtons, BorderLayout.SOUTH);

        pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnlButtons.add(btnOk);
        pnlButtons.add(btnCancel);
    }

    private void setUpTable() {
        patientModel = new PatientTableModel();
        this.tablePatient.setModel(patientModel);

        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int sRow = tablePatient.getSelectedRow();
                if(sRow != -1) {
                    sPatient = patientModel.getSelectedPatient(sRow);
                    PatientTable.this.close();
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sPatient = null;
                PatientTable.this.close();
            }
        });

        tablePatient.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me ) {
                if (me.getClickCount() > 1) {
                    int sRow = tablePatient.getSelectedRow();
                    if (sRow != -1) {
                        sPatient = patientModel.getSelectedPatient(sRow);
                        PatientTable.this.close();
                    }
                }
            }
        });


        tablePatient.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                // Nothing for now
            }
        });

        this.loadPatients();
    }

    public Patient getSelectedPatient() {
        return sPatient;
    }


    private void loadPatients() {
        Patient patient = null;
        try {
            File[] pFiles = new File(PATIENT_BASE_XML_PATH).listFiles();
            for (File pFile : pFiles) {
                if (pFile != null && pFile.getName().endsWith(".xml")) {
                    patient = (Patient) DataManager.getInstance().getObject(pFile);
                    patientModel.addRow(patient);
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void launchDialog() {
        if (hDialog == null) {
            hDialog = new HDialog();
        }
        hDialog.add(this);
        hDialog.setTitle("Patient Search");
        hDialog.setModal(true);
        //hDialog.setLocation(this.getParent().getLocationOnScreen());
        hDialog.setSize(400, 200);
        hDialog.setVisible(true);

    }

    public void close() {
        if(hDialog != null) {
            hDialog.dispose();
        }
    }
}
