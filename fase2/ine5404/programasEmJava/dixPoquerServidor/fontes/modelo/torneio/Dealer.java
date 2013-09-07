package modelo.torneio;

public class Dealer 
{
	private Baralho baralho;
	
	public Dealer()
	{
		baralho = new Baralho();
		baralho.desordenarBaralho();
	}
	
	public void darCartasParaJogadores(ListaDeJogador jogadoresNaMao)
	{
		baralho = new Baralho();
		
		for(int cont = Constante.ZERO; cont < jogadoresNaMao.fornecerTamanhoDaLista(); cont++)
		{
			darCartasParaJogador(jogadoresNaMao);
		}
	}
	
	private void darCartasParaJogador(ListaDeJogador jogadoresNaMao)
	{
		for(int cont = Constante.ZERO; cont < Constante.DOIS; cont++)
		{
			Carta cartaJogador = baralho.pegarCartaAleatoria();
			jogadoresNaMao.receberCarta(cont, cartaJogador);
		}
	}
	
	private void darCartaDoBoardParaJogadores(Carta cartaBoard, ListaDeJogador jogadoresNaMao)
	{
		for(int cont = Constante.ZERO; cont < jogadoresNaMao.fornecerTamanhoDaLista(); cont++)
		{
			jogadoresNaMao.receberCarta(cont, cartaBoard);
		}
	}
	
	public void darFlop(Board board, ListaDeJogador jogadoresNaMao)
	{
		Carta[] cartasFlop = new Carta[Constante.TRES];
		
		for(int cont = Constante.ZERO; cont < Constante.TRES; cont++)
		{
			cartasFlop[cont] = baralho.pegarCartaAleatoria();
			darCartaDoBoardParaJogadores(cartasFlop[cont], jogadoresNaMao);
		}
		board.adicionarFlop(cartasFlop);
	}
	
	public void darTurn(Board board, ListaDeJogador jogadoresNaMao)
	{
		Carta cartaTurn = baralho.pegarCartaAleatoria();
		darCartaDoBoardParaJogadores(cartaTurn, jogadoresNaMao);
		board.adicionarTurn(cartaTurn);
	}
	
	public void darRiver(Board board, ListaDeJogador jogadoresNaMao)
	{
		Carta cartaRiver = baralho.pegarCartaAleatoria();
		darCartaDoBoardParaJogadores(cartaRiver, jogadoresNaMao);
		board.adicionarTurn(cartaRiver);
	}
}