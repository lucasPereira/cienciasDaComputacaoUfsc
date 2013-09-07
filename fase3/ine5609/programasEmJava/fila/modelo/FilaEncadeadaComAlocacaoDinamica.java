package modelo;

public class FilaEncadeadaComAlocacaoDinamica 
{
	private ElementoDaFila primeiroElemento;
	private ElementoDaFila ultimoElemento;
	
	public FilaEncadeadaComAlocacaoDinamica()
	{
		primeiroElemento = null;
		ultimoElemento = null;
	}
	
	public final void entrar(int valor)
	{
		if (primeiroElemento == null)
		{
			primeiroElemento = new ElementoDaFila(valor);
			ultimoElemento = primeiroElemento;
		}
		else
		{
			ElementoDaFila novoElemento = new ElementoDaFila(valor);
			ultimoElemento.encadearElemento(novoElemento);
			ultimoElemento = novoElemento;
		}
	}
	
	public final int sair()
	{
		assert (primeiroElemento != null) : "Fila está vazia";
		
		int elemento = primeiroElemento.fornecerValor();
		primeiroElemento = primeiroElemento.sair();
		
		return elemento;
	}
	
	public final String fornecerElementosNaFila()
	{
		String elementos = "";
		if (primeiroElemento != null)
		{
			elementos = primeiroElemento.fornecerElementos(elementos); 
		}
		elementos = "Inicio: "+elementos;
		elementos += ":Fim";
		
		return elementos;
	}
}