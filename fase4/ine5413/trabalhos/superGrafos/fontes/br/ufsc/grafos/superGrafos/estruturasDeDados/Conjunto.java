package br.ufsc.grafos.superGrafos.estruturasDeDados;

import br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.IteravelAbstrato;
import br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.TipoIterador;
import br.ufsc.grafos.superGrafos.propriedadesDeElementos.Igualavel;
import br.ufsc.grafos.superGrafos.propriedadesDeElementos.IgualavelCodificavel;

/**
 * <p>{@link Conjunto} que é implementado através de um {@link ConjuntoAssociativo}. A diferença do 
 * {@link ConjuntoAssociativo} para o {@link Conjunto} é que neste último o próprio valor é sua chave.</p>
 *
 * @param <E> elemento que será guardado no conjunto. Os elementos que serão guardados 
 * nesse conjunto deverão implementar a interface {@link IgualavelCodificavel} que por sua vez é uma extensão
 * da interface {@link Igualavel}.
 */
public final class Conjunto<E extends IgualavelCodificavel<E>> extends IteravelAbstrato<E> {
	
	private final ConjuntoAssociativo<E, E> elementos;
	
	/**
	 * <p>Cria um {@link Conjunto} com a capacidade inicial fornecida.</p>
	 * 
	 * <p>Nota de implementação: Veja {@link ConjuntoAssociativo#ConjuntoAssociativo(int)}.</p>
	 * 
	 * @param capacidadeInicial
	 */
	public Conjunto(int capacidadeInicial) {
		elementos = new ConjuntoAssociativo<E, E>(capacidadeInicial);
	}
	
	/**
	 * <p>Nota de implementação: Veja {@link ConjuntoAssociativo#ConjuntoAssociativo()}.</p>
	 */
	public Conjunto() {
		elementos = new ConjuntoAssociativo<E, E>();
	}
	
	/**
	 * <p>Adiciona um elemento ao {@link Conjunto}. Se já exisitr um elemento igual no
	 * {@link Conjunto}, então o elemento já existente é substituído pelo elemento inserido.</p>
	 * 
	 * <p>Nota de implementação: Veja {@link ConjuntoAssociativo#adicionar(IgualavelCodificavel, Object)}.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param elemento
	 */
	public void adicionar(E elemento) {
		elementos.adicionar(elemento, elemento);
	}
	
	/**
	 * <p>Fornece o elemento fornecido como parâmetro. Esse método é últil quando não se tem o 
	 * elemento "por completo", mas apenas seu código ou identificadores usados para comparação no método
	 * {@link Igualavel#éIgual(Object)}.</p> 
	 * 
	 * <p>Nota de implementação: Veja {@link ConjuntoAssociativo#remover(IgualavelCodificavel)}.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param elemento
	 * @return o valor que se iguale ao elemento fornecido, ou null, caso o elemento não esteja 
	 * no {@link Conjunto}.
	 */
	public E fornecer(E elemento) {
		return elementos.fornecer(elemento);
	}
	
	/**
	 * <p>Remove o elemento do {@link Conjunto}.</p>
	 * 
	 * <p>Nota de implementação: Veja {@link ConjuntoAssociativo#remover(IgualavelCodificavel)}.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param elemento
	 * @return verdadeiro se o elemento existir para ser removido.
	 */
	public boolean remover(E elemento) {
		return elementos.remover(elemento); 
	}
	
	/**
	 * <p>Verifica se o elemento está no {@link Conjunto}.</p>
	 * 
	 * <p>Nota de implementação: Veja {@link ConjuntoAssociativo#contém(IgualavelCodificavel)}.</p>
	 *  
	 * <p>Complexidade: O(1).</p> 
	 * 
	 * @param elemento
	 * @return verdadeiro se o {@link Conjunto} contiver o elemenot fornecido.
	 */
	public boolean contém(E elemento) {
		return elementos.contém(elemento);
	}
	
	/**
	 * <p>Fornece a quantidade de elementos presentes no {@link Conjunto}.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @return a quantidade de elementos presentes no {@link Conjunto}.
	 */
	public int fornecerQuantidadeDeElementos() {
		return elementos.fornecerQuantidadeDeElementos();
	}
	
	@Override
	public TipoIterador<E> fornecerIterador() {
		return elementos.fornecerIterador();
	}
	
	@Override
	public String toString() {
		return elementos.toString();
	}
}