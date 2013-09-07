package modelo;
	
public class GaussLegendreDupla {
	private static final int ZERO = 0;
	private static final int DOIS = 2;
	private static final double[] am = {0.34785484, 0.65214516, 0.65214516, 0.34785484};
	private static final double[] tm = {-0.86113631, -0.33998104, 0.33998104, 0.86113631};

	public static double calcular(double a, double b, double c, double d) {
		int m = am.length;
		double aux1 = (b-a)/DOIS;
		double aux2 = (b+a)/DOIS;
		double auy1 = (d-c)/DOIS;
		double auy2 = (d+c)/DOIS;
		double integralX = 0;
		for (int contY = ZERO; contY < m; contY++) {
			double integralY = 0;
			double yy = auy1*tm[contY]+auy2;
			for (int contX = ZERO; contX < m; contX++) {
				double xx = aux1*tm[contX]+aux2;
				integralY += am[contX]*f(xx, yy); 
			}
			integralX += integralY*am[contY];
		}
		
		return aux1*auy1*integralX;
	}
	
	public static double f(double x, double y) {
		return Math.pow(Math.E, y/x);
	}
}