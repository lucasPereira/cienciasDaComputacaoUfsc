package modelo.caixaDoElemento;

public final class CaixaSimplesDoElemento<E>
{
	private final E elemento;
	private CaixaSimplesDoElemento<E> caixaDoProximoElemento;
	
	private static final int UM = 1;
	
	public CaixaSimplesDoElemento(E elemento)
	{
		this.elemento= elemento;
	}
	
	public E fornecerElemento()
	{
		return elemento;
	}
	
	public CaixaSimplesDoElemento<E> fornecerCaixaDoProximoElemento()
	{
		return caixaDoProximoElemento;
	}	
	
	public void receberCaixaDoProximoElemento(CaixaSimplesDoElemento<E> caixaDoProximoElemento)
	{
		this.caixaDoProximoElemento = caixaDoProximoElemento;
	}
	
	public int fornecerQuantidadeDeElementosEncadeados()
	{
		int quantidadeDeElemento = UM;
		CaixaSimplesDoElemento<E> caixaDoProximoElemento = this.fornecerCaixaDoProximoElemento();
		while (caixaDoProximoElemento != null)
		{
			caixaDoProximoElemento = caixaDoProximoElemento.fornecerCaixaDoProximoElemento();
			quantidadeDeElemento++;
		}
		
		return quantidadeDeElemento;
	}
	
	public String toString()
	{
		String proximoElemento = "null";
		if (caixaDoProximoElemento != null)
		{
			proximoElemento = caixaDoProximoElemento.fornecerElemento().toString();
		}
		
		return "Elemento: "+elemento+"\nPróximo Elemento: "+proximoElemento;
	}
}