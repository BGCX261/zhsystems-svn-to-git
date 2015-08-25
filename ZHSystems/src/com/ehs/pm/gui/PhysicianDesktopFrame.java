package com.ehs.pm.gui;


import javax.swing.JInternalFrame;

import org.apache.log4j.Logger;

import com.ehs.AppFrame;
import com.ehs.common.HSConstantsI;
import javax.swing.ImageIcon;

public class PhysicianDesktopFrame extends JInternalFrame implements HSConstantsI {

    private static final long serialVersionUID = 6211162272109240231L;
    private Logger log = AppFrame.getLogger();
    private PhysicianDesktop physicianDesktop = null;
    /**
     * Default Constructor
     */
    public PhysicianDesktopFrame() {
        super("Physician Desktop", true, true, true);
        log.debug("Initilizing the physician desktop");
        physicianDesktop = new PhysicianDesktop(this);
        this.add(physicianDesktop);
        this.setSize(PHY_PNL_WIDTH, PHY_PNL_HEIGHT);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource(TITLE_ICON)));
    }

}
