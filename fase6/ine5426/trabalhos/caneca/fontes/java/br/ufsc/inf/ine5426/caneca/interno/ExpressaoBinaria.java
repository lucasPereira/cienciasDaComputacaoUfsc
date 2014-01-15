package br.ufsc.inf.ine5426.caneca.interno;

public abstract class ExpressaoBinaria extends EscopoAbstrato implements Expressao {
	private Expressao operandoEsquerdo;
	private Expressao operandoDireito;
	
	public ExpressaoBinaria(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public final boolean definirExpressao(Expressao expressao) {
		if (operandoEsquerdo == null) {
			operandoEsquerdo = expressao;
		} else if (operandoDireito == null) {
			operandoDireito = expressao;
		}
		Reporter.instancia().reportarDefinicaoDeExpressao(expressao);
		return true;
	}
	
	protected final Expressao fornecerOperandoEsquerdo() {
		return operandoEsquerdo;
	}
	
	protected final Expressao fornecerOperandoDireito() {
		return operandoDireito;
	}
}
