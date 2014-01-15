package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoEmpilhar implements Codigo {
	private Valor valor;
	
	public CodigoEmpilhar(Valor valor) {
		this.valor = valor;
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.pilhaDeDados.push(valor);
	}
	
	@Override
	public String comoTexto() {
		return String.format("empilhar %s", valor.comoTexto());
	}
}
