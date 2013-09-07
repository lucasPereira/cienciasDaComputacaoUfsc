package comportamento.globo;

import infra.Cenario;
import junit.framework.Assert;
import modelo.sorteio.Globo;
import modelo.sorteio.TipoGlobo;

import org.junit.Test;

public class SortearDuasBolinhasDeUmGloboComDezBolinhas extends Cenario 
{
	private TipoGlobo globo;
	
	public void dadoQue() 
	{
		crioUmGloboComDezBolinhas();
	}
	
	public void quando()
	{
		sorteioDuasBolinhas();
	}
	
	public void entao()
	{
		globoTemOitoBolinhas();
	}
	
	private void crioUmGloboComDezBolinhas()
	{
		globo = new Globo(10);
	}
	
	private void sorteioDuasBolinhas()
	{
		globo.sortear();
		globo.sortear();
	}
	
	@Test
	public void globoTemOitoBolinhas()
	{
		Assert.assertTrue(8 == globo.fornecerQuantidadeDeBolinhas());
	}
}