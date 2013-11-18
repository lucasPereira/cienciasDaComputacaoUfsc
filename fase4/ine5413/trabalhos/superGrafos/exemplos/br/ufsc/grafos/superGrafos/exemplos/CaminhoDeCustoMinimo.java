package br.ufsc.grafos.superGrafos.exemplos;

import br.ufsc.grafos.superGrafos.Digrafo;
import br.ufsc.grafos.superGrafos.Vertice;
import br.ufsc.grafos.superGrafos.estruturasDeDados.ConjuntoAssociativo;
import br.ufsc.grafos.superGrafos.utilidades.DescritorGenerico;

/**
 * Exemplo que representao seguinte problema: http://www.inf.ufsc.br/grafos/temas/custo-minimo/dijkstra.html
 */
public class CaminhoDeCustoMinimo {
	
	private static Digrafo<DescritorGenerico, DescritorGenerico> dígrafo;
	
	public static void main(String[] args) {
		
		dígrafo = new Digrafo<DescritorGenerico, DescritorGenerico>();
		Vertice<DescritorGenerico> verticeS = dígrafo.criarVertice(DescritorGenerico.novo('s'));
		Vertice<DescritorGenerico> verticeU = dígrafo.criarVertice(DescritorGenerico.novo('u'));
		Vertice<DescritorGenerico> verticeV = dígrafo.criarVertice(DescritorGenerico.novo('v'));
		Vertice<DescritorGenerico> verticeX = dígrafo.criarVertice(DescritorGenerico.novo('x'));
		Vertice<DescritorGenerico> verticeY = dígrafo.criarVertice(DescritorGenerico.novo('y'));
		
		dígrafo.criarAresta(verticeS, verticeU,	DescritorGenerico.novo()).fixarValor(10);
		dígrafo.criarAresta(verticeS, verticeX, DescritorGenerico.novo()).fixarValor(5);
		dígrafo.criarAresta(verticeU, verticeX, DescritorGenerico.novo()).fixarValor(2);
		dígrafo.criarAresta(verticeU, verticeV, DescritorGenerico.novo()).fixarValor(1);
		dígrafo.criarAresta(verticeX, verticeU,	DescritorGenerico.novo()).fixarValor(3);
		dígrafo.criarAresta(verticeX, verticeV, DescritorGenerico.novo()).fixarValor(9);
		dígrafo.criarAresta(verticeX, verticeY, DescritorGenerico.novo()).fixarValor(2);
		dígrafo.criarAresta(verticeV, verticeY, DescritorGenerico.novo()).fixarValor(6);
		dígrafo.criarAresta(verticeY, verticeS, DescritorGenerico.novo()).fixarValor(7);
		dígrafo.criarAresta(verticeY, verticeV, DescritorGenerico.novo()).fixarValor(4);
		
		System.out.println("Exemplo que representao seguinte problema: http://www.inf.ufsc.br/grafos/temas/custo-minimo/dijkstra.html\n\n");
		System.out.println(dígrafo);
		
		encontrarCaminhoDeCustoMínimo(verticeS);
	}
	
	public static void encontrarCaminhoDeCustoMínimo(Vertice<DescritorGenerico> verticeDePartida) {
		ConjuntoAssociativo<Vertice<DescritorGenerico>, Integer> estimativas;
		ConjuntoAssociativo<Vertice<DescritorGenerico>, Vertice<DescritorGenerico>> precedentes;
		estimativas = new  ConjuntoAssociativo<Vertice<DescritorGenerico>, Integer>();
		precedentes = new ConjuntoAssociativo<Vertice<DescritorGenerico>, Vertice<DescritorGenerico>>();
		int quantidadeDeVerticesFechados = 0;
		
		//Atribua valor zero à estimativa do custo mínimo do vértice s (a raiz da busca) e infinito às demais estimativas;
		//Atribua um valor qualquer aos precedentes (o precedente de um vértice t é o vértice que precede t no caminho de custo mínimo de s para t); 
		for (Vertice<DescritorGenerico> vertice : dígrafo.fornecerVertices()) {
			estimativas.adicionar(vertice, Integer.MAX_VALUE);
			precedentes.adicionar(vertice, verticeDePartida);
		}
		estimativas.adicionar(verticeDePartida, Integer.valueOf(0));
		precedentes.adicionar(verticeDePartida, null);
		
		//Enquanto houver vértice aberto: 
		while (quantidadeDeVerticesFechados < dígrafo.fornecerVertices().fornecerQuantidadeDeElementos()) {
			//seja k um vértice ainda aberto cuja estimativa seja a menor dentre todos os vértices abertos; 
			int menorEstimativa = Integer.MAX_VALUE;
			Vertice<DescritorGenerico> verticeFechado = null;
			for (Vertice<DescritorGenerico> vertice : dígrafo.fornecerVertices()) {
				int estimativa = estimativas.fornecer(vertice);
				if (!vertice.estáMarcado() && estimativa <= menorEstimativa) {
					verticeFechado = vertice;
					menorEstimativa = estimativa;
				}
			}
			//feche o vértice k
			verticeFechado.marcar();
			quantidadeDeVerticesFechados++;
			//Para todo vértice j ainda aberto que seja sucessor de k faça: 
			for (Vertice<DescritorGenerico> verticeSucessorDoFechado : dígrafo.fornecerSucessores(verticeFechado)) {
				//some a estimativa do vértice k com o custo do arco que une k a j;
				int custoDoArco = dígrafo.fornecerAresta(verticeFechado, verticeSucessorDoFechado).fornecerValor();
				int novaEstimativadoSucessor = menorEstimativa+custoDoArco;
				//caso esta soma seja melhor que a estimativa anterior para o vértice j, substitua-a e anote k como precedente de j.
				int estivamivaDoSucessor = estimativas.fornecer(verticeSucessorDoFechado);
				if (novaEstimativadoSucessor < estivamivaDoSucessor) {
					estimativas.adicionar(verticeSucessorDoFechado, novaEstimativadoSucessor);
					precedentes.adicionar(verticeSucessorDoFechado, verticeFechado);
				}
			}
		}
		
		mostrarCaminhos(verticeDePartida, precedentes, estimativas);
	}
	
	public static void mostrarCaminhos(Vertice<DescritorGenerico> verticeDePartida, 
			ConjuntoAssociativo<Vertice<DescritorGenerico>, Vertice<DescritorGenerico>> precedentes, 
			ConjuntoAssociativo<Vertice<DescritorGenerico>, Integer> estimativas) {
		System.out.println("\n");
		for (Vertice<DescritorGenerico> verticeDestino : dígrafo.fornecerVertices()) {
			String texto = String.format("Caminho de %s até %s", verticeDePartida, verticeDestino);
			Vertice<DescritorGenerico> precedente = precedentes.fornecer(verticeDestino);
			String caminho = String.format("%s", verticeDestino); 
			while (precedente != null) {
				caminho = String.format("%s -> %s", precedente, caminho);
				precedente = precedentes.fornecer(precedente);
			}
			texto = String.format("%s\n%s\nEstimativa: %d\n", texto, caminho, estimativas.fornecer(verticeDestino));
			System.out.println(texto);
		}
	}
}