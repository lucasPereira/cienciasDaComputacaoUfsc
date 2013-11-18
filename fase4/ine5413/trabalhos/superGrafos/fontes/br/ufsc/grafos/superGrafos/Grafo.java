package br.ufsc.grafos.superGrafos;

import br.ufsc.grafos.superGrafos.estruturasDeDados.Conjunto;
import br.ufsc.grafos.superGrafos.estruturasDeDados.ConjuntoAssociativo;
import br.ufsc.grafos.superGrafos.propriedadesDeElementos.Igualavel;
import br.ufsc.grafos.superGrafos.propriedadesDeElementos.IgualavelCodificavel;
import br.ufsc.grafos.superGrafos.utilidades.Grau;

/**
 * <p>Representa um grafo não orientado.</p>
 * 
 * @param <V> é a descrição do {@link Vertice}. Cada {@link Vertice} será representado pelo elemento V.
 * O identificador de V será usado para recuperar o {@link Vertice} desejado. 
 * Para isso V deve ser {@link IgualavelCodificavel}.
 * @param <A> é a descrição da {@link Aresta}. Cada {@link Aresta} será representada pelo elemento A. 
 * A {@link Aresta} pode ser recuperada através do fornecimento de seus {@link Vertice}s ou do fornecimento
 * de seus vertices {@link Vertice}s e de seu descritor A que deve ser {@link Igualavel}. 
 * Essa última forma é útil para os casos de um Multigrafo. 
 * 
 * @see GrafoAbstrato
 * @see Digrafo
 * @see Vertice
 * @see Aresta
 */
public final class Grafo<V extends IgualavelCodificavel<V>, A extends Igualavel<A>> extends GrafoAbstrato<V, A> {
	
	private final ConjuntoAssociativo<V, Conjunto<Vertice<V>>> adjacentes;
	private final ConjuntoAssociativo<V, Grau> grauDosVertices;
	
	private static final int ZERO = 0;
	
	public Grafo() {
		adjacentes = new ConjuntoAssociativo<V, Conjunto<Vertice<V>>>();
		grauDosVertices = new ConjuntoAssociativo<V, Grau>();
	}
	
	@Override
	protected void adicionarVerticeConcreto(Vertice<V> vertice) {
		V descritorDoVertice = vertice.fornecerDescritor();
		adjacentes.adicionar(descritorDoVertice, new Conjunto<Vertice<V>>());
		grauDosVertices.adicionar(descritorDoVertice, new Grau());
	}

	@Override
	protected void removerVerticeConcreto(Vertice<V> vertice) {
		V descritorDoVertice = vertice.fornecerDescritor();
		Conjunto<Vertice<V>> adjacentesDoVertice = adjacentes.fornecer(descritorDoVertice);
		for (Vertice<V> adjacente : adjacentesDoVertice) {
			boolean removida;
			do {
				removida = removerAresta(fornecerAresta(vertice, adjacente));
			} while (removida);
		}
		adjacentes.remover(descritorDoVertice);
		grauDosVertices.remover(descritorDoVertice);
	}

	@Override
	protected void adicionarArestaConcreto(Aresta<A, V> aresta) {
		Vertice<V> verticeAlfa = aresta.fornecerVerticeAlfa();
		Vertice<V> verticeBeta = aresta.fornecerVerticeBeta();
		V descritorDoVerticeAlfa = verticeAlfa.fornecerDescritor();
		V descritorDoVerticeBeta = verticeBeta.fornecerDescritor();
		adjacentes.fornecer(descritorDoVerticeAlfa).adicionar(verticeBeta);
		adjacentes.fornecer(descritorDoVerticeBeta).adicionar(verticeAlfa);
		grauDosVertices.fornecer(descritorDoVerticeAlfa).incrementarGrau();
		grauDosVertices.fornecer(descritorDoVerticeBeta).incrementarGrau();
	}

	@Override
	protected void removerArestaConcreto(Aresta<A, V> aresta) {
		Vertice<V> verticeAlfa = aresta.fornecerVerticeAlfa();
		Vertice<V> verticeBeta = aresta.fornecerVerticeBeta();
		V descritorDoVerticeAlfa = verticeAlfa.fornecerDescritor();
		V descritorDoVerticeBeta = verticeBeta.fornecerDescritor();
		adjacentes.fornecer(descritorDoVerticeAlfa).remover(verticeBeta);
		adjacentes.fornecer(descritorDoVerticeBeta).remover(verticeAlfa);
		grauDosVertices.fornecer(descritorDoVerticeAlfa).decrementarGrau();
		grauDosVertices.fornecer(descritorDoVerticeBeta).decrementarGrau();
	}
	
	/**
	 * <p>Dado os {@link Vertice}s da {@link Aresta}, retorna a {@link Aresta} que guarda estes {@link Vertice}s.</p>
	 * 
	 * <p>Esse método é principalmente útil para recuperar arestas em um {@link Grafo} que não
	 * seja um Multigrafo. Caso o seu {@link Grafo} seja um Multigrafo, então use 
	 * {@link #fornecerAresta(Vertice, Vertice, Igualavel)}.</p>
	 * 
	 * <p>Se este método for usado em um Multigrafo, então será retornanada a primeira {@link Aresta} encontrada
	 * que contenha os dois {@link Veritce}s fornecidos.</p>
	 * 
	 * <p>Como este é um {@link Grafo}, então a ordem dos {@link Vertices}s não importa. 
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param verticeAlfa
	 * @param verticeBeta
	 * @return {@link Aresta} que contém os {@link Vertice}s fornecidos ou null caso a 
	 * {@link Aresta} não esteja no {@link Grafo}.
	 */
	public Aresta<A, V> fornecerAresta(Vertice<V> verticeAlfa, Vertice<V> verticeBeta) {
		return fornecerAresta(verticeAlfa, verticeBeta, null);
	}
	
	/**
	 * <p>Dado os {@link Vertice}s da {@link Aresta} e o descritor da mesma, 
	 * retorna a {@link Aresta} que guarda estes {@link Vertice}s.</p>
	 * 
	 * <p>Esse método é principalmente útil para recuperar arestas em um {@link Grafo} que
	 * seja um Multigrafo. Caso o seu {@link Grafo} não seja um Multigrafo, então use 
	 * {@link #fornecerAresta(Vertice, Vertice, Igualavel)}.</p>
	 * 
	 * <p>Como este é um {@link Grafo}, então a ordem dos {@link Vertices}s não importa. 
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param descritorDaAresta
	 * @param verticeAlfa
	 * @param verticeBeta
	 * @return {@link Aresta} que contém os {@link Vertice}s fornecidos ou null caso a 
	 * {@link Aresta} não esteja no {@link Grafo}.
	 */
	public Aresta<A, V> fornecerAresta(Vertice<V> verticeAlfa, Vertice<V> verticeBeta, A descritorDaAresta) {
		Aresta<A, V> aresta = fornecerArestaAbstrato(verticeAlfa, verticeBeta, descritorDaAresta);
		if (aresta == null) {
			return fornecerArestaAbstrato(verticeBeta, verticeAlfa, descritorDaAresta);
		}
		
		return aresta;
	}
		
	/**
	 * @param vertice
	 * @return o grau do {@link Vertice} fornecido ou 0 caso o {@link Vertice} não esteja no {@link Grafo}.
	 */
	public int fornecerGrau(Vertice<V> vertice) {
		Grau grau = grauDosVertices.fornecer(vertice.fornecerDescritor());
		if (grau != null) {
			return grau.fornecerGrau();
		}
		
		return ZERO;
	}
	
	/**
	 * @param vertice
	 * @return os adjacentes do {@link Vertice} fornecido.
	 */
	public Conjunto<Vertice<V>> fornecerAdjacentes(Vertice<V> vertice) {
		return adjacentes.fornecer(vertice.fornecerDescritor());
	}
	
	@Override
	public String toString() {
		String texto = super.toString();
		texto += "\n";
		for (Vertice<V> vertice : fornecerVertices()) {
			texto += "\n";
			texto += "\nVertice: " + vertice.toString();
			texto += "\nGrau: " + fornecerGrau(vertice);
			texto += "\nAdjacentes: " + fornecerAdjacentes(vertice).toString();
		}
		
		return texto;
	}
}