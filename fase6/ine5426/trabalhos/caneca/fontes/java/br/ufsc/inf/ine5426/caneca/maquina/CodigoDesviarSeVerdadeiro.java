package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoDesviarSeVerdadeiro implements Codigo {
	private Integer pontoDeDesvio;
	
	public void fixarPontoDeDesvio(Integer pontoDeDesvio) {
		this.pontoDeDesvio = pontoDeDesvio;
	}
	
	public CodigoDesviarSeVerdadeiro() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		if (!maquina.pilhaDeDados.pop().fornecerComoBooleano()) {
			maquina.contadorDePrograma = pontoDeDesvio;
		}
	}
	
	@Override
	public String comoTexto() {
		return String.format("desviarSeVerdadeiro %d", pontoDeDesvio);
	}
}
