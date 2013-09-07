package modelo;

import utilidades.SuperArray;

public class CalculoDaMultiplicidade 
{
	private static final int ZERO = 0;
	private static final int UM = 1;
	
	public static int calcularMultiplicidade(int grau, double solucao, SuperArray coeficientes, double e)
	{
		int novoGrau = grau;
		double valor = calcularP(grau, solucao, coeficientes);
		if (Math.abs(valor) > e) return ZERO;
		for (int k = UM; k <= grau; k++)
		{
			coeficientes = calcularCoeficientesDaDerivada(novoGrau, coeficientes);
			novoGrau--;
			valor = calcularP(novoGrau, solucao, coeficientes);
			if (Math.abs(valor) > e) return k;
		}
		
		return grau;
	}
	
	public static SuperArray calcularCoeficientesDaDerivada(int grau, SuperArray coeficientes)
	{
		int fatorial = grau;
		SuperArray novosCoeficientes = new SuperArray(UM, grau);
		for (int i = UM; i <= grau; i++)
		{
			novosCoeficientes.atribuir(i, coeficientes.acessar(i)*fatorial);
			fatorial--;
		}
		
		return novosCoeficientes;
	}
	
	public static double calcularP(int grau, double valor, SuperArray coeficientes)
	{
		double solucao = coeficientes.acessar(UM);
		for (int i = UM; i <= grau; i++)
		{
			solucao = solucao*valor+coeficientes.acessar(i+UM);
		}
		
		return solucao;
	}
}