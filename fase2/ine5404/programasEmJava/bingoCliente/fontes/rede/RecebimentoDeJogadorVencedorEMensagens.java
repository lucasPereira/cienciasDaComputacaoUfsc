package rede;

import modelo.FachadaJogador;
import edugraf.jadix.fachada.SeDito;
import edugraf.jadix.interno.rede.ReceptorDeRede;

public class RecebimentoDeJogadorVencedorEMensagens extends ReceptorDeRede 
{
	private FachadaJogador fachadaParaJogador;
	
	public RecebimentoDeJogadorVencedorEMensagens(FachadaJogador fachada)
	{
		fachadaParaJogador = fachada;
	}
	
	@SeDito
	public void tratarRecepcao(String identificadorServidor, String comando, String jogadorOuMensagem)
	{
		if(fachadaParaJogador.verificarSeOServidorEstaCorreto(identificadorServidor))
		{
			tratarRecepcaoJogadorVencedor(comando, jogadorOuMensagem);
			
			tratarRecepcaoMensagem(comando, jogadorOuMensagem);
		}
	}

	private void tratarRecepcaoMensagem(String comando, String jogadorOuMensagem) 
	{
		if(comando.equals("@envioDeMensagem"))
		{		
			fachadaParaJogador.receberMensagem(jogadorOuMensagem);
			System.out.println("[Recebendo] Mensagem " + jogadorOuMensagem);
		}
	}

	private void tratarRecepcaoJogadorVencedor(String comando, String jogadorOuMensagem) 
	{
		if(comando.equals("@envioDeJogadorVencedor"))
		{		
			fachadaParaJogador.receberJogadorVencedor(jogadorOuMensagem);
			System.out.println("[Recebendo] Jogador Vencedor " + jogadorOuMensagem);
		}
	}
}