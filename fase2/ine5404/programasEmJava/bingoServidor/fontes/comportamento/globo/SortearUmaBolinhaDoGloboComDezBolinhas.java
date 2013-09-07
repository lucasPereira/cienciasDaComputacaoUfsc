package comportamento.globo;

import infra.Cenario;
import junit.framework.Assert;
import modelo.sorteio.Globo;
import modelo.sorteio.TipoGlobo;

import org.junit.Test;

public class SortearUmaBolinhaDoGloboComDezBolinhas extends Cenario 
{
	private TipoGlobo globo;
	
	public void dadoQue() 
	{
		crioUmGloboComDezBolinhas();
	}
	
	public void quando()
	{
		sorteioUmaBolinha();
	}
	
	public void entao()
	{
		globoTemNoveBolinhas();
	}
	
	private void crioUmGloboComDezBolinhas()
	{
		globo = new Globo(10);
	}
	
	private void sorteioUmaBolinha()
	{
		globo.sortear();
	}
	
	@Test
	public void globoTemNoveBolinhas()
	{
		Assert.assertTrue(9 == globo.fornecerQuantidadeDeBolinhas());
	}
}