package br.ufsc.ine5609.modelo.estrutraDeDados;

public interface TipoIterador<E> {
	public boolean temProximo();
	
	public E fornecerProximo();
	
	public void remover();
}
