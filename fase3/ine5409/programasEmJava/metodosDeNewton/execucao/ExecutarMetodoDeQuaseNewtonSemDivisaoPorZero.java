package execucao;

import modelo.MetodoDeQuaseNewtonSemDivisaoPorZero;

public class ExecutarMetodoDeQuaseNewtonSemDivisaoPorZero 
{
	public static void main(String[] args) 
	{
		double x1 = MetodoDeQuaseNewtonSemDivisaoPorZero.calcular(1, Math.pow(10, -10), 4);
		System.out.println(x1);
	}

}
