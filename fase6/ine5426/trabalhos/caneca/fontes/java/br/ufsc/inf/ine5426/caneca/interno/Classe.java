package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class Classe extends EscopoAbstrato implements Simbolo {
	private Map<String, Atributo> atributos;
	private Map<String, Metodo> metodos;
	private Construtor construtor;
	private Destrutor destrutor;
	private String nome;
	private int linha;
	private int coluna;
	
	public Classe(Escopo escopoPai, String nome, int linha, int coluna) {
		super(escopoPai);
		this.nome = nome;
		this.linha = linha;
		this.coluna = coluna;
		atributos = new HashMap<String, Atributo>();
		metodos = new HashMap<String, Metodo>();
		//TODO: atributir valor na geração de código
		definirAtributo(new Atributo(this, new Tipo(nome), "esse", 0, 0));
		definirAtributo(new Atributo(this, new Tipo(nome), "essa", 0, 0));
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		Contexto contexto = new Contexto(areaDeDados);
		areaDeDados.definirContexto(nome, contexto);
		for (Map.Entry<String, Atributo> atributo : atributos.entrySet()) {
			contexto.definirSimbolo(atributo.getKey(), atributo.getValue().fornecerTipo().fornecerValorPadrao());
		}
		construtor.gerarCodigo(areaDeCodigo, contexto);
		destrutor.gerarCodigo(areaDeCodigo, contexto);
		for (Map.Entry<String, Metodo> metodo : metodos.entrySet()) {
			metodo.getValue().gerarCodigo(areaDeCodigo, contexto);
		}
	}
	
	@Override
	public boolean definirAtributo(Atributo atributo) {
		if (atributos.containsKey(atributo.fornecerNome())) {
			Reporter.instancia().reportarErroDeDefinicaoRepetidaDeAtributo(atributo);
			return false;
		}
		atributos.put(atributo.fornecerNome(), atributo);
		Reporter.instancia().reportarDefinicaoDeAtributo(atributo);
		return true;
	}
	
	@Override
	public boolean definirConstrutor(Construtor construtor) {
		if (!nome.equals(construtor.fornecerNome())) {
			Reporter.instancia().reportarErroDeDefinicaoDeNomeErradoDeConstrutor(construtor);
			return false;
		}
		this.construtor = construtor;
		Reporter.instancia().reportarDefinicaoDeConstrutor(construtor);
		return true;
	}
	
	@Override
	public boolean definirDestrutor(Destrutor destrutor) {
		if (!nome.equals(destrutor.fornecerNome())) {
			Reporter.instancia().reportarErroDeDefinicaoDeNomeErradoDeDestrutor(destrutor);
			return false;
		}
		this.destrutor = destrutor;
		Reporter.instancia().reportarDefinicaoDeDestrutor(destrutor);
		return true;
	}
	
	@Override
	public boolean definirMetodo(Metodo metodo) {
		if (metodos.containsKey(metodo.fornecerNome())) {
			Reporter.instancia().reportarErroDeDefinicaoRepetidaDeMetodo(metodo);
			return false;
		}
		metodos.put(metodo.fornecerNome(), metodo);
		Reporter.instancia().reportarDefinicaoDeMetodo(metodo);
		return true;
	}
	
	@Override
	public String comoTexto() {
		return nome;
	}
	
	@Override
	public String fornecerNome() {
		return nome;
	}
	
	@Override
	public int fornecerLinha() {
		return linha;
	}
	
	@Override
	public int fornecerColuna() {
		return coluna;
	}
}
