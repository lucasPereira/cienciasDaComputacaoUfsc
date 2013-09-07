package modelo.caixaDoElemento;

public class CaixaTriplaDoElemento<E> 
{
	private E elemento;
	private CaixaTriplaDoElemento<E> caixaDoElementoDaEsquerda;
	private CaixaTriplaDoElemento<E> caixaDoElementoPai;
	private CaixaTriplaDoElemento<E> caixaDoElementoDaDireita;
	
	public CaixaTriplaDoElemento(E elemento)
	{
		this.elemento = elemento;
	}
	
	public E fornecerElemento()
	{
		return elemento;
	}
	
	public CaixaTriplaDoElemento<E> fornecerCaixaDoElementoDaEsquerda()
	{
		return caixaDoElementoDaEsquerda;	
	}
	
	public CaixaTriplaDoElemento<E> fornecerCaixaDoElementoDaDireita()
	{
		return caixaDoElementoDaDireita;
	}
	
	public CaixaTriplaDoElemento<E> fornercerCaixaDoElementoPai()
	{
		return caixaDoElementoPai;
	}
	
	public void receberCaixaDoElementoDaEsquerda(CaixaTriplaDoElemento<E> caixaDoElemento)
	{
		caixaDoElementoDaEsquerda = caixaDoElemento;
	}
	
	public void receberCaixaDoElementoDaDireita(CaixaTriplaDoElemento<E> caixaDoElemento)
	{
		caixaDoElementoDaDireita = caixaDoElemento;
	}
	
	public void receberCaixaDoElementoPai(CaixaTriplaDoElemento<E> caixaDoElemento)
	{
		caixaDoElementoPai = caixaDoElemento;
	}
}