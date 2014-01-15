package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public final class InstrucaoDepurar extends EscopoAbstrato implements Instrucao {
	public InstrucaoDepurar(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		areaDeCodigo.add(new CodigoDepurar());
	}
	
	@Override
	public String comoTexto() {
		return "depurar";
	}
}
