public class Matriz 
{
	public Matriz()
	{
		
	}
	
	public static boolean matrizQuadrada(int[][] matriz)
	{
		return matriz.length == matriz[0].length;
	}
	
	public static boolean triangularSuperior(int[][] matriz)
	{
		if(!Matriz.matrizQuadrada(matriz))
		{
			return false;
		}
		int numeroLinhas = matriz.length;
		for(int linhas = 0; linhas < numeroLinhas; ++linhas)
		{
			for(int colunas = 0; colunas < numeroLinhas; ++colunas)
			{
				if(matriz[linhas][colunas] != 0)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static int fornecaSomaLinha1(int[][] matriz)
	{
		int somaLinha1 = 0;
		int colunas = matriz[0].length;
		for(int cont = 0; cont < colunas; cont++)
		{
			somaLinha1 += matriz[0][cont];
		}
		return somaLinha1;
	}
	
	public static int fornecasomaMatriz(int[][] matriz)
	{
		int somaMatriz = 0;
		int linhas = matriz.length;
		int colunas = matriz[0].length;
		for(int cont = 0; cont < linhas; cont++)
		{
			for(int cont1 = 0; cont1 < colunas; cont1++)
			{
				somaMatriz += matriz[cont][cont1];
			}
		}
		return somaMatriz;
	}
	
	public static int[][] fornecaMatrizTransposta(int[][] matriz)
	{
		int numeroLinhas = matriz.length;
		int numeroColunas = matriz[0].length;
		int[][] matrizTransposta = new int[numeroColunas][numeroLinhas];
		for(int linhas = 0; linhas < numeroLinhas; linhas++)
		{
			for(int colunas = 0; colunas < numeroColunas; colunas++)
			{
				matrizTransposta[colunas][linhas] = matriz[linhas][colunas];
			}
		}
		return matrizTransposta;
	}
	
	public static int fornecaSomaDiagonal(int[][] matriz)
	{
		if(Matriz.matrizQuadrada(matriz))
		{
			int soma = 0;
			int numeroLinhas = matriz.length;
			for(int linhas = 0; linhas < numeroLinhas; ++linhas)
			{
				soma += matriz[linhas][linhas];
			}
			return soma;
		}
		return Integer.MIN_VALUE;
	}
}
