package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoResolverSimbolo implements Codigo {
	private String nome;
	
	public CodigoResolverSimbolo(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.pilhaDeDados.push(maquina.pilhaDeContextos.peek().resolverSimbolo(nome).copiarComNome(nome));
	}
	
	@Override
	public String comoTexto() {
		return String.format("resolverSimbolo %s", nome);
	}
}
