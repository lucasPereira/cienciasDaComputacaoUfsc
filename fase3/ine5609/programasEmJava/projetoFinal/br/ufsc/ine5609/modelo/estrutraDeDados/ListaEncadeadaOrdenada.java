package br.ufsc.ine5609.modelo.estrutraDeDados;


public class ListaEncadeadaOrdenada<E extends Comparavel<E>> extends ListaEncadeada<E> {
	private static final int ZERO = 0;
	
	public void inserirOrdenado(E elemento) {
		CaixaSimples<E> caixaDoPrimeiroElemento = fornecerCaixaDoPrimeiroElemento();
		if (fornecerQuantidadeDeElementos() == ZERO || elemento.eMenor(caixaDoPrimeiroElemento.fornecerElemento())) {
			inserirNoInicio((E) elemento);
		} else {
			boolean inserido = false;
			CaixaSimples<E> atual = caixaDoPrimeiroElemento;
			CaixaSimples<E> proximo = caixaDoPrimeiroElemento.fornecerCaixaDoProximoElemento();
			while ((proximo != null) && !inserido) {
				if (elemento.eMenor(proximo.fornecerElemento())) {
					CaixaSimples<E> caixaDoElemento = new CaixaSimples<E>(elemento, proximo);
					atual.receberCaixaDoProximoElemento(caixaDoElemento);
					inserido = true;
				}
				atual = proximo;
				proximo = proximo.fornecerCaixaDoProximoElemento();
			}
			if (!inserido) {
				atual.receberCaixaDoProximoElemento(new CaixaSimples<E>(elemento));
			}
		}
	}
}