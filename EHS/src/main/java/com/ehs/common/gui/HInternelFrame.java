package com.ehs.common.gui;

import com.ehs.common.HSConstantsI;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public class HInternelFrame extends JInternalFrame implements HSConstantsI {

	private static final long serialVersionUID = -3566439573961119670L;

	public HInternelFrame(String title, boolean resizable, boolean closable,
			boolean maximizable) {
		super(title, resizable, closable, maximizable, false);
		this
				.setFrameIcon(new ImageIcon(this.getClass().getResource(
						TITLE_ICON)));
	}

	/**
	 * Creates a non-resizable, non-closable, non-maximizable, non-iconifiable
	 * <code>JInternalFrame</code> with no title.
	 */
	public HInternelFrame() {
		super("", false, false, false, false);
		this
				.setFrameIcon(new ImageIcon(this.getClass().getResource(
						TITLE_ICON)));
	}

	/**
	 * Creates a non-resizable, non-closable, non-maximizable, non-iconifiable
	 * <code>JInternalFrame</code> with the specified title. Note that passing
	 * in a <code>null</code> <code>title</code> results in unspecified behavior
	 * and possibly an exception.
	 * 
	 * @param title
	 *            the non-<code>null</code> <code>String</code> to display in
	 *            the title bar
	 */
	public HInternelFrame(String title) {
		super(title, false, false, false, false);
		this
				.setFrameIcon(new ImageIcon(this.getClass().getResource(
						TITLE_ICON)));
	}

	public HInternelFrame(String title, boolean resizable, boolean closable) {
		super(title, resizable, closable, false, false);
		this
				.setFrameIcon(new ImageIcon(this.getClass().getResource(
						TITLE_ICON)));
	}
}
