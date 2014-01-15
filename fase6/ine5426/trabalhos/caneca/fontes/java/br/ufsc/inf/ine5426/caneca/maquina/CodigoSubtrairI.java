package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoSubtrairI implements Codigo {
	public CodigoSubtrairI() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		int operandoB = maquina.pilhaDeDados.pop().fornecerComoInteiro();
		int operandoA = maquina.pilhaDeDados.pop().fornecerComoInteiro();
		maquina.pilhaDeDados.push(new ValorInteiro(operandoA - operandoB));
	}
	
	@Override
	public String comoTexto() {
		return String.format("subtrairI");
	}
}
