package br.ufsc.ine5609.modelo.execao;

public class ExecaoDeFaltaDeElementos extends RuntimeException {
	private static final long serialVersionUID = 3386703421288506709L;
	
	public ExecaoDeFaltaDeElementos() {
		super("Não há próximo elemento para ser fornecido");
	}
}