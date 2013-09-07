package controle;

import modelo.jogador.FachadaJogador; 
import visao.InterfaceJogador;

public class TratadorBotaoPegarCartela extends TratadorAbstratoDeBotao 
{
	private InterfaceJogador interfaceJogador;
	private FachadaJogador fachadaParaJogador;
	
	public TratadorBotaoPegarCartela(FachadaJogador fachada)
	{
		fachadaParaJogador = fachada;
		interfaceJogador = new InterfaceJogador(fachadaParaJogador);
	}
	
	public void seClicado() 
	{
		String nomeJogador = interfaceJogador.fornecerNomeJogador();
		interfaceJogador.desabilitarCampoNomeJogador();
		interfaceJogador.habilitarBotaoGritarBingo();
		fachadaParaJogador.pegarCartela(nomeJogador);
		System.out.println("[Tratador] Botão Pegar Cartela");
	}
}
