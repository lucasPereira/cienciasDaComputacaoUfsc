//Aluno: Lucas Pereira - 10100754

public class Principal 
{
	public static void main(String[] parametro)
	{
		Contador contas = new Contador();
		contas.conte();
		contas.conte();
		System.out.println(contas.mostreValor());
		contas.zereValor();
		System.out.println(contas.mostreValor());
		contas.conte();
		contas.conte();
		contas.conte();
		System.out.println(contas.mostreValor());
	}
}
