package br.ufsc.grafos.superGrafos.utilidades;

/**
 * <p>Classe usada para controlar o grau de um {@link Vertice}. Foi necessário essa classe pois nos Multigrafos
 * o grau de um {@link Vertice} não é apenas a quantidade de adjacentes. Assim é necessário ter uma tabela 
 * com o grau de cada {@link Vertice} para que se possa obter o grau desse mesmo {@link Vertice} com uma 
 * complexidade O(1).</p>
 * 
 * <p>Esta classe dá tanto suporte a {@link Vertice}s de {@link Grafo}s quanto a {@link Vertice}s de
 * {@link Digrafo}s.</p>
 */
public final class Grau {
	
	private int grauDeEmissão;
	private int grauDeRecepção;
	
	private static final int ZERO = 0;
	
	public Grau() {
		grauDeEmissão = ZERO;
		grauDeRecepção = ZERO;
	}
	
	public int fornecerGrau() {
		return grauDeEmissão;
	}
	
	public int fornecerGrauDeEmissão() {
		return grauDeEmissão;
	}
	
	public int fornecerGrauDeRecepção() {
		return grauDeRecepção;
	}
	
	public void incrementarGrau() {
		grauDeEmissão++;
		grauDeRecepção++;
	}
	
	public void incrementarGrauDeEmissão() {
		grauDeEmissão++;
	}
	
	public void incrementarGrauDeRecepção() {
		grauDeRecepção++;
	}
	
	public void decrementarGrau() {
		grauDeEmissão--;
		grauDeRecepção--;
	}
	
	public void decrementarGrauDeEmissão() {
		grauDeEmissão--;
	}
	
	public void decrementarGrauDeRecepção() {
		grauDeRecepção--;
	}	
}