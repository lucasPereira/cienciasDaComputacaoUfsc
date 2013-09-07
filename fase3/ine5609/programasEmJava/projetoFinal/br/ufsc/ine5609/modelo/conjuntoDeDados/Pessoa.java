package br.ufsc.ine5609.modelo.conjuntoDeDados;

import br.ufsc.ine5609.modelo.estrutraDeDados.Comparavel;

public class Pessoa implements Comparavel<Pessoa>{
	private String nome, cidade;
	private long cpf;
	private Escolaridade escolaridade;
	private double salario;
	private int idade;

	public Pessoa(String nome, long cpf, Escolaridade escolaridade,	double salario, int idade, String cidade) {
		this.nome = nome;
		this.cpf = cpf;
		this.escolaridade = escolaridade;
		this.salario = salario;
		this.idade = idade;
		this.cidade = cidade;
	}

	public String fornecerCidade() {
		return cidade;
	}

	public void fixarCidade(String cidade) {
		this.cidade = cidade;
	}

	public String fornecerNome() {
		return nome;
	}

	public void fixarNome(String nome) {
		this.nome = nome;
	}

	public long fornecerCpf() {
		return cpf;
	}

	public void fixarCpf(long cpf) {
		this.cpf = cpf;
	}

	public Escolaridade fornecerEscolaridade() {
		return escolaridade;
	}

	public void fixarEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public double fornecerSalario() {
		return salario;
	}

	public void fixarSalario(double salario) {
		this.salario = salario;
	}

	public int fornecerIdade() {
		return idade;
	}
	
	public void fixarIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return nome + " (" + cpf + ")";
	}

	@Override
	public boolean equals(Object objeto) {
		if (this == objeto)
			return true;
		if (objeto == null)
			return false;
		if (getClass() != objeto.getClass())
			return false;
		
		Pessoa outra = (Pessoa) objeto;
		String nomeOutra = outra.nome.toUpperCase();
		String cidadeOutra = outra.cidade.toUpperCase();
		if (!cidadeOutra.equals(cidade.toUpperCase()) || !nomeOutra.equals(nome.toUpperCase())) {
			return false;
		}
		if (outra.cpf != cpf || outra.idade != idade || outra.salario != salario) {
			return false;
		}
		if (!outra.escolaridade.equals(escolaridade)) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean eMaior(Pessoa comparado) {
		return this.cpf > comparado.cpf;
	}

	@Override
	public boolean eMenor(Pessoa comparado) {
		return this.cpf < comparado.cpf;
	}

	@Override
	public boolean eIgual(Pessoa comparado) {
		return this.cpf == comparado.cpf;
	}
}