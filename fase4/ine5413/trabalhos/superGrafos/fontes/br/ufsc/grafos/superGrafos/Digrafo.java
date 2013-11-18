package br.ufsc.grafos.superGrafos;

import br.ufsc.grafos.superGrafos.estruturasDeDados.Conjunto;
import br.ufsc.grafos.superGrafos.estruturasDeDados.ConjuntoAssociativo;
import br.ufsc.grafos.superGrafos.propriedadesDeElementos.Igualavel;
import br.ufsc.grafos.superGrafos.propriedadesDeElementos.IgualavelCodificavel;
import br.ufsc.grafos.superGrafos.utilidades.Grau;

/**
 * <p>Representa um grafo orientado.</p>
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
 * @see Grafo
 * @see Vertice
 * @see Aresta
 */
public final class Digrafo<V extends IgualavelCodificavel<V>, A extends Igualavel<A>> extends GrafoAbstrato<V, A> {

	private final ConjuntoAssociativo<V, Conjunto<Vertice<V>>> sucessores;
	private final ConjuntoAssociativo<V, Conjunto<Vertice<V>>> antecessores;
	private final ConjuntoAssociativo<V, Grau> grauDosVertices;
	
	private static final int ZERO = 0;
	
	public Digrafo() {
		sucessores = new ConjuntoAssociativo<V, Conjunto<Vertice<V>>>();
		antecessores = new ConjuntoAssociativo<V, Conjunto<Vertice<V>>>();
		grauDosVertices = new ConjuntoAssociativo<V, Grau>();
	}
	
	@Override
	protected void adicionarVerticeConcreto(Vertice<V> vertice) {
		V descritorDoVertice = vertice.fornecerDescritor();
		sucessores.adicionar(descritorDoVertice, new Conjunto<Vertice<V>>());
		antecessores.adicionar(descritorDoVertice, new Conjunto<Vertice<V>>());
		grauDosVertices.adicionar(descritorDoVertice, new Grau());
	}
	
	@Override
	protected void removerVerticeConcreto(Vertice<V> vertice) {
		V descritorDoVertice = vertice.fornecerDescritor();
		Conjunto<Vertice<V>> sucessoresDoVertice = sucessores.fornecer(descritorDoVertice);
		Conjunto<Vertice<V>> antecessoresDoVertice = antecessores.fornecer(descritorDoVertice);
		for (Vertice<V> sucessor : sucessoresDoVertice) {
			boolean removida;
			do {
				removida = removerAresta(fornecerAresta(vertice, sucessor));
			} while (removida);
		}
		for (Vertice<V> antecessor : antecessoresDoVertice) {
			boolean removida = false;
			do {
				removida = removerAresta(fornecerAresta(antecessor, vertice));
			} while (removida);
		}
		sucessores.remover(descritorDoVertice);
		antecessores.remover(descritorDoVertice);
		grauDosVertices.remover(descritorDoVertice);
	}
	
	@Override
	protected void adicionarArestaConcreto(Aresta<A, V> aresta) {
		Vertice<V> verticeAlfa = aresta.fornecerVerticeAlfa();
		Vertice<V> verticeBeta = aresta.fornecerVerticeBeta();
		V descritorDoVerticeAlfa = verticeAlfa.fornecerDescritor();
		V descritorDoVerticeBeta = verticeBeta.fornecerDescritor();
		sucessores.fornecer(descritorDoVerticeAlfa).adicionar(verticeBeta);
		antecessores.fornecer(descritorDoVerticeBeta).adicionar(verticeAlfa);
		grauDosVertices.fornecer(descritorDoVerticeAlfa).incrementarGrauDeEmissão();
		grauDosVertices.fornecer(descritorDoVerticeBeta).incrementarGrauDeRecepção();
	}
	
	@Override
	protected void removerArestaConcreto(Aresta<A, V> aresta) {
		Vertice<V> verticeAlfa = aresta.fornecerVerticeAlfa();
		Vertice<V> verticeBeta = aresta.fornecerVerticeBeta();
		V descritorDoVerticeAlfa = verticeAlfa.fornecerDescritor();
		V descritorDoVerticeBeta = verticeBeta.fornecerDescritor();
		sucessores.fornecer(descritorDoVerticeAlfa).remover(verticeBeta);
		antecessores.fornecer(descritorDoVerticeBeta).remover(verticeAlfa);
		grauDosVertices.fornecer(descritorDoVerticeAlfa).decrementarGrauDeEmissão();
		grauDosVertices.fornecer(descritorDoVerticeBeta).decrementarGrauDeRecepção();
	}
	
	/**
	 * <p>Dado os {@link Vertice}s da {@link Aresta}, retorna a {@link Aresta} que guarda estes {@link Vertice}s.</p>
	 * 
	 * <p>Esse método é principalmente útil para recuperar arestas em um {@link Digrafo} que não
	 * seja um Multigrafo. Caso o seu {@link Digrafo} seja um Multigrafo, então use 
	 * {@link #fornecerAresta(Vertice, Vertice, Igualavel)}.</p>
	 * 
	 * <p>Se este método for usado em um Multigrafo, então será retornanada a primeira {@link Aresta} encontrada
	 * que contenha os dois {@link Veritce}s fornecidos.</p>
	 * 
	 * <p>Como este é um {@link Digrafo}, então a ordem dos {@link Vertices}s importa. 
	 * O primeiro {@link Vertice} (verticeAlfa) é o 
	 * {@link Vertice} de onde a {@link Aresta} parte e o segundo {@link Vertice} (verticeBeta) é o 
	 * {@link Vertice} onde a {@link Aresta} chega.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param verticeAlfa
	 * @param verticeBeta
	 * @return {@link Aresta} que contém os {@link Vertice}s fornecidos ou null caso a 
	 * {@link Aresta} não esteja no {@link Digrafo}.
	 */
	public Aresta<A, V> fornecerAresta(Vertice<V> verticeAlfa, Vertice<V> verticeBeta) {
		return fornecerAresta(verticeAlfa, verticeBeta, null);
	}
	
	/**
	 * <p>Dado os {@link Vertice}s da {@link Aresta} e o descritor da mesma, 
	 * retorna a {@link Aresta} que guarda estes {@link Vertice}s.</p>
	 * 
	 * <p>Esse método é principalmente útil para recuperar arestas em um {@link Digrafo} que
	 * seja um Multigrafo. Caso o seu {@link Digrafo} seja um Multigrafo, então use 
	 * {@link #fornecerAresta(Vertice, Vertice, Igualavel)}.</p>
	 * 
	 * <p>Como este é um {@link Digrafo}, então a ordem dos {@link Vertices}s importa. 
	 * O primeiro {@link Vertice} (verticeAlfa) é o 
	 * {@link Vertice} de onde a {@link Aresta} parte e o segundo {@link Vertice} (verticeBeta) é o 
	 * {@link Vertice} onde a {@link Aresta} chega.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param verticeAlfa
	 * @param verticeBeta
	 * @param descritorDaAresta
	 * @return {@link Aresta} que contém os {@link Vertice}s fornecidos ou null caso a 
	 * {@link Aresta} não esteja no {@link Digrafo}.
	 */
	public Aresta<A, V> fornecerAresta(Vertice<V> verticeAlfa, Vertice<V> verticeBeta, A descritorDaAresta) {
		return fornecerArestaAbstrato(verticeAlfa, verticeBeta, descritorDaAresta);
	}
	
	/**
	 * @param vertice
	 * @return o grau de emissão do {@link Vertice} fornecido ou 0 caso o {@link Vertice} não esteja 
	 * no {@link Digrafo}.
	 */
	public int fornecerGrauDeEmissão(Vertice<V> vertice) {
		Grau grauDeEmissão = grauDosVertices.fornecer(vertice.fornecerDescritor());
		if (grauDeEmissão != null) {
			return grauDeEmissão.fornecerGrauDeEmissão();
		}
		
		return ZERO;
	}
	
	/**
	 * @param vertice
	 * @return o grau de recepção do {@link Vertice} fornecido ou 0 caso o {@link Vertice} não esteja 
	 * no {@link Digrafo}.
	 */
	public int fornecerGrauDeRecepção(Vertice<V> vertice) {
		Grau grauDeRecepção = grauDosVertices.fornecer(vertice.fornecerDescritor());
		if (grauDeRecepção != null) {
			return grauDeRecepção.fornecerGrauDeRecepção();
		}
		
		return ZERO;
	}
	
	/**
	 * @param vertice
	 * @return os sucessores do {@link Vertice} fornecido.
	 */
	public Conjunto<Vertice<V>> fornecerSucessores(Vertice<V> vertice) {
		return sucessores.fornecer(vertice.fornecerDescritor());
	}
	
	/**
	 * @param vertice
	 * @return os antecessores do {@link Vertice} fornecido.
	 */
	public Conjunto<Vertice<V>> fornecerAntecessores(Vertice<V> vertice) {
		return antecessores.fornecer(vertice.fornecerDescritor());
	}
	
	@Override
	public String toString() {
		String texto = super.toString();
		texto += "\n";
		for (Vertice<V> vertice : fornecerVertices()) {
			texto += "\n";
			texto += "\nVertice: " + vertice.toString();
			texto += "\nGrau De Emissão: " + fornecerGrauDeEmissão(vertice);
			texto += "\nGrau De Recepção: " + fornecerGrauDeRecepção(vertice);
			texto += "\nSucessores: " + fornecerSucessores(vertice).toString();
			texto += "\nAntecessores: " + fornecerAntecessores(vertice).toString();
		}
		
		return texto;
	}
}