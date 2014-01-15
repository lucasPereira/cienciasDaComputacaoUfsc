package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoExtrairContexto implements Codigo {
	public CodigoExtrairContexto() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.pilhaDeContextos.push(maquina.pilhaDeDados.pop().fornecerComoReferencia());
	}
	
	@Override
	public String comoTexto() {
		return String.format("extrairContexto");
	}
}
