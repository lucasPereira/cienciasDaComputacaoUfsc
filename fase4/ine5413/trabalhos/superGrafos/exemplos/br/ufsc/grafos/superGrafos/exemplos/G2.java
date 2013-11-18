package br.ufsc.grafos.superGrafos.exemplos;

import br.ufsc.grafos.superGrafos.Digrafo;
import br.ufsc.grafos.superGrafos.Vertice;
import br.ufsc.grafos.superGrafos.exemplos.descritores.Pessoa;
import br.ufsc.grafos.superGrafos.utilidades.DescritorGenerico;

/**
 * Exemplo que representa o seguinte Grafo: http://www.inf.ufsc.br/grafos/definicoes/digrafo.gif
 */
public class G2 {
		
	public static void main(String[] args) {
		
		Pessoa renata = new Pessoa("Renata");
		Pessoa emerson = new Pessoa("Emerson");
		Pessoa antonio = new Pessoa("Antonio");
		Pessoa isadora = new Pessoa("Isadora");
		Pessoa alfredo = new Pessoa("Alfredo");
		Pessoa cecília = new Pessoa("Cecília");
		
		Digrafo<Pessoa, DescritorGenerico> digrafo = new Digrafo<Pessoa, DescritorGenerico>();
		
		Vertice<Pessoa> verticeRenata = digrafo.criarVertice(renata);
		Vertice<Pessoa> verticeEmerson = digrafo.criarVertice(emerson);
		Vertice<Pessoa> verticeAntonio = digrafo.criarVertice(antonio);
		Vertice<Pessoa> verticeIsadora = digrafo.criarVertice(isadora);
		Vertice<Pessoa> verticeAlfredo = digrafo.criarVertice(alfredo);
		Vertice<Pessoa> verticeCecília = digrafo.criarVertice(cecília);
		
		digrafo.criarAresta(verticeAntonio, verticeRenata, DescritorGenerico.novo());
		digrafo.criarAresta(verticeAlfredo, verticeAntonio, DescritorGenerico.novo());
		digrafo.criarAresta(verticeCecília, verticeAntonio, DescritorGenerico.novo());
		digrafo.criarAresta(verticeAlfredo, verticeEmerson, DescritorGenerico.novo());
		digrafo.criarAresta(verticeIsadora, verticeEmerson, DescritorGenerico.novo());
		
		//digrafo.removerAresta(digrafo.fornecerAresta(verticeRenata, verticeAntonio));
		//digrafo.removerAresta(digrafo.fornecerAresta(verticeAntonio, verticeRenata));
		//digrafo.removerVertice(verticeRenata);
		
		System.out.println("Exemplo que representa o seguinte Grafo: http://www.inf.ufsc.br/grafos/definicoes/digrafo.gif\n\n");
		System.out.println(digrafo);
	}
}