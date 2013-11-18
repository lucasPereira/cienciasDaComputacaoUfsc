package br.ufsc.grafos.superGrafos.exemplos.descritores;

import br.ufsc.grafos.superGrafos.propriedadesDeElementos.IgualavelCodificavel;

public class MargemDeKonigsberg implements IgualavelCodificavel<MargemDeKonigsberg> {

	private char identificador;
	
	public MargemDeKonigsberg(char identificador) {
		this.identificador = identificador;
	}
	
	public char fornecerIdentificador() {
		return identificador;
	}
	
	@Override
	public boolean éIgual(MargemDeKonigsberg outro) {
		return identificador == outro.identificador;
	}

	@Override
	public int fornecerCódigo() {
		return (int) identificador;
	}
	
	@Override
	public String toString() {
		return "Margem " + identificador;
	}
}