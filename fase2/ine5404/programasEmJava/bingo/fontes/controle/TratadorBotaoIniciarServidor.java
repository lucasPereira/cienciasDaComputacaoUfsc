package controle;

import modelo.servidor.FachadaServidor;

public class TratadorBotaoIniciarServidor extends TratadorAbstratoDeBotao
{
	private FachadaServidor fachadaParaServidor;
	
	public TratadorBotaoIniciarServidor(FachadaServidor fachada)
	{
		fachadaParaServidor = fachada;
	}
	
	public void seClicado() 
	{
		System.out.println("[Tratador] Botão Iniciar Servidor");
		fachadaParaServidor.iniciarServidor();	
	}

}
