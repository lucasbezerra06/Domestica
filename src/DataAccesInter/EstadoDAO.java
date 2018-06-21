package DataAccesInter;

import java.sql.SQLException;
import java.util.List;

import model.Cidades;
import model.Estados;

public interface EstadoDAO {
	public Estados pesquisar(int idEstados) throws SQLException;
	public List<Estados> read() throws SQLException;
	public void inserir(Estados estados) throws SQLException;
	public void remover(int idEstados) throws SQLException;
}
