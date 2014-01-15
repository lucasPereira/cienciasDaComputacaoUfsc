package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.LinkedList;
import java.util.List;

public final class ExpressaoComando extends EscopoAbstrato implements Expressao {
	private LinkedList<Expressao> chamadas;
	
	public ExpressaoComando(Escopo escopoPai) {
		super(escopoPai);
		chamadas = new LinkedList<Expressao>();
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		chamadas.removeFirst().gerarCodigo(areaDeCodigo, areaDeDados);
		for (Expressao chamada : chamadas) {
			areaDeCodigo.add(new CodigoExtrairContexto());
			chamada.gerarCodigo(areaDeCodigo, areaDeDados);
			areaDeCodigo.add(new CodigoFecharContexto());
		}
	}
	
	@Override
	public boolean definirExpressao(Expressao expressao) {
		chamadas.add(expressao);
		Reporter.instancia().reportarDefinicaoDeExpressao(expressao);
		return true;
	}
	
	@Override
	public Tipo fornecerTipo() {
		return Tipo.INTEIRO;
		// return chamadas.getLast().fornecerTipo();
	}
	
	@Override
	public String comoTexto() {
		return "comando";
	}
}
