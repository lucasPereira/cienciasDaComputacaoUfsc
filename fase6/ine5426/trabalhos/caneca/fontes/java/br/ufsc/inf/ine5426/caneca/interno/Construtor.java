package br.ufsc.inf.ine5426.caneca.interno;

public final class Construtor extends Procedimento<Construtor> {
	private String nomeDaClasse;
	
	public Construtor(Escopo escopoPai, String nomeDaClasse, int linha, int coluna) {
		super(escopoPai, "construtor", linha, coluna);
		this.nomeDaClasse = nomeDaClasse;
	}
	
	@Override
	public String fornecerNome() {
		return nomeDaClasse;
	}
	
	@Override
	public String comoTexto() {
		return String.format("c:%s", nomeDaClasse);
	}
}
