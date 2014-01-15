package br.ufsc.inf.ine5426.caneca.interno;

public final class Destrutor extends Procedimento<Destrutor> {
	private String nomeDaClasse;

	public Destrutor(Escopo escopoPai, String nomeDaClasse, int linha, int coluna) {
		super(escopoPai, "destrutor", linha, coluna);
		this.nomeDaClasse = nomeDaClasse;
	}
	
	@Override
	public String fornecerNome() {
		return nomeDaClasse;
	}
	
	@Override
	public String comoTexto() {
		return String.format("d:%s", fornecerNome());
	}
}

