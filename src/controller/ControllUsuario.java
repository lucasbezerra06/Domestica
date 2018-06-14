package controller;

import model.Operador;
import persist.JDBCDAO;

public class ControllUsuario {
	public static Operador logonSistema(String registro, String senha) {

		JDBCDAO<Operador, String> jdbc = new JDBCDAO<Operador, String>(Operador.class);

		Operador operador = jdbc.read(registro);

		if (operador != null && operador.getSenha().equals(senha)) {
			return operador;
		}

		return null;
	}

}
