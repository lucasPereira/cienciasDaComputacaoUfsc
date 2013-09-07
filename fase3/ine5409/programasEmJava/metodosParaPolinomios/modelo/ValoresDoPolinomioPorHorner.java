package modelo;

public class ValoresDoPolinomioPorHorner 
{
	private static final int ZERO = 0;
	private static final int UM = 1;

	public static double[] calcular(int grau, double v, double[] coeficientes)
	{
		double[] valoresDoPolinomio = new double[21];
		valoresDoPolinomio[ZERO] = calcularValor(grau, v, coeficientes);
		int novoGrau = grau;
		for (int cont = UM; cont <= grau; cont++, novoGrau--)
		{
			coeficientes = calcularCoeficientesDaDerivada(novoGrau, coeficientes);
			valoresDoPolinomio[cont] = calcularValor(novoGrau-UM, v, coeficientes);
		}
		
		return valoresDoPolinomio;
	}

	private static double calcularValor(double grau, double v, double[] coeficientes)
	{
		double valor = coeficientes[ZERO];
		for (int cont = UM; cont <= grau; cont++)
		{
			valor = valor*v+coeficientes[cont];
		}
		
		return valor;
	}
	
	private static double[] calcularCoeficientesDaDerivada(int grau, double[] coeficientes)
	{
		double[] coeficientesDaDerivada = new double[grau];
		for (int cont = UM; cont <= grau; cont++)
		{
			int posicao = grau-cont;
			coeficientesDaDerivada[posicao] = coeficientes[posicao]*cont;
		}
		
		return coeficientesDaDerivada;
	}
}