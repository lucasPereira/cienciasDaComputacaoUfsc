public class Principal 
{
	public static void main(String[] parametro)
	{
		Interface comunicaUsuario = new Interface();
		Mdc Mdc = new Mdc();
		
		int x = comunicaUsuario.pecaX();
		int y = comunicaUsuario.pecaY();
		
		int MdcXY = Mdc.fornecaMdc(x, y);
		
		if(MdcXY > x && MdcXY > y)
		{
			comunicaUsuario.mostreMensagem("Não existe Mdc dos números fornecidos.");
		}
		else
		{
			comunicaUsuario.mostreMensagem("O Mdc de x e y é: "+MdcXY);
		}
	}
}
