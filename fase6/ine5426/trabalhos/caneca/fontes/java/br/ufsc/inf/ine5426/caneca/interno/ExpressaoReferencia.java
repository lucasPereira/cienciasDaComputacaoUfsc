package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.LinkedList;
import java.util.List;

public final class ExpressaoReferencia extends EscopoAbstrato implements Expressao {
	private Escopo escopoDono;
	private String nome;
	
	public ExpressaoReferencia(Escopo escopoPai, Escopo escopoDono, String nome) {
		super(escopoPai);
		this.escopoDono = escopoDono;
		this.nome = nome;
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		areaDeCodigo.add(new CodigoResolverSimbolo(nome));
	}
	
	@Override
	public Tipo fornecerTipo() {
		//return fornecerEscopoPai().resolverReferencia(nome).fornecerTipo();
		//TODO
		return null;
	}
	
	@Override
	public String comoTexto() {
		return nome;
	}
}
