//Aluno: Lucas Pereira da Silva - 10100754

public class Apostadores extends Pessoas 
{
	protected int[] numerosApostados;
	protected int quantidadeNumerosApostados;
	public Apostadores(String nome, int[] numeros)
	{
		super(nome, 0, '*');
		
		/*Serve para não permitir que alguém crie um objeto com numeros apostados repetidos ou números maiores que 60 e menores que 1. Caso isso ocorra a váriavel erro recebe true e um objeto = {1, 2, 3, 4, 5, 6} é criado*/
		boolean erro = false;
		for(int cont = 0; cont < numeros.length; cont++)	
		{
			for(int cont1 = 0; cont1 < numeros.length; cont1++)	
			{
				if((cont != cont1) && (numeros[cont] == numeros[cont1]) || numeros[cont] < 1 || (numeros[cont] > 60))
				{
					erro = true;
				}
			}
		}
		
		if(numeros.length >= 6 && numeros.length <= 10 && erro == false)
		{
			quantidadeNumerosApostados = numeros.length;
			numerosApostados = new int[quantidadeNumerosApostados];
			
			for(int cont = 0; cont < quantidadeNumerosApostados; cont++)
			{
				numerosApostados[cont] = numeros[cont];
			}
		}
		else
		{
			numerosApostados = new int[]{1, 2, 3, 4, 5, 6};
		}
	}
	
	public int[] fornecaNumerosApostados()
	{
		return numerosApostados;
	}
	
	public String fornecaNome()
	{
		return nome;
	}
}