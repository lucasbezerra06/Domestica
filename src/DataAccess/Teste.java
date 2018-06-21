package DataAccess;

import java.sql.SQLException;

import controller.ControllTipoUsuario;
import model.TiposUsuario;

public class Teste {

	public static void main(String[] args) {
		try {
			TiposUsuario t = new ControllTipoUsuario().pesquisar(1);
			System.out.println(t.getTipoDescricao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
