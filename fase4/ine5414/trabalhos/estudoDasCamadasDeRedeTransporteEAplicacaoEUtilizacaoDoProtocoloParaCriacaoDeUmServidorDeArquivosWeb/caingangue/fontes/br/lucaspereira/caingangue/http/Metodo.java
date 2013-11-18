package br.lucaspereira.caingangue.http;

public enum Metodo implements TipoElementoHttp<Metodo> {
	
	GET,
	POST,
	PUT,
	DELETE,
	HEAD,
	TRACE,
	OPTIONS,
	CONNECT,
	DESCONHECIDO;

	@Override
	public boolean éIgual(Metodo outroElementoHttp) {
		return equals(outroElementoHttp);
	}

	@Override
	public boolean éIgual(String outroValorTextual) {
		return toString().equals(outroValorTextual);
	}

	@Override
	public String fornecerComoTexto() {
		return toString();
	}
}