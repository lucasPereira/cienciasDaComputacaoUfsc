package controle;

import apliques.ApliqueServidor;  
import modelo.servidor.FachadaServidor;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;

public class IniciarTratadoresServidor 
{
	private PaginaDix paginaServidor;
	private FachadaServidor fachadaParaServidor;
	private ComponenteDix botaoIniciarServidor;
	
	public IniciarTratadoresServidor(FachadaServidor fachada)
	{
		paginaServidor = new ApliqueServidor().obterPaginaDix();
		fachadaParaServidor = fachada;
		
		botaoIniciarServidor = paginaServidor.criarProcuradorDeComponente("botaoIniciarServidor");
		botaoIniciarServidor.adicionarTratadorDeEventos(new TratadorBotaoIniciarServidor(fachadaParaServidor));
	}
}
