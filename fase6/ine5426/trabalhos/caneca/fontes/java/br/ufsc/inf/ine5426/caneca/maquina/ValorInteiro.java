package br.ufsc.inf.ine5426.caneca.maquina;

public final class ValorInteiro extends ValorAbstrato {
	public static ValorInteiro PADRAO = new ValorInteiro(0);
	private int valor;
	
	public ValorInteiro(int valor) {
		this.valor = valor;
	}
	
	@Override
	public ValorInteiro copiarComNome(String nome) {
		ValorInteiro novoValor = new ValorInteiro(valor);
		novoValor.fixarNome(nome);
		return novoValor;
	}
	
	@Override
	public int fornecerComoInteiro() {
		return valor;
	}
	
	@Override
	public String comoTexto() {
		return valor + "";
	}
}
