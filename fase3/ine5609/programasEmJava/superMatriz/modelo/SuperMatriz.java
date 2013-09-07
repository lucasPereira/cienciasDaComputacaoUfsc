package modelo;

public final class SuperMatriz 
{
	private SuperArray matriz;
	
	private final int NUMERO_DE_COLUNAS;
	private final int NUMERO_DE_LINHAS;
	
	private static final int UM = 1;
	
	public SuperMatriz(int numeroDeLinhas, int numeroDeColunas)
	{
		if (numeroDeLinhas <= 0 || numeroDeColunas <=0) throw new IllegalArgumentException("Número de linhas e colunas deve ser mairo que zero.");
		
		NUMERO_DE_COLUNAS = numeroDeColunas;
		NUMERO_DE_LINHAS = numeroDeLinhas;
		matriz = new SuperArray(UM, numeroDeLinhas * numeroDeColunas);
	}
	
	public void atribuir(int posicaoLinha, int posicaoColuna, int valor)
	{
		int posicao = this.fornecerPosicaoArray(posicaoLinha, posicaoColuna);
		matriz.atribuir(posicao, valor);
	}
	
	public int acessar(int posicaoLinha, int posicaoColuna)
	{
		int posicao = this.fornecerPosicaoArray(posicaoLinha, posicaoColuna);
		
		return matriz.acessar(posicao);
	}
	
	private int fornecerPosicaoArray(int posicaoLinha, int posicaoColuna)
	{
		int posicao = (posicaoLinha - UM) * NUMERO_DE_COLUNAS + (posicaoColuna);
	
		return posicao;
	}
	
	public void imprimir()
	{
		String matrizImpressa= "";
		for(int linha = 1; linha <= NUMERO_DE_LINHAS; linha++)
		{
			for(int coluna = 1; coluna <= NUMERO_DE_COLUNAS; coluna++)
			{
				if((coluna - 1) % NUMERO_DE_COLUNAS == 0)
				{
					matrizImpressa += "\n";
				}
				matrizImpressa += " " + matriz.acessar(this.fornecerPosicaoArray(linha, coluna));
			}
		}
		System.out.println(matrizImpressa);	
	}
	
	public static void main(String[] args)
	{
		new SuperArray(2, 4).acessar(1);
		
		SuperMatriz superMatriz = new SuperMatriz(3, 3);
		superMatriz.atribuir(1, 1, 11);
		superMatriz.atribuir(1, 2, 12);
		superMatriz.atribuir(1, 3, 13);
		superMatriz.atribuir(2, 1, 21);
		superMatriz.atribuir(2, 2, 22);
		superMatriz.atribuir(2, 3, 32);
		superMatriz.atribuir(3, 1, 31);
		superMatriz.atribuir(3, 2, 32);
		superMatriz.atribuir(3, 3, 33);
		superMatriz.imprimir();
	}
}