package br.lucaspereira.caingangue.http;

public interface TipoElementoHttp<T> {

	public boolean éIgual(T outroElementoHttp);
	
	public boolean éIgual(String outroValorTextual);
	
	public String fornecerComoTexto();
}