package modelo.torneio;

public class Carta 
{
	private final Valor valor;
	private final Naipe naipe;
	
	public Carta(Valor valor, Naipe naipe)
	{
		this.valor = valor;
		this.naipe = naipe;
	}
	
	public String toString()
	{
		return valor + " DE " + naipe;
	}
	
	public String toStringJPG()
	{
		String nomeDaCarta = valor + "" + naipe + ".jpg";
		return nomeDaCarta.toLowerCase();
	}
	
	public boolean equals(Carta carta)
	{
		return this.valor.equals(carta.valor) && this.naipe.equals(carta.naipe); 
	}
}
