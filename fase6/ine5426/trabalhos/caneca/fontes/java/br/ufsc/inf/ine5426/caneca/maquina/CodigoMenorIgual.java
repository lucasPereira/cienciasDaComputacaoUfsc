package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoMenorIgual implements Codigo {
	public CodigoMenorIgual() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		Valor valorB = maquina.pilhaDeDados.pop();
		Valor valorA = maquina.pilhaDeDados.pop();
		try {
			int operandoB = valorB.fornecerComoInteiro();
			int operandoA = valorA.fornecerComoInteiro();
			maquina.pilhaDeDados.push(new ValorBooleano(operandoA <= operandoB));
		} catch (Exception excecao1) {
			try {
			double operandoB = valorB.fornecerComoReal();
			double operandoA = valorA.fornecerComoReal();
			maquina.pilhaDeDados.push(new ValorBooleano(operandoA <= operandoB));
			} catch (Exception excecao2) {
				// maquina.pilhaDeDados.push(new ValorBooleano(false));
				throw excecao2;
			}
		}
	}
	
	@Override
	public String comoTexto() {
		return String.format("menorIgual");
	}
}
