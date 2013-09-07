package modelo.bingo;

public class Sorteio 
{
	private int numeroMaximo;
	private int numeroMinimo;
	
	public Sorteio()
	{
		numeroMaximo = 30;
		numeroMinimo = 1;
	}
	
	public int sorteie()
	{
		return (int)(Math.random() * (numeroMaximo + 1 - numeroMinimo)) + numeroMinimo;
	}
	
	public int fornecerAmplitude()
	{
		return numeroMaximo - numeroMinimo;
	}
}
