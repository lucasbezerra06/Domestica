package model;


public class TiposUsuario {
	private int idTipoUsuario;
	private String tipoDescricao;
	private int permissao;
	public int getIdTipoUsuario() {
	
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public String getTipoDescricao() {
		return tipoDescricao;
	}
	public void setTipoDescricao(String tipoDescricao) {
		this.tipoDescricao = tipoDescricao;
	}
	public int getPermissao() {
		return permissao;
	}
	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return tipoDescricao;
	}
	
	

}
