package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public final class InstrucaoImprimir extends EscopoAbstrato implements Instrucao {
	public InstrucaoImprimir(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		areaDeCodigo.add(new CodigoImprimir());
	}
	
	@Override
	public String comoTexto() {
		return "imprimir";
	}
}
