/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehs.pm.dblayer;

import com.ehs.pm.beans.MainBean;
import com.ehs.common.HSConstantsI;
import java.io.File;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author E15567
 */
public class DataManager implements HSConstantsI {

    private static DataManager dataManager;

    static {
        dataManager = new DataManager();
    }

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (dataManager == null) {
            dataManager = new DataManager();
        }
        return dataManager;
    }

    public boolean saveToXml(Object obj, String filePath) {
        String fileName = "";
        if (obj instanceof MainBean) {
            MainBean mb = (MainBean) obj;
            mb.setEnteredBy(com.ehs.auth.SecurityManager.getInstance().getUser().getUsername());
            mb.setEnteredDate(new Date().toString());
            mb.setId(new Date().getTime());
            fileName = obj.getClass().getSimpleName() + "_" + mb.getId() + ".xml";
        }

        File xmlFile = new File(filePath + fileName);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BEANS_LOCATION);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(obj, xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean editXml(Object nObj, String filePath) {
        // First find the xml file
        Object oObj = getObject(filePath, nObj.getClass().getSimpleName());
        if(oObj != null) {
         
        }

        if (nObj instanceof MainBean) {
            MainBean mb = (MainBean) nObj;
            String fileName = nObj.getClass().getSimpleName() + "_" + mb.getId() + ".xml";
            File xmlFile = new File(filePath + fileName);
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(BEANS_LOCATION);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.marshal(nObj, xmlFile);
            } catch (JAXBException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }


    public Object getObject(String filePath, String fileName) {
        Object object = null;
          try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BEANS_LOCATION);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File pFile = new File(filePath+fileName);
            if (pFile != null  && pFile.getName().endsWith(".xml")) {
                object =  unmarshaller.unmarshal(pFile);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return object;
    }

	public Object getObject(File file) throws JAXBException {
		if (file != null) {
			return getObject(file.getAbsolutePath());
		}
		return null;
	}
    
	public Object getObject(String fileName) throws JAXBException {
		Object object = null;
		JAXBContext jaxbContext = JAXBContext.newInstance(BEANS_LOCATION);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		File pFile = new File(fileName);
		if (pFile != null && pFile.getName().endsWith(".xml")) {
			object = unmarshaller.unmarshal(pFile);
		}
		return object;
	}

    public boolean saveToDB() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
