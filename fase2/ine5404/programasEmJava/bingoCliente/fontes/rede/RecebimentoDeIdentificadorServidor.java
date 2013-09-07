package rede;

import aplique.ApliqueJogador;
import edugraf.jadix.fachada.SeDito;
import edugraf.jadix.interno.rede.ReceptorDeRede;

public class RecebimentoDeIdentificadorServidor extends ReceptorDeRede 
{	
	private ApliqueJogador apliqueJogador;
	
	public RecebimentoDeIdentificadorServidor(ApliqueJogador aplique)
	{
		apliqueJogador = aplique;
	}
	
	@SeDito
	public void tratarRecepcao(String identificadorServidor, String comando)
	{
		if(comando.equals("@envioDeIDs"))
		{
			System.out.println("[Recebendo] Identificador Servidor");
			apliqueJogador.iniciarJogo(identificadorServidor);
		}
	}
}