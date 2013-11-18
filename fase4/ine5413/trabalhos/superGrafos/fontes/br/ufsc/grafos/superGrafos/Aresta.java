package br.ufsc.grafos.superGrafos;

import br.ufsc.grafos.superGrafos.propriedadesDeElementos.Igualavel;
import br.ufsc.grafos.superGrafos.propriedadesDeElementos.IgualavelCodificavel;

/**
 * <p>Aresta do grafo.</p>
 * 
 * @param <A> é o descritor da aresta do grafo. É através de A que uma aresta é identificada em
 * um multigrafo. A aresta possui dois vertices associados a ela, o verticeAlfa e o verticeBeta. Em
 * um {@link Grafo} não importa qual dos vertices é o verticeAlfa ou verticeBeta. Já em um
 * {@link Digrafo} o verticeAlfa é sempre o vertice de onde parte a aresta e o verticeBeta é sempre
 * o vertice para onde parte a aresta.
 */
public final class Aresta<A extends Igualavel<A>, V extends IgualavelCodificavel<V>> implements TipoComponenteDeGrafo<Aresta<A, V>, A> {
	
	private A descritor;
	private Vertice<V> verticeAlfa;
	private Vertice<V> verticeBeta;
	private boolean marcado;
	private int valor;
	
	private static final int VALOR_INICIAL_DA_ARESTA = 0;
	
	protected Aresta(Vertice<V> verticeAlfa, Vertice<V> verticeBeta, A descritor) {
		this.verticeAlfa = verticeAlfa;
		this.verticeBeta = verticeBeta;
		this.descritor = descritor;
		marcado = false;
		valor = VALOR_INICIAL_DA_ARESTA;
	}
	
	protected Aresta(Vertice<V> verticeAlfa, Vertice<V> verticeBeta) {
		this(verticeAlfa, verticeBeta, null);
	}
	
	@Override
	public void marcar() {
		marcado = true;
	}
	
	@Override
	public void desmarcar() {
		marcado = false;
	}
	
	@Override
	public boolean estáMarcado() {
		return marcado;
	}
	
	@Override
	public A fornecerDescritor() {
		return descritor;
	}
	
	/**
	 * <p>Em um {@link Grafo} não importa qual vertice é o verticeAlfa. Entretanto
	 * em um {@link Digrafo} o verticeAlfa é sempre o vertice de onde a aresta parte.</p>
	 * 
	 * @return um dos vertices no caso de um {@link Grafo} e o vertice de onde a aresta parte
	 * no caso de um {@link Digrafo}.
	 */
	public Vertice<V> fornecerVerticeAlfa() {
		return verticeAlfa;
	}
	
	/**
	 * <p>Em um {@link Grafo} não importa qual vertice é o verticeBeta. Entretanto
	 * em um {@link Digrafo} o verticeBeta é sempre o vertice onde a aresta chega.</p>
	 * 
	 * @return um dos vertices no caso de um {@link Grafo} e o vertice de onde a aresta chega
	 * no caso de um {@link Digrafo}.
	 */
	public Vertice<V> fornecerVerticeBeta() {
		return verticeBeta;
	}
	
	/**
	 * Fornece o valor da aresta fixado em {@link Aresta# fixarValor(int)}. O valor padrão
	 * inicial é 0.
	 * 
	 * @return valor da aresta.
	 */
	public int fornecerValor() { 
		return valor;
	}
	
	/**
	 * Valora a aresta com o valor fornecido.
	 * 
	 * @param valor
	 */
	public void fixarValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public boolean éIgual(Aresta<A, V> outro) {
		boolean descritorIgual = true;
		if (descritor != null && outro.descritor != null) {
			descritorIgual = descritor.éIgual(outro.descritor);
		}
		return (verticeAlfa.éIgual(outro.verticeAlfa) && verticeBeta.éIgual(outro.verticeBeta) && descritorIgual);
	}
	
	@Override
	public int fornecerCódigo() {
		return (verticeAlfa.fornecerCódigo() + verticeBeta.fornecerCódigo()); 
	}	
	
	@Override
	public String toString() {
		return "(" + verticeAlfa.toString() + ", " + verticeBeta.toString() + ")";
	}
}
