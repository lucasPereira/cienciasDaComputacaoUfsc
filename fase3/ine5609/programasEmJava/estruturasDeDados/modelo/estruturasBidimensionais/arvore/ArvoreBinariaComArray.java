package modelo.estruturasBidimensionais.arvore;

import modelo.utilidades.Comparavel;

public class ArvoreBinariaComArray<E extends Comparavel<E>> 
{
	private final E[] elementos; 
	
	private static final int RAIZ = 0;
	private static final int RAZAO_PG = 2;
	
	private static final int UM = 1;
	
	@SuppressWarnings("unchecked")
	public ArvoreBinariaComArray(int numeroDeNiveis)
	{
		int numeroDeElementos = numeroDeNiveis*numeroDeNiveis-UM;
		elementos = (E[]) new Comparavel[numeroDeElementos];
	}

	public void inserir(E elemento)
	{
		inserir(elemento, RAIZ);
	}
	
	private void inserir(E elemento, int posicaoSubRaiz)
	{		
		if (elementos[posicaoSubRaiz] == null)
		{
			elementos[posicaoSubRaiz] = elemento;
		}
		else
		{
			posicaoSubRaiz = escolherEsquerdaOuDireita(elemento, posicaoSubRaiz);
			inserir(elemento, posicaoSubRaiz);
		}
	}
	
	public boolean verificarSePossuiElemento(E elemento)
	{
		return verificarSePossuiElemento(elemento, RAIZ);
	}
	
	private boolean verificarSePossuiElemento(E elemento, int posicaoSubRaiz)
	{
		if (elementos[posicaoSubRaiz] == null) return false;
		int novaPosicaoSubRaiz = escolherEsquerdaOuDireita(elemento, posicaoSubRaiz);
		
		return elementos[posicaoSubRaiz].verificarSeÉIgual(elemento) ? true : verificarSePossuiElemento(elemento, novaPosicaoSubRaiz);
	}
	
	private int escolherEsquerdaOuDireita(E elemento, int posicaoElementoAtual)
	{
		return elementos[posicaoElementoAtual].verificarSeÉMaior(elemento) ? fornecerPosicaoElementoDaEsquerda(posicaoElementoAtual) : fornecerPosicaoElementoDaDireita(posicaoElementoAtual);
	}
	
	private int fornecerPosicaoElementoDaEsquerda(int posicaoElementoAtual)
	{
		return (RAZAO_PG*(posicaoElementoAtual+UM))-UM;
	}
	
	private int fornecerPosicaoElementoDaDireita(int posicaoElementoAtual)
	{
		return (RAZAO_PG*(posicaoElementoAtual+UM));
	}
}