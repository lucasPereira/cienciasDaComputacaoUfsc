package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoRetornar implements Codigo {
	public CodigoRetornar() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.contadorDePrograma = maquina.pilhaDeExecucao.pop() + 1;
	}
	
	@Override
	public String comoTexto() {
		return String.format("retornar");
	}
}
