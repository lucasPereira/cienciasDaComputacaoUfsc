package execucao;

import modelo.MetodoDaBissecao;

public class ExecutarMetodoDaBissecao 
{
	public static void main(String[] args)
	{
		double solucao = MetodoDaBissecao.calcular(3, 5, Math.pow(10, -10));
		System.out.printf("%.10f", solucao);
	}
}
