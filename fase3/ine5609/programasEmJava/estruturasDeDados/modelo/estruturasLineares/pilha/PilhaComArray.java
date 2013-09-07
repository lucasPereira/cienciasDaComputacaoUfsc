package modelo.estruturasLineares.pilha;

import modelo.execoes.execoesDePilha.ExecaoDePilhaCheia;
import modelo.execoes.execoesDePilha.ExecaoDePilhaVazia;

public final class PilhaComArray<E>
{
	private final E[] elementos;
	private int stackPointer;
	
	private static final int TAMANHO_PADRAO_DA_PILHA = 10; 
	private static final int ZERO = 0;
	private static final int UM = 1;
	
	public PilhaComArray()
	{
		this(TAMANHO_PADRAO_DA_PILHA);
	}
	
	@SuppressWarnings("unchecked")
	public PilhaComArray(int quantidadeDeElementos)
	{
		if (quantidadeDeElementos <= ZERO) throw new IllegalArgumentException("Quantidade de elementos deve ser maior que zero.");
		stackPointer = ZERO;
		elementos = (E[]) new Object[quantidadeDeElementos];
	}

	public void push(E elemento) 
	{
		lancarExecaoDePilhaCheiaSeNecessario(); 
		elementos[stackPointer++] = elemento;
	}
	
	public E pop()
	{
		lancarExecaoDePilhaVaziaSeNecessario();
		E elemento = elementos[--stackPointer];
		elementos[stackPointer] = null;
		
		return elemento;
	}

	public E top() 
	{
		lancarExecaoDePilhaVaziaSeNecessario();
		
		return elementos[stackPointer-UM];
	}
	
	public boolean verificarSeEstaVazia()
	{
		return (stackPointer == ZERO);
	}
	
	public boolean verificarSeEstaCheia()
	{
		return (stackPointer == elementos.length);
	}
	
	public int fornecerQuantidadeDeElementos()
	{
		return stackPointer;
	}
	
	private void lancarExecaoDePilhaCheiaSeNecessario()
	{
		if (verificarSeEstaCheia()) throw new ExecaoDePilhaCheia();
	}
	
	private final void lancarExecaoDePilhaVaziaSeNecessario()
	{
		if (verificarSeEstaVazia()) throw new ExecaoDePilhaVazia();
	}
}