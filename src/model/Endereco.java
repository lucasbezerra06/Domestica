package model;
public class Endereco {
	private int idEnderecos;
	private String cep;
	private String logradouro;
	private String bairro;
	private int numero;
	private String complemento;
	private Cidades cidade;
	
	public int getIdEnderecos() {
		return idEnderecos;
	}
	public void setIdEnderecos(int idEnderecos) {
		this.idEnderecos = idEnderecos;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Cidades getCidade() {
		return cidade;
	}
	public void setCidade(Cidades cidade) {
		this.cidade = cidade;
	}
	
	
}
