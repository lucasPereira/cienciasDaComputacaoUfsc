package modelo.execoes.execoesDeHash;

public class ExececaoDeValorNuloNoHash extends RuntimeException 
{
	private static final long serialVersionUID = -8782445594628862908L;

	public ExececaoDeValorNuloNoHash()
	{
		super("Impossível realizar operaçao, valor não pode ser nulo.");
	}
}
