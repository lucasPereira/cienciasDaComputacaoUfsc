package br.ufsc.inf.ine5426.caneca.interno;

public abstract class ExpressaoLogica extends ExpressaoBinaria {
	Tipo tipo = Tipo.BOOLEANO;
	
	public ExpressaoLogica(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public final Tipo fornecerTipo() {
		return tipo;
	}
}
