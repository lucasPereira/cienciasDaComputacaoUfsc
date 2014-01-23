package br.ufsc.inf.ine5429.diffieHellman;

import br.ufsc.inf.ine5429.millerRabin.MillerRabin;
import br.ufsc.inf.ine5429.raizPrimitiva.RaizPrimitiva;
import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {
	private BigInteger primo;
	private BigInteger raizPrimitivaDoPrimo;
	private Entidade entidadeA;
	private Entidade entidadeB;
	private Random geradorAleatorio;

	public BigInteger calcularPrimo() {
		MillerRabin millerRabin = new MillerRabin(10);
		primo = millerRabin.encontrarProvavelPrimo();
		geradorAleatorio = new Random();
		return primo;
	}

	public BigInteger calcularRaizPrimitivaDoPrimo() {
		RaizPrimitiva raizPrimitiva = new RaizPrimitiva(primo);
		raizPrimitivaDoPrimo = raizPrimitiva.encontrarRaizPrimitivaDePrimo();
		return raizPrimitivaDoPrimo;
	}

	public void iniciarAcordoDeChaves() {
		entidadeA = new Entidade();
		entidadeB = new Entidade();
		BigInteger xa = entidadeA.gerarNumeroPrivado();
		BigInteger xb = entidadeB.gerarNumeroPrivado();
		BigInteger ya = entidadeA.calcularNumeroCompartilhado();
		BigInteger yb = entidadeB.calcularNumeroCompartilhado();
		entidadeA.receberNumeroCompartilhadoDaOutraEntidade(yb);
		entidadeB.receberNumeroCompartilhadoDaOutraEntidade(ya);
		BigInteger ka = entidadeA.calcularChave();
		BigInteger kb = entidadeB.calcularChave();
		System.out.printf("Acordo de chaves iniciado.\n");
		System.out.printf("xa gerado: %d.\n", xa);
		System.out.printf("xb gerado: %d.\n", xb);
		System.out.printf("ya calculado: %d.\n", ya);
		System.out.printf("yb calculado: %d.\n", yb);
		System.out.printf("ka calculada: %d.\n", ka);
		System.out.printf("ka calculada: %d.\n", kb);
		System.out.printf("Acordo de chaves finalizado.\n");
	}

	private class Entidade {
		private BigInteger numeroPrivado;
		private BigInteger numeroCompartilhado;
		private BigInteger numeroCompartilhadoDaOutraEntidade;
		private BigInteger chave;

		public BigInteger gerarNumeroPrivado() {
			do {
				numeroPrivado = new BigInteger(primo.bitCount(), geradorAleatorio);
			} while (numeroPrivado.compareTo(primo) >= 0);
			return numeroPrivado;
		}

		public BigInteger calcularNumeroCompartilhado() {
			numeroCompartilhado = raizPrimitivaDoPrimo.modPow(numeroPrivado, primo);
			return numeroCompartilhado;
		}

		public void receberNumeroCompartilhadoDaOutraEntidade(BigInteger numeroCompartilhadoDaOutraEntidade) {
			this.numeroCompartilhadoDaOutraEntidade = numeroCompartilhadoDaOutraEntidade;
		}

		public BigInteger calcularChave() {
			chave = numeroCompartilhadoDaOutraEntidade.modPow(numeroPrivado, primo);
			return chave;
		}
	}

	public static void main(String[] argumentos) {
		DiffieHellman diffieHellman = new DiffieHellman();
		System.out.printf("Número primo: %d.\n", diffieHellman.calcularPrimo());
		System.out.printf("Raiz primitiva do número primo: %d.\n", diffieHellman.calcularRaizPrimitivaDoPrimo());
		diffieHellman.iniciarAcordoDeChaves();
	}
}
