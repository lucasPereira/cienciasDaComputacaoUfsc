package producao;

public class FlipFlopJK extends FlipFlops 
{
	protected boolean[] valoresJ;
	protected boolean[] valoresK;
	public FlipFlopJK(boolean transicao, int delay, boolean[] j, boolean[] k)
	{
		super(transicao, delay);
		valoresJ = j;
		valoresK = k;
	}
	
	public boolean[] fornecaJ()
	{
		return valoresJ;
	}
	
	public boolean[] fornecaK()
	{
		return valoresK;
	}
}
