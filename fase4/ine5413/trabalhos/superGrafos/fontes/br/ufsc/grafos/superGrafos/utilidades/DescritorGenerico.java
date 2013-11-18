package br.ufsc.grafos.superGrafos.utilidades;

import br.ufsc.grafos.superGrafos.Aresta;
import br.ufsc.grafos.superGrafos.Vertice;
import br.ufsc.grafos.superGrafos.propriedadesDeElementos.IgualavelCodificavel;

/**
 * Classe usada para o caso de não se querer definir nenhum descritor para um {@link Vertice} ou {@link Aresta}.
 */
public final class DescritorGenerico implements IgualavelCodificavel<DescritorGenerico> {
	
	private static int contadorDeDescritores = 0;

	private int código;
	private char letra;
	
	private DescritorGenerico(char letra) {
		código = ++contadorDeDescritores;
		this.letra = letra;
	}
	
	public static DescritorGenerico novo() {
		return new DescritorGenerico(' ');
	}
	
	public static DescritorGenerico novo(char letra) {
		return new DescritorGenerico(letra);
	}
	
	@Override
	public boolean éIgual(DescritorGenerico outro) {
		return código == outro.código;
	}

	@Override
	public int fornecerCódigo() {
		return código;
	}
	
	public char fornecerLetra() {
		return letra;
	}
	
	@Override
	public String toString() {
		return letra+"";
	}
}