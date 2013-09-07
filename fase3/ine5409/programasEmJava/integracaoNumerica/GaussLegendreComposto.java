package modelo;

public class GaussLegendreComposto { 
	private static final int ZERO = 0;
	private static final int DOIS = 2;
	private static final int DEZ = 10;
	
	public static double calcular(double a, double b, double e) {
		double integral1 = GaussLegendre.calcular(a, b);
		double k = DOIS;
		double erro = DEZ*e;
		int iterações = ZERO;
		while (erro > e) {
			double integral2 = ZERO;
			double passo = (b-a)/k;
			double c = a;
			for (int cont = ZERO; cont < k; cont++) {
				double d = c+passo;
				integral2 = integral2+GaussLegendre.calcular(c, d);
				c = d;
			}
			erro = Math.abs(integral1-integral2)/Math.max(Math.abs(integral1), Math.abs(integral2));
			k = k+k;
			System.out.println(k+"\t"+integral1+"\t"+integral2+"\t"+erro);
			integral1 = integral2;
			iterações++;
		}
		System.out.println("Iterações: "+iterações);
		System.out.println("K: "+k/2);
		
		return integral1;
	}
}