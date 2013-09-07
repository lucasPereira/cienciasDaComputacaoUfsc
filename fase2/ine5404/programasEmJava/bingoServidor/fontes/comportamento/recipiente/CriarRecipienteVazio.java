package comportamento.recipiente;

import infra.Cenario;
import modelo.sorteio.Recipiente;
import modelo.sorteio.TipoRecipiente;

import org.junit.Assert;
import org.junit.Test;

public class CriarRecipienteVazio extends Cenario 
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
		tenhoUmRecipienteComZeroBolinhas();
	}
	
	private void crioUmRecipiente()
	{
		recipiente = new Recipiente(); 
	}
	
	@Test
	public void tenhoUmRecipienteComZeroBolinhas()
	{
		Assert.assertTrue(0 == recipiente.fornecerQuantidadeDeBolinhas());
	}
}