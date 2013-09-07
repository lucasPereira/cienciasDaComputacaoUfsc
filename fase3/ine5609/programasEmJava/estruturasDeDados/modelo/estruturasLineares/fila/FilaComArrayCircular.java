package modelo.estruturasLineares.fila;

import modelo.execoes.execoesDeFila.ExecaoDeFilaCheia;
import modelo.execoes.execoesDeFila.ExecaoDeFilaVazia;

public final class FilaComArrayCircular<E>
{
	private final E[] elementos;
	private int inicio;
	private int fim;
	private int quantidadeDeElementos;
	
	private static final int TAMANHO_PADRAO_DA_FILA = 10;
	private static final int ZERO = 0;
	
	public FilaComArrayCircular()
	{
		this(TAMANHO_PADRAO_DA_FILA);
	}
	
	@SuppressWarnings("unchecked")
	public FilaComArrayCircular(int quantidadeDeElementos)
	{
		if (quantidadeDeElementos < ZERO) throw new IllegalArgumentException("Quantidade de elementos deve ser maior que zero.");
		inicio = ZERO;
		fim = ZERO;
		elementos = (E[]) new Object[quantidadeDeElementos];
	}
	
	public void entrar(E elemento)
	{
		lancarExecaoDeFilaCheiaSeNecessario();
		elementos[fim++] = elemento;
		quantidadeDeElementos++;
		darVolta();
	}
	
	public E sair()
	{
		lancarExecaoDeFilaVaziaSeNecessario();
		E elemento = elementos[inicio];
		elementos[inicio] = null;
		inicio++;
		quantidadeDeElementos--;
		darVolta();
		
		return elemento;
	}
	
	public E fornecerPrimeiro()
	{
		lancarExecaoDeFilaVaziaSeNecessario();
		
		return elementos[inicio];
	}

	private void darVolta()
	{
		if (fim == elementos.length) fim = ZERO;
		if (fim == elementos.length) inicio = ZERO;
	}
	
	public boolean verificarSeEstaCheia()
	{
		return (quantidadeDeElementos == elementos.length);
	}
	
	public boolean verificarSeEstaVazia()
	{
		return (quantidadeDeElementos == ZERO);
	}
	
	public int fornecerQuantidadeDeElementos()
	{
		return quantidadeDeElementos;
	}
	
	private void lancarExecaoDeFilaCheiaSeNecessario() 
	{
		if (verificarSeEstaCheia()) throw new ExecaoDeFilaCheia();
	}
	
	private void lancarExecaoDeFilaVaziaSeNecessario() 
	{
		if (verificarSeEstaVazia()) throw new ExecaoDeFilaVazia();
	}
}