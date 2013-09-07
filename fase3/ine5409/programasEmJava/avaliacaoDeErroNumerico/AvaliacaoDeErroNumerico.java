package modelo;

public class AvaliacaoDeErroNumerico 
{
	public static void main(String[] args)
	{
		AvaliacaoDeErroNumerico avaliacao = new AvaliacaoDeErroNumerico();
		//avaliacao.calcularValorDeE();
		//avaliacao.calcularRaizQuadrada(10, 5);
		//avaliacao.erroTrigonometricas(7);
		avaliacao.instabilidadeNumerica(3);
	}
	
	public double calcularRaizQuadrada(double valor, int casasDePrecisao)
	{
		double x0 = 1;
		double x1 = (x0 + valor/x0)/2;
		
		while(calcularErro(x1, x0) > Math.pow(10, -casasDePrecisao))
		{
			x0 = x1;
			x1 = (x0 + valor/x0)/2;
			System.out.println(x1);
		}
		
		return x1;
	}
	
	public double calcularValorDeE()
	{
		double e1 = 1;
		double e0 = 0;
		double erro = 1;
		int cont = 0;
		
		while(erro != 0)
		{
			e0 = e1;
			e1 = e1 + calcularParcelaDaSerie(++cont);
			erro = calcularErro(e1, e0);
			
			System.out.println(cont);
			System.out.println(e1);
			System.out.println(calcularErro(e1, e0) + "\n");
		}
		
		return e1;
	}
	
	private double calcularErro(double x1, double x0)
	{
		double dividendo = Math.abs(x1-x0);
		double divisor = Math.max(Math.abs(x1), Math.abs(x0));
		double resultado = dividendo/divisor;
		
		return resultado;
	}
	
	private double calcularParcelaDaSerie(int valor)
	{
		double fatorial = 1;
		while(valor > 0)
		{
			fatorial = valor * fatorial;
			valor--;
		}
	
		return 1/fatorial;
	}
	
	public void erroTrigonometricas(int expoente)
	{
		double x = Math.pow(10, -expoente);
		double funcao1 = 1-Math.cos(x);
		double funcao2 = Math.pow(Math.sin(x), 2)/(1+Math.cos(x));
		
		System.out.println(funcao1);
		System.out.println(funcao2);
	}
	
	public void instabilidadeNumerica(double y)
	{
		double x = 1/y;
		for(int cont = 1; cont <= 50; cont++)
		{
			x = (y+1)*x-1;
			System.out.println(x);
		}
	}
}
