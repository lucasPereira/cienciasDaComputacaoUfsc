package br.ufsc.inf.ine5426.caneca.maquina;

public final class ValorBooleano extends ValorAbstrato {
	public static ValorBooleano PADRAO = new ValorBooleano(false);
	private boolean valor;
	
	public ValorBooleano(boolean valor) {
		this.valor = valor;
	}
	
	@Override
	public ValorBooleano copiarComNome(String nome) {
		ValorBooleano novoValor = new ValorBooleano(valor);
		novoValor.fixarNome(nome);
		return novoValor;
	}
	
	@Override
	public boolean fornecerComoBooleano() {
		return valor;
	}
	
	@Override
	public String comoTexto() {
		return (valor) ? "verdadeiro" : "falso";
	}
}
