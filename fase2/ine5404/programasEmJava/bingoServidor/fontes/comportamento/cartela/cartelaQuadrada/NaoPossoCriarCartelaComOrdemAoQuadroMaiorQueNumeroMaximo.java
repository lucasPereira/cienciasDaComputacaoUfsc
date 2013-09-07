package comportamento.cartela.cartelaQuadrada;

import infra.Cenario;

import modelo.cartela.CartelaQuadrada;

import org.junit.Test;

public class NaoPossoCriarCartelaComOrdemAoQuadroMaiorQueNumeroMaximo extends Cenario
{
	private final int ORDEM = 0;
	private final int NUMERO_MAXIMO = 0;
	
	public void dadoQue()
	{
		
	}
	
	public void quando()
	{
		
	}
	
	public void entao()
	{
		naoConsigoCriarACartela();
	}
	
	@Test(expected = AssertionError.class)
	public void naoConsigoCriarACartela()
	{
		new CartelaQuadrada(ORDEM, NUMERO_MAXIMO);
	}
}