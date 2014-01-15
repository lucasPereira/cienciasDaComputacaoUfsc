package br.ufsc.inf.ine5426.caneca.maquina;

public final class ValorReferencia extends ValorAbstrato {
	private Contexto contexto;
	
	public ValorReferencia(Contexto contexto) {
		this.contexto = contexto;
	}
	
	@Override
	public ValorReferencia copiarComNome(String nome) {
		ValorReferencia valor = new ValorReferencia(contexto);
		valor.fixarNome(nome);
		return valor;
	}
	
	@Override
	public Contexto fornecerComoReferencia() {
		return contexto;
	}
	
	@Override
	public String fornecerComoTexto() {
		return contexto.resolverSimbolo(nome).fornecerComoTexto();
	}
	
	@Override
	public char fornecerComoCaractere() {
		return contexto.resolverSimbolo(nome).fornecerComoCaractere();
	}
	
	@Override
	public boolean fornecerComoBooleano() {
		return contexto.resolverSimbolo(nome).fornecerComoBooleano();
	}
	
	@Override
	public int fornecerComoInteiro() {
		return contexto.resolverSimbolo(nome).fornecerComoInteiro();
	}
	
	@Override
	public double fornecerComoReal() {
		return contexto.resolverSimbolo(nome).fornecerComoReal();
	}
	
	@Override
	public String comoTexto() {
		return String.format("referencia:%s", nome);
	}
}
