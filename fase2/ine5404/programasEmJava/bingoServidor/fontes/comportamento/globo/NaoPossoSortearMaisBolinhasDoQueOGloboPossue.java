package comportamento.globo;

import infra.Cenario;
import modelo.sorteio.Globo;
import modelo.sorteio.TipoGlobo;

import org.junit.Test;
 
public class NaoPossoSortearMaisBolinhasDoQueOGloboPossue extends Cenario  
{
	private TipoGlobo globo;
	private final int QUANTIDADE_DE_BOLINHAS_DO_GLOBO = 10;
	
	public void dadoQue()
	{
		tenhoUmGlobo();
	}
	
	public void quando()
	{
		sorteioTodasBolinhasDoGlobo();
	}
	
	public void entao()
	{
		nãoConsigoSortearMaisBolinhas();
	}
	
	
	private void tenhoUmGlobo()
	{
		globo = new Globo(QUANTIDADE_DE_BOLINHAS_DO_GLOBO);
	}
	
	private void sorteioTodasBolinhasDoGlobo()
	{
		for(int cont = 0; cont < QUANTIDADE_DE_BOLINHAS_DO_GLOBO; cont++)
		{
			globo.sortear();
		}
	}
	
	@Test(expected = AssertionError.class)
	public void nãoConsigoSortearMaisBolinhas()
	{
		globo.sortear();
	}
}