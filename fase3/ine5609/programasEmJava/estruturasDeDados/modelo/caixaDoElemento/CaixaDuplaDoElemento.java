package modelo.caixaDoElemento;

public final class CaixaDuplaDoElemento<E> 
{
	private final E elemento;
	private CaixaDuplaDoElemento<E> caixaDuplaDoElementoAnterior;
	private CaixaDuplaDoElemento<E> caixaDuplaDoElementoPosterior;
	
	public CaixaDuplaDoElemento(E elemento)
	{
		this.elemento = elemento;
	}
	
	public void receberCaixaDuplaDoElementoAnterior(CaixaDuplaDoElemento<E> elementoAnterior)
	{
		this.caixaDuplaDoElementoAnterior = elementoAnterior;
	}
	
	public void receberCaixaDuplaDoElementoPosterior(CaixaDuplaDoElemento<E> elementoPosterior)
	{
		this.caixaDuplaDoElementoPosterior = elementoPosterior;
	}
	
	public E fornecerElemento()
	{
		return elemento;
	}
	
	public CaixaDuplaDoElemento<E> fornecerCaixaDuplaDoElementoAnteriror()
	{
		return caixaDuplaDoElementoAnterior;
	}
	
	public CaixaDuplaDoElemento<E> fornecerCaixaDuplaDoElementoPosterior()
	{
		return caixaDuplaDoElementoPosterior;
	}
	
	private boolean verificarSePossuiElementoEmVolta(CaixaDuplaDoElemento<E> caixaDuplaDoElemento)
	{
		return (caixaDuplaDoElemento == null);
	}
	
	public boolean verificarSePossuiElementoAnteriror()
	{
		return verificarSePossuiElementoEmVolta(caixaDuplaDoElementoAnterior);
	}
	
	public boolean verificarSePossuiElementoPosterior()
	{
		return verificarSePossuiElementoEmVolta(caixaDuplaDoElementoPosterior);
	}
	
	public String toString()
	{
		String string = "Elemento Anterior: "+caixaDuplaDoElementoAnterior.fornecerElemento();
		string += "\nElemento: "+elemento;
		string += "\nElemento Posterior: "+caixaDuplaDoElementoPosterior.fornecerElemento();
		
		return string;
	}
}