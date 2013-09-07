package modelo.execoes.execoesDeFila;


public class ExecaoDeFilaCheia extends ExecaoAbstrataDeFila 
{
	private static final long serialVersionUID = -8177277304950332218L;

	public ExecaoDeFilaCheia()
	{
		super("Impossível adicionar elemento, fila está cheia.");
	}
}
