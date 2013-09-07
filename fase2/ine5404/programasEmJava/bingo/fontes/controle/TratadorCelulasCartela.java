package controle;

import modelo.jogador.FachadaJogador; 
import edugraf.jadix.eventos.EventoDeGrade;
import edugraf.jadix.fachada.TratadorDixAbstrato;
import static edugraf.jadix.eventos.nomes.NomeDeEventosDeGrade.CÉLULA_CLICADA;
import static edugraf.jadix.eventos.nomes.NomeDeEventosDeGrade.CÉLULA_DUPLAMENTE_CLICADA;

public class TratadorCelulasCartela extends TratadorDixAbstrato
{
	private FachadaJogador fachadaParaJogador;
	
	public TratadorCelulasCartela(FachadaJogador fachada)
	{
		fachadaParaJogador = fachada;
	}
	
	public void seDito(EventoDeGrade evento)
	{
		String nomeDaCelula = evento.obterNomeDoComponente()+"_"+evento.obterLinha()+"_"+evento.obterColuna();
		
		if(evento.obterNomeDoEvento().equals(CÉLULA_CLICADA))
		{
			fachadaParaJogador.marcarCelula(nomeDaCelula);
		}
		
		if(evento.obterNomeDoEvento().equals(CÉLULA_DUPLAMENTE_CLICADA))
		{
			fachadaParaJogador.desmarcarCelula(nomeDaCelula);
		}
	}
	
}