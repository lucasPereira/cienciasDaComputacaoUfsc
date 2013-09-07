package rede;

import static edugraf.jadix.primitivas.Primitiva.tupla; 

public class EnvioDePedidoDeCartela
{
	public void enviarPedidoDeCartelar(String identificadorServidor, String identificadorJogador)
	{
		tupla(identificadorServidor, identificadorJogador, "@pedidoDeCartela").dizer();
		System.out.println("[Enviando] Pedido de Cartela");
	}
}
