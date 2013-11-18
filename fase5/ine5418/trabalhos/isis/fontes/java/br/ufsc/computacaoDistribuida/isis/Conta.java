package br.ufsc.computacaoDistribuida.isis;

public final class Conta {
	
	private double saldo;
	
	public void depositar(Double valor) {
		if (valor > 0) {
			saldo += valor;
		}
	}
	
	public void sacar(Double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
		}
	}
	
	public Double fornecerSaldo() {
		return saldo;
	}
	
	public void corrigir(Double correcao) {
		if (correcao > 0) {
			saldo *= correcao;
		}
	}
	
	public String toString() {
		return String.format("Saldo: %d.00", saldo);
	}
}
