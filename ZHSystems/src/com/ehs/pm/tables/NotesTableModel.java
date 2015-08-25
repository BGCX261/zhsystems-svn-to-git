/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehs.pm.tables;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.ehs.common.HSConstantsI;
import com.ehs.hiber.beans.Notes;
import com.ehs.pm.dblayer.DataManager;

/**
 *
 * @author E15567
 */
public class NotesTableModel extends AbstractTableModel implements HSConstantsI {

    private static final long serialVersionUID = 9034591738403063005L;
    public static final int COL_MEDRECNO_IDX = 0;
    public static final int COL_VISITNO_IDX = 1;
    public static final int COL_NOTES_IDX = 2;
    public static final int COL_ENTEREDBY_IDX = 3;
    public static final int COL_ENTEREDDATE_IDX = 4;
    protected String[] columnNames = {"MedRecNo", "visitNo", "Notes", "Entered By", "Entered Date"};
    protected List<Notes> dataV;

    public NotesTableModel() {
        super();
        this.dataV = new Vector<Notes>();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return dataV.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Notes notes = this.dataV.get(rowIndex);
        switch (columnIndex) {
            case COL_MEDRECNO_IDX:
                return notes.getMedrecno();
            case COL_VISITNO_IDX:
                return notes.getVisitNo();
            case COL_NOTES_IDX:
                return notes.getNotes();
            case COL_ENTEREDBY_IDX:
                return notes.getCreatedBy();
            case COL_ENTEREDDATE_IDX:
                return notes.getCreatedDate();
        }
        return "";
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Notes notes = this.dataV.get(row);
        switch (col) {
            case COL_MEDRECNO_IDX:
                notes.setMedrecno(value.toString());
            case COL_VISITNO_IDX:
                notes.setVisitNo(Integer.parseInt(value.toString()));
            case COL_NOTES_IDX:
                notes.setNotes(value.toString());
            case COL_ENTEREDBY_IDX:
                notes.setCreatedBy(value.toString());
            case COL_ENTEREDDATE_IDX:
                notes.setCreatedDate(new Date(value.toString()));
        }
    }

    public Object getValueAt(int rowIndex) {
        if (rowIndex <= this.dataV.size()) {
            return this.dataV.get(rowIndex);
        }
        return null;
    }

    /**
     *
     * @param col
     * @return
     */
    @Override
    public String getColumnName(int col) {
        return this.columnNames[col];
    }

    /**
     * Remove all rows
     */
    public synchronized void removeAll() {
        while (getRowCount() > 0) {
            dataV.clear();
            fireTableDataChanged();
        }
    }

    /**
     *
     * @param clear patient
     */
    public synchronized void clearRow(final Notes notes) {
        if (notes != null) {
            dataV.remove(notes);
            fireTableDataChanged();
        }
    }

    public void addRow(final Notes notes) {
        if (notes != null) {
            dataV.add(notes);
            this.fireTableDataChanged();
        }
    }

    public Notes getSelectedNote(int sRow) {
        if (sRow != -1) {
            return dataV.get(sRow);
        }
        return null;
    }

    public void load(String medRecNo) {
        this.removeAll();
        if (medRecNo != null && medRecNo.trim().length() > 0) {
            ArrayList<Notes> results = getNotes(medRecNo);
            for (Notes note : results) {
                this.addRow(note);
            }
        }
    }

    public void load(String medRecNo, String visitNo) {
        this.removeAll();
        if (medRecNo != null && visitNo != null) {
            ArrayList<Notes> results = getNotes(medRecNo);
            for (Notes note : results) {
                if ((""+note.getVisitNo()).equals(visitNo)) {
                    this.addRow(note);
                }
            }
        }
    }

    /**
     * Get the Notes
     * @param medRecNo
     * @return
     */
    private ArrayList<Notes> getNotes(String medRecNo) {
        Notes notes = null;
        ArrayList<Notes> result = new ArrayList<Notes>();
        try {
            File[] pFiles = new File(NOTES_BASE_XML_PATH + medRecNo + "/").listFiles();
            for (File pFile : pFiles) {
                if (pFile != null && pFile.getName().endsWith(".xml")) {
                	notes = (Notes) DataManager.getInstance().getObject(pFile);
                    result.add(notes);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

