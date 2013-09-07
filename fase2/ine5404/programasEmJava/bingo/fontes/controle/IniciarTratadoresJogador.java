package controle;

import apliques.ApliqueJogador;   
import modelo.jogador.FachadaJogador;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;

public class IniciarTratadoresJogador 
{
	private PaginaDix paginaJogador;
	private FachadaJogador fachadaParaJogador;
	private ComponenteDix botaoPegarCartela;
	private ComponenteDix botaoGritarBingo;
	private ComponenteDix gradeCartela;
	
	public IniciarTratadoresJogador(FachadaJogador fachada)
	{
		paginaJogador = new ApliqueJogador().obterPaginaDix();
		fachadaParaJogador = fachada;
		
		botaoPegarCartela = paginaJogador.criarProcuradorDeComponente("botaoPegarCartela");
		botaoGritarBingo = paginaJogador.criarProcuradorDeComponente("botaoGritarBingo");
		gradeCartela = paginaJogador.criarProcuradorDeComponente("gradeCartela");
		
		botaoPegarCartela.adicionarTratadorDeEventos(new TratadorBotaoPegarCartela(fachadaParaJogador));
		botaoGritarBingo.adicionarTratadorDeEventos(new TratadorBotaoGritarBingo(fachadaParaJogador));
		gradeCartela.adicionarTratadorDeEventos(new TratadorCelulasCartela(fachadaParaJogador));
	}
}
