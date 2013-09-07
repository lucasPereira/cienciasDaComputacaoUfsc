//Aluno: Lucas Pereira da Silva

public class Contas 
{
	private int numero;
	private double saldo;
	private double limiteSaqueNegativo;
	
	public Contas(int valorNumero, double valorSaldo, double valorLimiteSaqueNegativo) 
	{
		if(valorNumero <= 0)
		{
			if(valorNumero < 0)
			{
				numero = valorNumero*(-1);
			}
			else
			{
				numero = 0;
			}
		}
		else
		{
			numero = valorNumero;
		}
		
		if(valorSaldo < 0)
		{
			saldo = valorSaldo*(-1);
		}
		else
		{
			saldo = valorSaldo;
		}
		
		if(valorLimiteSaqueNegativo > 0)
		{
			limiteSaqueNegativo = valorLimiteSaqueNegativo*(-1);
		}
		else
		{
			limiteSaqueNegativo = valorLimiteSaqueNegativo;
		}
	}
	
	public Contas()
	{
		numero = 0001;
		saldo = 0;
		limiteSaqueNegativo = 0;
	}
	
	public int fornecaNumero()
	{
		return numero;
	}
	
	public double fornecaSaldo()
	{
		return saldo;
	}
	
	public double fornecaLimiteSaqueNegativo()
	{
		return limiteSaqueNegativo;
	}
	
	public boolean deposite(double valorDeposito)
	{
		if(valorDeposito < 0)
		{
			valorDeposito = valorDeposito*(-1);
		}
		saldo = saldo+valorDeposito;
		return true;
	}
	
	public double saque(double valorSaque)
	{
		if(valorSaque < 0)
		{
			valorSaque = valorSaque*(-1);
		}
		if(saldo-valorSaque >= limiteSaqueNegativo)
		{
			saldo = saldo-valorSaque;
			return valorSaque;
		}
		else
		{
			double saque = valorSaque-(valorSaque-(saldo-limiteSaqueNegativo));
			saldo = limiteSaqueNegativo;
			return saque;
		}
	}
}