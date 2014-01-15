package br.ufsc.inf.ine5426.caneca.interno;

public abstract class ExpressaoUnaria extends EscopoAbstrato implements Expressao {
	private Expressao operando;
	
	public ExpressaoUnaria(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public final boolean definirExpressao(Expressao expressao) {
		if (operando == null) {
			operando = expressao;
		}
		Reporter.instancia().reportarDefinicaoDeExpressao(expressao);
		return true;
	}
	
	protected final Expressao fornecerOperando() {
		return operando;
	}
}
