package modelo.torneio;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCarta 
{
	private List<Carta> cartas;
	
	public ListaDeCarta()
	{
		cartas = new ArrayList<Carta>();
	}
	
	public void adicionarCarta(Carta carta)
	{
		cartas.add(carta);
	}
	
	public void removerCarta(Carta carta)
	{
		cartas.remove(carta);
	}
	
	public void limparLista()
	{
		cartas.clear();
	}
	
	public boolean verificarSeListaPossuiCarta(Carta carta)
	{
		return cartas.contains(carta);
	}
}
