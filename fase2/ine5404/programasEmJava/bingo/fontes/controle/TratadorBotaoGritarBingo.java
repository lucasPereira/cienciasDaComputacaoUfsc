package controle;

import modelo.jogador.FachadaJogador;  

public class TratadorBotaoGritarBingo extends TratadorAbstratoDeBotao 
{
	private FachadaJogador fachadaParaJogador;
	
	public TratadorBotaoGritarBingo(FachadaJogador fachada)
	{
		fachadaParaJogador = fachada;
	}
	
	public void seClicado()
	{
		fachadaParaJogador.gritarBingo();
		System.out.println("[Tratador] Botão Gritar Bingo");
	}
}
