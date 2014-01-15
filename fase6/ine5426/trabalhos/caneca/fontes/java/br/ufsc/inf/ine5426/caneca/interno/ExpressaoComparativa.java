package br.ufsc.inf.ine5426.caneca.interno;

public abstract class ExpressaoComparativa extends ExpressaoBinaria {
	Tipo tipo = Tipo.BOOLEANO;
	
	public ExpressaoComparativa(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public final Tipo fornecerTipo() {
		return tipo;
	}
}
