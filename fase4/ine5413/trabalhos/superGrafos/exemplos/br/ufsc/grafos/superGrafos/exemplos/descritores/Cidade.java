package br.ufsc.grafos.superGrafos.exemplos.descritores;

import br.ufsc.grafos.superGrafos.propriedadesDeElementos.IgualavelCodificavel;

public class Cidade implements IgualavelCodificavel<Cidade> {
	
	String nome;
	
	public Cidade(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean éIgual(Cidade outro) {
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