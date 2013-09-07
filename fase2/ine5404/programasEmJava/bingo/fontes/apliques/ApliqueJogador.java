package apliques;

import modelo.jogador.FachadaJogador; 
import edugraf.jadix.Aplique;  

public class ApliqueJogador extends Aplique 
{
	public void iniciar() 
	{
		System.out.println("Aplique Jogador Iniciado");
		
		new FachadaJogador(); 
		
		System.out.println("Aplique Jogador Completado");
	}
}