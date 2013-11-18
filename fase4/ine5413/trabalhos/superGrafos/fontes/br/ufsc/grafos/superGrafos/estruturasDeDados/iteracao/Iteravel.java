package br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao;

public interface Iteravel<T> extends Iterable<T> {
	
	public TipoIterador<T> fornecerIterador();
}