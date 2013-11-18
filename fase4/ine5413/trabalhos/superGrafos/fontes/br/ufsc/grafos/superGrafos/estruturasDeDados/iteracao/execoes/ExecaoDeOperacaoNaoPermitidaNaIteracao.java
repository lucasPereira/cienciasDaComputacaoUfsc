package br.ufsc.grafos.superGrafos.estruturasDeDados.iteracao.execoes;

public final class ExecaoDeOperacaoNaoPermitidaNaIteracao extends RuntimeException {

	private static final long serialVersionUID = -7379162874701697305L;
	
	public ExecaoDeOperacaoNaoPermitidaNaIteracao() {
		super("Está operação não é permitida durante uma iteração");
	}
}