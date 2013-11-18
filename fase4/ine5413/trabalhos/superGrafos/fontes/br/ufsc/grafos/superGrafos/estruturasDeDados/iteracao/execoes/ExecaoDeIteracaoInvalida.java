package br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.execoes;

public final class ExecaoDeIteracaoInvalida extends RuntimeException {
		
	private static final long serialVersionUID = -7511889635385741697L;

	public ExecaoDeIteracaoInvalida() {
		super ("Não há mais elementos para serem iterados");
	}
}