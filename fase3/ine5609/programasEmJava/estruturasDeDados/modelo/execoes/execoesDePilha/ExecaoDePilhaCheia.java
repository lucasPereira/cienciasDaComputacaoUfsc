package modelo.execoes.execoesDePilha;


public final class ExecaoDePilhaCheia extends ExecaoAbstrataDePilha
{
	private static final long serialVersionUID = 3243264756965886509L;

	public ExecaoDePilhaCheia()
	{
		super("Impossível adicionar elemento, pilha está cheia.");
	}
}
