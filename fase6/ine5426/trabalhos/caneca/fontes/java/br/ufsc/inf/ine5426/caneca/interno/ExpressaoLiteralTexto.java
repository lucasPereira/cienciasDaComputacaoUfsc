package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public final class ExpressaoLiteralTexto extends ExpressaoPrimaria {
	private String valor;
	
	public ExpressaoLiteralTexto(Escopo escopoPai, String valorTextual) {
		super(escopoPai, valorTextual);
		valor = valorTextual.substring(1, valorTextual.length() - 1);
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		areaDeCodigo.add(new CodigoEmpilhar(new ValorTexto(valor)));
	}
	
	@Override
	public Tipo fornecerTipo() {
		return Tipo.TEXTO;
	}
}
