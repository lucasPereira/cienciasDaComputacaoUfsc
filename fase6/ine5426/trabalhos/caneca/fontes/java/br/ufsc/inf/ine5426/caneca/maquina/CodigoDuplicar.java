package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoDuplicar implements Codigo {
	public CodigoDuplicar() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.pilhaDeDados.push(maquina.pilhaDeDados.peek());
	}
	
	@Override
	public String comoTexto() {
		return String.format("duplicar");
	}
}
