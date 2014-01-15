package br.ufsc.inf.ine5426.caneca.maquina;

public interface Valor {
	public Valor copiarComNome(String nome);
	
	public String fornecerNome();
	
	public Contexto fornecerComoReferencia();
	
	public String fornecerComoTexto();
	
	public char fornecerComoCaractere();
	
	public boolean fornecerComoBooleano();
	
	public int fornecerComoInteiro();
	
	public double fornecerComoReal();
	
	public String comoTexto();
}
