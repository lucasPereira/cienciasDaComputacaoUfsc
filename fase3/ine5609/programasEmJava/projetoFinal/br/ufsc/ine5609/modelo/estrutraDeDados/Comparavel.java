package br.ufsc.ine5609.modelo.estrutraDeDados;

public interface Comparavel<T> {
	public boolean eMaior(T comparado);
	
	public boolean eMenor(T comparado);
	
	public boolean eIgual(T comparado);
}
