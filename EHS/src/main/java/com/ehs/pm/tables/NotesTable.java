    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ehs.pm.tables;

import com.ehs.common.gui.HPanel;
import com.ehs.common.gui.HTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

/**
 *
 * @author E15567
 */
public class NotesTable extends HPanel{
	private static final long serialVersionUID = 8406456420032842350L;
	
	private HTable tableNotes;
    private JScrollPane scrollNotes;
    private NotesTableModel notesTableModel;

    public NotesTable() {
        try{
            initComponents();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }


    private void initComponents() throws Exception  {
        tableNotes = new HTable();
        scrollNotes = new JScrollPane(tableNotes);
        notesTableModel = new NotesTableModel();
        tableNotes.setModel(notesTableModel);

        this.setLayout(new BorderLayout());
        this.add(scrollNotes, BorderLayout.CENTER);
    }


    public HTable getTable() {
        return tableNotes;
    }

    public NotesTableModel getModel() {
        return notesTableModel;
    }

    public void load(String medRecNo) {
        if(medRecNo != null) {
            notesTableModel.load(medRecNo);
        }
    }
    
    public void load(String medRecNo, String visitNo) {
        if(medRecNo != null) {
            notesTableModel.load(medRecNo, visitNo);
        }
    }
}
