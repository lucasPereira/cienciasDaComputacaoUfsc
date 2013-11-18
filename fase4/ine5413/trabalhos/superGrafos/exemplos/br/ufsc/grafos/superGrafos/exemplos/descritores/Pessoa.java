package br.ufsc.grafos.superGrafos.exemplos.descritores;

import br.ufsc.grafos.superGrafos.propriedadesDeElementos.IgualavelCodificavel;

public class Pessoa implements IgualavelCodificavel<Pessoa> {
	
	String nome;
	
	public Pessoa(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean éIgual(Pessoa outro) {
		return nome.equals(outro.nome);
	}

	@Override
	public int fornecerCódigo() {
		return nome.hashCode();
	}
	
	@Override
	public String toString() {
		return nome;
	}
}