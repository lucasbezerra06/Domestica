package DataAccesInter;

import java.sql.SQLException;
import java.util.List;

import model.Servicos;


public interface ServicosDAO {
	public Servicos pesquisar(int idServicos) throws SQLException;
	public List<Servicos> read() throws SQLException;
	public void inserir(Servicos servico) throws SQLException;
	public void remover(int idServico) throws SQLException;
}
