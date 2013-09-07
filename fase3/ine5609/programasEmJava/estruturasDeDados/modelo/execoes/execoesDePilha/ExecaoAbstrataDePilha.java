package modelo.execoes.execoesDePilha;

public abstract class ExecaoAbstrataDePilha extends RuntimeException
{
	private static final long serialVersionUID = -8823322194569899451L;

	public ExecaoAbstrataDePilha(String mensagem)
	{
		super(mensagem);
	}
}
