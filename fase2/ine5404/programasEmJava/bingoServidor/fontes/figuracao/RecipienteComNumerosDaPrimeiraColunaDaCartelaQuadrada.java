package figuracao;

import java.util.List;

import modelo.cartela.TipoCartela;
import modelo.sorteio.Recipiente;

public class RecipienteComNumerosDaPrimeiraColunaDaCartelaQuadrada extends Recipiente 
{
	public RecipienteComNumerosDaPrimeiraColunaDaCartelaQuadrada(TipoCartela cartela) 
	{
		List<String> valoresDaCartela = cartela.fornecerListaComOsValores();
		int ordem = (int)Math.sqrt(valoresDaCartela.size()); 
		
		for(int cont = 0; cont + ordem <= ordem * ordem; cont += ordem)
		{
			int bolinha = Integer.parseInt(valoresDaCartela.get(cont));
			guardarBolinha(bolinha);
		}
	}

}
