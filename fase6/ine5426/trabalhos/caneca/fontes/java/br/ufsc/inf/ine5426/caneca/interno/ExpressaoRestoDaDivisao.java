package br.ufsc.inf.ine5426.caneca.interno;

public final class ExpressaoRestoDaDivisao extends ExpressaoAritmetica {
	public ExpressaoRestoDaDivisao(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public String comoTexto() {
		return "%";
	}
}
