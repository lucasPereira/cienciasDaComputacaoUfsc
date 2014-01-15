package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public final class ExpressaoConstanteReal extends ExpressaoPrimaria {
	private double valor;
	
	public ExpressaoConstanteReal(Escopo escopoPai, String valorTextual) {
		super(escopoPai, valorTextual);
		valor = Double.parseDouble(valorTextual);
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		areaDeCodigo.add(new CodigoEmpilhar(new ValorReal(valor)));
	}
	
	@Override
	public Tipo fornecerTipo() {
		return Tipo.REAL;
	}
}
