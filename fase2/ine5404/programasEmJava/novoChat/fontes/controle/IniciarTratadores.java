package controle;

import aplique.UmAplique;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;

public class IniciarTratadores 
{
	private PaginaDix pagina;
	private ComponenteDix botaoDeEnviarMensagem;
	public IniciarTratadores()
	{
		pagina = new UmAplique().obterPaginaDix();
		botaoDeEnviarMensagem = pagina.criarProcuradorDeComponente("botaoEnviar");
		botaoDeEnviarMensagem.adicionarTratadorDeEventos(new TratadorDeBotaoDeEnvioDeMensagem());
	}
}
