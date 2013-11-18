package br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao;

import java.util.Iterator;

/**
 * Criado para manter a compatibilidade com os iteradores padrões do Java. Assim
 * é possível iterar um elemento usando:
 * <pre>
 * for (E elemento : estrutura) {
 * 		<sentenças>
 * }
 * </pre>
 *
 * @param <T>
 */
public abstract class IteravelAbstrato<T> implements Iteravel<T>  {

	@Override
	public final Iterator<T> iterator() {
		return fornecerIterador();
	}
}
