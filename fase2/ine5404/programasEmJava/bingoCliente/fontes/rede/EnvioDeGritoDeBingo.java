package rede;

import static edugraf.jadix.primitivas.Primitiva.tupla; 

public class EnvioDeGritoDeBingo
{
	public void gritarBingo(String identificadorServidor, String identificadorJogador, String nomeDoJogador)
	{
		tupla(identificadorServidor, identificadorJogador, "@gritoDeBingo", nomeDoJogador).dizer();
		System.out.println("[Enviando] Gritar Bingo");
	}
}
