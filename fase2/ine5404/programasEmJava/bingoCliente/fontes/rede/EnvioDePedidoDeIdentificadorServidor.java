package rede;

import static edugraf.jadix.primitivas.Primitiva.tupla; 

public class EnvioDePedidoDeIdentificadorServidor 
{
	public void enviarPedidoDeIdendificador()
	{
		tupla("@fornecimentoDeIDs").dizer();
		System.out.println("[Enviando] Pedido de Identificador Servidor");
	}
}
