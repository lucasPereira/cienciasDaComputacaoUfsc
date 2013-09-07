package execucao;

import modelo.MetodoDaFalsaPosicaoModificado;

public class ExecutarMetodoDaFalsaPosicaoModificado 
{
	public static void main(String[] args)
	{
		double solucao = MetodoDaFalsaPosicaoModificado.calcular(3, 5, Math.pow(10, -10));
		System.out.printf("%.10f", solucao);
	}
}
