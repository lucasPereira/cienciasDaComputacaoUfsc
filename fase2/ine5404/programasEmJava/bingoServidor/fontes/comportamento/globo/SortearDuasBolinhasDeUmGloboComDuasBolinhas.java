package comportamento.globo;

import infra.Cenario;
import modelo.sorteio.Globo;
import modelo.sorteio.TipoGlobo;

import org.junit.Assert;
import org.junit.Test;

public class SortearDuasBolinhasDeUmGloboComDuasBolinhas extends Cenario  
{
	private TipoGlobo globoComum;
	
	public void dadoQue()
	{
		tenhoUmGloboComDuasBolinhas();
	}
	
	public void quando()
	{
		sorteioDuasBolinhas();
	}
	
	public void entao()
	{
		nãoTenhoMaisBolinhasNoGlobo();
	}
	
	private void tenhoUmGloboComDuasBolinhas()
	{
		globoComum = new Globo(2);
	}
	
	private void sorteioDuasBolinhas()
	{
		globoComum.sortear();
		globoComum.sortear();
	}
	
	@Test
	public void nãoTenhoMaisBolinhasNoGlobo()
	{
		Assert.assertTrue(globoComum.fornecerQuantidadeDeBolinhas() == 0);
	}
}