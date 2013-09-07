package figuracao;

import java.util.List;

import modelo.cartela.TipoCartela;
import modelo.sorteio.Recipiente;

public class RecipienteComApenasAlgunsNumerosDaCartela extends Recipiente 
{
	public RecipienteComApenasAlgunsNumerosDaCartela(TipoCartela cartela) 
	{
		List<String> valoresDaCartela = cartela.fornecerListaComOsValores();
		int cont = 1;
		
		for(String valor : valoresDaCartela)
		{
			if(cont % 2 == 0)
			{
				int bolinha = Integer.parseInt(valor);
				guardarBolinha(bolinha);
			}
			
			cont++;
		}
	}

}
