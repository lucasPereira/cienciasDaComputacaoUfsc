package br.ufsc.inf.ine5426.caneca.maquina;

public final class ValorNulo extends ValorAbstrato {
	public static ValorNulo PADRAO = new ValorNulo();
	
	public ValorNulo() {
		
	}
	
	@Override
	public ValorNulo copiarComNome(String nome) {
		ValorNulo novoValor = new ValorNulo();
		novoValor.fixarNome(nome);
		return novoValor;
	}
	
	@Override
	public String comoTexto() {
		return "nulo";
	}
}
