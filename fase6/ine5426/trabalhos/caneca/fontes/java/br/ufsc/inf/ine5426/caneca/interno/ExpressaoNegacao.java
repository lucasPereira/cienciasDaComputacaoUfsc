package br.ufsc.inf.ine5426.caneca.interno;

public final class ExpressaoNegacao extends ExpressaoUnaria {
	Tipo tipo = Tipo.BOOLEANO;

	public ExpressaoNegacao(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public Tipo fornecerTipo() {
		return tipo;
	}
	
	@Override
	public String comoTexto() {
		return "~";
	}
}
