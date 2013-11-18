package br.ufsc.grafos.superGrafos.exemplos;

import br.ufsc.grafos.superGrafos.Grafo;
import br.ufsc.grafos.superGrafos.Vertice;
import br.ufsc.grafos.superGrafos.exemplos.descritores.MargemDeKonigsberg;
import br.ufsc.grafos.superGrafos.exemplos.descritores.PonteDeKonigsberg;

/**
 * Exemplo que representa o problema das Pontes de Königsberg, mostrado em: http://www.inf.ufsc.br/grafos/problemas/konigsb.htm
 */
public class PontesDeKonigsberg {
	
	public static void main(String[] args) {
		
		MargemDeKonigsberg margemA = new MargemDeKonigsberg('A');
		MargemDeKonigsberg margemB = new MargemDeKonigsberg('B');
		MargemDeKonigsberg margemC = new MargemDeKonigsberg('C');
		MargemDeKonigsberg margemD = new MargemDeKonigsberg('D');
		
		Grafo<MargemDeKonigsberg, PonteDeKonigsberg> grafo = new Grafo<MargemDeKonigsberg, PonteDeKonigsberg>();
		
		Vertice<MargemDeKonigsberg> verticeMargemA = grafo.criarVertice(margemA);
		Vertice<MargemDeKonigsberg> verticeMargemB = grafo.criarVertice(margemB);
		Vertice<MargemDeKonigsberg> verticeMargemC = grafo.criarVertice(margemC);
		Vertice<MargemDeKonigsberg> verticeMargemD = grafo.criarVertice(margemD);
		
		grafo.criarAresta(verticeMargemA, verticeMargemB, new PonteDeKonigsberg('a'));
		grafo.criarAresta(verticeMargemA, verticeMargemB, new PonteDeKonigsberg('b'));
		grafo.criarAresta(verticeMargemA, verticeMargemC, new PonteDeKonigsberg('c'));
		grafo.criarAresta(verticeMargemA, verticeMargemC, new PonteDeKonigsberg('d'));
		grafo.criarAresta(verticeMargemA, verticeMargemD, new PonteDeKonigsberg('e'));
		grafo.criarAresta(verticeMargemB, verticeMargemD, new PonteDeKonigsberg('f'));
		grafo.criarAresta(verticeMargemC, verticeMargemD, new PonteDeKonigsberg('g'));
		
		//grafo.removerAresta(grafo.fornecerAresta(verticeMargemA, verticeMargemB));
		//grafo.removerVertice(verticeMargemA);
		//grafo.removerAresta(grafo.fornecerAresta(verticeMargemA, verticeMargemB, new PonteDeKonigsberg('c')));
		//grafo.removerAresta(grafo.fornecerAresta(verticeMargemA, verticeMargemB, new PonteDeKonigsberg('a')));
		
		System.out.println("Exemplo que representa o problema das Pontes de Königsberg, mostrado em: http://www.inf.ufsc.br/grafos/problemas/konigsb.htm\n\n");
		System.out.println(grafo);
		
		int verticesDeGrauÍmpar = 0;
		for (Vertice<MargemDeKonigsberg> vertice : grafo.fornecerVertices()) {
			if (grafo.fornecerGrau(vertice)%2 != 0) {
				verticesDeGrauÍmpar++;
			}
		}
		if (verticesDeGrauÍmpar != 2 || verticesDeGrauÍmpar != 0) {
			System.out.println("\n\nO grafo não é nem euleriano nem atravessável, logo não é possivel cruzar " +
					"as sete pontes numa caminhada contínua sem que se passe duas vezes por qualquer " +
					"uma delas. ");
		}
	}
}