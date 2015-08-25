/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ehs.pm.gui;

import com.ehs.AppFrame;
import com.ehs.pm.beans.Notes;
import com.ehs.common.gui.HPanel;
import com.ehs.common.HSConstantsI;
import com.ehs.pm.dblayer.DataManager;
import com.ehs.pm.tables.NotesTable;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import org.apache.log4j.Logger;

/**
 *
 * @author E15567
 */
public class PnlNotes extends HPanel implements HSConstantsI {
	private static final long serialVersionUID = -8139307443568252022L;
	
	private Logger log = AppFrame.getLogger();
    private NotesTable notesTable;
    private JScrollPane pnlNote;
    private JTextArea txaNotes;

    private JSplitPane splitPane;

    private JPanel pnlButtons;
    private JButton btnSave;
    private JButton btnClear;

    private String visitNo = "";
    private String medRecNo = "";
    
    public PnlNotes() {
        try{
            initComponents();
        }catch(Exception ex) {
            log.error(ex.toString());
        }

        init();
    }

    private void initComponents() throws Exception {
        this.setBorder(BorderFactory.createTitledBorder("Notes:"));
        this.setLayout(new BorderLayout());

        notesTable = new NotesTable();
        txaNotes = new JTextArea();
        pnlNote = new JScrollPane(txaNotes);
        pnlButtons = new JPanel();

        this.add(notesTable, BorderLayout.NORTH);
        notesTable.setPreferredSize(new Dimension(500,150));
        //this.add(pnlNote, BorderLayout.CENTER);
        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.add(notesTable);
        splitPane.add(pnlNote);
        this.add(splitPane, BorderLayout.CENTER);

        
        this.add(pnlButtons, BorderLayout.SOUTH);

        pnlNote.setBorder(BorderFactory.createTitledBorder("Enter the notes:"));

        btnSave = new JButton("Save Notes");
        btnClear = new JButton("Clear Notes");
        pnlButtons.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlButtons.add(btnSave);
        pnlButtons.add(btnClear);
    }

    private void init() {
        notesTable.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int sRow = notesTable.getTable().getSelectedRow();
                Notes note = notesTable.getModel().getSelectedNote(sRow);
                if(note != null) {
                    txaNotes.setText(note.getFormattedNotes());
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveNotes();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               txaNotes.setText("");
               notesTable.getTable().clearSelection();
            }
        });
    }

    public void load(String medRecNo) {
        this.medRecNo = medRecNo;
        notesTable.load(medRecNo);
    }

    public void load(String medRecNo, String visitNo) {
        this.medRecNo = medRecNo;
        this.visitNo = visitNo;
        notesTable.load(medRecNo);
    }


    private boolean saveNotes() {
        
         int sRow = notesTable.getTable().getSelectedRow();
         Notes nObj = notesTable.getModel().getSelectedNote(sRow);
         String notes = txaNotes.getText();
         if(nObj != null) {
            // Edit the notes 
            if(notes.trim().length() > 0) {
                nObj.setNotes(notes);
                if(DataManager.getInstance().saveToXml(nObj, NOTES_BASE_XML_PATH+medRecNo+"/")) {
                    log.debug("Successfully saved the notes");
                    load(medRecNo);
                } else {
                    log.error("Error whiling saving the notes");
                }
            }
         } else {
            if(notes.trim().length() > 0) {
                nObj = new Notes();
                nObj.setId(new Date().getTime());
                nObj.setVisitNo("1234");
                nObj.setMedRecNo(medRecNo);
                nObj.setNotes(notes);
                if(DataManager.getInstance().saveToXml(nObj, NOTES_BASE_XML_PATH+medRecNo+"/")) {
                    log.debug("Successfully saved the notes");
                    load(medRecNo);
                } else {
                    log.error("Error whiling saving the notes");
                }
            }

         }



        return false;
    }

    public void clearAction() {
        txaNotes.setText("");
        notesTable.getModel().removeAll();
    }

}
