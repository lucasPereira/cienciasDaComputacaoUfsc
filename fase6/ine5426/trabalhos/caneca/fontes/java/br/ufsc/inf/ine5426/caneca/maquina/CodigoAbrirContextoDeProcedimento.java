package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoAbrirContextoDeProcedimento implements Codigo {
	private String nomeDaClasse;
	
	public CodigoAbrirContextoDeProcedimento(String nomeDaClasse) {
		this.nomeDaClasse = nomeDaClasse;
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.pilhaDeContextos.push(new Contexto(maquina.pilhaDeContextos.peek().resolverSimbolo("esse").fornecerComoReferencia()));
	}
	
	@Override
	public String comoTexto() {
		return String.format("abrirContextoDeProcedimento %s", nomeDaClasse);
	}
}
