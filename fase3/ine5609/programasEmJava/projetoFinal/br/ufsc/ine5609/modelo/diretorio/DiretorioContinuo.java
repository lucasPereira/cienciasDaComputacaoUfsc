package br.ufsc.ine5609.modelo.diretorio;

import br.ufsc.ine5609.modelo.estrutraDeDados.ListaArray;
import br.ufsc.ine5609.modelo.estrutraDeDados.ListaEncadeada;

public class DiretorioContinuo<E> implements TipoDiretorio<Double, E> {
	private ListaArray<ListaEncadeada<E>> particao;
	private ListaArray<Double> intervalos;
	
	private static final int ZERO = 0;
	private static final int UM = 1;
	
	public DiretorioContinuo(Double...intervalos) {
		particao = new ListaArray<ListaEncadeada<E>>(intervalos.length-UM);
		this.intervalos = new ListaArray<Double>(intervalos.length);
		this.intervalos.inserir(ZERO, intervalos[ZERO]);
		for (int indice = UM; indice < intervalos.length; indice++) {
			assert (intervalos[indice] > intervalos[indice-UM]) : "O intervalo deve estar em ordem crescente.";
			this.intervalos.inserir(indice, intervalos[indice]);
			particao.inserir(indice-UM, new ListaEncadeada<E>());
		}
	}
	
	public void inserirDado(Double chave, E elemento) {
		fornecerParticaoDoDiretorio(chave).inserirNoInicio(elemento);
	}
	
	public boolean removerDado(Double chave, E elemento) {
		return fornecerParticaoDoDiretorio(chave).remover(elemento);
	}
	
	public ListaEncadeada<E> fornecerParticaoDoDiretorio(Double chave) {
		assert (chave < intervalos.acessar(intervalos.fornecerTamanho()-UM)) : "Chave deve ser menor que o maior intervalo.";
		assert (chave > intervalos.acessar(ZERO)) : "Chave deve ser maior que o menor intervalo.";
		int cont = ZERO;
		boolean intervaloEncontrado = false;
		int quantidadeDeIntervalos = intervalos.fornecerTamanho()-UM;
		while ((cont < quantidadeDeIntervalos) && !intervaloEncontrado) {
			if (chave >= intervalos.acessar(cont) && chave < intervalos.acessar(++cont)) {
				intervaloEncontrado = true;
			}
		}
		
		return particao.acessar(cont-UM);
	}
}