package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DataAccesInter.ServicosPrestradosDAO;
import model.Servicos;
import model.Usuarios;

public class ServicosPrestradosDAOImpl implements ServicosPrestradosDAO{
	Connection con;
	public ServicosPrestradosDAOImpl() {
		con = new ConnectionFactory().getConnection();
	}
	@Override
	public Servicos pesquisar(int idUsuario) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Servicos> read() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Servicos servico, Usuarios usuario) throws SQLException {
		String sql = "INSERT INTO `servicos_prestrados` (`fk_id_usuarios`, `fk_id_servico`) "
				+ "VALUES(?,?)";
		PreparedStatement consulta = con.prepareStatement("select * from servicos_prestrados where fk_id_usuarios = '"+usuario.getIdUsuarios()+"' and fk_id_servico = '"+servico.getIdServicos()+"'");
		//executa
		ResultSet rs = consulta.executeQuery();
		if(rs == null) {
			PreparedStatement stmt = con.prepareStatement(sql);
			//stmt.setInt(1, usuario.getIdUsuarios());
			//stmt.setInt(2, usuario.getTipoUsuario().getIdTipoUsuario());
			stmt.setInt(1, usuario.getTipoUsuario().getIdTipoUsuario());
			stmt.setInt(2, servico.getIdServicos());
			//executa
			stmt.execute();
			stmt.close();
		}

		
		System.out.println("Gravado!");
		con.close();
		
	}

	@Override
	public void remover(Servicos servico, Usuarios usuario) throws SQLException {
		// TODO Auto-generated method stub
		
	}



}
