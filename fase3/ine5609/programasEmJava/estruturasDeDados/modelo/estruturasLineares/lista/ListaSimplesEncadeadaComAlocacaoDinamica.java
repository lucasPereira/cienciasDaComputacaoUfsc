package modelo.estruturasLineares.lista;

import modelo.caixaDoElemento.CaixaSimplesDoElemento;
import modelo.utilidades.Igualavel;

public final class ListaSimplesEncadeadaComAlocacaoDinamica<E extends Igualavel<E>> 
{
	private CaixaSimplesDoElemento<E> caixaDoPrimeiroElemento;
	
	public ListaSimplesEncadeadaComAlocacaoDinamica()
	{
		caixaDoPrimeiroElemento = null;
	}
	
	public void inserirInicio(E elemento)
	{
		CaixaSimplesDoElemento<E> caixaDoNovoPrimeiroElemento = new CaixaSimplesDoElemento<E>(elemento);
		caixaDoNovoPrimeiroElemento.receberCaixaDoProximoElemento(caixaDoPrimeiroElemento);
		caixaDoPrimeiroElemento = caixaDoNovoPrimeiroElemento;
	}
	
	public boolean removerElemento(E elemento)
	{
		boolean removido;
		if (removido = verificarSePossuiElemento(elemento))
		{
			caixaDoPrimeiroElemento = removerElemento(elemento, caixaDoPrimeiroElemento);
		}
		
		return removido;
	}
	
	private CaixaSimplesDoElemento<E> removerElemento(E elemento, CaixaSimplesDoElemento<E> caixaDoElementoAtual)
	{
		if (caixaDoElementoAtual == null) return null;
		if (caixaDoElementoAtual.fornecerElemento().verificarSeÉIgual(elemento))
		{
			return caixaDoElementoAtual.fornecerCaixaDoProximoElemento();
		}
		caixaDoElementoAtual.receberCaixaDoProximoElemento(removerElemento(elemento, caixaDoElementoAtual.fornecerCaixaDoProximoElemento()));
		
		return caixaDoElementoAtual;
	}
	
	public boolean verificarSePossuiElemento(E elemento)
	{
		return verificarSePossuiElemento(elemento, caixaDoPrimeiroElemento);
	}
	
	private boolean verificarSePossuiElemento(E elemento, CaixaSimplesDoElemento<E> caixaDoElementoAtual)
	{
		if (caixaDoElementoAtual == null) return false;
		
		if (caixaDoElementoAtual.fornecerElemento().equals(elemento)) return true;
		
		return verificarSePossuiElemento(elemento, caixaDoElementoAtual.fornecerCaixaDoProximoElemento());
	}
}