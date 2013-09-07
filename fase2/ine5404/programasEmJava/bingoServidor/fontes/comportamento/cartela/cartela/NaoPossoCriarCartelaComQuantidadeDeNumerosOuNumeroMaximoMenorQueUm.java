package comportamento.cartela.cartela;

import infra.Cenario;

import modelo.cartela.CartelaQuadrada;

import org.junit.Test;

public class NaoPossoCriarCartelaComQuantidadeDeNumerosOuNumeroMaximoMenorQueUm extends Cenario
{
	private final int ORDEM = 10;
	private final int NUMERO_MAXIMO = 50;
	
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