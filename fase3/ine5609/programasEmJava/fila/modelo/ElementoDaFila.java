package modelo;

public class ElementoDaFila 
{
	private int valor;
	private ElementoDaFila proximoElemento;
	
	public ElementoDaFila(int valor)
	{
		this.valor = valor;
		proximoElemento = null;
	}
	
	public final void encadearElemento(ElementoDaFila novoElemento)
	{
		proximoElemento = novoElemento;
	}
	
	public final ElementoDaFila sair()
	{
		return proximoElemento;
	}
	
	public final int fornecerValor()
	{
		return valor;
	}
	
	public final String fornecerElementos(String elementos)
	{
		if (proximoElemento != null)
		{
			elementos = proximoElemento.fornecerElementos(elementos);
		}
		elementos = "("+valor+") "+elementos;
		
		return elementos;
	}
}