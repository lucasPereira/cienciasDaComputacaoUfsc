package br.ufsc.inf.ine5426.caneca.interno;

public final class ExpressaoOu extends ExpressaoComparativaIdentidade {
	public ExpressaoOu(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public String comoTexto() {
		return "||";
	}
}
