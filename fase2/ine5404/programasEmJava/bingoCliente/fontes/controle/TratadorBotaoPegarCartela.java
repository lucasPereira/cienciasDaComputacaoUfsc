package controle;

import modelo.FachadaJogador;
import visao.VisaoJogador;

public class TratadorBotaoPegarCartela extends TratadorAbstratoDeBotao 
{
	private VisaoJogador interfaceJogador;
	private FachadaJogador fachadaParaJogador;
	
	public TratadorBotaoPegarCartela(FachadaJogador fachada)
	{
		fachadaParaJogador = fachada;
		interfaceJogador = new VisaoJogador(fachadaParaJogador);
	}
	
	public void seClicado() 
	{
		String nomeJogador = interfaceJogador.fornecerNomeJogador();
		fachadaParaJogador.pegarCartela(nomeJogador);
		System.out.println("[Tratador] Botão Pegar Cartela");
	}
}
