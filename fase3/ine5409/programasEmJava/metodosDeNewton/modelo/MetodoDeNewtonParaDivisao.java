package modelo;

public class MetodoDeNewtonParaDivisao 
{
	private static final int ZERO = 0;
	private static final int DEZ = 10;

	public static double calcular(double c, double d, double e, int nit)
	{
		String numeroDeDigitos = Long.toString((long) c);
		int expoente = -numeroDeDigitos.length();
		double x0 = Math.pow(DEZ, expoente);
		double x1 = x0;
		double erro = DEZ*e;
		for (int cont = ZERO; cont < nit; cont++)
		{
			x0 = x1;
			x1 = x0*(2-c*x0);
			erro = Math.abs(x1-x0)/Math.max(Math.abs(x1), Math.abs(x0));
			if (erro < e)
			{
				return x1;
			}
		}
		return x1*d;
	}
}
