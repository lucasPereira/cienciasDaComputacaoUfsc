package modelo;

public class EliminacaoDeGauss 
{
	private double[][] matrizAumentada = {{2, 1, 0, 0}, {1, 3, 2, 1}, {-2, 0, 1, 1}};
	private double[][] matrizSuperAumentada = {{2, 1, 0, 1, 0, 0}, {1, 3, 2, 0, 1, 0}, {-2, 0, 1, 0, 0, 1}};
	private double[] matrizSolucao = {0, 1, 1};
	private int numeroDeLinhas;
	private int numeroDeColunas;
	
	private static final int UM = 1;
	private static final int ZERO = 0;
	
	public EliminacaoDeGauss()
	{
		numeroDeLinhas = 3;
		numeroDeColunas = 4;
	}
	
	public static void main(String[] args)
	{
		new EliminacaoDeGauss().solucionarSistema();
		new EliminacaoDeGauss().solucionarSistemaPeloMetodoDaInversa();
	}
	
	public void solucionarSistema()
	{
		obterFormaDeEscada();
		imprimirMatriz();
		imprimirSolucoes(obterSolucoes());
	}
	
	public void solucionarSistemaPeloMetodoDaInversa()
	{
		numeroDeColunas = 6;
		matrizAumentada = matrizSuperAumentada;
		obterFormaDeEscada();
		imprimirMatriz();
		obterFormaDeEscadaReduzida();
		imprimirMatriz();
		imprimirSolucoes(obterSolucoesDoMetodoDaInversa());
	}
	
	private void pivotar(int colunaLinhaDoPivo)
	{
		double maior = ZERO;
		int linhaMaior = colunaLinhaDoPivo;
		//Achar maior pivô
		for (int linha = colunaLinhaDoPivo; linha < numeroDeLinhas; linha++)
		{
			if (Math.abs(matrizAumentada[linha][colunaLinhaDoPivo]) > maior)
			{
				maior = matrizAumentada[linha][colunaLinhaDoPivo];
				linhaMaior = linha;
			}
		}
		
		//Trocar linha atual pela linha do maior pivô
		if (linhaMaior != colunaLinhaDoPivo)
		{
			for (int cont = ZERO; cont < numeroDeColunas; cont++)
			{
				double troca = matrizAumentada[colunaLinhaDoPivo][cont];
				matrizAumentada[colunaLinhaDoPivo][cont] = matrizAumentada[linhaMaior][cont];
				matrizAumentada[linhaMaior][cont] = troca;
			}
		}
	}
	
	private void obterFormaDeEscada()
	{
		for (int linha = ZERO; linha < numeroDeLinhas; linha++)
		{			
			pivotar(linha);
			
			//Obtém um pivô em cada linha
			double pivo = matrizAumentada[linha][linha];
			for (int coluna = linha; coluna < numeroDeColunas; coluna++)
			{
				matrizAumentada[linha][coluna] = matrizAumentada[linha][coluna]/pivo;
			}
			
			//Zera as linhas abaixo do pivôs
			for (int linhaAZerar = linha+UM; linhaAZerar < numeroDeLinhas; linhaAZerar++)
			{
				double valorAZerar = matrizAumentada[linhaAZerar][linha];
				for (int coluna = linha; coluna < numeroDeColunas; coluna++)
				{
					matrizAumentada[linhaAZerar][coluna] = matrizAumentada[linhaAZerar][coluna]-matrizAumentada[linha][coluna]*valorAZerar;
				}
			}		
		}
	}
	
	private void obterFormaDeEscadaReduzida()
	{
		for (int linhaPivo = numeroDeLinhas-UM; linhaPivo > ZERO; linhaPivo--)
		{
			for (int linhaDividida = linhaPivo-UM; linhaDividida >= ZERO; linhaDividida--)
			{
				double valorAZerar = matrizAumentada[linhaDividida][linhaPivo];
				for (int coluna = linhaPivo; coluna < numeroDeColunas; coluna++)
				{
					matrizAumentada[linhaDividida][coluna] -= matrizAumentada[linhaPivo][coluna]*valorAZerar;
				}	
			}
		}
	}
	
	private double[] obterSolucoesDoMetodoDaInversa()
	{
		double[] solucao = new double[numeroDeLinhas];
		for (int linha = ZERO; linha < numeroDeLinhas; linha++)
		{
			for(int coluna = numeroDeLinhas; coluna < numeroDeColunas; coluna++)
			{
				solucao[linha] += matrizAumentada[linha][coluna]*matrizSolucao[coluna-numeroDeLinhas]; 
			}
		}
		 
		return solucao;
	}
	
	private double[] obterSolucoes() 
	{
		double[] solucao = new double[numeroDeLinhas];
		solucao[numeroDeLinhas-UM] = matrizAumentada[numeroDeLinhas-UM][numeroDeColunas-UM];
		for (int linha = ZERO; linha < numeroDeLinhas; linha++)
		{
			int linhaSolucao = numeroDeLinhas-UM-linha;
			solucao[linhaSolucao] = matrizAumentada[linhaSolucao][numeroDeLinhas];
			for (int coluna = linhaSolucao+UM; coluna < numeroDeColunas-UM; coluna++)
			{
				solucao[linhaSolucao] -= matrizAumentada[linhaSolucao][coluna]*solucao[coluna];
			}
		}
		return solucao;
	}
	
	private void imprimirMatriz()
	{
		String matriz = "";
		for (int linha = ZERO; linha < numeroDeLinhas; linha++)
		{		
			for (int coluna = ZERO; coluna < numeroDeColunas; coluna++)
			{
				if((coluna+UM)%(numeroDeColunas) == ZERO)
				{
					matriz += ("["+matrizAumentada[linha][coluna]+"]\n");
				}
				else
				{
					matriz += ("["+matrizAumentada[linha][coluna]+"] ");
				}
			}
		}
		System.out.println(matriz);
	}
	
	private void imprimirSolucoes(double[] matrizSolucao) 
	{
		char[] variaveis = {'x', 'y', 'z'};
		String solucao = "";
		for (int cont = ZERO; cont < numeroDeLinhas; cont++)
		{
			solucao += (variaveis[cont]+": "+matrizSolucao[cont]+"\n");
		}
		System.out.println(solucao);
	}
}