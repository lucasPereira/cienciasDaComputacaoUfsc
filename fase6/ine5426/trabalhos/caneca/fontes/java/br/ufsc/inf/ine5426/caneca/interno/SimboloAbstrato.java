package br.ufsc.inf.ine5426.caneca.interno;

public abstract class SimboloAbstrato implements Simbolo {
	private Escopo escopoPai;
	private Tipo tipo;
	private String nome;
	private int linha;
	private int coluna;
	
	public SimboloAbstrato(Escopo escopoPai, Tipo tipo, String nome, int linha, int coluna) {
		this.escopoPai = escopoPai;
		this.tipo = tipo;
		this.nome = nome;
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public boolean mesmoTipo(SimboloAbstrato outra) {
		return tipo.mesmoQue(outra.tipo);
	}
	
	@Override
	public Escopo fornecerEscopoPai() {
		return escopoPai;
	}
	
	@Override
	public String comoTexto() {
		return nome;
	}
	
	@Override
	public String fornecerNome() {
		return nome;
	}
	
	public Tipo fornecerTipo() {
		return tipo;
	}
	
	@Override
	public int fornecerLinha() {
		return linha;
	}
	
	@Override
	public int fornecerColuna() {
		return coluna;
	}
}
