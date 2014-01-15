package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoImprimir implements Codigo {
	public CodigoImprimir() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		System.out.println("[saida] " + maquina.pilhaDeDados.pop().comoTexto());
	}
	
	@Override
	public String comoTexto() {
		return String.format("imprimir");
	}
}
