package br.ufsc.inf.ine5426.caneca.interno;

public final class Metodo extends Procedimento<Metodo> {
	private Tipo tipo;
	
	public Metodo(Escopo escopoPai, Tipo tipo, String nome, int linha, int coluna) {
		super(escopoPai, nome, linha, coluna);
		this.tipo = tipo;
	}
	
	@Override
	public String comoTexto() {
		return String.format("m:%s", fornecerNome());
	}
}
