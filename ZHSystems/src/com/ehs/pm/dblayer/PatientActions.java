package com.ehs.pm.dblayer;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.ehs.pm.beans.Patient;
import com.ehs.common.HSConstantsI;

public class PatientActions implements HSConstantsI {

	private final Patient patient;

	public PatientActions(Patient patient) {
		this.patient = patient;
	}

	public boolean saveAction() {
		boolean isSuccess = false;
		if (patient != null) {
			isSuccess = savePatientXml();
			if (isSuccess) {
				isSuccess = savePatientDb();
			}
		}

		return isSuccess;
	}

	private boolean savePatientXml() {
		File xmlFile = new File(PATIENT_BASE_XML_PATH + getPatientXmlFileName());

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(BEANS_LOCATION);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(patient, xmlFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return true;
	}

	private boolean savePatientDb() {
		//Hibernate
            return true;
	}

	private String getPatientXmlFileName() {
		return patient.getLastName()+getMedicalRecordNumber()+".xml";
	}

	public static String getMedicalRecordNumber() {
		String uniqueMRN = "1212";

		return uniqueMRN;
	}

}
