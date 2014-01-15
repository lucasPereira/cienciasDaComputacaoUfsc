package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public final class ExpressaoValorBooleano extends ExpressaoPrimaria {
	private boolean valor;
	
	public ExpressaoValorBooleano(Escopo escopoPai, String valorTextual) {
		super(escopoPai, valorTextual);
		if (valorTextual.equals("verdadeiro")) {
			valor = true;
		} else if (valorTextual.equals("falso")) {
			valor = false;
		}
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		areaDeCodigo.add(new CodigoEmpilhar(new ValorBooleano(valor)));
	}
	
	@Override
	public Tipo fornecerTipo() {
		return Tipo.BOOLEANO;
	}
}
