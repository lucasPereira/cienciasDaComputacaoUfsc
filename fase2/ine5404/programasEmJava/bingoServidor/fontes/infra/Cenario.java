package infra;

import org.junit.Before;

public abstract class Cenario implements TipoCenario
{
	@Before
	public void preparacao()
	{
		dadoQue();
		quando();
	}
}
