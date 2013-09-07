public class Principal 
{
	public static void main(String[] parametro)
	{
		Interface comunicaUsuario = new Interface();
		int[][] matriz = comunicaUsuario.pecaMatriz();
		comunicaUsuario.mostreMatriz(matriz);	
		
		int linhas = matriz.length;
		int colunas = matriz[0].length;
		
		int somaLinha1 = 0;
		for(int cont = 0; cont < colunas; cont++)
		{
			somaLinha1 += matriz[0][cont];
		}
		
		int somaMatriz = 0;
		for(int cont = 0; cont < linhas; cont++)
		{
			for(int cont1 = 0; cont1 < colunas; cont1++)
			{
				somaMatriz += matriz[cont][cont1];
			}
		}
		
		comunicaUsuario.mostreMensagem("Soma dos valores da linha um: "+somaLinha1+"\nSoma dos valores da matriz: "+somaMatriz);
	}
}
