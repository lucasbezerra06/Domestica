package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAccesInter.CidadesDAO;
import model.Cidades;
import model.TiposUsuario;

public class CidadesDAOImpl implements CidadesDAO{
	private Connection con;
	public CidadesDAOImpl() {
		con = new ConnectionFactory().getConnection();
	}
	@Override
	public Cidades pesquisar(int idCidades) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cidades> read() throws SQLException {
		List<Cidades> lista = new ArrayList();
		
		PreparedStatement stmt = con.prepareStatement("select * from tb_cidades");
		//executa
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			 Cidades cidade = new Cidades();
			 
			cidade.setIdCidades(rs.getInt("id_tb_cidades"));
			cidade.setUf(rs.getString("uf"));
			cidade.setNome(rs.getString("nome"));
			lista.add(cidade);
			
			}
		stmt.close();
		con.close();
		
		return lista;
	}

	@Override
	public void inserir(Cidades cidades) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int idCidades) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Cidades> read(int idEstado) throws SQLException {
		List<Cidades> lista = new ArrayList();
		
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM `tb_cidades` WHERE `fk_id_tb_estados` = "+idEstado);
		//executa
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			 Cidades cidade = new Cidades();
			 
			cidade.setIdCidades(rs.getInt("id_tb_cidades"));
			cidade.setUf(rs.getString("uf"));
			cidade.setNome(rs.getString("nome"));
			lista.add(cidade);
			
			}
		stmt.close();
		con.close();
		
		return lista;
	}
	
}
