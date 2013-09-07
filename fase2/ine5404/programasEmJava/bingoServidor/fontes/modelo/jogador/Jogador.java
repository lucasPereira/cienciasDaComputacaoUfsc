package modelo.jogador;

import java.util.List;

import modelo.cartela.TipoCartela;
import modelo.cartela.TipoFabricaDeCartela;
import modelo.sorteio.TipoRecipiente;

public class Jogador 
{
	private int identificador;
	private TipoCartela cartela;
	
	public Jogador(int identificador)
	{
		this.identificador = identificador;
	}
	
	public boolean compararIdentificador(String identificadorAComparar) 
	{
		return fornecerIdentificadorTextual().equals(identificadorAComparar);
	}
	
	public String fornecerIdentificadorTextual()
	{
		return "@identificadorJogador:" + identificador;
	}
	
	public List<String> pegarCartela(TipoFabricaDeCartela fabricaDeCartela)
	{
		cartela = fabricaDeCartela.criarCartela();
		
		return cartela.fornecerListaComOsValores();
	}
	
	public boolean verificarSeFezBingo(TipoRecipiente recipiente)
	{
		return cartela.verificarSeFezBingo(recipiente);
	}
}