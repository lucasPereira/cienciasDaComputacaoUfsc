package comportamento.recipiente;

import infra.Cenario;
import junit.framework.Assert;
import modelo.sorteio.Recipiente;
import modelo.sorteio.TipoRecipiente;

import org.junit.Test;

public class GuardarDuasBolinhasIguaisNoRecipiente extends Cenario 
{
	TipoRecipiente recipiente;
	
	public void dadoQue()
	{
		crioUmRecipiente();
	}

	public void quando()
	{
		guardoDuasBolinhasIguais();
	}
	
	public void entao()
	{
		tenhoUmRecipienteComUmaBolinhas();
	}
	
	private void crioUmRecipiente()
	{
		recipiente = new Recipiente();
	}
	
	private void guardoDuasBolinhasIguais()
	{
		recipiente.guardarBolinha(1);
		recipiente.guardarBolinha(1);
	}
	
	@Test
	public void tenhoUmRecipienteComUmaBolinhas()
	{
		Assert.assertTrue(1 == recipiente.fornecerQuantidadeDeBolinhas());
	}
}