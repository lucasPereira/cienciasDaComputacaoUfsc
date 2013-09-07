package modelo.cartela;

import java.util.ArrayList;
import java.util.List;

import modelo.sorteio.Globo;
import modelo.sorteio.TipoGlobo;

public abstract class CartelaAbstrata implements TipoCartela 
{
	private static final int UM = 1;

	protected final List<Integer> gerarCartela(int quantidadeDeNumeros, int numeroMaximo)
	{			
		List<Integer> numeros = new ArrayList<Integer>();
		TipoGlobo globo = new Globo(numeroMaximo);
		
		for(int cont = UM; cont <= quantidadeDeNumeros; cont++)
		{
			numeros.add(globo.sortear());
		}
		
		return numeros;
	}
	
	protected final List<String> fornecerListaComOsValores(List<Integer> numeros)
	{
		List<String> valores = new ArrayList<String>();
		for(Integer numero : numeros)
		{
			valores.add(numero.toString());
		}
		
		return valores;	
	}
}