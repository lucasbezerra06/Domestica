package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DataAccesInter.ServicosPrestradosDAO;
import DataAccess.ServicosPrestradosDAOImpl;
import model.Servicos;
import model.Usuarios;
import view.painel.ListaServicos;

public class ControllServicosPrestrados implements TableModel {
	ServicosPrestradosDAO spdao = new ServicosPrestradosDAOImpl();
	List<Servicos> listServicos = new ArrayList<>();
	public ControllServicosPrestrados() {
		listServicos = new ControllServicos().read();
	}
	public void definirServicos(Usuarios usuario, Servicos servico) {
		try {
			spdao.inserir(servico, usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class clazz = String.class;
        switch (columnIndex) {
          case 0:
            clazz = String.class;
            break;
          case 1:
            clazz = Boolean.class;
            break;
        }
        return clazz;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Servicos s = listServicos.get(rowIndex);
		if (columnIndex == 0){ 
			return s.getNome();
		} else if (columnIndex == 1){
			return false;
		}	
		return "";
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return column == 1;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		
	}

}
