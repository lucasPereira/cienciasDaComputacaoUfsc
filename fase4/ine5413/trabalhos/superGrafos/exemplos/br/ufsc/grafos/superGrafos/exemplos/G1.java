package br.ufsc.grafos.superGrafos.exemplos;

import br.ufsc.grafos.superGrafos.Grafo;
import br.ufsc.grafos.superGrafos.Vertice;
import br.ufsc.grafos.superGrafos.exemplos.descritores.Pessoa;
import br.ufsc.grafos.superGrafos.utilidades.DescritorGenerico;

/**
 * Exemplo que representa o seguinte Grafo: http://www.inf.ufsc.br/grafos/definicoes/grafo.gif
 */
public class G1 {
	
	public static void main(String[] args) {
		
		Pessoa maria = new Pessoa("Maria");
		Pessoa pedro = new Pessoa("Pedro");
		Pessoa joana = new Pessoa("Joana");
		Pessoa luiz = new Pessoa("Luiz");
		
		Grafo<Pessoa, DescritorGenerico> grafo = new Grafo<Pessoa, DescritorGenerico>();
		
		Vertice<Pessoa> verticeMaria = grafo.criarVertice(maria);
		Vertice<Pessoa> verticeJoana = grafo.criarVertice(joana);
		Vertice<Pessoa> verticeLuiz = grafo.criarVertice(luiz);
		Vertice<Pessoa> verticePedro = grafo.criarVertice(pedro);
		
		DescritorGenerico descritorJoanaMaria = DescritorGenerico.novo();
		
		grafo.criarAresta(verticeLuiz, verticePedro, DescritorGenerico.novo());
		grafo.criarAresta(verticeJoana, verticeMaria, descritorJoanaMaria);
		grafo.criarAresta(verticeMaria, verticeJoana, descritorJoanaMaria);
		grafo.criarAresta(verticeMaria, verticePedro, DescritorGenerico.novo());
		grafo.criarAresta(verticeJoana, verticePedro, DescritorGenerico.novo());
		
		//grafo.removerVertice(verticeMaria);
		//grafo.removerAresta(grafo.fornecerAresta(verticeJoana, verticePedro));
		
		System.out.println("Exemplo que representa o seguinte Grafo: http://www.inf.ufsc.br/grafos/definicoes/grafo.gif\n\n");
		System.out.println(grafo);
	}
}