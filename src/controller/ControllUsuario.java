package controller;

import java.sql.SQLException;
import java.util.List;

import DataAccesInter.CidadesDAO;
import DataAccesInter.EstadoDAO;
import DataAccesInter.TipoUsuarioDAO;
import DataAccesInter.UsuariosDAO;
import DataAccess.CidadesDAOImpl;
import DataAccess.EstadosDAOImpl;
import DataAccess.TipoUsuarioDAOImpl;
import DataAccess.UsuarioDAOImpl;
import model.Cidades;
import model.Estados;
import model.TiposUsuario;
import model.Usuarios;

public class ControllUsuario {
	UsuariosDAO udao;
	EstadoDAO edao;
	CidadesDAO cdao;
	TipoUsuarioDAO tdao;
	public ControllUsuario() {
		udao = new UsuarioDAOImpl();
		edao = new EstadosDAOImpl();
		cdao = new CidadesDAOImpl();
		tdao = new TipoUsuarioDAOImpl();
	}
	public void inserir(Usuarios usuario) throws SQLException {
		udao.inserir(usuario);
	}
	
	public List<Estados> lerEstado() throws SQLException {
		return edao.read();
	}
	public List<Cidades> lerCidade(int idEstado) throws SQLException{
		return cdao.read(idEstado);
	}
	public Usuarios logonSistema(String registro, String senha){	
		try {
			return udao.login(registro, senha);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
