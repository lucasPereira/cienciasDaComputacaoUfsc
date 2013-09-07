package comportamento.cartela.cartelaQuadrada;

import figuracao.RecipienteComNumerosDaPrimeiraLinhaDaCartelaQuadrada;
import figuracao.RecipienteComNumerosDaUltimaLinhaDaCartelaQuadrada;
import infra.Cenario;
import junit.framework.Assert;
import modelo.cartela.CartelaQuadrada;
import modelo.cartela.TipoCartela;
import modelo.sorteio.TipoRecipiente;

import org.junit.Test;

public class VerificarSeFezBingoEmLinhaDadoQueFez extends Cenario 
{
	private TipoCartela cartela;
	private final int ORDEM = 100;
	private final int NUMERO_MAXIMO = 10000;
	private TipoRecipiente recipienteComPrimeiraLinhaDaCartela;
	private TipoRecipiente recipienteComUltimaLinhaDaCartela;
	
	public void dadoQue()
	{
		tenhoUmaCartela();
		tenhoUmRecipienteComOsNumerosDaPrimeiraLinhaDaCartela();
		tenhoUmRecipienteComOsNumerosDaUltimaLinhaDaCartela();
	}
	
	public void quando()
	{
		
	}
	
	public void entao()
	{
		fizBingoNaPrimeiraLinha();
		fizBingoNaUltimaLinha();
	}
	
	private void tenhoUmaCartela()
	{
		cartela = new CartelaQuadrada(ORDEM, NUMERO_MAXIMO);
	}
	
	private void tenhoUmRecipienteComOsNumerosDaPrimeiraLinhaDaCartela()
	{
		recipienteComPrimeiraLinhaDaCartela = new RecipienteComNumerosDaPrimeiraLinhaDaCartelaQuadrada(cartela);
	}
	
	private void tenhoUmRecipienteComOsNumerosDaUltimaLinhaDaCartela()
	{
		recipienteComUltimaLinhaDaCartela = new RecipienteComNumerosDaUltimaLinhaDaCartelaQuadrada(cartela);
	}
	
	@Test
	public void fizBingoNaPrimeiraLinha()
	{
		Assert.assertTrue(cartela.verificarSeFezBingo(recipienteComPrimeiraLinhaDaCartela));
	}
	
	@Test
	public void fizBingoNaUltimaLinha()
	{
		Assert.assertTrue(cartela.verificarSeFezBingo(recipienteComUltimaLinhaDaCartela));
	}
}