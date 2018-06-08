package entidades;

public class cidades {
	private int idCidades;
	private String uf;
	private String nome;
	private estados estado;
	
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
	public estados getEstado() {
		return estado;
	}
	public void setEstado(estados estado) {
		this.estado = estado;
	}

}
