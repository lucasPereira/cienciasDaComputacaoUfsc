package modelo;

public class MetodoDeNewton 
{
	private static final int ZERO = 0;
	private static final int DEZ = 10;

	public static double calcular(double x0, double e, int nit)
	{
		double x1 = x0;
		double erro = DEZ*e;
		for (int cont = ZERO; cont < nit; cont++)
		{
			x0 = x1;
			double fLinhax0 = fLinha(x0);
			if (fLinhax0 == ZERO)
			{
				return Double.NaN;
			}
			x1 = x0-f(x0)/fLinhax0;
			erro = Math.abs(x1-x0)/Math.max(Math.abs(x1), Math.abs(x0));
			if (erro < e)
			{
				return x1;
			}
		}
		return x1;
	}
	
	public static double f(double x)
	{
		return Math.pow(Math.E, -x)-Math.log(x);
	}
	
	public static double fLinha(double x)
	{
		return -Math.pow(Math.E, -x)-(1/x);
	}
}
