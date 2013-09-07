package modelo.torneio;

public class Mao 
{
	private Jogador jogadorNoBotao;
	private ListaDeJogador jogadoresQueContinuam;
	private ListaDeJogador jogadoresQueDesistiram;
	private Pote pote;
	
	public Mao(Jogador jogadorNoBotao, ListaDeJogador jogadoresNaMao)
	{
		this.jogadorNoBotao = jogadorNoBotao;
		jogadoresQueContinuam = jogadoresNaMao;
		jogadoresQueDesistiram = new ListaDeJogador();
		pote = new Pote();
	}
}
