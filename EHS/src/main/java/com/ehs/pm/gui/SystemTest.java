package com.ehs.pm.gui;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.ehs.pm.beans.Patient;
import com.ehs.common.HSConstantsI;

public class SystemTest extends JFrame implements HSConstantsI {

	private static final long serialVersionUID = 6211162272109240231L;
	
	private PnlPatient pnlPatient;
	
	public SystemTest(){
		this.setLookAndFeel();
		
		pnlPatient = new PnlPatient();
		this.add(pnlPatient);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(HS_PNL_WIDTH,HS_PNL_HEIGHT);
		this.setVisible(true);
		this.setTitle("Patient Registration form");

		this.load();
	}
	
	public void load(){
		if(pnlPatient != null) {
			this.pnlPatient.load(this.test());
		}
	}
	
	private void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public Patient test() {
		Patient patient = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("com.ehs.pm.dao");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			patient = (Patient)unmarshaller.unmarshal(new File("src/com/ehs/pm/xsd/Patient.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return patient;
	}
	
	public static void main(String args[]){
		new SystemTest();
	}
	
}
