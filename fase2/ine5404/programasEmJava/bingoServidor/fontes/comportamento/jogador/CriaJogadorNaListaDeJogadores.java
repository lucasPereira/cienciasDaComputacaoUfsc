package comportamento.jogador;

import infra.Cenario;
import junit.framework.Assert;
import modelo.cartela.FabricaAbstrataDeCartela;
import modelo.cartela.TipoFabricaDeCartela;
import modelo.jogador.ListaDeJogador;

import org.junit.Test;

public class CriaJogadorNaListaDeJogadores extends Cenario 
{ 
	private ListaDeJogador jogadores;
	private int quantidadeDeJogadoresNaLista;
	private TipoFabricaDeCartela fabricaDeCartela;
	private final int QUANTIDADE_DE_NUMEROS_DA_CARTELA = 1000;
	private final int NUMERO_MAXIMO_DA_CARTELA = 1000;
	
	public void dadoQue()
	{
		tenhoUmaListaDeJogadores();
		tenhoUmaQuantidadeDeJogadoresNaLista();
		tenhoUmaFabricaDeCartela();
	}
	
	public void quando()
	{
		crioUmNovoJogadorNaLista();
	}
	
	public void entao()
	{
		listaTemMaisUmJogador();
	}
	
	private void tenhoUmaListaDeJogadores()
	{
		jogadores = new ListaDeJogador(fabricaDeCartela);
	}
	
	private void tenhoUmaQuantidadeDeJogadoresNaLista()
	{
		quantidadeDeJogadoresNaLista = jogadores.fornecerQuantidadeDeJogadores();
	}
	
	private void tenhoUmaFabricaDeCartela()
	{
		fabricaDeCartela = FabricaAbstrataDeCartela.fornecerFabricaDeCartela(QUANTIDADE_DE_NUMEROS_DA_CARTELA, NUMERO_MAXIMO_DA_CARTELA);
	}
	
	private void crioUmNovoJogadorNaLista()
	{
		jogadores.criarJogador();
	}
	
	@Test
	public void listaTemMaisUmJogador()
	{
		Assert.assertTrue(jogadores.fornecerQuantidadeDeJogadores() == quantidadeDeJogadoresNaLista + 1);
	}
}