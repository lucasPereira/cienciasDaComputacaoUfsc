package rede;

import static edugraf.jadix.primitivas.Primitiva.tupla;

public class EnvioDeMensagens 
{
	public void envioDeMensagens(String mensagem)
	{
		tupla(mensagem).dizer();
		System.out.println("[Enviando] Mensagem "+mensagem);
	}
}
