package model;

import java.util.Date;

public class Extrato {
	private int idExtrato;
	private float valor;
	private Date data;
	private String comprovante;
	
	public int getIdExtrato() {
		return idExtrato;
	}
	public void setIdExtrato(int idExtrato) {
		this.idExtrato = idExtrato;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getComprovante() {
		return comprovante;
	}
	public void setComprovante(String comprovante) {
		this.comprovante = comprovante;
	}
	

}
