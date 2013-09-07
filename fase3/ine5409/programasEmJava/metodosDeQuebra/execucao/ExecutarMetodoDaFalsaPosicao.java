package execucao;

import modelo.MetodoDaFalsaPosicao;

public class ExecutarMetodoDaFalsaPosicao 
{
	public static void main(String[] args)
	{
		double solucao = MetodoDaFalsaPosicao.calcular(3, 5, Math.pow(10, -10));
		System.out.printf("%.10f", solucao);
	}
}
