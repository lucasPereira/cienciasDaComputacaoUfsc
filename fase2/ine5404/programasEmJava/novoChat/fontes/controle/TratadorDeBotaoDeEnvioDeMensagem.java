package controle;

import rede.EnvioDeMensagens;
import visao.InterfaceChat;

public class TratadorDeBotaoDeEnvioDeMensagem extends TratadorAbstratoDeBotao 
{
	public void seClicado()
	{
		String texto = new InterfaceChat().pegarTexto();
		new InterfaceChat().mostreTextoRecebido(texto);
		new EnvioDeMensagens().envioDeMensagens(texto);
		new InterfaceChat().limparAreaDeTexto();
		System.out.println("[Tratador] Botão Enviar Mensagem");
	}
}
