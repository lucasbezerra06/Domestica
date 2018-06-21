package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAccesInter.EstadoDAO;
import model.Estados;
import model.Estados;

public class EstadosDAOImpl implements EstadoDAO{
	private Connection con;
	public EstadosDAOImpl() {
		con = new ConnectionFactory().getConnection();
	}

	@Override
	public Estados pesquisar(int idEstados) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estados> read() throws SQLException {
		List<Estados> lista = new ArrayList();
		
		PreparedStatement stmt = con.prepareStatement("select * from tb_estados");
		//executa
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			 Estados estados = new Estados();
			 
			estados.setIdEstados(rs.getInt("id_tb_estados"));
			estados.setUf(rs.getString("uf"));
			estados.setNome(rs.getString("nome"));
			lista.add(estados);
			
			}
		stmt.close();
		con.close();
		
		return lista;
	}

	@Override
	public void inserir(Estados estados) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int idEstados) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
