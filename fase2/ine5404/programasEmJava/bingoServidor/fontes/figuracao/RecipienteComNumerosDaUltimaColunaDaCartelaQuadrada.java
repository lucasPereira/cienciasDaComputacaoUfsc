package figuracao;

import java.util.List;

import modelo.cartela.TipoCartela;
import modelo.sorteio.Recipiente;

public class RecipienteComNumerosDaUltimaColunaDaCartelaQuadrada extends Recipiente 
{
	public RecipienteComNumerosDaUltimaColunaDaCartelaQuadrada(TipoCartela cartela) 
	{
		List<String> valoresDaCartela = cartela.fornecerListaComOsValores();
		int ordem = (int)Math.sqrt(valoresDaCartela.size()); 
		
		for(int cont = ordem - 1; cont <= ordem * ordem; cont += ordem)
		{
			int bolinha = Integer.parseInt(valoresDaCartela.get(cont));
			guardarBolinha(bolinha);
		}
	}

}
