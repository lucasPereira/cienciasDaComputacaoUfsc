package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public final class ExpressaoMenor extends ExpressaoComparativaAritmetica {
	public ExpressaoMenor(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		fornecerOperandoEsquerdo().gerarCodigo(areaDeCodigo, areaDeDados);
		fornecerOperandoDireito().gerarCodigo(areaDeCodigo, areaDeDados);
		areaDeCodigo.add(new CodigoMenor());
	}
	
	@Override
	public String comoTexto() {
		return "<";
	}
}
