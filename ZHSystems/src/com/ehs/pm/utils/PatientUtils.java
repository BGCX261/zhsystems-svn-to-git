package com.ehs.pm.utils;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.ehs.AppFrame;
import com.ehs.pm.beans.Patient;
import com.ehs.common.HSConstantsI;

public class PatientUtils implements HSConstantsI {

	private static Logger logger = AppFrame.getLogger();

	
	/**
	 * Get the patient object 
	 * @param medRecNo
	 * @return
	 */
	public static Patient getPatient(String medRecNo) {
		logger.debug("Get the patient of :" + medRecNo);
		if (medRecNo != null) {

			Patient patient = null;
			try {
				JAXBContext jaxbContext = JAXBContext
						.newInstance("com.ehs.pm.beans");
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				File[] pFiles = new File(PATIENT_BASE_XML_PATH).listFiles();

				for (File pFile : pFiles) {
					if (pFile != null) {
						if (pFile.getName().indexOf(medRecNo) > 0) {
							patient = (Patient) unmarshaller.unmarshal(pFile);
							logger.debug(pFile.getName());
						}
					}
				}

				return patient;

			} catch (JAXBException e) {
				e.printStackTrace();
			}

		}

		return null;
	}

	
	/**
	 * Get the patients
	 * @param fName
	 * @return
	 */
	public static ArrayList<Patient> getPatients(String fName) {
		ArrayList<Patient> resultPatient = new ArrayList<Patient>();

		ArrayList<File> pFiles = getPatientXmls(fName);
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance("com.ehs.pm.beans");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Patient patient = null;
			for (File pFile : pFiles) {
				patient = (Patient) unmarshaller.unmarshal(pFile);
				resultPatient.add(patient);
			}

		} catch (JAXBException e) {
			logger.error("Error while parsing patient xml file:"+fName);
			e.printStackTrace();
		}

		return resultPatient;
	}
	
	
	

	private static ArrayList<File> getPatientXmls(String search) {
		ArrayList<File> results = new ArrayList<File>();
		File[] pFiles = new File(PATIENT_BASE_XML_PATH).listFiles();
		for (File pFile : pFiles) {
			if (pFile != null && pFile.getName().indexOf(search) > 0) {
				results.add(pFile);
			}
		}

		return results;
	}

}
