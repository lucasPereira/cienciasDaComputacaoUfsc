package br.ufsc.inf.ine5426.caneca.interno;

public final class InstrucaoPara extends EscopoAbstrato implements Instrucao {
	private Expressao antes;
	private Expressao condicao;
	private Expressao depois;
	private Bloco bloco;
	
	public InstrucaoPara(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public boolean definirBloco(Bloco bloco) {
		this.bloco = bloco;
		Reporter.instancia().reportarDefinicaoDeBloco(bloco);
		return true;
	}
	
	@Override
	public boolean definirExpressao(Expressao expressao) {
		if (antes == null) {
			antes = expressao;
		} else if (condicao == null) {
			condicao = expressao;
		} else if (depois == null) {
			depois = expressao;
		}
		Reporter.instancia().reportarDefinicaoDeExpressao(expressao);
		return true;
	}
	
	@Override
	public String comoTexto() {
		return "para";
	}
}
