package visao;

import aplique.UmAplique;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;

public class InterfaceChat 
{
	private PaginaDix pagina;
	private ComponenteDix campoDeTextoMensagens;
	private ComponenteDix campoDeTextoRecebido;
	
	public InterfaceChat()
	{
		pagina = new UmAplique().obterPaginaDix();
		campoDeTextoMensagens = pagina.criarProcuradorDeComponente("campoDeTextoMensagens");
		campoDeTextoRecebido = pagina.criarProcuradorDeComponente("áreaDeTextoChat");
	} 
	
	public String pegarTexto()
	{
		return campoDeTextoMensagens.obterTexto();
	}
	
	public void mostreTextoRecebido(String texto)
	{
		String textoAntigo = texto + "\n" + campoDeTextoRecebido.obterTexto();
		campoDeTextoRecebido.fixarTexto(textoAntigo);
	}
	
	public void limparAreaDeTexto()
	{
		campoDeTextoMensagens.fixarTexto("");
	}
}
