package br.ufsc.grafos.superGrafos;

import br.ufsc.grafos.superGrafos.estruturasDeDados.Conjunto;
import br.ufsc.grafos.superGrafos.propriedadesDeElementos.Igualavel;
import br.ufsc.grafos.superGrafos.propriedadesDeElementos.IgualavelCodificavel;

/**
 * <p>Representa um grafo abstrato que pode tanto ser orientado {@link Grafo} quanto não orientado
 * {@link Digrafo}.</p>
 * 
 * @param <V> é a descrição do {@link Vertice}. Cada {@link Vertice} será representado pelo elemento V.
 * O identificador de V será usado para recuperar o {@link Vertice} desejado. 
 * Para isso V deve ser {@link IgualavelCodificavel}.
 * @param <A> é a descrição da {@link Aresta}. Cada {@link Aresta} será representada pelo elemento A. 
 * A {@link Aresta} pode ser recuperada através do fornecimento de seus {@link Vertice}s ou do fornecimento
 * de seus vertices {@link Vertice}s e de seu descritor A que deve ser {@link Igualavel}. 
 * Essa última forma é útil para os casos de um Multigrafo. 
 * 
 * @see Grafo
 * @see Digrafo
 * @see Vertice
 * @see Aresta
 */
public abstract class GrafoAbstrato<V extends IgualavelCodificavel<V>, A extends Igualavel<A>> {
	
	private final Conjunto<Vertice<V>> vertices;
	private final Conjunto<Aresta<A, V>> arestas;
	
	protected GrafoAbstrato() {
		vertices = new Conjunto<Vertice<V>>();
		arestas = new Conjunto<Aresta<A,V>>();
	}
	
	/**
	 * <p>Adiciona um {@link Vertice} ao {@link GrafoAbstrato}.</p>
	 *  
	 * <p>Complexidade O(1).</p>
	 *
	 * @param vertice
	 */
	public final void adicionarVertice(Vertice<V> vertice) {
		if (!vertices.contém(vertice)) {
			adicionarVerticeConcreto(vertice);
		}
		vertices.adicionar(vertice);
	}
	
	protected abstract void adicionarVerticeConcreto(Vertice<V> vertice);
	
	/**
	 * <p>Cria um {@link Vertice} que guarda o descritor fornecido. Após isso
	 * adiciona este {@link Vertice} ao {@link GrafoAbstrato}.</p>
	 *  
	 * <p>Complexidade O(1).</p>
	 * 
	 * @param descritorDoVertice
	 * @return {@link Vertice} criado que guarda o descritor fornecido. 
	 */
	public final Vertice<V> criarVertice(V descritorDoVertice) {
		Vertice<V> vertice = new Vertice<V>(descritorDoVertice);
		adicionarVertice(vertice);
		
		return vertice;
	}
	
	/**
	 * <p>Dado o descritor do {@link Vertice}, retorna o {@link Vertice} que guarda este descritor.
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param descritorDoVertice
	 * @return {@link Vertice} que guarda o descritor fornecido ou null caso o {@link Vertice} não 
	 * esteja no {@link GrafoAbstrato}.
	 */
	public final Vertice<V> fornecerVertice(V descritorDoVertice) {
		return vertices.fornecer(new Vertice<V>(descritorDoVertice));
	}
	
	/**
	 * <p>Remove o {@link Vertice} do {@link GrafoAbstrato}, bem como todas as {@link Aresta}s que tem ligação 
	 * com ele. Caso você não tenha o {@link Vertice} que deseja remover, então pode-se obtê-lo em
	 * {@link #fornecerVertice(IgualavelCodificavel)}. A complexidade será O(n) no caso de um {@link GrafoAbstrato} 
	 * completo pois é necessário remover todas as {@link Aresta}s do {@link Vertice} e em um {@link GrafoAbstrato} 
	 * completo um {@link Vertice} possui (n-1) {@link Aresta}s. Também podemos considerar a complexidade como
	 * O(m) para o caso de um Multigrafo, já que no pior caso em um Multigrafo um {@link Vertice} pode conter todas
	 * as {@link Aresta}s do {@link GrafoAbstrato}.</p>
	 * 
	 * <p>Complexidade: O(n).</p> 
	 * 
	 * @param vertice
	 * @return verdadeiro se o {@link Vertice} estiver no {@link GrafoAbstrato} e puder ser removido.
	 */
	public final boolean removerVertice(Vertice<V> vertice) {
		boolean possuiVertice = vertices.remover(vertice);
		if (possuiVertice) {
			removerVerticeConcreto(vertice);
		}
		
		return possuiVertice;
	}
	
	protected abstract void removerVerticeConcreto(Vertice<V> vertice);
	
	/**
	 * <p>Adiciona uma {@link Aresta} ao {@link GrafoAbstrato}. Caso os {@link Vertice}s que fazem parte 
	 * desta {@link Aresta} não estiverem no {@link GrafoAbstrato}, então os mesmo são adicionados.</p>
	 *  
	 * <p>{@link Aresta}s com os mesmos {@link Vertice}s, porém com descritores diferentes
	 * são consideradas {@link Aresta}s diferentes. Isso é utilizado para que seja possível
	 * trabalhar com Multigrafos.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param aresta
	 */
	public final void adicionarAresta(Aresta<A, V> aresta) {
		if (fornecerAresta(aresta.fornecerVerticeAlfa(), aresta.fornecerVerticeBeta(), 
				aresta.fornecerDescritor()) == null) {
			adicionarArestaConcreto(aresta);
			vertices.adicionar(aresta.fornecerVerticeAlfa());
			vertices.adicionar(aresta.fornecerVerticeBeta());
			arestas.adicionar(aresta);
		}
	}
	
	protected abstract void adicionarArestaConcreto(Aresta<A, V> aresta);
	
	/**
	 * <p>Cria uma {@link Aresta} que guarda o descritor fornecido. Após isso
	 * adiciona esta {@link Aresta} ao {@link GrafoAbstrato}.
	 * Caso os {@link Vertice}s fornecidos como parâmetro
	 * não estejam no {@link GrafoAbstrato}, então os mesmos são adicionados.</p>
	 * 
	 * <p>{@link Aresta}s com os mesmos {@link Vertice}s, porém com descritores diferentes
	 * são consideradas {@link Aresta}s diferentes. Isso é utilizado para que seja possível
	 * trabalhar com Multigrafos.</p>
	 * 
	 * <p>Em um {@link Grafo} não importa a ordem em que os {@link Vertice}s são fornecidos. 
	 * Já em um {@link Digrafo} o primeiro {@link Vertice} (verticeAlfa) será o 
	 * {@link Vertice} de onde a {@link Aresta} partirá e o segundo {@link Vertice} (verticeBeta) será o 
	 * {@link Vertice} onde a {@link Aresta} chegará.</p>
	 *  
	 * <p>Complexidade O(1).</p>
	 * 
	 * @param verticeAlfa
	 * @param verticeBeta
	 * @param descritorDaAresta
	 * @return {@link Aresta} criada que guarda o descritor fornecido.
	 */
	public final Aresta<A, V> criarAresta(Vertice<V> verticeAlfa, Vertice<V> verticeBeta, A descritorDaAresta) {
		Aresta<A, V> aresta = new Aresta<A, V>(verticeAlfa, verticeBeta, descritorDaAresta);
		adicionarAresta(aresta);
		
		return aresta;
	}
	
	protected final Aresta<A, V> fornecerArestaAbstrato(Vertice<V> verticeAlfa, Vertice<V> verticeBeta, 
			A descritorDaAresta) {
		return arestas.fornecer(new Aresta<A, V>(verticeAlfa, verticeBeta, descritorDaAresta));
	}
	
	/**
	 * <p>Dado os {@link Vertice}s da {@link Aresta}, retorna a {@link Aresta} que guarda estes {@link Vertice}s.</p>
	 * 
	 * <p>Esse método é principalmente útil para recuperar arestas em um {@link GrafoAbstrato} que não
	 * seja um Multigrafo. Caso o seu {@link GrafoAbstrato} seja um Multigrafo, então use 
	 * {@link #fornecerAresta(Vertice, Vertice, Igualavel)}.</p>
	 * 
	 * <p>Se este método for usado em um Multigrafo, então será retornanada a primeira {@link Aresta} encontrada
	 * que contenha os dois {@link Veritce}s fornecidos.</p>
	 * 
	 * <p>Em um {@link Grafo} não importa a ordem em que os {@link Vertice}s são fornecidos. 
	 * Já em um {@link Digrafo} o primeiro {@link Vertice} (verticeAlfa) é o 
	 * {@link Vertice} de onde a {@link Aresta} parte e o segundo {@link Vertice} (verticeBeta) é o 
	 * {@link Vertice} onde a {@link Aresta} chega.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param verticeAlfa
	 * @param verticeBeta
	 * @return {@link Aresta} que contém os {@link Vertice}s fornecidos ou null caso a 
	 * {@link Aresta} não esteja no {@link GrafoAbstrato}.
	 */
	public abstract Aresta<A, V> fornecerAresta(Vertice<V> verticeAlfa, Vertice<V> verticeBeta);
	
	/**
	 * <p>Dado os {@link Vertice}s da {@link Aresta} e o descritor da mesma, 
	 * retorna a {@link Aresta} que guarda estes {@link Vertice}s.</p>
	 * 
	 * <p>Esse método é principalmente útil para recuperar arestas em um {@link GrafoAbstrato} que
	 * seja um Multigrafo. Caso o seu {@link GrafoAbstrato} não seja um Multigrafo, então use 
	 * {@link #fornecerAresta(Vertice, Vertice)}.</p>
	 * 
	 * <p>Em um {@link Grafo} não importa a ordem em que os {@link Vertice}s são fornecidos. 
	 * Já em um {@link Digrafo} o primeiro {@link Vertice} (verticeAlfa) é o 
	 * {@link Vertice} de onde a {@link Aresta} parte e o segundo {@link Vertice} (verticeBeta) é o 
	 * {@link Vertice} onde a {@link Aresta} chega.</p>
	 * 
	 * <p>Complexidade: O(1).</p>
	 * 
	 * @param verticeAlfa
	 * @param verticeBeta
	 * @param descritorDaAresta
	 * @return {@link Aresta} que contém os {@link Vertice}s fornecidos e tenha um descritor igual ao fornecido
	 * ou null caso a {@link Aresta} não esteja no {@link GrafoAbstrato}.
	 */
	public abstract Aresta<A, V> fornecerAresta(Vertice<V> verticeAlfa, Vertice<V> verticeBeta, A descritorDaAresta);
	
	/**
	 * <p>Remove a {@link Aresta} do {@link GrafoAbstrato}. Note que essa operação não remove do 
	 * {@link GrafoAbstrato} os {@link Vertice}s pertencentes a essa {@link Aresta}. Caso você não tenha a 
	 * {@link Aresta} que deseja remover, então pode obtê-la através de 
	 * {@link #fornecerAresta(IgualavelCodificavel, IgualavelCodificavel)} ou de
	 * {@link #fornecerAresta(IgualavelCodificavel, IgualavelCodificavel, Igualavel)} no caso de Multigrafos.</p>
	 * 
	 * <p>{@link Aresta}s com os mesmos {@link Vertice}s, porém com descritores diferentes
	 * são consideradas {@link Aresta}s diferentes. Isso é utilizado para que seja possível
	 * trabalhar com Multigrafos.</p>
	 * 
	 * <p>Complexidade: O(1).</p> 
	 * 
	 * @param aresta
	 * @return verdadeiro se a {@link Aresta} estiver no {@link GrafoAbstrato} puder ser removida.
	 */
	public final boolean removerAresta(Aresta<A, V> aresta) {
		if (aresta == null) {
			return false;
		}
		Aresta<A, V> arestaRemovida = fornecerAresta(aresta.fornecerVerticeAlfa(), aresta.fornecerVerticeBeta());
		boolean possuiAresta = (arestaRemovida != null);
		if (possuiAresta) {
			arestas.remover(arestaRemovida);
			removerArestaConcreto(arestaRemovida);
		}
		
		return possuiAresta;
	}

	protected abstract void removerArestaConcreto(Aresta<A, V> aresta);
	
	/**
	 * @return A ordem do {@link GrafoAbstrato}.
	 */
	public final int fornecerOrdem() {
		return vertices.fornecerQuantidadeDeElementos();
	}
	
	/**
	 * @return Todos os {@link Vertice}s do {@link GrafoAbstrato}.
	 */
	public final Conjunto<Vertice<V>> fornecerVertices() {
		return vertices;
	}
	
	/**
	 * @return Todas as {@link Aresta}s do {@link GrafoAbstrato}.
	 */
	public final Conjunto<Aresta<A, V>> fornecerArestas() {
		return arestas;
	}
	
	@Override
	public String toString() {
		String texto = "";
		texto += "Ordem: " + fornecerOrdem();
		texto += "\nVertices: " + vertices.toString();
		texto += "\nArestas: " + arestas.toString();
		texto += "\n\n";
		texto += "\nArestas";
		for (Aresta<A, V> aresta : arestas) {
			texto += "\n" + aresta + "\tDescritor: " + aresta.fornecerDescritor().toString() + 
					".\tValor: " + aresta.fornecerValor() + ".";
		}
		
		return texto;
	}
}