public class Principal 
{
	public static void main(String[] parametro)
	{
		Interface comunicaUsuario = new Interface();
		
		Relogios relogio1 = new Relogios();
		comunicaUsuario.mostreHorario(relogio1.fornecaHorario());
		
		Relogios relogio2 = new Relogios(23, 800, 125);
		comunicaUsuario.mostreHorario(relogio2.fornecaHorario());
		relogio2.tictac();
		comunicaUsuario.mostreHorario(relogio2.fornecaHorario());
		relogio2.tictac();
		comunicaUsuario.mostreHorario(relogio2.fornecaHorario());
		
		Relogios relogio3 = new Relogios(23, 59, 59);
		relogio3.tictac();
		comunicaUsuario.mostreHorario(relogio3.fornecaHorario());
	}
}
