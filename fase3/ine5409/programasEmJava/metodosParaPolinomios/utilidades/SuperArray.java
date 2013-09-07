package utilidades;


public final class SuperArray 
{
	private int[] array;
	private int deslocamento;
	
	private static final int ZERO = 0;
	private static final int UM = 1;
	
	public SuperArray(int posicaoInicial, int posicaoFinal)
	{
		if (posicaoInicial >= posicaoFinal) throw new IllegalArgumentException("Posição final deve ser maior que posição inicial.");

		int tamanho = posicaoFinal - posicaoInicial;
		deslocamento = posicaoInicial;
		array = new int[tamanho+UM];
	}
	
	public void atribuir(int posicao, int valor)
	{
		if (posicao-deslocamento < 0) throw new IllegalArgumentException("Posição inexistente.");
		
		array[posicao-deslocamento] = valor;
	}
	
	public int acessar(int posicao)
	{
		if (posicao-deslocamento < 0) throw new IllegalArgumentException("Posição inexistente.");
		
		return array[posicao-deslocamento];
	}
	
	public String toString()
	{
		String stringArray = null;
		for(int cont = ZERO; cont < array.length; cont++)
		{
			stringArray += String.format("[%d] %d\n", cont, array[cont]);
		}
		
		return stringArray;
	}
}