package com.ehs.pd.gui;

import org.apache.log4j.Logger;

import com.ehs.AppFrame;
import com.ehs.common.gui.HInternelFrame;
import com.ehs.common.HSConstantsI;

public class PhysicianDesktopFrame extends HInternelFrame implements HSConstantsI{

	private static final long serialVersionUID = -7094402728697760451L;
	private Logger log = AppFrame.getLogger();

	public PhysicianDesktopFrame() {
		super("Physician Desktop", true, true, true);
		
		log.debug("Initilizing the patient frame");
		this.setSize(HS_PNL_WIDTH, HS_PNL_HEIGHT);


		try {
			initComponents();
		} catch (Exception e) {
                        log.debug("Exception while initializing the Main Frame :"+e.toString());
		}
	}
	
	private void initComponents() throws Exception {
		log.debug("Initicomponents");
	}
	
}
