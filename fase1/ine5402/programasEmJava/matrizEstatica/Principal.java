public class Principal 
{
	public static void main(String[] parametro)
	{
		int[][] matriz = Interface.pecaMatriz();
		Interface.mostreMatriz(matriz);	
		
		int somaLinha1 = Matriz.fornecaSomaLinha1(matriz);
		int somaMatriz = Matriz.fornecasomaMatriz(matriz);
		Interface.mostreMensagem("Soma dos valores da linha um: "+somaLinha1+"\nSoma dos valores da matriz: "+somaMatriz);
	
		int[][] matrizTransposta = Matriz.fornecaMatrizTransposta(matriz);
		Interface.mostreMatriz(matrizTransposta);
		
		int somaDiagonal = Matriz.fornecaSomaDiagonal(matriz);
		Interface.mostreMensagem("Soma diagonal principal: "+somaDiagonal);
		
		boolean matrizTriangular = Matriz.triangularSuperior(matriz);
		if(matrizTriangular)
		{
			Interface.mostreMensagem("A matriz é uma matriz triangular superior.");
		}
		else
		{
			Interface.mostreMensagem("A matriz não é uma matriz triangular superior.");
		}
	}
}
