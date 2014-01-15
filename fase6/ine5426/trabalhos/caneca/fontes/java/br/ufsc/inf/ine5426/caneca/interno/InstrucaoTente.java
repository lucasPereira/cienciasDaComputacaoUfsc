package br.ufsc.inf.ine5426.caneca.interno;

import java.util.LinkedList;
import java.util.List;

public final class InstrucaoTente extends EscopoAbstrato implements Instrucao {
	private Bloco bloco;
	private List<Instrucao> capturas;
	
	public InstrucaoTente(Escopo escopoPai) {
		super(escopoPai);
		capturas = new LinkedList<Instrucao>();
	}
	
	@Override
	public boolean definirBloco(Bloco bloco) {
		this.bloco = bloco;
		Reporter.instancia().reportarDefinicaoDeBloco(bloco);
		return true;
	}
	
	@Override
	public boolean definirInstrucao(Instrucao instrucao) {
		this.capturas.add(instrucao);
		Reporter.instancia().reportarDefinicaoDeInstrucao(instrucao);
		return true;
	}
	
	@Override
	public String comoTexto() {
		return "tente";
	}
}
