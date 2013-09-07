package modelo.torneio;

public class Board 
{
	private ListaDeCarta flop;
	private Carta turn;
	private Carta river;
	
	public Board()
	{
		flop = new ListaDeCarta();
	}
	
	public void adicionarFlop(Carta[] carta)
	{
		flop.limparLista();
		
		for(int cont = Constante.ZERO; cont < Constante.TRES; cont++)
		{
			flop.adicionarCarta(carta[cont]);
		}
		FachadaTorneio.EnviarFlop(flop);
	
	}
	
	public void adicionarTurn(Carta carta)
	{
		turn = carta;
		FachadaTorneio.EnviarTurn(turn);
	}
	
	public void adicionarRiver(Carta carta)
	{
		river = carta;
		FachadaTorneio.EnviarRiver(river);
	}
}
