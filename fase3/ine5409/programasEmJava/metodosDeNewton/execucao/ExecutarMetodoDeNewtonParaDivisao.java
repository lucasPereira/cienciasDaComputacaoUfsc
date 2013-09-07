package execucao;

import modelo.MetodoDeNewtonParaDivisao;

public class ExecutarMetodoDeNewtonParaDivisao 
{
	public static void main(String[] args)
	{
		double x1 = MetodoDeNewtonParaDivisao.calcular(780, 1, Math.pow(10, -10), 4);
		System.out.println(x1);
	}
}
