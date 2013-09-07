package comportamento.cartela.cartela;

import figuracao.RecipienteComTodosNumerosDaCartela;
import infra.Cenario;
import junit.framework.Assert;
import modelo.cartela.Cartela;
import modelo.cartela.TipoCartela;
import modelo.sorteio.TipoRecipiente;

import org.junit.Test;

public class VerificarSeFezBingoDadoQueFez extends Cenario 
{ 
	private TipoCartela cartela;
	private final int QUANTIDADE_DE_NUMEROS = 1000;
	private final int NUMERO_MAXIMO = 1000;
	private TipoRecipiente recipiente;
	
	public void dadoQue()
	{
		tenhoUmaCartela();
		tenhoUmRecipienteComOsNumerosDaCartela();
	}
	
	public void quando()
	{ 
		
	}
	
	public void entao()
	{
		fizBingo();
	}
	
	private void tenhoUmaCartela()
	{
		cartela = new Cartela(QUANTIDADE_DE_NUMEROS, NUMERO_MAXIMO);
	}
	
	private void tenhoUmRecipienteComOsNumerosDaCartela()
	{
		recipiente = new RecipienteComTodosNumerosDaCartela(cartela);
	}
	
	@Test
	public void fizBingo()
	{
		Assert.assertTrue(cartela.verificarSeFezBingo(recipiente));
	}
}