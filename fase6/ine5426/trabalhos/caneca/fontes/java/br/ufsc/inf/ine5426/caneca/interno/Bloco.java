package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class Bloco extends EscopoAbstrato {
	private Map<String, Variavel> variaveis;
	private List<Instrucao> instrucoes;
	
	public Bloco(Escopo escopoPai) {
		super(escopoPai);
		variaveis = new HashMap<String, Variavel>();
		instrucoes = new LinkedList<Instrucao>();
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		areaDeCodigo.add(new CodigoAbrirContexto());
		for (Map.Entry<String, Variavel> variavel : variaveis.entrySet()) {
			areaDeCodigo.add(new CodigoEmpilhar(variavel.getValue().fornecerTipo().fornecerValorPadrao()));
			areaDeCodigo.add(new CodigoDefinirSimbolo(variavel.getKey()));
		}
		for (Instrucao instrucao : instrucoes) {
			instrucao.gerarCodigo(areaDeCodigo, areaDeDados);
		}
		areaDeCodigo.add(new CodigoFecharContexto());
	}
	
	@Override
	public boolean definirVariavel(Variavel variavel) {
		if (variaveis.containsKey(variavel.fornecerNome())) {
			Reporter.instancia().reportarErroDeDefinicaoRepetidaDeVariavel(variavel);
			return false;
		}
		variaveis.put(variavel.fornecerNome(), variavel);
		Reporter.instancia().reportarDefinicaoDeVariavel(variavel);
		return true;
	}
	
	@Override
	public boolean definirInstrucao(Instrucao instrucao) {
		instrucoes.add(instrucao);
		Reporter.instancia().reportarDefinicaoDeInstrucao(instrucao);
		return true;
	}
	
	@Override
	public boolean definirExpressao(Expressao expressao) {
		instrucoes.add(expressao);
		Reporter.instancia().reportarDefinicaoDeExpressao(expressao);
		return true;
	}
	
	@Override
	public String comoTexto() {
		return "bloco";
	}
}
