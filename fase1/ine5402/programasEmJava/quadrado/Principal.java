//Aluno: Lucas Pereira - 10100754

public class Principal
{
	public static void main(String[] parametro)
	{
		Interface comunicaUsuario = new Interface();
		Quadrados quadrado = comunicaUsuario.pecaLados();
		comunicaUsuario.mostreRetangulo(quadrado.calculeArea(), quadrado.calculePerimetro(), quadrado.calculeDiagonal());
	}
}