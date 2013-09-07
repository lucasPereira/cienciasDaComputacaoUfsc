package comportamento.globo;

import infra.Cenario;
import modelo.sorteio.Globo;
import modelo.sorteio.TipoGlobo;

import org.junit.Assert;
import org.junit.Test;

public class SortearUmaBolinhaDoGloboComValorEntre1E1000IncluindoExtremos extends Cenario
{
	private TipoGlobo globoComum;
	private int valorBolinha;
	
	public void dadoQue()
	{
		crioUmGloboComMilBolinhas();
	}
	
	public void quando()
	{
		sorteioUmaBolinha();
	}
	
	public void entao()
	{
		tenhoUmaBolinhaComValorEntre1E1000IncluindoExtremos();
	}
	
	private void crioUmGloboComMilBolinhas()
	{
		globoComum = new Globo(1000);
	}
	
	private void sorteioUmaBolinha()
	{
		valorBolinha = globoComum.sortear();
	}
	
	@Test
	public void tenhoUmaBolinhaComValorEntre1E1000IncluindoExtremos()
	{
		Assert.assertTrue(valorBolinha >= 1 && valorBolinha <= 1000);
	}	
}