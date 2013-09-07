package comportamento.cartela.fabrica;

import infra.Cenario;
import junit.framework.Assert;
import modelo.cartela.Cartela;
import modelo.cartela.FabricaAbstrataDeCartela;
import modelo.cartela.TipoCartela;
import modelo.cartela.TipoFabricaDeCartela;

import org.junit.Test;

public class FabricarCartela extends Cenario 
{
	private TipoFabricaDeCartela fabrica;
	private final int QUANTIDADE_DE_NUMEROS = 10000;
	private final int NUMERO_MAXIMO = 10000;
	private TipoCartela cartela;
	
	public void dadoQue()
	{
		tenhoUmaFabricaDeCartela();
	}
	
	public void quando()
	{
		fabricoUmaCartela();
	}
	
	public void entao()
	{
		tenhoUmaCartela();
	}
	
	private void tenhoUmaFabricaDeCartela()
	{
		fabrica = FabricaAbstrataDeCartela.fornecerFabricaDeCartela(QUANTIDADE_DE_NUMEROS, NUMERO_MAXIMO);
	}
	
	private void fabricoUmaCartela()
	{
		cartela = fabrica.criarCartela();
	}
	
	@Test
	public void tenhoUmaCartela()
	{
		Assert.assertTrue(cartela instanceof Cartela);
	}
}