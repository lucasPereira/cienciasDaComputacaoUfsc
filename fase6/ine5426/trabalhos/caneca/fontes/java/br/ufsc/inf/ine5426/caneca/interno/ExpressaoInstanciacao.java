package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.LinkedList;
import java.util.List;

public final class ExpressaoInstanciacao extends EscopoAbstrato implements Expressao {
	private Tipo tipo;
	private List<Expressao> parametros;
	
	public ExpressaoInstanciacao(Escopo escopoPai, Tipo tipo) {
		super(escopoPai);
		this.tipo = tipo;
		parametros = new LinkedList<Expressao>();
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		for (Expressao parametro : parametros) {
			parametro.gerarCodigo(areaDeCodigo, areaDeDados);
		}
		areaDeCodigo.add(new CodigoInstanciar(tipo.fornecerNomeDaClasse()));
		areaDeCodigo.add(new CodigoExtrairContexto());
		areaDeCodigo.add(new CodigoChamar("construtor", areaDeCodigo.size()));
		areaDeCodigo.add(new CodigoResolverSimbolo("esse"));
		areaDeCodigo.add(new CodigoFecharContexto());
	}
	
	@Override
	public boolean definirExpressao(Expressao expressao) {
		parametros.add(expressao);
		Reporter.instancia().reportarDefinicaoDeExpressao(expressao);
		return true;
	}
	
	@Override
	public Tipo fornecerTipo() {
		return tipo;
	}
	
	@Override
	public String comoTexto() {
		return "novo " + tipo.comoTexto();
	}
}
