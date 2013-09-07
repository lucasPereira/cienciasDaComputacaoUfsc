package br.ufsc.ine5609.modelo.conjuntoDeDados;

public enum Escolaridade {
	SEM_ESCOLARIDADE("Sem Escolariedade"),
	FUNDAMENTAL("Fundamental"),
	MEDIO("Medio"),
	SUPERIOR_INCOMPLETO("Superior Incompleto"),
	SUPERIOR("Superior");
	
	private final String escolariedade;
	
	Escolaridade(String escolariedade) {
		this.escolariedade = escolariedade;
	}
	
	public String toString() {
		return escolariedade;
	}
	
}