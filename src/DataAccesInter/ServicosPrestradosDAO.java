package DataAccesInter;

import java.sql.SQLException;
import java.util.List;

import model.Servicos;
import model.Usuarios;

public interface ServicosPrestradosDAO {
	public Servicos pesquisar(int idUsuario) throws SQLException;
	public List<Servicos> read() throws SQLException;
	public void inserir(Servicos servico, Usuarios usuario) throws SQLException;
	public void remover(Servicos servico, Usuarios usuario) throws SQLException;
}
