package execucao;

import modelo.MetodoDeNewton;

public class ExecutarMetodoDeNewton 
{
	public static void main(String[] args)
	{
		double x1 = MetodoDeNewton.calcular(1, Math.pow(10, -10), 4);
		System.out.println(x1);
	}
}
