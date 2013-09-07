package modelo;

public class ValoresDoPolinomioPorDivisoesSucessivas 
{
	private static final int ZERO = 0;
	private static final int UM = 1;

	public static double[] calcular(int grau, double v, double[] coeficientes)
	{
		double[] valoresDoPolinomio = new double[grau+UM];
		double[] polinomioDividido = dividirPolinomio(grau, v, coeficientes);
		valoresDoPolinomio[ZERO] = polinomioDividido[polinomioDividido.length-UM];
		long fatorial = 1;
		for (int cont = UM; cont <= grau; cont++)
		{
			int novoGrau = grau-cont;
			fatorial *= cont;
			polinomioDividido = dividirPolinomio(novoGrau, v, polinomioDividido);
			valoresDoPolinomio[cont] = fatorial*polinomioDividido[polinomioDividido.length-UM];
		}
		
		return valoresDoPolinomio;
	}
	
	public static double[] dividirPolinomio(int grau, double v, double[] coeficientes)
	{
		double[] coeficientesDoPolinomioDividido = new double[grau+UM];
		coeficientesDoPolinomioDividido[ZERO] = coeficientes[ZERO];
		for (int cont = UM; cont <= grau; cont++)
		{
			coeficientesDoPolinomioDividido[cont] = coeficientesDoPolinomioDividido[cont-UM]*v+coeficientes[cont]; 
		}
		
		return coeficientesDoPolinomioDividido;
	}
}