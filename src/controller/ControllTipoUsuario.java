package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataAccesInter.TipoUsuarioDAO;
import DataAccess.ConnectionFactory;
import DataAccess.TipoUsuarioDAOImpl;
import model.TiposUsuario;

public class ControllTipoUsuario {
	private TipoUsuarioDAO tdao;
	private Connection con;
	public ControllTipoUsuario() {
		tdao = new TipoUsuarioDAOImpl();
		con = new ConnectionFactory().getConnection();
	}
	public TiposUsuario pesquisar(int idTipoUsuario) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("select * from tipos_usuario where id_tipo_usuario = "+idTipoUsuario);
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

}
