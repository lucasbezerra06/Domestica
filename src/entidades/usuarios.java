package entidades;

import java.util.ArrayList;

public class usuarios {
	private int idUsuarios;
	private tiposUsuario TipoUsuario;
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
	private ArrayList<servicos> servicosPrestrados;
	private ArrayList<endereco> enderecos;
	private ArrayList<pagamentos> pagamentosRealizados;
	private ArrayList<extrato> extratos;
	
	
	public usuarios(){
		enderecos = new ArrayList();
		servicosPrestrados = new ArrayList();
		pagamentosRealizados = new ArrayList();
		extratos = new ArrayList();
	}
	
	public ArrayList<extrato> getExtratos(){
		return extratos;
	}
	public void setExtratos(extrato extratos){
		this.extratos.add(extratos);
	}
	
	
	public ArrayList<pagamentos> getPagamentosRealizados(){
		return pagamentosRealizados;
	}
	public void setPagamentosRealizados(pagamentos pagamento){
		pagamentosRealizados.add(pagamento);
	}
	
	public ArrayList<servicos> getServicosPrestrados(){
		return servicosPrestrados;
	}
	
	public void setServicosPrestrados(servicos servico){
		servicosPrestrados.add(servico);
	}
	
	public ArrayList<endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(endereco endereco ) {
		enderecos.add(endereco);
	}


	public int getIdUsuarios() {
		return idUsuarios;
	}
	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}
	public tiposUsuario getTipoUsuario() {
		return TipoUsuario;
	}
	public void setTipoUsuario(tiposUsuario idTipoUsuario) {
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
