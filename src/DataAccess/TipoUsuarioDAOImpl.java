package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAccesInter.TipoUsuarioDAO;
import model.Servicos;
import model.TiposUsuario;
import model.Usuarios;

public class TipoUsuarioDAOImpl implements TipoUsuarioDAO{
	private Connection con;
	public TipoUsuarioDAOImpl() {
		con = new ConnectionFactory().getConnection();
	}

	@Override
	public TiposUsuario pesquisar(int idTipoUsuario) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("select * from tipos_usuario where id_tipo_usuario = '"+idTipoUsuario+"'");
		//executa
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			rs.next();
			TiposUsuario tipo = new TiposUsuario();
			tipo.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
			tipo.setTipoDescricao(rs.getString("tipo_descricao"));
			tipo.setPermissao(rs.getInt("permissao"));
			stmt.close();
			con.close();
			return tipo;
		}else {
			return null;
		}
	}

	@Override
	public List<TiposUsuario> read() throws SQLException {
		List<TiposUsuario> lista = new ArrayList();
		
		PreparedStatement stmt = con.prepareStatement("select * from tipos_usuario");
		//executa
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			TiposUsuario tipo = new TiposUsuario();
			
			tipo.setIdTipoUsuario(rs.getInt("id_tipo_usuario"));
			tipo.setTipoDescricao(rs.getString("tipo_descricao"));
			tipo.setPermissao(rs.getInt("permissao"));
			lista.add(tipo);
			
			}
		stmt.close();
		con.close();
		
		return lista;
	}

	@Override
	public void inserir(TiposUsuario tiposUsuario) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int idTipoUsuario) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
