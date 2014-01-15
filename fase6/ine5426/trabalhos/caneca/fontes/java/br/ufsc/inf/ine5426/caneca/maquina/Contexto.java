package br.ufsc.inf.ine5426.caneca.maquina;

import java.util.HashMap;
import java.util.Map;

public final class Contexto {
	private Contexto contextoPai;
	private Map<String, Valor> simbolos;
	private Map<String, Contexto> contextos;
	private Map<String, Integer> pontosDeEntrada;
	
	public Contexto(Contexto contextoPai) {
		this.contextoPai = contextoPai;
		simbolos = new HashMap<String, Valor>();
		contextos = new HashMap<String, Contexto>();
		pontosDeEntrada = new HashMap<String, Integer>();
	}
	
	public Contexto() {
		this(null);
	}
	
	public void definirSimbolo(String nome, Valor valor) {
		simbolos.put(nome, valor);
	}
	
	public void atualizarSimbolo(String nome, Valor valor) {
		if (simbolos.containsKey(nome)) {
			simbolos.put(nome, valor);
		} else if (contextoPai != null) {
			contextoPai.atualizarSimbolo(nome, valor);
		}
	}
	
	public Valor resolverSimbolo(String nome) {
		Valor valor = simbolos.get(nome);
		if (valor == null && contextoPai != null) {
			valor = contextoPai.resolverSimbolo(nome);
		}
		return valor;
	}
	
	public void definirPontoDeEntrada(String nome, Integer pontoDeEntrada) {
		pontosDeEntrada.put(nome, pontoDeEntrada);
	}
	
	public Integer resolverPontoDeEntrada(String nome) {
		Integer pontoDeEntrada = pontosDeEntrada.get(nome);
		if (pontoDeEntrada == null && contextoPai != null) {
			pontoDeEntrada = contextoPai.resolverPontoDeEntrada(nome);
		}
		return pontoDeEntrada;
	}
	
	public void definirContexto(String nome, Contexto contexto) {
		contextos.put(nome, contexto);
	}
	
	public Contexto resolverContexto(String nome) {
		Contexto contexto = contextos.get(nome);
		if (contexto == null && contextoPai != null) {
			contexto = contextoPai.resolverContexto(nome);
		}
		return contexto;
	}
	
	public Map<String, Valor> fornecerSimbolos() {
		return simbolos;
	}
}
