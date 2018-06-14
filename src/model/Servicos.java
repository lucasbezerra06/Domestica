package model;

import java.util.ArrayList;

public class Servicos {

	private int idServicos;
	private String nome;
	private String descricao;
	private float valor;
	public int getIdServicos() {
		return idServicos;
	}
	public void setIdServicos(int idServicos) {
		this.idServicos = idServicos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		String servico = "idServico = "+idServicos+"\nNome = "+nome+"\nDescrição = "+descricao+"\nValor = "+valor;
		return servico;
	}
}
