package principal;

public class Principal 
{
	public static void main(String[] parametro)
	{
		SistemasLineares sistema;
		sistema = new SistemasLineares(Interface.pecaSistemaLinear());
		
		sistema.formaDeEscada();
		Interface.mostreMensagem(sistema.fornecaStringSistema());
	}
}
