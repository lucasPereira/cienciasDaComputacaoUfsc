package modelo.jogador;

import java.util.ArrayList;
import java.util.List;

import modelo.cartela.TipoFabricaDeCartela;

public class ListaDeJogador 
{
	private List<Jogador> jogadores;
	//private TipoFabricaDeCartela fabricaDeCartela;
	
	public ListaDeJogador(TipoFabricaDeCartela fabricaDeCartela)
	{
		jogadores = new ArrayList<Jogador>();
		//this.fabricaDeCartela = fabricaDeCartela;
	}
	
	public String criarJogador()
	{
		int identificadorJogador = jogadores.size();
		Jogador jogador = new Jogador(identificadorJogador); 
		jogadores.add(jogador);
		
		return jogador.fornecerIdentificadorTextual();
	}
	
	public List<String> pegarCartelaParaJogador(String identificadorJogador)
	{
		return null;
	}
	
	public boolean verificarSeJogadorFezBingo()
	{
		return false;
	}
	
	public int fornecerQuantidadeDeJogadores()
	{
		return jogadores.size();
	}
}