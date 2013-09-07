package rede;

import visao.InterfaceChat;
import edugraf.jadix.fachada.SeDito;
import edugraf.jadix.interno.rede.ReceptorDeRede;

public class RecebimentoDeMensagens extends ReceptorDeRede
{
	@SeDito
	public void receber(String texto)
	{
		System.out.println("[Recebendo] "+texto);
		new InterfaceChat().mostreTextoRecebido(texto);
	}
	
}
