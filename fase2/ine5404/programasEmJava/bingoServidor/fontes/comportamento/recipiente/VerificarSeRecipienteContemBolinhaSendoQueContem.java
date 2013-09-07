package comportamento.recipiente;

import infra.Cenario;
import modelo.sorteio.Recipiente;
import modelo.sorteio.TipoRecipiente;

import org.junit.Assert;
import org.junit.Test;

public class VerificarSeRecipienteContemBolinhaSendoQueContem extends Cenario 
{
	private TipoRecipiente recipiente;
	
	public void dadoQue()
	{
		tenhoUmRecipienteVazio();
	}
	
	public void quando()
	{
		guardoOValorDezNoRecipiente();
	}
	
	public void entao()
	{
		tenhoOValorDezNoRecipiente();
	}
	
	private void tenhoUmRecipienteVazio()
	{
		recipiente = new Recipiente();
	}
	
	private void guardoOValorDezNoRecipiente()
	{
		recipiente.guardarBolinha(10);
	}
	
	@Test
	public void tenhoOValorDezNoRecipiente()
	{
		Assert.assertTrue(recipiente.verificarSeValorEstaNoRecipiente(10));
	}
}