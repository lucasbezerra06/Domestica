package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Usuarios {
	private int idUsuarios;
	private TiposUsuario TipoUsuario;
	private String cpf;
	private String rg;
	private String nome;
	private float saldo;
	private int mascaraCartaoCred;
	private int tokenCartaoCred;
	private String contaCorrente;
	private String agencia;
	private String banco;
	private int codBanco;
	Set<Servicos> servicosPrestrados;
//	private ArrayList<Servicos> servicosPrestrados;
	private ArrayList<Endereco> enderecos;
	private ArrayList<Pagamentos> pagamentosRealizados;
	private ArrayList<Extrato> extratos;
	private ArrayList<Agendamento> agendamentos;
	private ArrayList<Avaliacoes> avaliacoes;
	public Usuarios(){
		enderecos = new ArrayList();
		servicosPrestrados = new HashSet();
//		servicosPrestrados = new ArrayList();
		pagamentosRealizados = new ArrayList();
		extratos = new ArrayList();
		agendamentos = new ArrayList();
		avaliacoes = new ArrayList();
	}
	
	
	
	public Set<Servicos> getServicosPrestrados() {
		return servicosPrestrados;
	}



	public void setServicosPrestrados(Servicos servico) {
		servicosPrestrados.add(servico);
	}



	public ArrayList<Avaliacoes> getAvaliacoes(){
		return avaliacoes;
	}
	public void setAvaliacoes(Avaliacoes avaliacao){
		this.avaliacoes.add(avaliacao);
	}
	
	
	public ArrayList<Agendamento> getAgendamentos(){
		return agendamentos;
	}
	public void setAgendamentos(Agendamento agendamento){
		this.agendamentos.add(agendamento);
	}
	
	public ArrayList<Extrato> getExtratos(){
		return extratos;
	}
	public void setExtratos(Extrato extratos){
		this.extratos.add(extratos);
	}
	
	
	public ArrayList<Pagamentos> getPagamentosRealizados(){
		return pagamentosRealizados;
	}
	public void setPagamentosRealizados(Pagamentos pagamento){
		pagamentosRealizados.add(pagamento);
	}
	
	/*public ArrayList<Servicos> getServicosPrestrados(){
		return servicosPrestrados;
	}
	
	public void setServicosPrestrados(Servicos servico){
		servicosPrestrados.add(servico);
	}*/
	
	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(Endereco endereco ) {
		enderecos.add(endereco);
	}


	public int getIdUsuarios() {
		return idUsuarios;
	}
	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}
	public TiposUsuario getTipoUsuario() {
		return TipoUsuario;
	}
	public void setTipoUsuario(TiposUsuario idTipoUsuario) {
		this.TipoUsuario = idTipoUsuario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public int getMascaraCartaoCred() {
		return mascaraCartaoCred;
	}
	public void setMascaraCartaoCred(int mascaraCartaoCred) {
		this.mascaraCartaoCred = mascaraCartaoCred;
	}
	public int getTokenCartaoCred() {
		return tokenCartaoCred;
	}
	public void setTokenCartaoCred(int tokenCartaoCred) {
		this.tokenCartaoCred = tokenCartaoCred;
	}
	public String getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public int getCodBanco() {
		return codBanco;
	}
	public void setCodBanco(int codBanco) {
		this.codBanco = codBanco;
	}
	
	
	

}
