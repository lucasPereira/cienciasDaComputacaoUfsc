package br.ufsc.inf.ine5426.caneca.interno;

import java.util.LinkedList;
import java.util.List;

public final class InstrucaoCapture extends EscopoAbstrato implements Instrucao {
	private Variavel excecao;
	private Bloco bloco;
	
	public InstrucaoCapture(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public boolean definirVariavel(Variavel excecao) {
		this.excecao = excecao;
		Reporter.instancia().reportarDefinicaoDeVariavel(excecao);
		return true;
	}
	
	@Override
	public boolean definirBloco(Bloco bloco) {
		this.bloco = bloco;
		Reporter.instancia().reportarDefinicaoDeBloco(bloco);
		return true;
	}
	
	@Override
	public String comoTexto() {
		return "capture";
	}
}
