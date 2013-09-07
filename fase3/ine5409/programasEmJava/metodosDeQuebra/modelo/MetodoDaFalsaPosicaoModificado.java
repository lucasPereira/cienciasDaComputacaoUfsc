package modelo;

public class MetodoDaFalsaPosicaoModificado 
{
	private static final double ZERO = 0.0;
	private static final int DOIS = 2;
	
	public static double calcular(double a, double b, double e)
	{
		double fa = f(a);
		double fb = f(b);
		double xx = Double.NaN;
		double fxx0 = fa;
		if (verificarSeTemMesmoSinal(fa, fb))
		{
			return xx;
		}
		double erro = Math.abs(a-b);
		
		while (erro >= e)
		{
			xx = a-fa*(b-a)/(fb-fa);
			double fxx = f(xx);
			System.out.printf("%.10f %.10f %.10f %.10f %.10f %.10f %.11f\n", a, xx, b, fa, fxx, fb, erro);
			if (fxx == ZERO)
			{
				return xx;
			}
			if (verificarSeTemMesmoSinal(fa, fxx))
			{
				a = xx;
				fa = fxx;
				if (verificarSeTemMesmoSinal(fxx, fxx0))
				{
					fb = fb/DOIS;
				}
			}
			else
			{
				b = xx;
				fb = fxx;
				if (verificarSeTemMesmoSinal(fxx, fxx0))
				{
					fa = fa/DOIS;
				}
			}
			erro = Math.abs(a-b);
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