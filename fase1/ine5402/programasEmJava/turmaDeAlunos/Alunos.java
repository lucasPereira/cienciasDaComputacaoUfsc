//Aluno: Lucas Pereira - 10100754

public class Alunos extends Pessoas 
{
	private double provaFinal;
	private double[] notasTestes;
	private int numeroTeste;
	
	public Alunos(String nome, int idade, char sexo)
	{
		super(nome, idade, sexo);
		provaFinal = 0.0;
		notasTestes = new double[20];
		numeroTeste = 0;		
	}

	public int fornecaNumeroTeste()
	{
		return numeroTeste;
	}
	
	public double fornecaProvaFinal()
	{
		return provaFinal;
	}
	
	public double fornecaNotaTeste(int teste)
	{
		if(teste >= 1 && teste <= 20)
		{
			return notasTestes[teste-1];
		}
		else
		{
			return -1;
		}
	}
	
	public double fornecaMenorNotaTestes()
	{
		double menorNota = notasTestes[0];
		for(int cont = 1; cont < numeroTeste; cont++)
		{
			if(notasTestes[cont] <= menorNota)
			{
				menorNota = notasTestes[cont];
			}
		}
		return menorNota;
	}
	
	public double fornecaMediaTestes()
	{
		double soma = 0;
		for(int cont = 0; cont < numeroTeste; cont++)
		{
			soma += notasTestes[cont];
		}
		
		if(numeroTeste == 1)
		{
			return soma;
		}
		else
		{
			return (soma-this.fornecaMenorNotaTestes())/(numeroTeste-1);
		}
	}
	
	public double fornecaMediaFinal()
	{
		return 0.6*this.fornecaMediaTestes()+0.4*provaFinal;
	}
	
	public boolean fornecaSituacao(double criterio)
	{
		return this.fornecaMediaFinal() >= criterio;
	}
	
	public boolean altereProvaFinal(double notaProvaFinal)
	{
		if(notaProvaFinal >= 0 && notaProvaFinal <= 10)
		{
			provaFinal = notaProvaFinal;
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean insiraNotaTeste(double notaTeste)
	{
		if(notaTeste >= 0 && notaTeste <= 10 && numeroTeste < 20)
		{
			notasTestes[numeroTeste] = notaTeste;
			numeroTeste++;			
			return true;
		}
		else
		{
			return false;
		}
	}
}
