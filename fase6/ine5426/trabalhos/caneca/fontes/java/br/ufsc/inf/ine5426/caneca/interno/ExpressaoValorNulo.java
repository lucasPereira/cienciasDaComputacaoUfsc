package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public final class ExpressaoValorNulo extends ExpressaoPrimaria {
	public ExpressaoValorNulo(Escopo escopoPai, String valorTextual) {
		super(escopoPai, valorTextual);
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		areaDeCodigo.add(new CodigoEmpilhar(new ValorNulo()));
	}
	
	@Override
	public Tipo fornecerTipo() {
		return Tipo.OBJETO;
	}
}
