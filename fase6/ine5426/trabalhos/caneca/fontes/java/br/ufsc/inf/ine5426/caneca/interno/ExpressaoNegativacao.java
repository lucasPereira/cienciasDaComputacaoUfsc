package br.ufsc.inf.ine5426.caneca.interno;

public final class ExpressaoNegativacao extends ExpressaoUnaria {
	Tipo tipo;
	
	public ExpressaoNegativacao(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public Tipo fornecerTipo() {
		if (tipo == null) {
			tipo = Tipo.REAL;
			if (fornecerOperando().fornecerTipo().mesmoQue(Tipo.INTEIRO)) {
				tipo = Tipo.INTEIRO;
			}
		}
		return tipo;
	}
	
	@Override
	public String comoTexto() {
		return "-";
	}
}
