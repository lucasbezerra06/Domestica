package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAccesInter.ServicosDAO;
import model.Estados;
import model.Servicos;

public class ServicosDAOImpl implements ServicosDAO{
	Connection con;
	public ServicosDAOImpl() {
		con = new ConnectionFactory().getConnection();
	}
	@Override
	public Servicos pesquisar(int idServicos) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Servicos> read() throws SQLException {
			List<Servicos> lista = new ArrayList();
		
		PreparedStatement stmt = con.prepareStatement("select * from servicos");
		//executa
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			 Servicos servico = new Servicos();
			 
			servico.setIdServicos(rs.getInt("id_servico"));
			servico.setNome(rs.getString("nome_servico"));
			servico.setDescricao(rs.getString("descri_servico"));
			servico.setValor(rs.getFloat("valor"));
			lista.add(servico);
			}
		stmt.close();
		con.close();
		
		return lista;
	}
	@Override
	public void inserir(Servicos servico) throws SQLException {
		String sql = "INSERT INTO servicos ( nome_servico, descri_servico, valor) "
				+ "VALUES(?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, servico.getNome());
		stmt.setString(2, servico.getDescricao());
		stmt.setFloat(3, servico.getValor());
		//executa
		stmt.execute();
		stmt.close();
		
		System.out.println("Gravado!");
		con.close();
		
	}
	@Override
	public void remover(int idServico) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
