package aplique;
import modelo.Fachada;
import edugraf.jadix.ApliqueSemPichador;

public class UmAplique extends ApliqueSemPichador 
{
	public void iniciar() 
	{
		System.out.println("Aplique Iniciado");
		
		new Fachada();
		
		System.out.println("Aplique Terminado");
	}
}