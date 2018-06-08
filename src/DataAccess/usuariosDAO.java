package DataAccess;

import java.sql.SQLException;

import entidades.usuarios;

public interface usuariosDAO {
		public usuarios pesquisar(int idUsuario) throws SQLException;
		public void inserir(usuarios usuario) throws SQLException;
		public void remover(int idUsuario) throws SQLException;

}
