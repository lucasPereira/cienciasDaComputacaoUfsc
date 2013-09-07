package comportamento.jogador;

import infra.Cenario;

import java.util.List;

import junit.framework.Assert;
import modelo.cartela.FabricaAbstrataDeCartela;
import modelo.cartela.TipoFabricaDeCartela;
import modelo.jogador.Jogador;

import org.junit.Test;

public class PegarCartela extends Cenario 
{
	private Jogador jogador;
	private TipoFabricaDeCartela fabricaDeCartela;
	private TipoFabricaDeCartela fabricaDeCartelaQuadrada;
	private List<String> valoresDaCartela;
	private List<String> valoresDaCartelaQuadrada;
	private final int QUANTIDADE_DE_NUMEROS = 10000;
	private final int NUMERO_MAXIMO = 10000;
	private final int ORDEM = 100;
	
	public void dadoQue()
	{
		tenhoUmJogador();
		tenhoUmaFabricaDeCartela();
		tenhoUmaFabricaDeCartelaQuadrada();
	}
	
	public void quando()
	{
		jogadorPegaCartela();
		jogadorPegaCartelaQuadrada();
	}
	
	public void entao()
	{
		
	}
	
	private void tenhoUmJogador()
	{
		jogador = new Jogador(0);
	}
	
	private void tenhoUmaFabricaDeCartela()
	{
		fabricaDeCartela = FabricaAbstrataDeCartela.fornecerFabricaDeCartela(QUANTIDADE_DE_NUMEROS, NUMERO_MAXIMO);
	}
	
	private void tenhoUmaFabricaDeCartelaQuadrada()
	{
		fabricaDeCartelaQuadrada = FabricaAbstrataDeCartela.fornecerFabricaDeCartelaQuadrada(ORDEM, NUMERO_MAXIMO);
	}
	
	private void jogadorPegaCartela()
	{
		valoresDaCartela = jogador.pegarCartela(fabricaDeCartela);
	}
	
	private void jogadorPegaCartelaQuadrada()
	{
		valoresDaCartelaQuadrada = jogador.pegarCartela(fabricaDeCartelaQuadrada);
	}
	
	@Test
	public void tenhoUmaListaComValoresDaCartelaComUmOuMaisValores()
	{
		Assert.assertTrue(valoresDaCartela.size() >= 1);
	}
	
	@Test
	public void tenhoUmaListaComValoresDaCartelaQuadradaComUmOuMaisValores()
	{
		Assert.assertTrue(valoresDaCartelaQuadrada.size() >= 1);
	}
}