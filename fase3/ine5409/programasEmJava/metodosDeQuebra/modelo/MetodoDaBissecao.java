package modelo;

public class MetodoDaBissecao 
{
	private static final double ZERO = 0.0;
	private static final int DOIS = 2;
	
	public static double calcular(double a, double b, double e)
	{
		double fa = f(a);
		double fb = f(b);
		double xm = Double.NaN;
		if (verificarSeTemMesmoSinal(fa, fb))
		{
			return xm;
		}
		double erro = Math.abs(a-b);
		
		while (erro >= e)
		{
			xm = (a+b)/DOIS;
			double fxm = f(xm);
			if (fxm == ZERO)
			{
				return xm;
			}
			System.out.printf("%.10f %.10f %.10f %.10f %.10f %.10f %.11f\n", a, xm, b, fa, fxm, fb, erro);
			if (verificarSeTemMesmoSinal(fa, fxm))
			{
				a = xm;
				fa = fxm;
			}
			else
			{
				b = xm;
				fb = fxm;
			}
			erro = Math.abs(a-b);
		}
		
		return xm;
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