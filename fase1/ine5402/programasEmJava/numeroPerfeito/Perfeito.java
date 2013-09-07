public class Perfeito 
{
	private int numero;
	public Perfeito(int valorNumero)
	{
		numero = valorNumero;
		if(numero < 0)
		{
			numero = numero*-1;
		}
		else
		{
			if(numero == 0)
			{
				numero = 1;
			}
		}
	}
	
	public boolean numeroPerfeito()
	{
		int somaDivisores = 1;
		int divisor = 1;
		
		while(divisor <= numero/2)
		{
			divisor++;
			if(numero%divisor == 0)
			{
				somaDivisores += divisor;
			}
		}
		return numero == somaDivisores;
	}
}
