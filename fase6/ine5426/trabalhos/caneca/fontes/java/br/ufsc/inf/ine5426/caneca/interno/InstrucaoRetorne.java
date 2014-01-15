package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public final class InstrucaoRetorne extends EscopoAbstrato implements Instrucao {
	private Expressao expressao;
	
	public InstrucaoRetorne(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		expressao.gerarCodigo(areaDeCodigo, areaDeDados);
		areaDeCodigo.add(new CodigoRetornar());
	}
	
	@Override
	public boolean definirExpressao(Expressao expressao) {
		this.expressao = expressao;
		Reporter.instancia().reportarDefinicaoDeExpressao(expressao);
		return true;
	}
	
	@Override
	public String comoTexto() {
		return "retorne";
	}
}
