package DataAccess;

import java.sql.SQLException;

import model.Usuarios;

public interface usuariosDAO {
		public Usuarios pesquisar(int idUsuario) throws SQLException;
		public void inserir(Usuarios usuario) throws SQLException;
		public void remover(int idUsuario) throws SQLException;

}
