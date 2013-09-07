package modelo;

import static edugraf.jadix.tiposPrimitivos.ElementoGenerico.TEXTO;
import rede.RecebimentoDeMensagens;
import controle.IniciarTratadores;

public class Fachada 
{	
	public Fachada()
	{		
		new IniciarTratadores();
		new RecebimentoDeMensagens().para(TEXTO);
	}
	
	public void altereNumero()
	{
		
	}
	
}
