package br.ufsc.ine5609.modelo.diretorio;

import br.ufsc.ine5609.modelo.estrutraDeDados.ListaArray;
import br.ufsc.ine5609.modelo.estrutraDeDados.ListaEncadeada;

public class DiretorioDiscreto<E> implements TipoDiretorio<Integer, E>{
	private ListaArray<ListaEncadeada<E>> particoes;
	private int minimo;
	
	private static final int UM = 1;
	private static final int ZERO = 0;
	
	public DiretorioDiscreto(Integer minimo, Integer maximo) {
		assert (maximo >= minimo) : "Valor máximo deve ser maior ou igual ao valor mínimo.";
		particoes = new ListaArray<ListaEncadeada<E>>(maximo-minimo+UM);
		for(int i = minimo; i <= maximo; i++) {
			particoes.inserir(calcularIndex(i), new ListaEncadeada<E>());
		}
		this.minimo = minimo;
	}
	
	public DiretorioDiscreto(Enum<?>...chaves) {
		minimo = ZERO;
		particoes = new ListaArray<ListaEncadeada<E>>(chaves.length);
		for (int i = ZERO; i < chaves.length; i++) {
			particoes.inserir(calcularIndex(i), new ListaEncadeada<E>());
		}
	}
	
	public void inserirDado(Integer chave, E elemento) {
		particoes.acessar(calcularIndex(chave)).inserirNoInicio(elemento);
	}
	
	public boolean removerDado(Integer chave, E elemento) {
		return particoes.acessar(calcularIndex(chave)).remover(elemento);
	}

	public ListaEncadeada<E> fornecerParticaoDoDiretorio(Integer chave) {
		return particoes.acessar(calcularIndex(chave));
	}
	
	private int calcularIndex(int chave) {
		return chave-minimo;
	}
}