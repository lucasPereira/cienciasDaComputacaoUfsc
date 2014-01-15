package br.ufsc.inf.ine5426.caneca.maquina;

public abstract class ValorAbstrato implements Valor {
	String nome;
	
	public void fixarNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String fornecerNome() {
		return nome;
	}
	
	@Override
	public Contexto fornecerComoReferencia() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String fornecerComoTexto() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public char fornecerComoCaractere() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean fornecerComoBooleano() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int fornecerComoInteiro() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public double fornecerComoReal() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString() {
		return comoTexto();
	}
}
