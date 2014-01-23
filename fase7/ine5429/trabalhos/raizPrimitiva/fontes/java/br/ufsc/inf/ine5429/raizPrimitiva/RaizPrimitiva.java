package br.ufsc.inf.ine5429.raizPrimitiva;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RaizPrimitiva {
	private static final BigInteger DOIS = BigInteger.ONE.add(BigInteger.ONE);
	private static final BigInteger TRES = DOIS.add(BigInteger.ONE);
	private BigInteger numero;
	private Set<BigInteger> raizes;

	public RaizPrimitiva(BigInteger numero) {
		this.numero = numero;
	}

	public BigInteger encontrarRaizPrimitivaDePrimo() {
		BigInteger phi = numero.subtract(BigInteger.ONE);
		return encontrarRaizPrimitiva(phi);
	}

	public BigInteger encontrarRaizPrimitiva() {
		BigInteger phi = calcularPhi(numero);
		return encontrarRaizPrimitiva(phi);
	}

	private BigInteger encontrarRaizPrimitiva(BigInteger phi) {
		Set<BigInteger> fatoresPrimosDePhi = encontrarFatoresPrimos(phi);
		BigInteger candidataRaizPrimitiva = TRES;
		while (true) {
			if (testarRaizPrimitiva(candidataRaizPrimitiva, numero, phi, fatoresPrimosDePhi)) {
				return candidataRaizPrimitiva;
			}
			candidataRaizPrimitiva = candidataRaizPrimitiva.add(BigInteger.ONE);
		}
	}

	public List<BigInteger> encontrarRaizesPrimitivas() {
		BigInteger phi = calcularPhi(numero);
		Set<BigInteger> fatoresPrimosDePhi = encontrarFatoresPrimos(phi);
		List<BigInteger> raizesPrimitivas = new LinkedList<BigInteger>();
		BigInteger candidataRaizPrimitiva = BigInteger.ONE;
		BigInteger quantidadeDeRaizesPrimitivas = calcularPhi(phi);
		BigInteger contadorDeRaizesPrimitivas = BigInteger.ZERO;
		while (contadorDeRaizesPrimitivas.compareTo(quantidadeDeRaizesPrimitivas) == -1) {
			if (testarRaizPrimitiva(candidataRaizPrimitiva, this.numero, phi, fatoresPrimosDePhi)) {
				raizesPrimitivas.add(candidataRaizPrimitiva);
				contadorDeRaizesPrimitivas = contadorDeRaizesPrimitivas.add(BigInteger.ONE);
			}
			candidataRaizPrimitiva = candidataRaizPrimitiva.add(BigInteger.ONE);
		}
		return raizesPrimitivas;
	}

	private Boolean testarRaizPrimitiva(BigInteger raizPrimitiva, BigInteger numero, BigInteger phi, Set<BigInteger> fatoresPrimos) {
		for (BigInteger fatorPrimo : fatoresPrimos) {
			if (raizPrimitiva.modPow(phi.divide(fatorPrimo), numero).equals(BigInteger.ONE)) {
				return false;
			}
		}
		return true;
	}

	private Set<BigInteger> encontrarFatoresPrimos(BigInteger numero) {
		Set<BigInteger> fatoresPrimos = new HashSet<BigInteger>();
		BigInteger fatorPrimoAtual = DOIS;
		while (!numero.equals(BigInteger.ONE)) {
			BigInteger[] divisaoSobra = numero.divideAndRemainder(fatorPrimoAtual);
			BigInteger divisao = divisaoSobra[0];
			BigInteger sobra = divisaoSobra[1];
			if (sobra.equals(BigInteger.ZERO)) {
				numero = divisao;
				fatoresPrimos.add(fatorPrimoAtual);
			} else {
				fatorPrimoAtual = fatorPrimoAtual.add(BigInteger.ONE);
			}
		}
		return fatoresPrimos;
	}

	private Set<BigInteger> encontrarFatoresPrimosComMillerRabin(BigInteger numero) {
		Set<BigInteger> fatoresPrimos = new HashSet<BigInteger>();
		BigInteger fatorPrimoAtual = BigInteger.ONE.nextProbablePrime();
		while (!numero.equals(BigInteger.ONE)) {
			BigInteger[] divisaoSobra = numero.divideAndRemainder(fatorPrimoAtual);
			BigInteger divisao = divisaoSobra[0];
			BigInteger sobra = divisaoSobra[1];
			if (sobra.equals(BigInteger.ZERO)) {
				numero = divisao;
				fatoresPrimos.add(fatorPrimoAtual);
			} else {
				fatorPrimoAtual = fatorPrimoAtual.nextProbablePrime();
			}
		}
		return fatoresPrimos;
	}

	protected BigInteger calcularPhi(BigInteger numero) {
		if (numero.isProbablePrime(30)) {
			return numero.subtract(BigInteger.ONE);
		}
		BigInteger phi = BigInteger.ZERO;
		BigInteger candidatoCoPrimo = BigInteger.ONE;
		while (candidatoCoPrimo.compareTo(numero) == -1) {
			if (candidatoCoPrimo.gcd(numero).equals(BigInteger.ONE)) {
				phi = phi.add(BigInteger.ONE);
			}
			candidatoCoPrimo = candidatoCoPrimo.add(BigInteger.ONE);
		}
		return phi;
	}

	public static void main(String[] argumentos) {
		Scanner leitor = new Scanner(System.in);
		Boolean encerrar = false;
		while (!encerrar) {
			System.out.print("Digite o número para o qual deseja encontrar as raízes primitivas: ");
			try {
				BigInteger numero = leitor.nextBigInteger();
				List<BigInteger> raizesPrimitivas = new RaizPrimitiva(numero).encontrarRaizesPrimitivas();
				System.out.printf("O número possui %d raízes primitivas. Elas são: %s.\n", raizesPrimitivas.size(), raizesPrimitivas.toString());
			} catch (InputMismatchException excecao) {
				System.out.println("Programa encerrado.");
				encerrar = true;
			}
		}
	}
}
