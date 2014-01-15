package br.ufsc.inf.ine5426.caneca.maquina;

public final class ValorReal extends ValorAbstrato {
	public static ValorReal PADRAO = new ValorReal(0.0);
	private double valor;
	
	public ValorReal(double valor) {
		this.valor = valor;
	}
	
	@Override
	public ValorReal copiarComNome(String nome) {
		ValorReal novoValor = new ValorReal(valor);
		novoValor.fixarNome(nome);
		return novoValor;
	}
	
	@Override
	public double fornecerComoReal() {
		return valor;
	}
	
	@Override
	public String comoTexto() {
		return valor + "";
	}
}
