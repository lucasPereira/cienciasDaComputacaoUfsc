package comportamento.recipiente;

import infra.Cenario;
import modelo.sorteio.Recipiente;
import modelo.sorteio.TipoRecipiente;

import org.junit.Test;

public class NaoPossoGuardarBolinhaNoRecipienteComValorMenorIgualAZero extends Cenario
{	
	TipoRecipiente recipiente;
	
	public void dadoQue()
	{
		crioUmRecipiente();
	}
	
	public void quando()
	{
		
	}
	
	public void entao()
	{
		naoConsigoGuardarUmaBolinhaMenorIgualAZero();
	}
	
	private void crioUmRecipiente()
	{
		recipiente = new Recipiente();
	}
	
	@Test(expected = AssertionError.class)
	public void naoConsigoGuardarUmaBolinhaMenorIgualAZero()
	{
		recipiente.guardarBolinha(0);
	}
}