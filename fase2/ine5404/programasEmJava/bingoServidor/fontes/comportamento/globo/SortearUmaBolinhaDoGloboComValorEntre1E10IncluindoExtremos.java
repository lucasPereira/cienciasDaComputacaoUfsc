package comportamento.globo;

import infra.Cenario;
import modelo.sorteio.Globo;

import org.junit.Assert;
import org.junit.Test;

public class SortearUmaBolinhaDoGloboComValorEntre1E10IncluindoExtremos extends Cenario
{
	private Globo globo;
	private int valorBolinha;
	
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
		tenhoUmaBolinhaComValorEntre1E10IncluindoExtremos();
	}
	
	private void crioUmGloboComDezBolinhas()
	{
		globo = new Globo(10);
	}
	
	private void sorteioUmaBolinha()
	{
		valorBolinha = globo.sortear();
	}
	
	@Test
	public void tenhoUmaBolinhaComValorEntre1E10IncluindoExtremos()
	{
		Assert.assertTrue(valorBolinha >= 1 && valorBolinha <= 10);
	}
}