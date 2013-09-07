package execucao;

import modelo.GaussLegendre;
import modelo.GaussLegendreComposto;
import modelo.GaussLegendreCompostoDupla;

public class Principal {
	public static void main(String[] args) {
		double d = 7;
		double e = Math.pow(10, -d);
		GaussLegendre.gerarQuadraturaDeGauss();
		double integralImpropria = GaussLegendreComposto.calcular(0, 1, e);
		System.out.printf("%.32f", integralImpropria*2);
		System.out.println("\n\n--\n");
		double integralDupla = GaussLegendreCompostoDupla.calcular(1, 2, 3, 5, e);
		System.out.printf("%.32f", integralDupla);
	}
}
