package DataAccesInter;

import java.sql.SQLException;
import java.util.List;

import model.Cidades;
import model.TiposUsuario;

public interface CidadesDAO {
	public Cidades pesquisar(int idCidades) throws SQLException;
	public List<Cidades> read() throws SQLException;
	public List<Cidades> read(int idEstado) throws SQLException;
	public void inserir(Cidades cidades) throws SQLException;
	public void remover(int idCidades) throws SQLException;
}
