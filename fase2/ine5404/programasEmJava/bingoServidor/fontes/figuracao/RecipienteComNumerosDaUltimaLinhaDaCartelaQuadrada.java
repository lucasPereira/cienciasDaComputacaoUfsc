package figuracao;

import java.util.List;

import modelo.cartela.TipoCartela;
import modelo.sorteio.Recipiente;

public class RecipienteComNumerosDaUltimaLinhaDaCartelaQuadrada extends Recipiente 
{
	public RecipienteComNumerosDaUltimaLinhaDaCartelaQuadrada(TipoCartela cartela) 
	{
		List<String> valoresDaCartela = cartela.fornecerListaComOsValores();
		int ordem = (int)Math.sqrt(valoresDaCartela.size());
		
		for(int cont = ordem * ordem - ordem; cont < ordem * ordem; cont++)
		{
			int bolinha = Integer.parseInt(valoresDaCartela.get(cont));
			guardarBolinha(bolinha);
		}
	}

}
