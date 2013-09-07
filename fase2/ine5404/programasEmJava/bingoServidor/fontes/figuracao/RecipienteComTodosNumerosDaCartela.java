package figuracao;

import java.util.List;

import modelo.cartela.TipoCartela;
import modelo.sorteio.Recipiente;

public class RecipienteComTodosNumerosDaCartela extends Recipiente 
{
	public RecipienteComTodosNumerosDaCartela(TipoCartela cartela) 
	{
		List<String> valoresDaCartela = cartela.fornecerListaComOsValores();

		for(String valor : valoresDaCartela)
		{
			int bolinha = Integer.parseInt(valor);
			guardarBolinha(bolinha);
		}
	}
}
