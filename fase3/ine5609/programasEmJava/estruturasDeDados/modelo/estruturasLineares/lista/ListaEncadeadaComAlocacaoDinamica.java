package modelo.estruturasLineares.lista;

import modelo.caixaDoElemento.CaixaSimplesDoElemento;
import modelo.execoes.execoesDeLista.ExecaoDeListaVazia;

public final class ListaEncadeadaComAlocacaoDinamica<E>
{
	private CaixaSimplesDoElemento<E> caixaDoPrimeiroElemento;
	private CaixaSimplesDoElemento<E> caixaDoUltimoElemento;
	
	private static final int ZERO = 0;
	
	public ListaEncadeadaComAlocacaoDinamica()
	{
		caixaDoPrimeiroElemento = null;
		caixaDoUltimoElemento = null;
	}
	
	public void inserirInicio(E elemento) 
	{
		CaixaSimplesDoElemento<E> caixaDoNovoPrimeiroElemento = new CaixaSimplesDoElemento<E>(elemento);
		caixaDoNovoPrimeiroElemento.receberCaixaDoProximoElemento(caixaDoPrimeiroElemento);
		caixaDoPrimeiroElemento = caixaDoNovoPrimeiroElemento;
		if (caixaDoUltimoElemento == null) caixaDoUltimoElemento = caixaDoPrimeiroElemento;
	}

	public void inserirFim(E elemento) 
	{
		CaixaSimplesDoElemento<E> caixaDoNovoUltimoElemento = new CaixaSimplesDoElemento<E>(elemento);
		if (caixaDoUltimoElemento != null) caixaDoUltimoElemento.receberCaixaDoProximoElemento(caixaDoNovoUltimoElemento);
		caixaDoUltimoElemento = caixaDoNovoUltimoElemento;
		if (caixaDoPrimeiroElemento == null) caixaDoPrimeiroElemento = caixaDoUltimoElemento;
	}

	public E removerInicio() 
	{
		lancarExecaoDeListaVaziaSeNecessario();
		E elemento = caixaDoPrimeiroElemento.fornecerElemento();
		caixaDoPrimeiroElemento = caixaDoPrimeiroElemento.fornecerCaixaDoProximoElemento();
		
		return elemento;
	}

	public E removerFim() 
	{
		lancarExecaoDeListaVaziaSeNecessario();
		E elemento = caixaDoUltimoElemento.fornecerElemento();
		CaixaSimplesDoElemento<E> caixaDoPenultimoElemento = caixaDoPrimeiroElemento;
		CaixaSimplesDoElemento<E> caixaAuxiliar;
		while ((caixaAuxiliar = caixaDoPenultimoElemento.fornecerCaixaDoProximoElemento()) != caixaDoUltimoElemento)
		{
			caixaDoPenultimoElemento = caixaAuxiliar;
		}
		caixaDoUltimoElemento = caixaDoPenultimoElemento;
		caixaDoUltimoElemento.receberCaixaDoProximoElemento(null);
		
		return elemento;
	}

	public boolean verificarSeContemElemento(E elemento) 
	{
		return (fornecerCaixaDoElemento(elemento) != null);
	}

	public int fornecerQuantidadeDeElementos() 
	{
		if (caixaDoPrimeiroElemento == null) return ZERO;
		
		return caixaDoPrimeiroElemento.fornecerQuantidadeDeElementosEncadeados();
	}

	public boolean verificarSeEstaVazia() 
	{
		return (caixaDoPrimeiroElemento == null);
	}
	
	private CaixaSimplesDoElemento<E> fornecerCaixaDoElemento(E elemento)
	{
		CaixaSimplesDoElemento<E> caixaDoElementoBuscado = caixaDoPrimeiroElemento;
		while (caixaDoElementoBuscado != null)		
		{
			if (caixaDoElementoBuscado.fornecerElemento().equals(elemento))
			{
				return caixaDoElementoBuscado;
			}
			caixaDoElementoBuscado = caixaDoElementoBuscado.fornecerCaixaDoProximoElemento();
		}
		
		return caixaDoElementoBuscado;
	}
	
	private final void lancarExecaoDeListaVaziaSeNecessario()
	{
		if (verificarSeEstaVazia()) throw new ExecaoDeListaVazia();
	}
}