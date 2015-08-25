/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ehs.pm.gui;

import com.ehs.AppFrame;
import com.ehs.pm.beans.Visit;
import com.ehs.common.gui.HPanel;
import com.ehs.common.HSConstantsI;
import com.ehs.pm.tables.VisitsTable;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import org.apache.log4j.Logger;

/**
 *
 * @author E15567
 */
public class PnlVisits extends HPanel implements HSConstantsI{

	private static final long serialVersionUID = 4335968615184165728L;

	private Logger logger = AppFrame.getLogger();

    private VisitsTable visitTable;
    public PnlVisits() {
        this.setBorder(BorderFactory.createTitledBorder("Visits:"));

        visitTable = new VisitsTable();
        this.setLayout(new BorderLayout());
        this.add(visitTable, BorderLayout.CENTER);

        this.init();
    }

    private void init() {
        visitTable.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                PnlVisits.this.loadVisit(visitTable.getSelectedVisit());
            }
        });
    }

    public void load(String medRecNum) {
        logger.debug("Load visits of the patient:"+medRecNum);
        visitTable.loadVisits(medRecNum);
    }

    private void loadVisit(Visit visit) {
        logger.debug("Load the visit");
        if(visit != null) {
            
        }
    }
}
