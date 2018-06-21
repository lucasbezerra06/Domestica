package controller;

import java.sql.SQLException;
import java.util.List;

import DataAccesInter.ServicosDAO;
import DataAccess.ServicosDAOImpl;
import model.Servicos;

public class ControllServicos {
	ServicosDAO sdo;
	public ControllServicos() {
		sdo = new ServicosDAOImpl();
	}
	public void Inserir(Servicos servico) throws SQLException {
		sdo.inserir(servico);
	}
	
	public List<Servicos> read(){
		try {
			return sdo.read();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
