package modelo.estruturasLineares.pilha;

import modelo.execoes.execoesDePilha.ExecaoDePilhaCheia;
import modelo.execoes.execoesDePilha.ExecaoDePilhaVazia;

public final class PilhaDupla<E>
{
	private int stackPointerA;
	private int stackPointerB;
	private E[] elementos;
	
	private static final int QUANTIDADE_PADRAO_DE_ELEMENTOS = 10;
	private static final int ZERO = 0;
	private static final int UM = 1;
	
	public PilhaDupla()
	{
		this(QUANTIDADE_PADRAO_DE_ELEMENTOS);
	}
	
	@SuppressWarnings("unchecked")
	public PilhaDupla(int quantidadeDeElementos)
	{
		if (quantidadeDeElementos <= ZERO) throw new IllegalArgumentException("Quantidade de elementos deve ser maior que zero.");
		elementos = (E[]) new Object[quantidadeDeElementos];
		stackPointerA = ZERO;
		stackPointerB = elementos.length-UM;
	}
	
	private void push(E elemento, int stackPointer)
	{
		lancarExecaoDePilhaCheiaSeNecessario();
		elementos[stackPointer] = elemento;
	}
	
	public void pushA(E elemento)
	{
		push(elemento, stackPointerA);
		stackPointerA++;
	}
	
	public void pushB(E elemento)
	{
		push(elemento, stackPointerB);	
		stackPointerB--;
	}
	
	private E pop(int stackPointer)
	{
		lancarExecaoDePilhaVaziaSeNecessario();
		E elemento = elementos[stackPointer];
		elementos[stackPointer] = null;
		
		return elemento;
	}
	
	public E popA()
	{
		return pop(--stackPointerA);
	}
	
	public E popB()
	{
		return pop(++stackPointerB);
	}
	
	private E top(int stackPointer)
	{
		lancarExecaoDePilhaVaziaSeNecessario();
		
		return elementos[stackPointer];
	}
	
	public E topA()
	{
		return top(stackPointerA-UM);
	}
	
	public E topB()
	{
		return pop(stackPointerB+UM);
	}
	
	public boolean verificarSeEstaCheia()
	{
		return (stackPointerA > stackPointerB || stackPointerB < stackPointerA);
	}
	
	public boolean verificarSeEstaVazia()
	{
		return (stackPointerA <= ZERO);
	}
	
	public boolean verificarSePilhaBEstaVazia()
	{
		return (stackPointerB >= elementos.length-UM);
	}
	
	private final void lancarExecaoDePilhaCheiaSeNecessario()
	{
		if (verificarSeEstaCheia()) throw new ExecaoDePilhaCheia();
	}
	
	private final void lancarExecaoDePilhaVaziaSeNecessario()
	{
		if (verificarSeEstaVazia() || verificarSePilhaBEstaVazia()) throw new ExecaoDePilhaVazia();
	}
}