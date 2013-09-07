package comportamento.recipiente;

import infra.Cenario;
import junit.framework.Assert;
import modelo.sorteio.Recipiente;
import modelo.sorteio.TipoRecipiente;

import org.junit.Test;

public class VerificarSeRecipienteContemBolinhaSendoQueNaoContem extends Cenario 
{
	private TipoRecipiente recipiente;
	
	public void dadoQue()
	{
		tenhoUmRecipienteVazio();
	}
	
	public void quando()
	{

	}
	
	public void entao()
	{
		naoTenhoOValorDezNoRecipiente();
	}
	
	private void tenhoUmRecipienteVazio()
	{
		recipiente = new Recipiente();
	}
	
	@Test
	public void naoTenhoOValorDezNoRecipiente()
	{
		Assert.assertFalse(recipiente.verificarSeValorEstaNoRecipiente(10));
	}
}