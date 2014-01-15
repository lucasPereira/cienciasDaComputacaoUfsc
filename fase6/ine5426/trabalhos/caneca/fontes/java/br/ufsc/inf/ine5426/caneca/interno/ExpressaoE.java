package br.ufsc.inf.ine5426.caneca.interno;

public final class ExpressaoE extends ExpressaoComparativaIdentidade {
	public ExpressaoE(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public String comoTexto() {
		return "&&";
	}
}
