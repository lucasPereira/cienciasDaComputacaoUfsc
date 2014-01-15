package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoDefinirSimbolo implements Codigo {
	private String nome;
	
	public CodigoDefinirSimbolo(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.pilhaDeContextos.peek().definirSimbolo(nome, maquina.pilhaDeDados.pop());
	}
	
	@Override
	public String comoTexto() {
		return String.format("definirSimbolo %s", nome);
	}
}
