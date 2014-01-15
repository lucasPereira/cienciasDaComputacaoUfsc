package br.ufsc.inf.ine5426.caneca.interno;

public abstract class ExpressaoAritmetica extends ExpressaoBinaria {
	Tipo tipo;
	
	public ExpressaoAritmetica(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public final Tipo fornecerTipo() {
		if (tipo == null) {
			Tipo tipoOperandoEsquerdo = fornecerOperandoEsquerdo().fornecerTipo();
			Tipo tipoOperandoDireito = fornecerOperandoDireito().fornecerTipo();
			tipo = Tipo.REAL;
			if (tipoOperandoEsquerdo.mesmoQue(Tipo.INTEIRO) && tipoOperandoDireito.mesmoQue(Tipo.INTEIRO)) {
				tipo = Tipo.INTEIRO;
			}
		}
		return tipo;
	}
}
