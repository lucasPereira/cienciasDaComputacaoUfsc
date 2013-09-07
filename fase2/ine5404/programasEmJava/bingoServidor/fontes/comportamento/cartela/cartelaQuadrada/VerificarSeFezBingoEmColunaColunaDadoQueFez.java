package comportamento.cartela.cartelaQuadrada;

import figuracao.RecipienteComNumerosDaPrimeiraColunaDaCartelaQuadrada;
import figuracao.RecipienteComNumerosDaUltimaColunaDaCartelaQuadrada;
import infra.Cenario;
import junit.framework.Assert;
import modelo.cartela.CartelaQuadrada;
import modelo.cartela.TipoCartela;
import modelo.sorteio.TipoRecipiente;

import org.junit.Test;

public class VerificarSeFezBingoEmColunaColunaDadoQueFez extends Cenario 
{
	private TipoCartela cartela;
	private final int ORDEM = 100;
	private final int NUMERO_MAXIMO = 10000;
	private TipoRecipiente recipienteComPrimeiraColunaDaCartela;
	private TipoRecipiente recipienteComUltimaColunaDaCartela;
	
	public void dadoQue()
	{
		tenhoUmaCartela();
		tenhoUmRecipienteComOsNumerosDaPrimeiraColunaDaCartela();
		tenhoUmRecipienteComOsNumerosDaUltimaColunaDaCartela();
	}
	
	public void quando()
	{
		
	}
	
	public void entao()
	{
		fizBingoNaPrimeiraColuna();
		fizBingoNaUltimaColuna();
	}
	
	private void tenhoUmaCartela()
	{
		cartela = new CartelaQuadrada(ORDEM, NUMERO_MAXIMO);
	}
	
	private void tenhoUmRecipienteComOsNumerosDaPrimeiraColunaDaCartela()
	{
		recipienteComPrimeiraColunaDaCartela = new RecipienteComNumerosDaPrimeiraColunaDaCartelaQuadrada(cartela);
	}
	
	private void tenhoUmRecipienteComOsNumerosDaUltimaColunaDaCartela()
	{
		recipienteComUltimaColunaDaCartela = new RecipienteComNumerosDaUltimaColunaDaCartelaQuadrada(cartela);
	}
	
	@Test
	public void fizBingoNaPrimeiraColuna()
	{
		Assert.assertTrue(cartela.verificarSeFezBingo(recipienteComPrimeiraColunaDaCartela));
	}
	
	@Test
	public void fizBingoNaUltimaColuna()
	{
		Assert.assertTrue(cartela.verificarSeFezBingo(recipienteComUltimaColunaDaCartela));
	}
}