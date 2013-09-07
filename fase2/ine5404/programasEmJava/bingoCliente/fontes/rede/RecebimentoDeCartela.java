package rede;

import java.util.List;

import modelo.FachadaJogador;
import edugraf.jadix.fachada.SeDito;
import edugraf.jadix.interno.rede.ReceptorDeRede;

public class RecebimentoDeCartela extends ReceptorDeRede 
{
	private FachadaJogador fachadaParaJogador;
	
	public RecebimentoDeCartela(FachadaJogador fachada)
	{
		fachadaParaJogador = fachada;
	}
	
	@SeDito
	public void tratarRecepcao(String identificadorServidor, String identificadorJogador, String comando, List<Integer> numerosDaCartela)
	{
		if(fachadaParaJogador.verificarSeOServidorEstaCorreto(identificadorServidor) && fachadaParaJogador.verificaSeOJogadorEstaCorreto(identificadorJogador) && comando.equals("@envioDeCartela"))
		{		
			fachadaParaJogador.receberCartela(numerosDaCartela);		
			System.out.println("[Recebendo] Números da Cartela");
		}
	}
}