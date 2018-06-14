package model;

import java.util.ArrayList;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Agendamento {
	private int idAgendamento;
	private Date data;
	private Date horaInicio;
	private Date horaTermino;
	private float valorTotal;
	private String cep;
	private String logradouro;
	private String bairro;
	private String numero;
	private String complemento;
	private ArrayList<ServicosExecutados> servicosExecutados;
	
	public Agendamento(){
		servicosExecutados = new ArrayList();
	}
	
	public ArrayList<ServicosExecutados> getServicosExecutados(){
		return servicosExecutados;
	}
	
	public void setServicosExecutados(ServicosExecutados servico){
		servicosExecutados.add(servico);
	}
	
	public int getIdAgendamento() {
		return idAgendamento;
	}
	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraTermino() {
		return horaTermino;
	}
	public void setHoraTermino(Date horaTermino) {
		this.horaTermino = horaTermino;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
