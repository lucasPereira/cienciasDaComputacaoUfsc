package modelo.execoes.execoesDeFila;

public abstract class ExecaoAbstrataDeFila extends RuntimeException 
{
	private static final long serialVersionUID = 6962383325530575504L;

	public ExecaoAbstrataDeFila(String mensagem)
	{
		super(mensagem);
	}
}
