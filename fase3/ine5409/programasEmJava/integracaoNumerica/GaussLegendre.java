package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class GaussLegendre {
	private static final int ZERO = 0;
	private static final double MEIO = 0.5;
	private static final int UM = 1;
	private static final int DOIS = 2;
	private static final int NUMERO_DE_PARAMETROS_QUADRATURA_DE_GAUSS = 80;
	private static double[] tm = new double[NUMERO_DE_PARAMETROS_QUADRATURA_DE_GAUSS];
	private static double[] am = new double[NUMERO_DE_PARAMETROS_QUADRATURA_DE_GAUSS];
	
	public static double calcular(double a, double b) {
		int m = am.length;
		double aux1 = (b-a)/DOIS;
		double aux2 = (b+a)/DOIS;
		double soma = ZERO;
		for (int cont = ZERO; cont < m; cont++) {
			double xx = aux1*tm[cont]+aux2;	
			soma = soma + am[cont]*f(xx);
		}
		
		return aux1*soma;	
	}
	
	private static double f(double x) {
		return UM/(Math.pow(x, MEIO)*(UM+x));
	}
	
	public static void gerarQuadraturaDeGauss() {
		int tamanhoParametros = am.length;
		try {
			FileInputStream arquivo = new FileInputStream(new File("QuadraturaGaussiana"));
			InputStreamReader leitor = new InputStreamReader(arquivo);
			BufferedReader bufferLeitor = new BufferedReader(leitor, DOIS*1024);
			String stringAim = null;
			String stringTim = null;
			int contPositivos = (int) am.length/DOIS;
			int contNegativos = contPositivos-UM;
			for (int cont = ZERO; cont < tamanhoParametros/DOIS; cont++) {
				stringTim = bufferLeitor.readLine(); 
				System.out.println(stringTim);
				stringAim = bufferLeitor.readLine();
				double aim = Double.parseDouble(stringAim);
				double tim = Double.parseDouble(stringTim);
				am[contPositivos] = aim;
				am[contNegativos] = aim;
				tm[contPositivos] = tim;
				tm[contNegativos] = -tim;
				contNegativos--;
				contPositivos++;
				bufferLeitor.readLine();
			}
		} catch (FileNotFoundException erro) {
			erro.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int cont = ZERO; cont < tamanhoParametros; cont++) {
			System.out.printf("%.32f \t %.32f\n", tm[cont], am[cont]);
		}
	}
}