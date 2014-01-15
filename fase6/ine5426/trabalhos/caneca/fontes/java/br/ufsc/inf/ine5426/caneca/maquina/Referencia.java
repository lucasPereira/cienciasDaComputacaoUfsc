package br.ufsc.inf.ine5426.caneca.maquina;

public final class Referencia {
	private String nome;
	private Contexto contexto;
	
	public Referencia(String nome, Contexto contexto) {
		this.nome = nome;
		this.contexto = contexto;
	}
	
	public String fornecerNome() {
		return nome;
	}
	
	public Contexto fornecerContexto() {
		return contexto;
	}
}
