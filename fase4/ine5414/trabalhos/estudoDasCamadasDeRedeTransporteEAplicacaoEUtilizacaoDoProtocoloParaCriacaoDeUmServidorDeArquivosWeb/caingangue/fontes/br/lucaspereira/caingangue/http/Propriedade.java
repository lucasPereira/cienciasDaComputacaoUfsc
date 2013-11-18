package br.lucaspereira.caingangue.http;

public enum Propriedade implements TipoElementoHttp<Propriedade> {
	
	ACCEPT("Accept"),
	ACCEPT_LANGUAGE("Accept-Language"),
	ACCEPT_ENCODING("Accept-Encoding"),
	ACCEPT_CHARSET("Accept-Charset"),
	CONNECTION("Connetion"),
	HOST("Host"),
	REFERER("Referer"),
	USER_AGENT("User-Agent"),
	DESCONHECIDA("Desconhecida"),
	COOKIE("Cookie"),
	CACHE_CONTROL("Cache-Control");
	
	private String valorTextual;
	
	Propriedade(String valorTextual) {
		this.valorTextual = valorTextual;
	}
	
	@Override
	public boolean éIgual(Propriedade outroElementoHttp) {
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