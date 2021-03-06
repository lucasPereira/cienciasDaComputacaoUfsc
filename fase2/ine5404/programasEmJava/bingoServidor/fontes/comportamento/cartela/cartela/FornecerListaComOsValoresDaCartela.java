package comportamento.cartela.cartela;

import infra.Cenario;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;
import modelo.cartela.Cartela;
import modelo.cartela.TipoCartela;

import org.junit.Test;

public class FornecerListaComOsValoresDaCartela extends Cenario 
{
	private TipoCartela cartela;
	private List<String> valoresDaCartela;
	private final int QUANTIDADE_DE_NUMEROS = 10000;
	private final int NUMERO_MAXIMO = 10000;
	
	public void dadoQue()
	{
		tenhoUmaCartela();
	}
	
	public void quando()
	{
		pegarListComValoresDaCartela();
	}
	
	public void entao()
	{
		tenhoUmaListaComOrdemVezesOrdemValores();
		tenhoUmaListaSemRepeticao();
	}
	
	private void tenhoUmaCartela()
	{
		cartela = new Cartela(QUANTIDADE_DE_NUMEROS, NUMERO_MAXIMO);
	}
	
	private void pegarListComValoresDaCartela()
	{
		valoresDaCartela = cartela.fornecerListaComOsValores();
	}
	
	@Test
	public void tenhoUmaListaComOrdemVezesOrdemValores()
	{
		Assert.assertTrue(QUANTIDADE_DE_NUMEROS == valoresDaCartela.size());
	}
	
	@Test
	public void tenhoUmaListaSemRepeticao()
	{
		Set<String> conjuntoComValoresDaCartela = new HashSet<String>();
		conjuntoComValoresDaCartela.addAll(valoresDaCartela);
		
		Assert.assertTrue(conjuntoComValoresDaCartela.size() == valoresDaCartela.size());
	}
}