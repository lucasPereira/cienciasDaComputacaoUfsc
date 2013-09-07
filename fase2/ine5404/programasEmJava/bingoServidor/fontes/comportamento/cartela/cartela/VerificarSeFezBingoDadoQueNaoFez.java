package comportamento.cartela.cartela;

import figuracao.RecipienteComApenasAlgunsNumerosDaCartela;
import infra.Cenario;
import junit.framework.Assert;
import modelo.cartela.Cartela;
import modelo.cartela.TipoCartela;
import modelo.sorteio.TipoRecipiente;

import org.junit.Test;

public class VerificarSeFezBingoDadoQueNaoFez extends Cenario 
{ 
	private TipoCartela cartela;
	private final int QUANTIDADE_DE_NUMEROS = 1000;
	private final int NUMERO_MAXIMO = 1000;
	private TipoRecipiente recipiente;
	
	public void dadoQue()
	{
		tenhoUmaCartela();
		tenhoUmRecipienteComAlgunsNumerosDaCartela();
	}
	
	public void quando()
	{ 
		
	}
	
	public void entao()
	{
		naoFizBingo();
	}
	
	private void tenhoUmaCartela()
	{
		cartela = new Cartela(QUANTIDADE_DE_NUMEROS, NUMERO_MAXIMO);
	}
	
	private void tenhoUmRecipienteComAlgunsNumerosDaCartela()
	{
		recipiente = new RecipienteComApenasAlgunsNumerosDaCartela(cartela);
	}
	
	@Test
	public void naoFizBingo()
	{
		Assert.assertFalse(cartela.verificarSeFezBingo(recipiente));
	}
}