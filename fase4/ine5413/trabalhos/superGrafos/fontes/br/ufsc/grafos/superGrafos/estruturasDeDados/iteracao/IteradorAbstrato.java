package br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao;

import br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.execoes.ExecaoDeOperacaoNaoPermitidaNaIteracao;

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
public abstract class IteradorAbstrato<T> implements TipoIterador<T> {

	@Override
	public final boolean hasNext() {
		return possuiPróximo();
	}

	@Override
	public final T next() {
		return fornecerPróximo();
	}

	@Override
	public final void remove() {
		throw new ExecaoDeOperacaoNaoPermitidaNaIteracao();
	}
}