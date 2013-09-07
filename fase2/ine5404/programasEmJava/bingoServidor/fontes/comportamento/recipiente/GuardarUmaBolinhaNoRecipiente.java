package comportamento.recipiente;

import infra.Cenario;
import modelo.sorteio.Recipiente;
import modelo.sorteio.TipoRecipiente;

import org.junit.Assert;
import org.junit.Test;

public class GuardarUmaBolinhaNoRecipiente extends Cenario
{
	TipoRecipiente recipiente;
	
	public void dadoQue()
	{
		crioUmRecipiente();
	}

	public void quando()
	{
		guardoUmaBolinha();
	}
	
	public void entao()
	{
		tenhoUmRecipienteComUmaBolinha();
	}
	
	private void crioUmRecipiente()
	{
		recipiente = new Recipiente();
	}
	
	private void guardoUmaBolinha()
	{
		recipiente.guardarBolinha(1);
	}
	
	@Test
	public void tenhoUmRecipienteComUmaBolinha()
	{
		Assert.assertTrue(1 == recipiente.fornecerQuantidadeDeBolinhas());
	}
}