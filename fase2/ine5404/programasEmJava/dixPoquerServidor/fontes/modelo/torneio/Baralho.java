package modelo.torneio;

import java.util.ArrayList;
import java.util.List;

public class Baralho 
{
	private List<Carta> baralho;
	private static final int NUMERO_DE_CARTAS = 52;
	
	public Baralho()
	{
		this.criarBaralhoOrdenado();
	}
	
	public void criarBaralhoOrdenado()
	{
		baralho = new ArrayList<Carta>();
		for(Naipe naipe : Naipe.values())
		{
			for(Valor valor : Valor.values())
			{
				baralho.add(new Carta(valor, naipe));
			}
		}
	}
	
	public void desordenarBaralho()
	{
		this.criarBaralhoOrdenado();
		List<Carta> baralhoOrdernado = new ArrayList<Carta>();
		baralhoOrdernado.addAll(baralho);
		baralho.clear();
		
		for(int cont = Constante.ZERO; cont < NUMERO_DE_CARTAS; cont++)
		{
			int numeroSorteado = (int)(Math.random() * (NUMERO_DE_CARTAS - cont));
			Carta carta = baralhoOrdernado.get(numeroSorteado);
			baralho.add(carta);
			baralhoOrdernado.remove(numeroSorteado);
		}
	}
	
	public Carta pegarCartaAleatoria()
	{
		Carta cartaAEnviar = baralho.get(sortearCarta());
		baralho.remove(cartaAEnviar);
		return cartaAEnviar;
	}
	
	private int sortearCarta()
	{
		return (int)(Math.random() * baralho.size());
	}
	
	public String toString()
	{
		String cartas = "";
		for(int cont = Constante.ZERO; cont < NUMERO_DE_CARTAS; cont++)
		{
			cartas += baralho.get(cont) + "\n";
		}
		
		return cartas;
	}
}
