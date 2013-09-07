public class Principal 
{
	public static void main(String[] parametro)
	{
		Interface comunicaUsuario = new Interface();
		Perfeito numeroPerfeito = comunicaUsuario.pecaNumero();
		
		if(numeroPerfeito.numeroPerfeito())
		{
			comunicaUsuario.mostreMensagem("É número perfeito.");
		}
		else
		{
			comunicaUsuario.mostreMensagem("Não é perfeito.");
		}
	}
}
