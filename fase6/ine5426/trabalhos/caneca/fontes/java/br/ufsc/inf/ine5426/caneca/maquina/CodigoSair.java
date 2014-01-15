package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoSair implements Codigo {
	public CodigoSair() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.contadorDePrograma = maquina.areaDeCodigo.size();
	}
	
	@Override
	public String comoTexto() {
		return String.format("sair");
	}
}
