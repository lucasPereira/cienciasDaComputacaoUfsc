package modelo;

public class Pilha 
{
	private int stackPointer;
	private int[] pilha;
	
	private static final int ZERO = 0;
	private static final int UM = 1;
	
	public Pilha(int quantidadeDeElementos)
	{
		assert (quantidadeDeElementos > ZERO) : "Quantidade de elementos deve ser maior que " + ZERO;
		stackPointer = ZERO;
		pilha = new int[quantidadeDeElementos];
	}
	
	public void push(int elemento)
	{
		assert (!verificarSeEstaCheia()) : "Pilha está cheia.";
		pilha[stackPointer++] = elemento;
	}
	
	public int pop()
	{
		assert (!verificarSeEstaVazia()) : "Pilha está vazia.";
		return pilha[--stackPointer];
	}
	
	public int top()
	{
		assert (!verificarSeEstaVazia()) : "Pilha está vazia.";
		return pilha[stackPointer-UM];
	}

	private boolean verificarSeEstaCheia()
	{
		return stackPointer == pilha.length;
	}
	
	private boolean verificarSeEstaVazia() 
	{
		return stackPointer == ZERO;
	}
	
	public String fornecerElementosNaPilha()
	{
		String valoresPilha = "Topo";
		for(int cont = stackPointer-UM; cont >= 0; cont--)
		{
			valoresPilha += "\n" + pilha[cont];
		}
		valoresPilha += "\nBase";
		
		return valoresPilha;
	}
}