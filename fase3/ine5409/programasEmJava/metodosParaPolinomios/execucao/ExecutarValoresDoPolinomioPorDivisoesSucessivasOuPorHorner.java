package execucao;

import modelo.ValoresDoPolinomioPorDivisoesSucessivas;
import modelo.ValoresDoPolinomioPorHorner;

public class ExecutarValoresDoPolinomioPorDivisoesSucessivasOuPorHorner 
{
	
	public static void main(String[] args)
	{
		double[] coeficientes = new double[21];
		coeficientes[0] = 1;
		for (int cont = 1; cont <= 20; cont++)
		{
			coeficientes[cont] = Math.log(cont+1);
		}
		double[] valoresDivisoesSucessivas = ValoresDoPolinomioPorDivisoesSucessivas.calcular(20, Math.pow(2, 0.5), coeficientes);
		double[] valoresHorner = ValoresDoPolinomioPorHorner.calcular(20, Math.pow(2, 0.5), coeficientes); 
		for (int cont = 0; cont < 21; cont++)
		{
			double erro = (Math.abs(valoresDivisoesSucessivas[cont] - valoresHorner[cont]))/(Math.max(Math.abs(valoresDivisoesSucessivas[cont]), Math.abs(valoresHorner[cont])));
			System.out.printf("[%d] %32.32f %32.32f %f\n", cont, valoresDivisoesSucessivas[cont], valoresHorner[cont], erro);
		}
	}
}
