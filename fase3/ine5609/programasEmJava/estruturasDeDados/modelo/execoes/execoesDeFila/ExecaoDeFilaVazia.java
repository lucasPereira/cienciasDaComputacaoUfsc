package modelo.execoes.execoesDeFila;


public class ExecaoDeFilaVazia extends ExecaoAbstrataDeFila 
{
	private static final long serialVersionUID = -5332203776285076387L;

	public ExecaoDeFilaVazia()
	{
		super("Impossível remover elemento, fila está vazia.");
	}
}
