package model;

public class Cidades {
	private int idCidades;
	private String uf;
	private String nome;
	private Estados estado;
	
	public int getIdCidades() {
		return idCidades;
	}
	public void setIdCidades(int idCidades) {
		this.idCidades = idCidades;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estados getEstado() {
		return estado;
	}
	public void setEstado(Estados estado) {
		this.estado = estado;
	}

}
