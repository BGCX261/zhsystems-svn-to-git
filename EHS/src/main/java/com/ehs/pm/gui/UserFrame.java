package com.ehs.pm.gui;

import com.ehs.AppFrame;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

import org.apache.log4j.Logger;

import com.ehs.common.HSConstantsI;

public class UserFrame extends JInternalFrame implements HSConstantsI {

	private static final long serialVersionUID = -7850703503051567689L;
	private Logger log = AppFrame.getLogger();
	private PnlUser pnlUser;

	/**
	 * Default Constructor
	 */
	public UserFrame() {
		super("User Maintenance", true, true, true);
		log.debug("Initilizing the patient frame");
		pnlUser = new PnlUser(this);
		this.add(pnlUser);
		this.setSize(380, 250);
                this.setResizable(false);
		this.setFrameIcon(new ImageIcon(this.getClass().getResource(TITLE_ICON)));
		this.load();
	}

	/**
	 * Nothing to load : this is for blank data
	 */
	private void load() {
		log.debug("load");
		if (pnlUser != null) {

		}
	}

}
