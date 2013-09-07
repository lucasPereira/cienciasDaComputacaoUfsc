//Aluno: Lucas Pereira - 10100754

public class Quadrados
{
	private double ladoA;
	private double ladoB;
	
	public Quadrados(double valorLadoA, double valorLadoB)
	{
		ladoA = valorLadoA;
		ladoB = valorLadoB;
	}
	
	public double calculeArea()
	{
		return ladoA*ladoB;
	}
	
	public double calculePerimetro()
	{
		return 2*ladoA+2*ladoB;
	}
	
	public double calculeDiagonal()
	{
		return Math.pow(ladoA*ladoA+ladoB*ladoB, 1.0/2.0);
	}
}