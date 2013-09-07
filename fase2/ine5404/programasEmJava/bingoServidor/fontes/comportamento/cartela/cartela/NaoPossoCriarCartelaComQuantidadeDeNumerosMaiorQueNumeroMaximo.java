package comportamento.cartela.cartela;

import infra.Cenario;
import modelo.cartela.Cartela;

import org.junit.Test;

public class NaoPossoCriarCartelaComQuantidadeDeNumerosMaiorQueNumeroMaximo extends Cenario
{
	private final int QUANTIDADE_DE_NUMEROS = 1000;
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
		new Cartela(QUANTIDADE_DE_NUMEROS, NUMERO_MAXIMO);
	}
}