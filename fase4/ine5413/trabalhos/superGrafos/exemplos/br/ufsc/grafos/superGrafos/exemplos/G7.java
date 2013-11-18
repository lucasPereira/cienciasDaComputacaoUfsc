package br.ufsc.grafos.superGrafos.exemplos;

import br.ufsc.grafos.superGrafos.Grafo;
import br.ufsc.grafos.superGrafos.exemplos.descritores.Cidade;
import br.ufsc.grafos.superGrafos.exemplos.descritores.TempoDeVoo;

/**
 * Exemplo que representa o seguinte Grafo: http://www.inf.ufsc.br/grafos/definicoes/aeroporto.gif
 */
public class G7 {

	public static void main(String[] args) {
		
		Cidade sãoPaulo = new Cidade("São Paulo");
		Cidade curitiba = new Cidade("Curitiba");
		Cidade florianópolis = new Cidade("Florianópolis");
		Cidade portoAlegre = new Cidade("Porto Alegre");
		
		Grafo<Cidade, TempoDeVoo> grafo = new Grafo<Cidade, TempoDeVoo>();
		
		grafo.criarVertice(sãoPaulo);
		grafo.criarVertice(curitiba);
		//Vertice<Cidade> verticeFlorianópolis = 
		grafo.criarVertice(florianópolis);
		grafo.criarVertice(portoAlegre);
		
		grafo.criarAresta(grafo.fornecerVertice(sãoPaulo), grafo.fornecerVertice(curitiba), new TempoDeVoo(20));
		grafo.criarAresta(grafo.fornecerVertice(sãoPaulo), grafo.fornecerVertice(portoAlegre), new TempoDeVoo(60));
		grafo.criarAresta(grafo.fornecerVertice(portoAlegre), grafo.fornecerVertice(florianópolis), new TempoDeVoo(45));
		grafo.criarAresta(grafo.fornecerVertice(portoAlegre), grafo.fornecerVertice(curitiba), new TempoDeVoo(50));
		grafo.criarAresta(grafo.fornecerVertice(florianópolis), grafo.fornecerVertice(curitiba), new TempoDeVoo(30));
		grafo.criarAresta(grafo.fornecerVertice(curitiba), grafo.fornecerVertice(portoAlegre), new TempoDeVoo(50));
		
		//grafo.removerVertice(grafo.fornecerVertice(florianópolis));
		//grafo.removerAresta(grafo.fornecerAresta(grafo.fornecerVertice(curitiba), grafo.fornecerVertice(portoAlegre)));
		//grafo.removerAresta(grafo.fornecerAresta(verticeFlorianópolis, grafo.fornecerVertice(curitiba)));

		System.out.println("Exemplo que representa o seguinte Grafo: http://www.inf.ufsc.br/grafos/definicoes/aeroporto.gif\n\n");
		System.out.println(grafo);
	}
}
