package com.ehs.pm.tables;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.ehs.pm.beans.Patient;

public class PatientTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 9034591738403063005L;
    public static final int COL_MEDRECNO_IDX = 0;
    public static final int COL_LASTNAME_IDX = 1;
    public static final int COL_FIRSTNAME_IDX = 2;
    public static final int COL_ADDRESS_IDX = 3;
    protected String[] columnNames = {"MedRecNo", "LastName", "FirstName", "Address"};
    protected List<Patient> dataV;

    public PatientTableModel() {
        super();
        this.dataV = new Vector<Patient>();
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
        Patient patient = this.dataV.get(rowIndex);
        switch (columnIndex) {
            case COL_MEDRECNO_IDX:
                return patient.getMedRecNo();
            case COL_LASTNAME_IDX:
                return patient.getLastName();
            case COL_FIRSTNAME_IDX:
                return patient.getFirstName();
            case COL_ADDRESS_IDX:
                return patient.getAddress() + " " + patient.getCity() + " " + patient.getState();
        }
        return "";
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Patient patient = this.dataV.get(row);
        switch (col) {
            case COL_MEDRECNO_IDX:
                patient.setMedRecNo(value.toString());
            case COL_LASTNAME_IDX:
                patient.setLastName(value.toString());
            case COL_FIRSTNAME_IDX:
                patient.setFirstName(value.toString());
            case COL_ADDRESS_IDX:
                patient.setAddress(value.toString());
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
    public synchronized void clearRow(final Patient patient) {
        if (patient != null) {
            dataV.remove(patient);
            fireTableDataChanged();
        }
    }

    public void addRow(final Patient patient) {
        if (patient != null) {
            dataV.add(patient);
            this.fireTableDataChanged();
        }
    }

    public Patient getSelectedPatient(int sRow) {
        return dataV.get(sRow);
    }
}
