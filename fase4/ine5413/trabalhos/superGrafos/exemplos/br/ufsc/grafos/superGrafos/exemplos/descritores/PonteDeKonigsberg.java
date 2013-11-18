package br.ufsc.grafos.superGrafos.exemplos.descritores;

import br.ufsc.grafos.superGrafos.propriedadesDeElementos.Igualavel;

public class PonteDeKonigsberg implements Igualavel<PonteDeKonigsberg> {
	
	private char identificador;
	
	public PonteDeKonigsberg(char identificador) {
		this.identificador = identificador;
	}
	
	public char fornecerIdentificador() {
		return identificador;
	}
	
	@Override
	public boolean éIgual(PonteDeKonigsberg outro) {
		return (identificador == outro.identificador);
	}

	@Override
	public String toString() {
		return "Ponte " + identificador;
	}
}