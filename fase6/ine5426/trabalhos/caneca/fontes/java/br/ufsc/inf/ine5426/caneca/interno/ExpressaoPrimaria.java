package br.ufsc.inf.ine5426.caneca.interno;

public abstract class ExpressaoPrimaria extends EscopoAbstrato implements Expressao {
	private String valorTextual;
	
	public ExpressaoPrimaria(Escopo escopoPai, String valorTextual) {
		super(escopoPai);
		this.valorTextual = valorTextual;
	}
	
	@Override
	public final String comoTexto() {
		return valorTextual;
	}
}
