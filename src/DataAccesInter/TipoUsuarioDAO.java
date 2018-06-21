package DataAccesInter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DataAccess.ConnectionFactory;
import model.TiposUsuario;
import model.Usuarios;

public interface TipoUsuarioDAO {
	public TiposUsuario pesquisar(int idTipoUsuario) throws SQLException;
	public List<TiposUsuario> read() throws SQLException;
	public void inserir(TiposUsuario tiposUsuario) throws SQLException;
	public void remover(int idTipoUsuario) throws SQLException;

}
