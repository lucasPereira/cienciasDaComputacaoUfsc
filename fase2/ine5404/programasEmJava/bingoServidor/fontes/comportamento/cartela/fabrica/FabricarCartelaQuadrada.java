package comportamento.cartela.fabrica;

import infra.Cenario;
import junit.framework.Assert;
import modelo.cartela.CartelaQuadrada;
import modelo.cartela.FabricaAbstrataDeCartela;
import modelo.cartela.TipoCartela;
import modelo.cartela.TipoFabricaDeCartela;

import org.junit.Test;

public class FabricarCartelaQuadrada extends Cenario 
{
	private TipoFabricaDeCartela fabrica;
	private final int ORDEM = 100;
	private final int NUMERO_MAXIMO = 10000;
	private TipoCartela cartela;
	
	public void dadoQue()
	{
		tenhoUmaFabricaDeCartelaQuadrada();
	}
	
	public void quando()
	{
		fabricoUmaCartela();
	}
	
	public void entao()
	{
		tenhoUmaCartelaQuadrada();
	}
	
	private void tenhoUmaFabricaDeCartelaQuadrada()
	{
		fabrica = FabricaAbstrataDeCartela.fornecerFabricaDeCartelaQuadrada(ORDEM, NUMERO_MAXIMO);
	}
	
	private void fabricoUmaCartela()
	{
		cartela = fabrica.criarCartela();
	}
	
	@Test
	public void tenhoUmaCartelaQuadrada()
	{
		Assert.assertTrue(cartela instanceof CartelaQuadrada);
	}
}
