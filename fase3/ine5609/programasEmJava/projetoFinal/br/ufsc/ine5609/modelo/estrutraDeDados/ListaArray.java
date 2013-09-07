package br.ufsc.ine5609.modelo.estrutraDeDados;

public class ListaArray<E> {
	private E[] elementos;
	private int quantidadeDeElementos;
	
	private static final int ZERO = 0;
	private static final float FATOR_DE_CRESCIMENTO = 1.5f;
	
	@SuppressWarnings("unchecked")
	public ListaArray(int tamanho) {
		tamanho = (tamanho >= 0) ? tamanho : -tamanho;
		quantidadeDeElementos = ZERO ;
		elementos = (E[]) new Object[tamanho];
	}
	
	public void inserirNoFim(E elemento) {
		if (quantidadeDeElementos == elementos.length) {
			aumentarCapacidade();
		}
		elementos[quantidadeDeElementos++] = elemento;
	}
	
	public void inserir(int posicao, E elemento) {
		elementos[posicao] = elemento;
		quantidadeDeElementos++;
	}
	
	public E acessar(int posicao) {
		return elementos[posicao];
	}
	
	private void aumentarCapacidade() {
		@SuppressWarnings("unchecked")
		E[] listaMaior = (E[]) new Object[(int) (quantidadeDeElementos*FATOR_DE_CRESCIMENTO)];
		int cont = ZERO;
		for (E elemento : elementos) {
			listaMaior[cont++] = elemento;
		}
		elementos = listaMaior;
	}
	
	public int fornecerTamanho() {
		return quantidadeDeElementos;
	}
}