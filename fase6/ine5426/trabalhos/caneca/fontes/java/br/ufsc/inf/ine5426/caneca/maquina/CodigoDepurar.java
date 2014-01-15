package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoDepurar implements Codigo {
	public CodigoDepurar() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		System.out.println("");
		System.out.println(String.format("[depuracao] contadorDePrograma: %d", maquina.contadorDePrograma));
		System.out.println(String.format("[depuracao] pilhaDeContextos: %d", maquina.pilhaDeContextos.size()));
		System.out.println(String.format("[depuracao] pilhaDeDados: %s", maquina.pilhaDeDados.toString()));
		System.out.println(String.format("[depuracao] pilhaDeExecucao: %s", maquina.pilhaDeExecucao.toString()));
		System.out.println(String.format("[depuracao] proximoCodigo: %s", maquina.areaDeCodigo.get(maquina.contadorDePrograma).comoTexto()));
	}
	
	@Override
	public String comoTexto() {
		return String.format("depurar");
	}
}
