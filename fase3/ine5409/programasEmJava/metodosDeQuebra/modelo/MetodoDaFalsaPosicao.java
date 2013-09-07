package modelo;

public class MetodoDaFalsaPosicao 
{
	private static final double ZERO = 0.0;
	
	public static double calcular(double a, double b, double e)
	{
		double fa = f(a);
		double fb = f(b);
		double xx = (a-fa*(b-a)/(fb-fa))*10;
		if (verificarSeTemMesmoSinal(fa, fb))
		{
			return Double.NaN;
		}
		double erro = Math.abs(a-b);
		while (erro >= e)
		{
			double xx0 = xx; 
			xx = a-fa*(b-a)/(fb-fa);
			double fxx = f(xx);
			if (fxx == ZERO)
			{
				return xx;
			}
			System.out.printf("%.10f %.10f %.10f %.10f %.10f %.10f %.11f\n", a, xx, b, fa, fxx, fb, erro);
			if (verificarSeTemMesmoSinal(fa, fxx))
			{
				a = xx;
				fa = fxx;
			}
			else
			{
				b = xx;
				fb = fxx;
			}
			erro = Math.abs(xx-xx0);
		}
		
		return xx;
	}
	
	private static double f(double x)
	{
		double ln = Math.log(x);
		double elevadoLn = Math.pow(ln, x);
		
		return x-elevadoLn;
	}
	
	private static boolean verificarSeTemMesmoSinal(double a, double b)
	{
		return (a > ZERO && b > ZERO) || (a < ZERO && b < ZERO);
	}
}