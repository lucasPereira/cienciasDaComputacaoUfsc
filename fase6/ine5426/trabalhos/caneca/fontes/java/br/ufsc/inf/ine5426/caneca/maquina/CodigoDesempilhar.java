package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoDesempilhar implements Codigo {
	public CodigoDesempilhar() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.pilhaDeDados.pop();
	}
	
	@Override
	public String comoTexto() {
		return String.format("desempilhar");
	}
}
