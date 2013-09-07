package comportamento.cartela.cartelaQuadrada;

import figuracao.RecipienteVazio;
import infra.Cenario;
import junit.framework.Assert;
import modelo.cartela.CartelaQuadrada;
import modelo.cartela.TipoCartela;
import modelo.sorteio.TipoRecipiente;

import org.junit.Test;

public class VerificarSeFezBingoEmLinhaOuColunaDadoQueNaoFez extends Cenario 
{
	private TipoCartela cartela;
	private final int ORDEM = 100;
	private final int NUMERO_MAXIMO = 10000;
	private TipoRecipiente recipiente;
	
	public void dadoQue()
	{
		tenhoUmaCartela();
		tenhoUmRecipienteVazio();
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
		cartela = new CartelaQuadrada(ORDEM, NUMERO_MAXIMO);
	}
	
	private void tenhoUmRecipienteVazio()
	{
		recipiente = new RecipienteVazio();
	}
	
	@Test
	public void naoFizBingo()
	{
		Assert.assertFalse(cartela.verificarSeFezBingo(recipiente));
	}
}