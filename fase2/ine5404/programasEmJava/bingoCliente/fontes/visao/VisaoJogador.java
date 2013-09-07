package visao;

import modelo.FachadaJogador;
import aplique.ApliqueJogador;  
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;

public class VisaoJogador 
{
	private PaginaDix paginaJogador;
	private ComponenteDix botaoGritarBingo;
	private ComponenteDix botaoPegarCartela;
	private ComponenteDix campoNomeJogador;
	private ComponenteDix etiquetaJogadorVencedor;
	private ComponenteDix etiquetaMensagens;
	
	public VisaoJogador(FachadaJogador fachada)
	{		
		paginaJogador = new ApliqueJogador().obterPaginaDix();
		botaoGritarBingo = paginaJogador.criarProcuradorDeComponente("botaoGritarBingo");
		botaoPegarCartela = paginaJogador.criarProcuradorDeComponente("botaoPegarCartela");
		campoNomeJogador = paginaJogador.criarProcuradorDeComponente("campoNomeJogador");
		etiquetaJogadorVencedor = paginaJogador.criarProcuradorDeComponente("etiquetaJogadorVencedor");
		etiquetaMensagens = paginaJogador.criarProcuradorDeComponente("etiquetaMensagens");

		botaoGritarBingo.desabilitar();
	}
	
	public String fornecerNomeJogador()
	{
		return campoNomeJogador.obterTexto();
	}

	public void habilitarCampoNomeJogador()
	{
		campoNomeJogador.habilitar();
	}
	
	public void desabilitarCampoNomeJogador()
	{
		campoNomeJogador.desabilitar();
	}
	
	public void habilitarBotaoGritarBingo()
	{
		botaoGritarBingo.habilitar();
	}
	
	public void desabilitarBotaoGritarBingo()
	{
		botaoGritarBingo.desabilitar();
	}
	
	public void habilitarBotaoPegarCartela()
	{
		botaoPegarCartela.habilitar();
	}
	
	public void desabilitarBotaoPegarCartela()
	{
		botaoPegarCartela.desabilitar();
	}
	
	public void mostrarVencedor(String jogadorVencedor)
	{
		etiquetaJogadorVencedor.fixarTexto("Último Vencedor do Bingo: " + jogadorVencedor);
	}
	
	public void mostrarMensagem(String mensagem)
	{
		etiquetaMensagens.fixarTexto("<em>"+mensagem+"</em>");
	}
	
	public String fornecerMensagemDeServidorEncontrado()
	{
		return "Servidor encontrado. Pegue sua cartela.";
	}
}
