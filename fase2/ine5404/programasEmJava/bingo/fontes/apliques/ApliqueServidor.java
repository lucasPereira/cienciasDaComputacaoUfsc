package apliques;

import modelo.servidor.FachadaServidor; 
import edugraf.jadix.Aplique;

public class ApliqueServidor extends Aplique 
{
	public void iniciar() 
	{
		System.out.println("Aplique Servidor Iniciado");
		
		new FachadaServidor(this);
		
		System.out.println("Aplique Servidor Completado");
	}
}