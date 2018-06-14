package model;


public class Avaliacoes {
	private int idAvaliacoes;
	private String avaliacaoText;
	private int avaliacao;
	

	public String getAvaliacaoText() {
		return avaliacaoText;
	}
	public void setAvaliacaoText(String avaliacaoText) {
		this.avaliacaoText = avaliacaoText;
	}
	public int getIdAvaliacoes() {
		return idAvaliacoes;
	}
	public void setIdAvaliacoes(int idAvaliacoes) {
		this.idAvaliacoes = idAvaliacoes;
	}
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	@Override
	public String toString() {
		return "idAvaliação = "+idAvaliacoes+"\nAvaliação Textual = "+avaliacaoText+"\nNota = "+avaliacao;
	}
}
