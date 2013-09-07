package visao;

import apliques.ApliqueJogador;  
import modelo.jogador.FachadaJogador;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;

public class InterfaceJogador 
{
	private PaginaDix paginaJogador;
	private ComponenteDix botaoGritarBingo;
	private ComponenteDix campoNomeJogador;
	private ComponenteDix etiquetaJogadorVencedor;
	
	public InterfaceJogador(FachadaJogador fachada)
	{		
		paginaJogador = new ApliqueJogador().obterPaginaDix();
		paginaJogador.criarProcuradorDeComponente("botaoPegarCartela");
		botaoGritarBingo = paginaJogador.criarProcuradorDeComponente("botaoGritarBingo");
		campoNomeJogador = paginaJogador.criarProcuradorDeComponente("campoNomeJogador");
		etiquetaJogadorVencedor = paginaJogador.criarProcuradorDeComponente("etiquetaJogadorVencedor");

		botaoGritarBingo.desabilitar();
	}
	
	public String fornecerNomeJogador()
	{
		return campoNomeJogador.obterTexto();
	}
	
	public void desabilitarCampoNomeJogador()
	{
		campoNomeJogador.desabilitar();
	}
	
	public void habilitarBotaoGritarBingo()
	{
		botaoGritarBingo.habilitar();
	}
	
	public void mostrarVencedor(String jogadorVencedor)
	{
		etiquetaJogadorVencedor.fixarTexto("Último Vencedor do Bingo: <em>"+jogadorVencedor+"</em>");
	}
}
