package modelo;

public class Fila 
{
	private int inicio;
	private int fim;
	private int quantidadeDeElementos;
	private int[] fila;
	
	private static final int ZERO = 0;
	
	public Fila(int quantidadeDeElementos)
	{
		assert (quantidadeDeElementos > ZERO) : "Quantidade de elementos deve ser maior que " + ZERO;
		inicio = ZERO;
		fim = ZERO;
		this.quantidadeDeElementos = ZERO;
		fila = new int[quantidadeDeElementos];
	}
	
	public final void entrar(int elemento)
	{
		assert (quantidadeDeElementos < fila.length) : "Fila está cheia";
		fila[fim++] = elemento;
		fim = darVolta(fim);
		quantidadeDeElementos++;
	}
	
	public final int sair()
	{
		assert (quantidadeDeElementos > ZERO) : "Fila está vazia";
		int valor = fila[inicio++];
		inicio = darVolta(inicio);
		quantidadeDeElementos--;
		
		return valor;
	}
	
	public final int primeiro()
	{
		assert (quantidadeDeElementos > ZERO) : "Fila está vazia";
		
		return fila[inicio];
	}
	
	private final int darVolta(int ponteiro)
	{
		return (ponteiro == fila.length) ? ZERO : ponteiro;
	}
	
	public final String fornecerElementosNaFila()
	{
		String valoresFila = "Inicio: ";
		int proximo = inicio;
		for (int cont = 0; cont < quantidadeDeElementos; cont++)
		{
			valoresFila += "(" + fila[proximo++] + ") ";
			proximo = darVolta(proximo);
		}
		valoresFila += ":Fim";
		
		return valoresFila;
	}
}