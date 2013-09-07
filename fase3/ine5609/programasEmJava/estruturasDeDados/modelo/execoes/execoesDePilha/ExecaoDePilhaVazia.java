package modelo.execoes.execoesDePilha;


public final class ExecaoDePilhaVazia extends ExecaoAbstrataDePilha
{
	private static final long serialVersionUID = 6601514906531082456L;

	public ExecaoDePilhaVazia()
	{
		super("Impossível remover elemento, pilha está vazia.");
	}
}
