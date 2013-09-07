package modelo;

public class GaussLegendreCompostoDupla {
	private static final int ZERO = 0;
	private static final int DOIS = 2;
	private static final int DEZ = 10;
	
	public static double calcular(double a, double b, double c, double d, double e) {
		double integral1 = GaussLegendreDupla.calcular(a, b, c, d);
		double k = DOIS;
		double erro = DEZ*e;
		int iterações = ZERO;
		while (erro > e) {
			double integral2 = ZERO;
			double passo1 = (b-a)/k;
			double passo2 = (d-c)/k;
			double f = a;
			for (int contA = ZERO; contA < k; contA++) {
				double g = f+passo1;
				double h = c;
				for (int contB = ZERO; contB < k; contB++) {
					double i = h+passo2;
					integral2 = integral2 + GaussLegendreDupla.calcular(f, g, h, i);
					h = i;
				}
				f = g;
			}
			erro = Math.abs(integral1-integral2)/Math.max(Math.abs(integral1), Math.abs(integral2));
			k = k+k;
			integral1 = integral2;
			iterações++;
		}
		System.out.println("Iterações: "+iterações);
		System.out.println("K:"+k/2);
		return integral1;
	}
}
