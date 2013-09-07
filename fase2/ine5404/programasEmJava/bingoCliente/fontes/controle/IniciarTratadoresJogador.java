package controle;

import visao.VisaoCartela;
import modelo.FachadaJogador;
import aplique.ApliqueJogador;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;

public class IniciarTratadoresJogador 
{
	private PaginaDix paginaJogador;
	private FachadaJogador fachadaParaJogador;
	private ComponenteDix botaoPegarCartela;
	private ComponenteDix botaoGritarBingo;
	private ComponenteDix gradeCartela;
	private VisaoCartela interfaceCartela;
	
	public IniciarTratadoresJogador(FachadaJogador fachada, VisaoCartela interfaceParaCartela)
	{
		paginaJogador = new ApliqueJogador().obterPaginaDix();
		fachadaParaJogador = fachada;
		interfaceCartela = interfaceParaCartela;
		
		botaoPegarCartela = paginaJogador.criarProcuradorDeComponente("botaoPegarCartela");
		botaoGritarBingo = paginaJogador.criarProcuradorDeComponente("botaoGritarBingo");
		gradeCartela = paginaJogador.criarProcuradorDeComponente("gradeCartela");
		
		botaoPegarCartela.adicionarTratadorDeEventos(new TratadorBotaoPegarCartela(fachadaParaJogador));
		botaoGritarBingo.adicionarTratadorDeEventos(new TratadorBotaoGritarBingo(fachadaParaJogador));
		gradeCartela.adicionarTratadorDeEventos(new TratadorCelulasCartela(interfaceCartela));
	}
}
