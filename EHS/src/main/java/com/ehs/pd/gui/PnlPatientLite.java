package com.ehs.pd.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.ehs.AppFrame;
import com.ehs.pm.beans.Patient;

public class PnlPatientLite extends JPanel{
  
	private static final long serialVersionUID = 3957367881500749604L;

	private static Logger logger = AppFrame.getLogger();

	private JLabel lblFirstName;
	private JLabel lblLastName;
	
	private JLabel lblAge;
	private JLabel lblSex;
	private JLabel lblPImage;
	private JRadioButton rbtnMale;
	private JRadioButton rbtnFemale;
	
	private JLabel lblWeight;
	private JLabel lblHeight;

	private JTextField txfFirstName;
	private JTextField txfLastName;
	private JTextField txfWeight;
	private JTextField txfHeight;

	// Panels
	private Patient patient = null;
	
	public PnlPatientLite (){
		try {
			initComponents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initComponents() throws Exception {
		lblFirstName = new JLabel("Fist Name");
		lblLastName = new JLabel("Last Name");
		lblAge = new JLabel("Age");
		lblPImage = new JLabel();
		lblWeight = new JLabel("Weight");
		lblHeight = new JLabel("Height");
		
		this.setLayout(null);
		
		this.add(lblFirstName);
		this.add(lblLastName);
		
	}
	
	
	
}
