package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public final class InstrucaoSe extends EscopoAbstrato implements Instrucao {
	private Expressao condicao;
	private Bloco blocoSe;
	private Bloco blocoSenao;
	
	public InstrucaoSe(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		CodigoDesviarSeFalso desviarParaSenao = new CodigoDesviarSeFalso();
		CodigoDesviar desviarParaEntao = new CodigoDesviar();
		condicao.gerarCodigo(areaDeCodigo, areaDeDados);
		areaDeCodigo.add(desviarParaSenao);
		blocoSe.gerarCodigo(areaDeCodigo, areaDeDados);
		if (blocoSenao != null) {
			areaDeCodigo.add(desviarParaEntao);
		}
		desviarParaSenao.fixarPontoDeDesvio(areaDeCodigo.size());
		if (blocoSenao != null) {
			blocoSenao.gerarCodigo(areaDeCodigo, areaDeDados);
			desviarParaEntao.fixarPontoDeDesvio(areaDeCodigo.size());
		}
	}
	
	@Override
	public boolean definirBloco(Bloco bloco) {
		if (blocoSe == null) {
			blocoSe = bloco;
		} else if (blocoSenao == null) {
			blocoSenao = bloco;
		}
		Reporter.instancia().reportarDefinicaoDeBloco(bloco);
		return true;
	}
	
	@Override
	public boolean definirExpressao(Expressao expressao) {
		condicao = expressao;
		Reporter.instancia().reportarDefinicaoDeExpressao(expressao);
		return true;
	}
	
	@Override
	public String comoTexto() {
		return "se";
	}
}
