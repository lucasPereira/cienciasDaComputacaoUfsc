package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.LinkedList;
import java.util.List;

public final class ExpressaoChamadaDeMetodo extends EscopoAbstrato implements Expressao {
	private Escopo escopoDono;
	private String nomeDoMetodo;
	private List<Expressao> parametros;
	
	public ExpressaoChamadaDeMetodo(Escopo escopoPai, Escopo escopoDono, String nomeDoMetodo) {
		super(escopoPai);
		this.nomeDoMetodo = nomeDoMetodo;
		this.escopoDono = escopoDono;
		parametros = new LinkedList<Expressao>();
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		for (Expressao parametro : parametros) {
			parametro.gerarCodigo(areaDeCodigo, areaDeDados);
		}
		areaDeCodigo.add(new CodigoChamar(nomeDoMetodo, areaDeCodigo.size()));
	}
	
	@Override
	public boolean definirExpressao(Expressao expressao) {
		parametros.add(expressao);
		Reporter.instancia().reportarDefinicaoDeExpressao(expressao);
		return true;
	}
	
	@Override
	public Tipo fornecerTipo() {
		//return fornecerEscopoPai().resolverReferencia(nome).fornecerTipo();
		//TODO
		return null;
	}
	
	@Override
	public String comoTexto() {
		return nomeDoMetodo + "()";
	}
}
