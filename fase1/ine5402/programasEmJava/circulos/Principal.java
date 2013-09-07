public class Principal
{
	public static void main(String[] p)
	{
		Interface comunicaUsuario = new Interface();
		double valorRaio = comunicaUsuario.pecaRaio();
		
		Circulos circulo1 = new Circulos(valorRaio);
		double area = circulo1.calculeArea();
		comunicaUsuario.imprimaArea(area);
		
		valorRaio = comunicaUsuario.pecaRaio();
		
		Circulos circulo2 = new Circulos(valorRaio);
		area = circulo2.calculeArea();
		comunicaUsuario.imprimaArea(area);
	}
}

