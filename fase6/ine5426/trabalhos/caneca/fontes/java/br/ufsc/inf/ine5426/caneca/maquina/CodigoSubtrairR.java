package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoSubtrairR implements Codigo {
	public CodigoSubtrairR() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		double operandoB = maquina.pilhaDeDados.pop().fornecerComoReal();
		double operandoA = maquina.pilhaDeDados.pop().fornecerComoReal();
		maquina.pilhaDeDados.push(new ValorReal(operandoA - operandoB));
	}
	
	@Override
	public String comoTexto() {
		return String.format("subtrairR");
	}
}
