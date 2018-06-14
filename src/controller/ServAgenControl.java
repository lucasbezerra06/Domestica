package controller;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ServAgenControl extends DefaultTableModel{
	public ServAgenControl() {
        super(new String[]{"Rua", "Número","Bairro","Contratante",""}, 0);
      }

      @Override
      public Class<?> getColumnClass(int columnIndex) {
        Class clazz = String.class;
        switch (columnIndex) {
        	case 0:
        		clazz = String.class;
        		break;
        	case 1:
        		clazz = Integer.class;
        		break;
        	case 2:
        		clazz = String.class;
        		break;
        	case 3:
        		clazz = String.class;
        		break;
        	case 4:
        		clazz = Boolean.class;
        		break;
        }
        return clazz;
      }

      @Override
      public boolean isCellEditable(int row, int column) {
        return column == 4;
      }

      @Override
      public void setValueAt(Object aValue, int row, int column) {
        if (aValue instanceof Boolean && column == 4) {
          System.out.println(aValue);
          Vector rowData = (Vector)getDataVector().get(row);
          rowData.set(4, (boolean)aValue);
          fireTableCellUpdated(row, column);
        }
      }
}
