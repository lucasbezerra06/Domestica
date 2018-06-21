package DataAccesInter;

import java.sql.SQLException;

import model.Usuarios;

public interface UsuariosDAO {
		public Usuarios pesquisar(int idUsuario) throws SQLException;
		public Usuarios login(String nome, String senha) throws SQLException;
		public void inserir(Usuarios usuario) throws SQLException;
		public void remover(int idUsuario) throws SQLException;

}
