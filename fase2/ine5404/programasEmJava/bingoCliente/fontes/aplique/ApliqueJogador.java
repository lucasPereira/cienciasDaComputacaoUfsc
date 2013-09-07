package aplique;

import static edugraf.jadix.tiposPrimitivos.ElementoGenerico.TEXTO;
import rede.EnvioDePedidoDeIdentificadorServidor;
import rede.RecebimentoDeIdentificadorServidor;
import modelo.FachadaJogador;


import edugraf.jadix.Aplique;

public class ApliqueJogador extends Aplique 
{
	private FachadaJogador fachadaJogador = null;	
	
	public void iniciar() 
	{
		System.out.println("[Aplique] Aplique Jogador Iniciado");
		
		new RecebimentoDeIdentificadorServidor(this).para(TEXTO, TEXTO);		
		new EnvioDePedidoDeIdentificadorServidor().enviarPedidoDeIdendificador();
		
		System.out.println("[Aplique] Aplique Jogador Completado");
	}
	
	public void iniciarJogo(String identificadorServidor)
	{
		if(fachadaJogador == null)
		{
			System.out.println("[Aplique] Servidor Encontrado");
		    fachadaJogador = new FachadaJogador(identificadorServidor);
		}
	}
}