/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehs.pm.tables;

import com.ehs.pm.beans.Visit;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author E15567
 */
public class VisitsTableModel extends AbstractTableModel {

    public static final int COL_VISIT_NO_IDX = 0;
    public static final int COL_VISIT_DATE_IDX = 1;
    public static final int COL_DR_NAME_IDX = 2;
    public static final int COL_COMMENTS_IDX = 3;
    protected String[] columnNames = {"Visit No", "Visit Date", "Dr.Name", "Comments"};
    protected List<Visit> dataV;

    public VisitsTableModel() {
        super();
        this.dataV = new Vector<Visit>();
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
        Visit visit = this.dataV.get(rowIndex);
        switch (columnIndex) {
            case COL_VISIT_NO_IDX:
                return visit.getVisitNo();
            case COL_VISIT_DATE_IDX:
                return visit.getVisitDate();
            case COL_DR_NAME_IDX:
                return visit.getDrName();
            case COL_COMMENTS_IDX:
                return visit.getComments();
        }
        return "";
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Visit visit = this.dataV.get(row);
        switch (col) {
            case COL_VISIT_NO_IDX:
                visit.setVisitNo(value.toString());
            case COL_VISIT_DATE_IDX:
                //visit.setVisitDate(value);
                visit.setVisitDate(value.toString());
            case COL_DR_NAME_IDX:
                visit.setDrName(value.toString());
            case COL_COMMENTS_IDX:
                visit.setComments(value.toString());
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
     *
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
    public synchronized void clearRow(final Visit visit) {
        if (visit != null) {
            dataV.remove(visit);
            fireTableDataChanged();
        }
    }

    public void addRow(final Visit visit) {
        if (visit != null) {
            dataV.add(visit);
            this.fireTableDataChanged();
        }
    }

    public Visit getSelectedVisit(int sRow) {
        return dataV.get(sRow);
    }
}
