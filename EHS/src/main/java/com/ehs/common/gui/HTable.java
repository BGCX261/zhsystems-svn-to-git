package com.ehs.common.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.JXTable;

public class HTable extends JXTable {

	private static final long serialVersionUID = 3654304177942562528L;

	public HTable() {
		super();
		this.setFillsViewportHeight(false);
	}

	public HTable(boolean isSortable) {
		super();
		if (isSortable) {
			this.setSortable(isSortable);
		}
	}
	
	/**
	 * Show tool tip text only if the cell text is wrapped
	 */
	@Override
	public String getToolTipText(MouseEvent event) {
		String tooltip = null;
		try {
			Point p = event.getPoint();
			// Locate the renderer under the event location
			int colIndex = columnAtPoint(p);
			int rowIndex = rowAtPoint(p);
			int colWidth = this.getColumnModel().getColumn(colIndex).getWidth();

			TableCellRenderer tableCellRenderer;

			if (rowIndex == -1) {
				return null;
			}
			tableCellRenderer = this.getCellRenderer(rowIndex, colIndex);
			Object obj = this.getValueAt(rowIndex, colIndex);
			if (obj == null) {
				return null;
			}

			Component comp = tableCellRenderer.getTableCellRendererComponent(this, obj, false, false, rowIndex,
					colIndex);

			if (comp instanceof JLabel) {
				JLabel jtextComp = (JLabel) comp;
				String text = jtextComp.getText();
				Font font = jtextComp.getFont();
				FontMetrics fontMetrics = jtextComp.getFontMetrics(font);

				int textWidth = SwingUtilities.computeStringWidth(fontMetrics, text);
				if (textWidth > colWidth) {
					tooltip = this.getValueAt(rowIndex, colIndex).toString();
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tooltip;
	}
}
