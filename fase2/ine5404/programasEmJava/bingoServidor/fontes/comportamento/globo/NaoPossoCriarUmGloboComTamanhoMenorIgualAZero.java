package comportamento.globo;

import infra.Cenario;
import modelo.sorteio.Globo;

import org.junit.Test;

public class NaoPossoCriarUmGloboComTamanhoMenorIgualAZero extends Cenario 
{	
	public void dadoQue()
	{
		
	}
	
	public void quando()
	{
		
	}
	
	public void entao()
	{
		naoConsigoCriarOGloboComTamanhoMenorIgualAZero();
	}
	
	@Test(expected = AssertionError.class)
	public void naoConsigoCriarOGloboComTamanhoMenorIgualAZero()
	{
		new Globo(0);
	}

}