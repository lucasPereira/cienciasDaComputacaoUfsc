package br.ufsc.inf.ine5426.caneca.maquina;

public final class ValorTexto extends ValorAbstrato {
	public static ValorTexto PADRAO = new ValorTexto("");
	private String valor;
	
	public ValorTexto(String valor) {
		this.valor = valor;
	}
	
	@Override
	public ValorTexto copiarComNome(String nome) {
		ValorTexto novoValor = new ValorTexto(valor);
		novoValor.fixarNome(nome);
		return novoValor;
	}
	
	@Override
	public String fornecerComoTexto() {
		return valor;
	}
	
	@Override
	public String comoTexto() {
		return valor;
	}
}
