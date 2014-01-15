package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoAbrirContexto implements Codigo {
	public CodigoAbrirContexto() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.pilhaDeContextos.push(new Contexto(maquina.pilhaDeContextos.peek()));
	}
	
	@Override
	public String comoTexto() {
		return String.format("abrirContexto");
	}
}
