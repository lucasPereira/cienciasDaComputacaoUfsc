package modelo.torneio;

import java.util.ArrayList;
import java.util.List;

public class ListaDeJogador
{
	private List<Jogador> jogadores;
	
	public ListaDeJogador()
	{
		jogadores = new ArrayList<Jogador>();
	}
	
	public void adicionarJogador(Jogador jogador)
	{
		jogadores.add(jogador);
	}
	
	public void removerJogador(Jogador jogador)
	{
		jogadores.remove(jogador);
	}
	
	public boolean verificarSeListaPossuiJogador(Jogador jogador)
	{
		return jogadores.contains(jogador);
	}
	
	public int fornecerTamanhoDaLista()
	{
		return jogadores.size();
	}
	
	public void rodarLista()
	{
		int tamanhoDaLista = fornecerTamanhoDaLista();
		List<Jogador> novaLista = new ArrayList<Jogador>();
		
		novaLista.addAll(Constante.UM, jogadores);
		novaLista.add(Constante.ZERO, novaLista.get(tamanhoDaLista));
		novaLista.remove(tamanhoDaLista);
		
		jogadores.addAll(novaLista);
	}
	
	public void receberCarta(int index, Carta carta)
	{
		jogadores.get(index).receberCarta(carta);
	}
}
