package figuracao;

import java.util.List;

import modelo.cartela.TipoCartela;
import modelo.sorteio.Recipiente;

public class RecipienteComNumerosDaPrimeiraLinhaDaCartelaQuadrada extends Recipiente 
{
	public RecipienteComNumerosDaPrimeiraLinhaDaCartelaQuadrada(TipoCartela cartela) 
	{
		List<String> valoresDaCartela = cartela.fornecerListaComOsValores();
		
		for(int cont = 0; cont < (int)Math.sqrt(valoresDaCartela.size()); cont++)
		{
			int bolinha = Integer.parseInt(valoresDaCartela.get(cont));
			guardarBolinha(bolinha);
		}
	}

}
