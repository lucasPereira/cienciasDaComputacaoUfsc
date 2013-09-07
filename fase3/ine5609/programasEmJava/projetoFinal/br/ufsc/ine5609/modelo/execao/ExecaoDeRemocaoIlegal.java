package br.ufsc.ine5609.modelo.execao;

public class ExecaoDeRemocaoIlegal extends RuntimeException {
	private static final long serialVersionUID = 3538925944472592956L;

	public ExecaoDeRemocaoIlegal() {
		super("É necessário de iterar antes de fazer a próxima remoção");
	}
}