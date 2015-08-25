package com.ehs.common.gui;

import com.ehs.common.HSConstantsI;
import java.awt.Dialog;
import java.lang.reflect.Field;
import java.util.Collection;
import javax.swing.ImageIcon;

import javax.swing.JDialog;

public class HDialog extends JDialog {

    private static final long serialVersionUID = 7643627730343383840L;
    private transient static Collection<?> modalDialogs;

    public HDialog() {
        super();
        this.setIconImage(new ImageIcon(this.getClass().getResource(HSConstantsI.TITLE_ICON)).getImage());
    }

    /**
     * Release the memory of modal dialogs
     */
    @Override
    public void dispose() {
        try {
            if (modalDialogs == null) {
                final Field modalDialog = Dialog.class.getDeclaredField("modalDialogs");
                modalDialog.setAccessible(true);

                modalDialogs = (Collection<?>) modalDialog.get(null);
                synchronized (getTreeLock()) {
                    while (modalDialogs.remove(this)) {
                        System.out.println("Released the memory");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.setVisible(false);
            super.dispose();
        }
    }
}
