package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public final class ExpressaoAtribuicao extends ExpressaoBinaria {
	Tipo tipo;
	
	public ExpressaoAtribuicao(Escopo escopoPai) {
		super(escopoPai);
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		fornecerOperandoEsquerdo().gerarCodigo(areaDeCodigo, areaDeDados);
		fornecerOperandoDireito().gerarCodigo(areaDeCodigo, areaDeDados);
		areaDeCodigo.add(new CodigoAtribuir());
	}
	
	@Override
	public Tipo fornecerTipo() {
		if (tipo == null) {
			tipo = fornecerOperandoEsquerdo().fornecerTipo();
		}
		return tipo;
	}
	
	@Override
	public String comoTexto() {
		return "=";
	}
}
