package controle;

import static edugraf.jadix.eventos.nomes.NomeDeEventosDeGrade.CÉLULA_CLICADA;
import visao.VisaoCartela;
import edugraf.jadix.eventos.EventoDeGrade;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorCelulasCartela extends TratadorDixAbstrato
{
	private VisaoCartela interfaceCartela;
	
	public TratadorCelulasCartela(VisaoCartela interfaceParaCartela)
	{
		interfaceCartela = interfaceParaCartela;
	}
	
	public void seDito(EventoDeGrade evento)
	{
		String nomeDaCelula = evento.obterNomeDoComponente()+"_"+evento.obterLinha()+"_"+evento.obterColuna();
		
		if(evento.obterNomeDoEvento().equals(CÉLULA_CLICADA))
		{
			interfaceCartela.marcarEDesmarcarCelula(nomeDaCelula);			
			System.out.println("[Tratador] Célula Clicada");
		}
	}
	
}