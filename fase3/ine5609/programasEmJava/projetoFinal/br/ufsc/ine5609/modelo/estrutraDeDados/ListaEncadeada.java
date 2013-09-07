package br.ufsc.ine5609.modelo.estrutraDeDados;

import br.ufsc.ine5609.modelo.execao.ExecaoDeFaltaDeElementos;
import br.ufsc.ine5609.modelo.execao.ExecaoDeRemocaoIlegal;

public class ListaEncadeada<E> implements Comparavel<ListaEncadeada<E>> {
	private int quantidadeDeElementos;
	private CaixaSimples<E> caixaDoPrimeiroElemento;
	
	public void inserirNoInicio(E elemento) {
		CaixaSimples<E> novaCaixaDoPrimeiroElemento = new CaixaSimples<E>(elemento, caixaDoPrimeiroElemento);
		caixaDoPrimeiroElemento = novaCaixaDoPrimeiroElemento;
		quantidadeDeElementos++;
	}
	
	public int fornecerQuantidadeDeElementos() {
		return quantidadeDeElementos;
	}
	
	protected CaixaSimples<E> fornecerCaixaDoPrimeiroElemento() {
		return caixaDoPrimeiroElemento;
	}
	
	public TipoIterador<E> fornecerIterador() {
		return new IteradorDeLista();
	}
	
	
	public String toString() {
		String string = "[ ";
		TipoIterador<E> iterador = fornecerIterador();
		while (iterador.temProximo()) {
			string += "("+iterador.fornecerProximo().toString()+") ";
		}
		string += "]";
		
		return string;
	}
	
	public boolean possui(E elemento) {
		TipoIterador<E> iterador = new IteradorDeLista();
		while (iterador.temProximo()) {
			if (iterador.fornecerProximo().equals(elemento)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean remover(E elemento) {
		boolean removido = false;
		TipoIterador<E> iterador = fornecerIterador();
		while (iterador.temProximo()) {
			if (iterador.fornecerProximo().equals(elemento)) {
				iterador.remover();
				removido = true;
			}
		}
		
		return removido;
	}
	
	public class IteradorDeLista implements TipoIterador<E> {
		private CaixaSimples<E> preCursor;
		private CaixaSimples<E> cursor;
		private CaixaSimples<E> posCursor;
		private boolean removido;
		
		public IteradorDeLista() {
			preCursor = null;
			cursor = null;
			posCursor = caixaDoPrimeiroElemento;
		}
		
		public boolean temProximo() {
			return (posCursor != null);
		}
		
		public E fornecerProximo() {
			if (posCursor == null) {
				throw new ExecaoDeFaltaDeElementos();
			}
			removido = false;
			preCursor = cursor;
			cursor = posCursor;
			posCursor = posCursor.fornecerCaixaDoProximoElemento();
			
			return cursor.fornecerElemento();
		}
		
		
		public void remover() {
			if (removido || ((preCursor == null) && (cursor == null))) {
				throw new ExecaoDeRemocaoIlegal();
			}
			if ((preCursor == null) && (cursor == caixaDoPrimeiroElemento)) {
				cursor = null;
				caixaDoPrimeiroElemento = posCursor;
			} else {
				preCursor.receberCaixaDoProximoElemento(posCursor);
				cursor = preCursor;
			}
			quantidadeDeElementos--;
			removido = true;
		}
	}

	public boolean eMaior(ListaEncadeada<E> comparado) {
		return (this.quantidadeDeElementos > comparado.quantidadeDeElementos);
	}

	public boolean eMenor(ListaEncadeada<E> comparado) {
		return (this.quantidadeDeElementos < comparado.quantidadeDeElementos);
	}

	public boolean eIgual(ListaEncadeada<E> comparado) {
		return (this.quantidadeDeElementos == comparado.quantidadeDeElementos);
	}
}