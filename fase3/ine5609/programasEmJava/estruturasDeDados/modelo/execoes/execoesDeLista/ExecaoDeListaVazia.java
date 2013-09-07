package modelo.execoes.execoesDeLista;

public class ExecaoDeListaVazia extends RuntimeException 
{
	private static final long serialVersionUID = 5471084222276074912L;
	
	public ExecaoDeListaVazia()
	{
		super("Impossível remover elemento, lista está cheia.");
	}
}
