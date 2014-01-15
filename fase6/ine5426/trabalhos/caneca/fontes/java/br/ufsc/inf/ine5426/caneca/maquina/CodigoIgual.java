package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoIgual implements Codigo {
	public CodigoIgual() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		Valor valorB = maquina.pilhaDeDados.pop();
		Valor valorA = maquina.pilhaDeDados.pop();
		try {
			int operandoB = valorA.fornecerComoInteiro();
			int operandoA = valorB.fornecerComoInteiro();
			maquina.pilhaDeDados.push(new ValorBooleano(operandoA == operandoB));
		} catch (Exception excecao1) {
			try {
			double operandoB = valorA.fornecerComoReal();
			double operandoA = valorB.fornecerComoReal();
			maquina.pilhaDeDados.push(new ValorBooleano(operandoA == operandoB));
			} catch (Exception excecao2) {
				try {
					boolean operandoB = valorA.fornecerComoBooleano();
					boolean operandoA = valorB.fornecerComoBooleano();
					maquina.pilhaDeDados.push(new ValorBooleano(operandoA == operandoB));
				} catch (Exception excecao3) {
					try {
						char operandoB = valorA.fornecerComoCaractere();
						char operandoA = valorB.fornecerComoCaractere();
						maquina.pilhaDeDados.push(new ValorBooleano(operandoA == operandoB));
					} catch (Exception excecao4) {
						try {
							String operandoB = valorA.fornecerComoTexto();
							String operandoA = valorB.fornecerComoTexto();
							maquina.pilhaDeDados.push(new ValorBooleano(operandoA.equals(operandoB)));
						} catch (Exception excecao5) {
							try {
								Contexto operandoB = valorA.fornecerComoReferencia();
								Contexto operandoA = valorB.fornecerComoReferencia();
								maquina.pilhaDeDados.push(new ValorBooleano(operandoA.equals(operandoB)));
							} catch (Exception excecao6) {
								maquina.pilhaDeDados.push(new ValorBooleano(false));
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public String comoTexto() {
		return String.format("igual");
	}
}
