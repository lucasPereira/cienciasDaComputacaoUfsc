package br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao;

import java.util.Iterator;

import br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.execoes.ExecaoDeIteracaoInvalida;

public interface TipoIterador<T> extends Iterator<T> {
	
	/**
	 * <p>Verifica se ainda há elementos para serem iterados.</p>
	 * 
	 * @return verdadeiro se existem elementos para serem iterados.
	 */
	public boolean possuiPróximo();
	
	/**
	 * <p>Fornece o elemento que está sendo iterado. Após a execução desse método
	 * a iteração apontará para o próximo elemento.</p>
	 * 
	 * @exception {@link ExecaoDeIteracaoInvalida} lançada quando este método é excutado e não há mais
	 * elementos para serem iterados.
	 * @return o elemento que está sendo iterado.
	 */
	public T fornecerPróximo();
}