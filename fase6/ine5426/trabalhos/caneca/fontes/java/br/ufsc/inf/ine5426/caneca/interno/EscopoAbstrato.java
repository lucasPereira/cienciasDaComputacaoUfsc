package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public abstract class EscopoAbstrato implements Escopo {
	private Escopo escopoPai;
	
	public EscopoAbstrato(Escopo escopoPai) {
		this.escopoPai = escopoPai;
	}
	
	@Override
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados) {
		//TODO
		//throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean definirClasse(Classe classe) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean definirAtributo(Atributo atributo) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean definirConstrutor(Construtor construtor) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean definirDestrutor(Destrutor destrutor) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean definirMetodo(Metodo metodo) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean definirVariavel(Variavel variavel) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean definirBloco(Bloco bloco) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean definirInstrucao(Instrucao instrucao) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean definirExpressao(Expressao expressao) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public final Escopo fornecerEscopoPai() {
		return escopoPai;
	}
}
