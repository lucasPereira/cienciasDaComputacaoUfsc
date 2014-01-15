package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoDesviar implements Codigo {
	private Integer pontoDeDesvio;
	
	public void fixarPontoDeDesvio(Integer pontoDeDesvio) {
		this.pontoDeDesvio = pontoDeDesvio;
	}
	
	public CodigoDesviar() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.contadorDePrograma = pontoDeDesvio;
	}
	
	@Override
	public String comoTexto() {
		return String.format("desviar %d", pontoDeDesvio);
	}
}
