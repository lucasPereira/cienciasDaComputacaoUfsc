package comportamento.cartela.cartelaQuadrada;

import figuracao.RecipienteComTodosNumerosDaCartela;
import infra.Cenario;
import junit.framework.Assert;
import modelo.cartela.CartelaQuadrada;
import modelo.cartela.TipoCartela;
import modelo.sorteio.TipoRecipiente;

import org.junit.Test;

public class VerificarSeFezBingoCompletoDadoQueFez extends Cenario 
{
	private TipoCartela cartela;
	private final int ORDEM = 100;
	private final int NUMERO_MAXIMO = 10000;
	private TipoRecipiente recipiente;
	
	public void dadoQue()
	{
		tenhoUmaCartela();
		tenhoUmRecipienteComTodosNumerosDaCartela();
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
		cartela = new CartelaQuadrada(ORDEM, NUMERO_MAXIMO);
	}
	
	private void tenhoUmRecipienteComTodosNumerosDaCartela()
	{
		recipiente = new RecipienteComTodosNumerosDaCartela(cartela);
	}
	
	@Test
	public void fizBingo()
	{
		Assert.assertTrue(cartela.verificarSeFezBingo(recipiente));
	}
}