package br.lucaspereira.caingangue.http;

public enum Versao implements TipoElementoHttp<Versao> {
	
	HTTP_1_0("HTTP/1.0"),
	HTTP_1_1("HTTP/1.1"),
	DESCONHECIDA("Desconhecida");
	
	private String valorTextual;
	
	Versao(String valorTextual) {
		this.valorTextual = valorTextual;
	}
	
	@Override
	public boolean éIgual(Versao outroElementoHttp) {
		return equals(outroElementoHttp);
	}
	
	@Override
	public boolean éIgual(String outroValorTextual) {
		return valorTextual.equals(outroValorTextual);
	}
	
	@Override
	public String fornecerComoTexto() {
		return valorTextual;
	}
	
	@Override
	public String toString() {
		return fornecerComoTexto();
	}
}