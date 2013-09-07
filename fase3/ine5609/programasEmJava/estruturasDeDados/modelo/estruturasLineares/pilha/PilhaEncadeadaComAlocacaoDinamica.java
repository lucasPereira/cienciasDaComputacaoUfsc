package modelo.estruturasLineares.pilha;

import modelo.caixaDoElemento.CaixaSimplesDoElemento;
import modelo.execoes.execoesDePilha.ExecaoDePilhaVazia;

public final class PilhaEncadeadaComAlocacaoDinamica<E>
{
	private CaixaSimplesDoElemento<E> caixaDoPrimeiroElemento;
	
	private static final int ZERO = 0;
	
	public PilhaEncadeadaComAlocacaoDinamica()
	{
		caixaDoPrimeiroElemento = null;
	}
	
	public void push(E elemento)
	{
		CaixaSimplesDoElemento<E> caixaDoAntigoPrimeiroElemento = caixaDoPrimeiroElemento;
		caixaDoPrimeiroElemento = new CaixaSimplesDoElemento<E>(elemento);
		caixaDoPrimeiroElemento.receberCaixaDoProximoElemento(caixaDoAntigoPrimeiroElemento);
	}
	
	public E pop()
	{
		lancarExecaoDePilhaVaziaSeNecessario();
		E primeiroElemento = caixaDoPrimeiroElemento.fornecerElemento(); 
		caixaDoPrimeiroElemento = caixaDoPrimeiroElemento.fornecerCaixaDoProximoElemento();
		
		return primeiroElemento;
	}
	
	public E top() 
	{
		lancarExecaoDePilhaVaziaSeNecessario();
		
		return caixaDoPrimeiroElemento.fornecerElemento();
	}	
	
	public boolean verificarSeEstaVazia()
	{
		return (caixaDoPrimeiroElemento == null); 
	}
	
	public int fornecerQuantidadeDeElementos() 
	{
		if (caixaDoPrimeiroElemento == null) return ZERO;
		
		return caixaDoPrimeiroElemento.fornecerQuantidadeDeElementosEncadeados();
	}
	
	private final void lancarExecaoDePilhaVaziaSeNecessario()
	{
		if (verificarSeEstaVazia()) throw new ExecaoDePilhaVazia();
	}
}