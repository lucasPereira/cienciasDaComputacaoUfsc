public class Principal 
{
	public static void main(String[] parametro)
	{
		Interface comunicaUsuario = new Interface();
		int[] sorteados = new int[20];
		
		for(int cont = 0; cont < 20; cont++)
		{
			sorteados[cont] = (int)(Math.random()*51)+50;
		}
		comunicaUsuario.mostreSorteados(sorteados);
		
		Principal pares = new Principal();
		int[] sorteadosPares = pares.fornecaPares(sorteados);
		comunicaUsuario.mostreSorteados(sorteadosPares);
	}
	
	public int[] fornecaPares(int[] sorteados)
	{
		int posicao = 0;
		int tamanho = sorteados.length;
		int sorteioPares = 0;
			
		for(int cont = 0; cont < tamanho; cont++)
		{
			if(sorteados[cont]%2 == 0)
			{
				sorteioPares++;
			}
		}
		
		int[] sorteadosPares = new int[sorteioPares];
		for(int cont = 0; cont < tamanho; cont++)
		{
			if(sorteados[cont]%2 == 0)
			{
				sorteadosPares[posicao++] = sorteados[cont];
			}
		}
		return sorteadosPares;
	}
}
