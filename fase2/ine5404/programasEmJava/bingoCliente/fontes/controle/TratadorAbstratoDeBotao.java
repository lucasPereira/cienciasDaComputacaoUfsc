package controle;

import edugraf.jadix.eventos.EventoSimples;  
import edugraf.jadix.fachada.TratadorDixAbstrato;
import static edugraf.jadix.eventos.nomes.NomeDeEventosSimples.CLICADO;  

public abstract class TratadorAbstratoDeBotao extends TratadorDixAbstrato
{
	public void seDito(EventoSimples evento)
	{
		if(evento.obterNomeDoEvento().equals(CLICADO))
		{
			seClicado();
		}
	}
	
	public abstract void seClicado();
}
