package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoMultiplicarI implements Codigo {
	public CodigoMultiplicarI() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		int operandoB = maquina.pilhaDeDados.pop().fornecerComoInteiro();
		int operandoA = maquina.pilhaDeDados.pop().fornecerComoInteiro();
		maquina.pilhaDeDados.push(new ValorReal(operandoA * operandoB));
	}
	
	@Override
	public String comoTexto() {
		return String.format("multiplicarI");
	}
}
