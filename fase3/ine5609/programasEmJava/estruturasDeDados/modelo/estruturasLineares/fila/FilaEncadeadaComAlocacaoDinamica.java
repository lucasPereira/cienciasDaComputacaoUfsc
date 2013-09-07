package modelo.estruturasLineares.fila;

import modelo.caixaDoElemento.CaixaSimplesDoElemento;
import modelo.execoes.execoesDeFila.ExecaoDeFilaVazia;

public final class FilaEncadeadaComAlocacaoDinamica<E>
{
	private CaixaSimplesDoElemento<E> caixaDoPrimeiroElemento;
	private CaixaSimplesDoElemento<E> caixaDoUltimoElemento;
	
	private static final int ZERO = 0;
	
	public FilaEncadeadaComAlocacaoDinamica()
	{
		caixaDoPrimeiroElemento = null;
		caixaDoUltimoElemento = null;
	}
	
	public void entrar(E elemento) 
	{
		CaixaSimplesDoElemento<E> caixaDoNovoUltimoElemento = new CaixaSimplesDoElemento<E>(elemento);
		if (caixaDoUltimoElemento != null)
		{
			caixaDoUltimoElemento.receberCaixaDoProximoElemento(caixaDoNovoUltimoElemento);
			caixaDoUltimoElemento = caixaDoNovoUltimoElemento;
		}
		else
		{
			caixaDoUltimoElemento = caixaDoNovoUltimoElemento;
			caixaDoPrimeiroElemento = caixaDoUltimoElemento;
		}
	}
	
	public E sair() 
	{	
		lancarExecaoDeFilaVaziaSeNecessario();
		
		E elemento = caixaDoPrimeiroElemento.fornecerElemento();
		caixaDoPrimeiroElemento = caixaDoPrimeiroElemento.fornecerCaixaDoProximoElemento();
		
		return elemento;
	}

	public E fornecerPrimeiro() 
	{
		lancarExecaoDeFilaVaziaSeNecessario();
		
		return caixaDoPrimeiroElemento.fornecerElemento();
	}
	
	public int fornecerQuantidadeDeElementos() 
	{
		if (verificarSeEstaVazia()) return ZERO;
		
		return caixaDoPrimeiroElemento.fornecerQuantidadeDeElementosEncadeados();
	}

	public boolean verificarSeEstaVazia() 
	{
		return (caixaDoPrimeiroElemento == null);
	}
	
	private final void lancarExecaoDeFilaVaziaSeNecessario() 
	{
		if (verificarSeEstaVazia()) throw new ExecaoDeFilaVazia();
	}
}