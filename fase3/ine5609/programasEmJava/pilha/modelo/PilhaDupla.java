package modelo;

public class PilhaDupla 
{
	private static final int UM = 1;
	private static final int ZERO = 0;
	
	private int stackPointerA;
	private int stackPointerB;
	private int[] pilha;
	
	public PilhaDupla(int quantidadeDeElementos)
	{
		assert (quantidadeDeElementos > 0) : "Quantidade de elementos deve ser maior que 0.";
		pilha = new int[quantidadeDeElementos];
		stackPointerA = pilha.length - UM;
		stackPointerB = ZERO;
	}
	
	public void pushA(int elemento)
	{
		assert (!pilhaEstaCheia()) : "Pilha está cheia.";
		pilha[stackPointerA--] = elemento;
	}
	
	public void pushB(int elemento)
	{
		assert (!pilhaEstaCheia()) : "Pilha está cheia.";
		pilha[stackPointerB++] = elemento;
	}
	
	public int popA()
	{
		assert (!pilhaAEstaVazia()) : "Pilha A está vazia.";
		return pilha[++stackPointerA];
	}
	
	public int popB()
	{
		assert (!pilhaBEstaVazia()) : "Pilha B está vazia.";
		return pilha[--stackPointerB];
	}
	
	public int topA()
	{
		assert (!pilhaAEstaVazia()) : "Pilha A está vazia.";
		return pilha[stackPointerA + UM];
	}
	
	public int topB()
	{
		assert(!pilhaBEstaVazia()) : "Pilha B está vazia.";
		return pilha[stackPointerB - UM];
	}
	
	public boolean pilhaEstaCheia()
	{
		return (stackPointerA + UM == stackPointerB) || (stackPointerB - UM == stackPointerA);
	}
	
	public boolean pilhaAEstaVazia()
	{
		return stackPointerA == pilha.length - UM;
	}
	
	public boolean pilhaBEstaVazia()
	{
		return stackPointerB == ZERO;
	}
	
	public int fornecerQuantidadeDeElementosA()
	{
		return stackPointerA;
	}
	
	public int fornecerQuantidadeDeElementosB()
	{
		return stackPointerA;
	}
}