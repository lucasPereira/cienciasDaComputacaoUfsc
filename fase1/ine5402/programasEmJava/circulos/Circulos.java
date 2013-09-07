public class Circulos
{
	private double raio;
	public Circulos(double valorRaio)
	{
		raio = valorRaio;
	}
	
	public double calculeArea()
	{
		double area = 3.1415*raio*raio;
		return area;
	}
}