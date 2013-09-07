public class Alunos 
{
	private String nome;
	private double n1;
	private double n2;
	private double n3;
	
	public Alunos(String valorNome, double valorN1, double valorN2, double valorN3)
	{
		nome = valorNome;
		n1 = valorN1;
		n2 = valorN2;
		n3 = valorN3;
	}
	
	public void aumenteNotaN1()
	{
		if(n1 < 9.0)
		{
			n1++;
		}
		else
		{
			n1 = 10.0;
		}
	}
	
	public String fornecaNome()
	{
		return nome;
	}
	
	public double fornecaN1()
	{
		return n1;
	}
	
	public double fornecaN2()
	{
		return n2;
	}
	
	public double fornecaN3()
	{
		return n3;
	}
	
	public double fornecaMedia()
	{
		return (n1+n2+n3)/3;
	}
	
	public boolean fornecaSituacao(double criterio)
	{
		return (n1+n2+n3)/3 >= criterio;
	}
	
	public double fornecaMenorNota()
	{
		if((n1 < n2) && (n1 < n3))
		{
			return n1;
		}	
		else
		{
			if(n2 < n3)
			{
				return n2;
			}
			else
			{
				return n3;
			}
		}
	}
	
	public double fornecaMaiorNota()
	{
		if((n1 > n2) && (n1 > n3))
		{
			return n1;
		}
		else
		{
			if(n2 > n3)
			{
				return n2;
			}
			else
			{
				return n3;
			}
		}
	}
	
	public int fornecaNotasAcima(double criterio)
	{
		int notasAcima = 0;
		if(n1 > criterio)
		{
			notasAcima++;
		}
		if(n2 > criterio)
		{
			notasAcima++;
		}
		if(n3 > criterio)
		{
			notasAcima++;
		}
		return notasAcima;
	}
}