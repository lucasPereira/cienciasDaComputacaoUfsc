package br.ufsc.grafos.superGrafos.estruturasDeDados;

import br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.IteradorAbstrato;
import br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.IteravelAbstrato;
import br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.TipoIterador;
import br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.execoes.ExecaoDeIteracaoInvalida;
import br.ufsc.grafos.superGrafos.propriedadesDeElementos.Igualavel;

/**
 * Lista implementada com encadeamento simples. Na lista podem haver elementos repetidos. 
 *
 * @param <E> elemento que será guardado na lista. Os elementos que serão guardados nessa lista
 * precisam implementar a interface {@link Igualavel}.
 */
public final class Lista<E extends Igualavel<E>> extends IteravelAbstrato<E> {
	
	private CaixaDoElemento caixaDoPrimeiroElemento;
	private CaixaDoElemento caixaDoÚltimoElemento;
	private int quantidadeDeElementos;
	
	private static final int ZERO = 0;
	
	public Lista() {
		quantidadeDeElementos = ZERO;
	}
	
	/**
	 * <p>Adiciona um elemento no ínicio da lista.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param elemento
	 */
	public void adicionarNoÍnicio(E elemento) {
		CaixaDoElemento caixaDoNovoPrimeiroElemento = new CaixaDoElemento(elemento);
		caixaDoNovoPrimeiroElemento.fixarCaixaDoPróximoElemento(caixaDoPrimeiroElemento);
		caixaDoPrimeiroElemento = caixaDoNovoPrimeiroElemento;
		if (quantidadeDeElementos == ZERO) {
			caixaDoÚltimoElemento = caixaDoPrimeiroElemento;
		}
		quantidadeDeElementos++;
	}
	
	/**
	 * <p>Adiciona um elemento no fim da lista.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param elemento
	 */
	public void adicionarNoFim(E elemento) {
		CaixaDoElemento caixaDoNovoÚltimoElemento = new CaixaDoElemento(elemento);
		if (quantidadeDeElementos == ZERO) {
			caixaDoPrimeiroElemento = caixaDoNovoÚltimoElemento;
		} else {
			caixaDoÚltimoElemento.fixarCaixaDoPróximoElemento(caixaDoNovoÚltimoElemento);
		}
		caixaDoÚltimoElemento = caixaDoNovoÚltimoElemento;
		quantidadeDeElementos++;
	}
	
	/**
	 * <p>Remove o elemento especificado.</p>
	 * 
	 * <p>Complexidade: O(n).</p>
	 * 
	 * @param elemento
	 * @return verdadeiro se o elemento estiver na lista e puder ser removido.
	 */
	public boolean remover(E elemento) {
		if (estáVazia()) {
			return false;
		}
		if (caixaDoPrimeiroElemento.fornecerElemento().éIgual(elemento)) {
			caixaDoPrimeiroElemento = caixaDoPrimeiroElemento.fornecerCaixaDoPróximoElemento();
			quantidadeDeElementos--;
			return true;
		}
		CaixaDoElemento caixaDoElementoAntecessorAoRemovido = caixaDoPrimeiroElemento;
		CaixaDoElemento caixaDoElementoRemovido = caixaDoPrimeiroElemento.fornecerCaixaDoPróximoElemento();
		while (caixaDoElementoRemovido != null) {
			if (caixaDoElementoRemovido.fornecerElemento().éIgual(elemento)) {
				caixaDoElementoAntecessorAoRemovido.
					fixarCaixaDoPróximoElemento(caixaDoElementoRemovido.fornecerCaixaDoPróximoElemento());
				quantidadeDeElementos--;
				return true;
			}
			caixaDoElementoAntecessorAoRemovido = caixaDoElementoRemovido;
			caixaDoElementoRemovido = caixaDoElementoRemovido.fornecerCaixaDoPróximoElemento();
		}
		
		return false;
	}
	
	/**
	 * <p>Verifica se o elemento está na lista.</p>
	 * 
	 * <p>Complexidade: O(n).</p>
	 * 
	 * @param elemento
	 * @return verdadeiro se o lemento estiver na lista.
	 */
	public boolean contém(E elemento) {
		TipoIterador<E> iterador = new Iterador();
		while (iterador.possuiPróximo()) {
			if (iterador.fornecerPróximo().éIgual(elemento)) {
				return true;
			}
		} 
		
		return false;
	}
	
	/**
	 * <p>Fornece a quantidade de elementos presentes na lista.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @return a quantidade de elementos presentes na lista.
	 */
	public int fornecerQuantidadeDeElementos() {
		return quantidadeDeElementos;
	}
	
	public boolean estáVazia() {
		return quantidadeDeElementos == ZERO;
	}
	
	@Override
	public TipoIterador<E> fornecerIterador() {
		return new Iterador();
	}
	
	private final class Iterador extends IteradorAbstrato<E> {
		
		private CaixaDoElemento cursor;
		
		public Iterador() {
			cursor = caixaDoPrimeiroElemento;
		}
		
		@Override
		public boolean possuiPróximo() {
			return (cursor != null);
		}

		@Override
		public E fornecerPróximo() {
			if (!possuiPróximo()) {
				throw new ExecaoDeIteracaoInvalida();
			}
			E elemento = cursor.fornecerElemento();
			cursor = cursor.fornecerCaixaDoPróximoElemento();
			
			return elemento;
		}
	}
	
	private final class CaixaDoElemento {
		
		private E elemento;
		private CaixaDoElemento caixaDoPróximoElemento;
		
		public CaixaDoElemento(E elemento) {
			this.elemento = elemento;
		}
		
		public void fixarCaixaDoPróximoElemento(CaixaDoElemento caixaDoPróximoElemento) {
			this.caixaDoPróximoElemento = caixaDoPróximoElemento; 
		}
		
		public E fornecerElemento() {
			return elemento;
		}
		
		public CaixaDoElemento fornecerCaixaDoPróximoElemento() {
			return caixaDoPróximoElemento;
		}
		
		@Override
		public String toString() {
			return elemento.toString();
		}
	}
	
	@Override
	public String toString() {
		String texto = "[";
		TipoIterador<E> iterador = fornecerIterador();
		while (iterador.possuiPróximo()) {
			texto += iterador.fornecerPróximo().toString() + ", "; 
		}
		texto = (texto.equals("[")) ? "[ ]" : texto.substring(ZERO, texto.length()-2) + "]";
		
		return texto;
	}
}