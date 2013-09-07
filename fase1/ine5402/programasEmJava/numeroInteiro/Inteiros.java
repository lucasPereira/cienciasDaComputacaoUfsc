public class Inteiros 
{
	private int inteiro;
	
	public Inteiros(int valorInteiro)
	{
		inteiro = valorInteiro;
		if(inteiro < 0)
		{
			inteiro = inteiro*(-1);
		}
		else
		{
			if(inteiro == 0)
			{
				inteiro = 1;
			}
		}
	}
	
	public boolean par()
	{
		return inteiro%2 == 0;
	}
	
	public int somaPares()
	{
		int par = 0;
		int soma = 0;
		while(par < inteiro)
		{
			soma = soma+par;
			par = par+2;
		}
		return soma;
	}
	
	public long fatorial()
	{
		int numero = 0;
		long fatorial = 1;
		while(numero < inteiro)
		{
		 numero++;
		 fatorial = fatorial*numero;
		}
		return fatorial;
	}
	
	public int sorteio()
	{
		return (int)(Math.random()*inteiro);
	}
	
	public double calculoS()
	{
		double dividendo = 1;
		int divisor = inteiro;
		double soma = 0;
		while(dividendo <= inteiro)
		{
			soma = soma+(dividendo/divisor);
			dividendo++;
			divisor--;
		}
		return soma;
	}
	
	public double calculoS(int parcelas)
	{
		int cont = 0;
		double soma = 0;
		int fatorial = 1;
		int sinal = 1;
		
		while(cont < parcelas)
		{
			cont++;
			fatorial = fatorial*cont;
			soma = soma+((Math.pow(inteiro, cont))/(fatorial)*sinal);
			sinal = sinal*(-1);
		}
		return soma;
	}
	
	public String ultimoDigito()
	{
		int ultimoDigito = inteiro%10;
		switch(ultimoDigito)
		{
			case 0:return "Zero";
			case 1:return "Um";
			case 2:return "Dois";
			case 3:return "Três";
			case 4:return "Quatro";
			case 5:return "Cinco";
			case 6:return "Seis";
			case 7:return "Sete";
			case 8:return "Oito";
			case 9:return "Nove";
			default:return "Erro";
		}
	}
	
	public int somaDigitos()
	{
		int soma = 0;
		int dividendo = inteiro;
		while(dividendo > 0)
		{
			soma = soma+(dividendo%10);
			dividendo = dividendo/10;
		}
		return soma;
	}
	
	public char igualdadeObjetos(Inteiros outroInteiro)
	{
		if(inteiro == outroInteiro.inteiro)
		{
			return '=';
		}
		if(inteiro > outroInteiro.inteiro)
		{
			return '>';
		}
		return '<';
	}
	
	public Inteiros somaObjetos(Inteiros outroInteiro)
	{
		return new Inteiros(inteiro+outroInteiro.inteiro); 
	}
	
	public Inteiros diferencaObjeots(Inteiros outroInteiro)
	{
		if(inteiro > outroInteiro.inteiro)
		{
			return new Inteiros(inteiro-outroInteiro.inteiro);
		}
		return null;
	}
	
	public boolean primo()
	{
		if(inteiro == 1)
		{
			return false;
		}
		if(inteiro == 2 || inteiro == 3)
		{ 
			return true;
		}
		if(this.par())
		{
			return false;
		}
		int raizInteiro = (int)Math.sqrt(inteiro);
		int cont = 1;
		while(cont < raizInteiro)
		{
			cont = cont+2;
			if(inteiro%cont == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public String convercaoDecimalBase(int base)
	{
		String numeroConvertido = "";
		
		for(int numero = inteiro; numero > 0; numero = numero/base)
		{
			int resto = numero%base;
			if(resto < 10)
			{
				numeroConvertido = resto+numeroConvertido;
			}
			else
			{
				switch(resto)
				{
					case 10:
						numeroConvertido = 'A'+numeroConvertido;
						break;
					case 11:
						numeroConvertido = 'B'+numeroConvertido;
						break;
					case 12:
						numeroConvertido = 'C'+numeroConvertido;
						break;
					case 13:
						numeroConvertido = 'D'+numeroConvertido;
						break;
					case 14:
						numeroConvertido = 'E'+numeroConvertido;
						break;
					case 15:
						numeroConvertido = 'F'+numeroConvertido;
				}
			}
		}
		return numeroConvertido;
	}
	
	public int fornecaInteiro()
	{
		return inteiro;
	}
}