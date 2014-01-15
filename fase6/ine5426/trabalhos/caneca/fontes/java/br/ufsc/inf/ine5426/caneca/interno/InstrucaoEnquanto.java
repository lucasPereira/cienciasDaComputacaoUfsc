package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public final class InstrucaoEnquanto extends EscopoAbstrato implements Instrucao {
	private Expressao condicao;
	private Bloco bloco;
	
	public InstrucaoEnquanto(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		CodigoDesviarSeFalso testeDeRepeticao = new CodigoDesviarSeFalso();
		CodigoDesviar repetir = new CodigoDesviar();
		repetir.fixarPontoDeDesvio(areaDeCodigo.size());
		condicao.gerarCodigo(areaDeCodigo, areaDeDados);
		areaDeCodigo.add(testeDeRepeticao);
		bloco.gerarCodigo(areaDeCodigo, areaDeDados);
		areaDeCodigo.add(repetir);
		testeDeRepeticao.fixarPontoDeDesvio(areaDeCodigo.size());
	}

	@Override
	public boolean definirBloco(Bloco bloco) {
		this.bloco = bloco;
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
		return "enquanto";
	}
}
