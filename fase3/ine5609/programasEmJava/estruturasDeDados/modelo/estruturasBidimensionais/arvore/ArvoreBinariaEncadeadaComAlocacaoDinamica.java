package modelo.estruturasBidimensionais.arvore;

import modelo.caixaDoElemento.CaixaTriplaDoElemento;
import modelo.utilidades.Comparavel;

public class ArvoreBinariaEncadeadaComAlocacaoDinamica<E extends Comparavel<E>> 
{
	private CaixaTriplaDoElemento<E> caixaDoElementoRaiz;
	
	public ArvoreBinariaEncadeadaComAlocacaoDinamica()
	{
		
	}
	
	public void inserir(E elemento)
	{
		inserir(caixaDoElementoRaiz, elemento);
	}
	
	private void inserir(CaixaTriplaDoElemento<E> caixaDoElementoRaiz, E elemento)
	{
		if (caixaDoElementoRaiz == null)
		{
			caixaDoElementoRaiz = new CaixaTriplaDoElemento<E>(elemento);
		}
		else
		{
			caixaDoElementoRaiz = escolherElementoDaEsquerdaOuDireita(caixaDoElementoRaiz, elemento);
			inserir(caixaDoElementoRaiz, elemento);
		}
	}
	
	public boolean remover(E elemento)
	{
		CaixaTriplaDoElemento<E> caixaDoElementoRemovido = buscarCaixaDoElemento(caixaDoElementoRaiz, elemento);
		if (caixaDoElementoRemovido == null) return false;
		int numeroDeFilhos = fornecerNumeroDeFilhos(caixaDoElementoRemovido);
		CaixaTriplaDoElemento<E> caixaDoElementoPai = caixaDoElementoRemovido.fornercerCaixaDoElementoPai();
		E elementoPai = caixaDoElementoPai.fornecerElemento();
		switch (numeroDeFilhos)
		{
			case 0:
			{
				if (elementoPai.verificarSeÉMaior(elemento))
				{
					caixaDoElementoPai.receberCaixaDoElementoDaEsquerda(null);
				}
				else
				{
					caixaDoElementoPai.receberCaixaDoElementoDaDireita(null);
				}
				caixaDoElementoRemovido.receberCaixaDoElementoPai(null);
				caixaDoElementoRemovido.receberCaixaDoElementoDaEsquerda(null);
				caixaDoElementoRemovido.receberCaixaDoElementoDaDireita(null);
				caixaDoElementoRemovido = null;
				break;
			}
			case 1:
			{
				CaixaTriplaDoElemento<E> caixaDoElementoFilho;
				if (caixaDoElementoRemovido.fornecerCaixaDoElementoDaEsquerda() != null)
				{
					caixaDoElementoFilho = caixaDoElementoRemovido.fornecerCaixaDoElementoDaEsquerda();
				}
				else
				{
					caixaDoElementoFilho = caixaDoElementoRemovido.fornecerCaixaDoElementoDaDireita();
				}
				
				if (caixaDoElementoPai.fornecerCaixaDoElementoDaEsquerda() == caixaDoElementoRemovido)
				{
					caixaDoElementoPai.receberCaixaDoElementoDaEsquerda(caixaDoElementoFilho);
				}
				else
				{
					caixaDoElementoPai.receberCaixaDoElementoDaDireita(caixaDoElementoFilho);
				}
				break;
			}
			case 2:
			{
				
			}
			default:
			{
				assert (false);
			}
		}
		
		return true;
	}
	
	private int fornecerNumeroDeFilhos(CaixaTriplaDoElemento<E> caixaDoElemento)
	{
		int numeroDeFilhos = 0;
		if (caixaDoElemento.fornecerCaixaDoElementoDaEsquerda() != null) numeroDeFilhos++;
		if (caixaDoElemento.fornecerCaixaDoElementoDaDireita() != null) numeroDeFilhos++;
		
		return numeroDeFilhos;
	}

	private CaixaTriplaDoElemento<E> buscarCaixaDoElemento(CaixaTriplaDoElemento<E> caixaDoElementoRaiz, E elemento)
	{
		if (caixaDoElementoRaiz == null) return null;
		if (caixaDoElementoRaiz.fornecerElemento().verificarSeÉIgual(elemento)) return caixaDoElementoRaiz;
		caixaDoElementoRaiz = escolherElementoDaEsquerdaOuDireita(caixaDoElementoRaiz, elemento);
		
		return buscarCaixaDoElemento(caixaDoElementoRaiz, elemento);
	}
	
	private CaixaTriplaDoElemento<E> escolherElementoDaEsquerdaOuDireita(CaixaTriplaDoElemento<E> caixaDoElemento, E elemento)
	{
		return caixaDoElemento.fornecerElemento().verificarSeÉMaior(elemento) ? caixaDoElemento.fornecerCaixaDoElementoDaEsquerda() : caixaDoElemento.fornecerCaixaDoElementoDaDireita();
	}
	
}