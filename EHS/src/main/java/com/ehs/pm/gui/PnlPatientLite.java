/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehs.pm.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.ehs.AppFrame;
import com.ehs.pm.beans.Patient;
import com.ehs.common.gui.HPanel;
import com.ehs.common.HSConstantsI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * @author E15567
 */
public class PnlPatientLite extends HPanel implements HSConstantsI {

    private static final long serialVersionUID = -3324840033589620839L;
    private Logger log = AppFrame.getLogger();
    private JPanel pnlFileds;
    private JPanel pnlImage;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblDateOfBirth;
    private JLabel lblAge;
    private JLabel lblWeight;
    private JLabel lblHeight;
    private JTextField txfFirstName;
    private JTextField txfLastName;
    private JTextField txfDateOfBirth;
    private JTextField txfAge;
    private JTextField txfWeight;
    private JTextField txfHeight;
    private JLabel lblImage;

    public PnlPatientLite() {
        try {
            initComponents();
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.toString());
        }
    }

    private void initComponents() throws Exception {

        pnlFileds = new JPanel();
        pnlImage = new JPanel();

        lblFirstName = new JLabel("  First Name:");
        lblLastName = new JLabel("  Last Name:");
        lblDateOfBirth = new JLabel("  Date of Birth:");
        lblAge = new JLabel("  Age:");
        lblWeight = new JLabel("  Weght:");
        lblHeight = new JLabel("  Height:");

        txfFirstName = new JTextField();
        txfLastName = new JTextField();
        txfDateOfBirth = new JTextField();
        txfAge = new JTextField();
        txfWeight = new JTextField();
        txfHeight = new JTextField();

        this.setLayout(new BorderLayout());
        this.add(pnlFileds, BorderLayout.CENTER);
        pnlFileds.setBorder(BorderFactory.createEtchedBorder());
        this.add(pnlImage, BorderLayout.EAST);
        pnlImage.setBorder(BorderFactory.createEtchedBorder());

        pnlFileds.setLayout(new GridLayout(3, 4));

        pnlFileds.add(lblFirstName);
        pnlFileds.add(txfFirstName);
        pnlFileds.add(lblLastName);
        pnlFileds.add(txfLastName);

        pnlFileds.add(lblDateOfBirth);
        pnlFileds.add(txfDateOfBirth);
        pnlFileds.add(lblAge);
        pnlFileds.add(txfAge);

        pnlFileds.add(lblWeight);
        pnlFileds.add(txfWeight);
        pnlFileds.add(lblHeight);
        pnlFileds.add(txfHeight);

        lblImage = new JLabel();
        pnlImage.add(lblImage);
        lblImage.setPreferredSize(new Dimension(100, 60));
    }

    public void load(Patient patient) {
        if (patient != null) {
            log.debug("Loading the patient lite:" + patient.getMedRecNo());

            this.txfFirstName.setText(patient.getFirstName());
            this.txfLastName.setText(patient.getLastName());
            this.txfDateOfBirth.setText(patient.getDateOfBirth());
            this.txfAge.setText(this.getAge(patient.getDateOfBirth()));

            this.txfWeight.setText("" + patient.getWeight());
            this.txfHeight.setText("" + patient.getHeight());
            if (patient.getSex().equals("Male")) {
                this.lblImage.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource(MALE_ICON)).getImage()));
            } else {
                this.lblImage.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource(FEMALE_ICON)).getImage()));
            }


            this.setEnabled(false);
        }
    }

    @Override
    public void setEnabled(boolean b) {
        this.txfFirstName.setEditable(b);
        this.txfLastName.setEditable(b);
        this.txfDateOfBirth.setEditable(b);
        this.txfAge.setEditable(b);
        this.txfWeight.setEditable(b);
        this.txfHeight.setEditable(b);
    }

    public String getAge(String dateOfBirth) {
        return "22 years";
    }
}
