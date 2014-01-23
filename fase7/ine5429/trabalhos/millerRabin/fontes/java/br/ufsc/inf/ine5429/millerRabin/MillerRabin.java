package br.ufsc.inf.ine5429.millerRabin;

import java.math.BigInteger;
import java.lang.Math;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class MillerRabin {
	private static final BigInteger DOIS = BigInteger.ONE.add(BigInteger.ONE);
	private static final BigInteger TRES = DOIS.add(BigInteger.ONE);
	private static final Integer QUANTIDADE_DE_TESTES = 10;
	private Integer quantidadeDeDigitos;
	private Random aleatorio;

	public MillerRabin(Integer quantidadeDeDigitos) {
		this.quantidadeDeDigitos = quantidadeDeDigitos;
		aleatorio = new Random();
	}

	public BigInteger encontrarProvavelPrimo() {
		BigInteger provavelPrimo = null;
		BigInteger provavelPrimoMenosUm;
		BigInteger multiplicador;
		Integer maiorExpoente;
		do {
			do {
				provavelPrimo = sortearProvavelPrimo();
			} while (provavelPrimo.compareTo(DOIS) <= 0);
			provavelPrimoMenosUm = provavelPrimo.subtract(BigInteger.ONE);
			maiorExpoente = encontrarMaiorExpoente(provavelPrimoMenosUm);
			multiplicador = encontrarMultiplicador(maiorExpoente, provavelPrimoMenosUm);
		} while (!testarPrimo(provavelPrimo, provavelPrimoMenosUm, maiorExpoente, multiplicador));
		return provavelPrimo;
	}

	private Boolean testarPrimo(BigInteger provavelPrimo, BigInteger provavelPrimoMenosUm, Integer maiorExpoente, BigInteger multiplicador) {
		for (Integer contador = 0; contador < QUANTIDADE_DE_TESTES; contador++) {
			if (!testarPrimalidade(provavelPrimo, provavelPrimoMenosUm, maiorExpoente, multiplicador)) {
				return false;
			}
		}
		return true;
	}

	private Boolean testarPrimalidade(BigInteger provavelPrimo, BigInteger provavelPrimoMenosUm, Integer maiorExpoente, BigInteger multiplicador) {
		BigInteger testemunha = sortearTestemunhaDePrimalidade(provavelPrimo);
		Boolean congruenteAUm = testemunha.modPow(multiplicador, provavelPrimo).equals(BigInteger.ONE);
		if (congruenteAUm) {
			return true;
		}
		for (Integer contador = 0; contador < maiorExpoente; contador++) {
			Boolean congruenteAMenosUm = testemunha.modPow(DOIS.pow(contador).multiply(multiplicador), provavelPrimo).equals(provavelPrimoMenosUm);
			if (congruenteAMenosUm) {
				return true;
			}
		}
		return false;
	}

	private BigInteger sortearProvavelPrimo() {
		Integer primeiroDigito = 0;
		String provavelPrimoTextual;
		BigInteger provavelPrimo;
		do {
			primeiroDigito = aleatorio.nextInt(10);
		} while (primeiroDigito == 0);
		provavelPrimoTextual = primeiroDigito.toString();
		for (Integer contador = 1; contador < quantidadeDeDigitos; contador++) {
			provavelPrimoTextual += aleatorio.nextInt(10);
		}
		provavelPrimo = new BigInteger(provavelPrimoTextual);
		if (provavelPrimo.mod(DOIS).equals(BigInteger.ZERO)) {
			provavelPrimo = provavelPrimo.add(BigInteger.ONE);
		}
		return provavelPrimo;
	}

	private BigInteger sortearTestemunhaDePrimalidade(BigInteger provavelPrimo) {
		BigInteger testemunhaDePrimalidade = null;
		Integer quantidadeDeBits = calcularQuantidadeDeBits(quantidadeDeDigitos);
		do {
			testemunhaDePrimalidade = new BigInteger(quantidadeDeBits, aleatorio);
		} while (testemunhaDePrimalidade.compareTo(provavelPrimo) >= 0 || testemunhaDePrimalidade.compareTo(BigInteger.ONE) <= 0);
		return testemunhaDePrimalidade;
	}

	private Integer encontrarMaiorExpoente(BigInteger primoMenosUm) {
		Integer maiorExpoente = 1;
		while (primoMenosUm.mod(DOIS.pow(maiorExpoente)).equals(BigInteger.ZERO)) {
			maiorExpoente += 1;
		}
		return (maiorExpoente - 1);
	}

	private BigInteger encontrarMultiplicador(Integer maiorExpoente, BigInteger primoMenosUm) {
		BigInteger multiplicador = primoMenosUm.divide(DOIS.pow(maiorExpoente));
		return multiplicador;
	}

	private Integer calcularQuantidadeDeBits(Integer quantidadeDeDigitosDecimais) {
		Double base = 2.0;
		Double maiorNumero = Math.pow(10, quantidadeDeDigitosDecimais);
		return (int) (Math.log10(maiorNumero) / Math.log10(base));
	}

	public static Double forecerProbabilidadeDeErro() {
		return Math.pow(4, -QUANTIDADE_DE_TESTES);
	}

	public static Double fornecerProbabilidadeDeAcerto() {
		return (1 - forecerProbabilidadeDeErro());
	}

	public static void main(String[] argumentos) {
		Scanner leitor = new Scanner(System.in);
		System.out.printf("Gerador de prováveis números primos. A probabilidade de erro é de: %f.\n", forecerProbabilidadeDeErro());
		System.out.print("Digite a quantidade máxima de digítos decimais do provável número primo que deseja gerar: ");
		try {
			Integer quantidadeDeDigitos = leitor.nextInt();
			leitor.nextLine();
			MillerRabin primo = new MillerRabin(quantidadeDeDigitos);
			Boolean encerrar = false;
			do {
				System.out.printf("Provável primo gerado: %d.\n", primo.encontrarProvavelPrimo());
				try {
					System.out.print("Deseja gerar outro primo (S/n)? ");
					encerrar = leitor.nextLine().equals("n");
				} catch (InputMismatchException excecao) {
					System.out.println("Programa encerrado.");
					System.exit(0);
				}
			} while (!encerrar);
			System.out.println("Programa encerrado.");
		} catch (InputMismatchException excecao) {
				System.out.println("Programa encerrado.");
				System.exit(0);
		}
	}
}
