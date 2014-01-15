package br.ufsc.inf.ine5426.caneca.interno;

public final class InstrucaoRepita extends EscopoAbstrato implements Instrucao {
	private Variavel contador;
	private Expressao repeticoes;
	private Bloco bloco;
	
	public InstrucaoRepita(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public boolean definirVariavel(Variavel variavel) {
		contador = variavel;
		Reporter.instancia().reportarDefinicaoDeVariavel(variavel);
		return true;
	}
	
	@Override
	public boolean definirBloco(Bloco bloco) {
		bloco = bloco;
		Reporter.instancia().reportarDefinicaoDeBloco(bloco);
		return true;
	}
	
	@Override
	public boolean definirExpressao(Expressao expressao) {
		repeticoes = repeticoes;
		Reporter.instancia().reportarDefinicaoDeExpressao(expressao);
		return true;
	}
	
	@Override
	public String comoTexto() {
		return "repita";
	}
}
