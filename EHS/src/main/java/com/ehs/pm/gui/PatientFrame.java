package com.ehs.pm.gui;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

import org.apache.log4j.Logger;

import com.ehs.AppFrame;
import com.ehs.pm.beans.Patient;
import com.ehs.common.HSConstantsI;

public class PatientFrame extends JInternalFrame implements HSConstantsI {

    private static final long serialVersionUID = 6211162272109240231L;
    private Logger log = AppFrame.getLogger();
    private PnlPatient pnlPatient;

    /**
     * Default Constructor
     */
    public PatientFrame() {
        super("Patient Registration Form", true, true, true);
        log.debug("Initilizing the patient frame");
        pnlPatient = new PnlPatient(this);
        this.add(pnlPatient);
        this.setSize(HS_PNL_WIDTH, HS_PNL_HEIGHT);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource(TITLE_ICON)));
        this.load();
    }

    /**
     * Nothing to load : this is for blank data
     */
    private void load() {
        log.debug("load");
        if (pnlPatient != null) {
            this.pnlPatient.load(this.test());
        }
    }

    /**
     * Remove later : this is for testing
     * @return
     */
    public Patient test() {
        Patient patient = null;
//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance("com.ehs.pm.beans");
//            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//            //patient = (Patient) unmarshaller.unmarshal(new File("src/com/ehs/pm/xsd/Patient.xml"));
//            patient = (Patient) unmarshaller.unmarshal(new File("Xmldata/PM/Patients/NimmanagotiM123456.xml"));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
        return patient;
    }

    public static void main(String args[]) {
        new PatientFrame();
    }
}
