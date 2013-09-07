package comportamento.jogador;

import junit.framework.Assert;
import infra.Cenario;
import modelo.jogador.Jogador;

import org.junit.Test;

public class CompararIdentificadorJogadorDadoQueTenhoUmIdentificadorIgual extends Cenario 
{
	private Jogador jogador;
	private String identificador;
	
	public void dadoQue()
	{
		crioUmJogadorComIdentificador();
	}
	
	public void quando()
	{
		pegoIdentificadorTextualDoJogador();
	}
	
	public void entao()
	{
		identificadorDoJogadorÉIgualAoIdentificador();
	}
	
	private void crioUmJogadorComIdentificador()
	{
		jogador = new Jogador(0);
	}
	
	private void pegoIdentificadorTextualDoJogador()
	{
		identificador = jogador.fornecerIdentificadorTextual();
	}
	
	@Test
	public void identificadorDoJogadorÉIgualAoIdentificador()
	{
		Assert.assertTrue(jogador.compararIdentificador(identificador));
	}
}