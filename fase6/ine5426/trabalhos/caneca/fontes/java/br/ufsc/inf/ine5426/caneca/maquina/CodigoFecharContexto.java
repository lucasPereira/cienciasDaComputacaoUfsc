package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoFecharContexto implements Codigo {
	public CodigoFecharContexto() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.pilhaDeContextos.pop();
	}
	
	@Override
	public String comoTexto() {
		return String.format("fecharContexto");
	}
}
