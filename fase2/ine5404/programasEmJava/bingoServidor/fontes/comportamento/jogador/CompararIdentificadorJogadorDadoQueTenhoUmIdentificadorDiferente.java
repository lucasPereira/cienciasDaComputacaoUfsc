package comportamento.jogador;

import junit.framework.Assert;
import infra.Cenario;
import modelo.jogador.Jogador;

import org.junit.Test;

public class CompararIdentificadorJogadorDadoQueTenhoUmIdentificadorDiferente extends Cenario 
{
	private Jogador jogador;
	private String identificador;
	
	public void dadoQue()
	{
		crioUmJogadorComIdentificador();
	}
	
	public void quando()
	{
		pegoIdentificadorTextualDoJogadorEAltero();
	}
	
	public void entao()
	{
		identificadorDoJogadorÉDiferenteDoIdentificador();
	}
	
	private void crioUmJogadorComIdentificador()
	{
		jogador = new Jogador(0);
	}
	
	private void pegoIdentificadorTextualDoJogadorEAltero()
	{
		identificador = jogador.fornecerIdentificadorTextual() + " ";
	}
	
	@Test
	public void identificadorDoJogadorÉDiferenteDoIdentificador()
	{
		Assert.assertFalse(jogador.compararIdentificador(identificador));
	}
}