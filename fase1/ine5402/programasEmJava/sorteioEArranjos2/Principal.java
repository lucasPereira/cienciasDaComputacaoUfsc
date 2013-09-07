public class Principal 
{
	public static void main(String[] paramentro)
	{
		int faixa = Interface.pecaFaixa();
		int quantidade = Interface.pecaQuantidade();
		int[] sorteados = Principal.sorteio(faixa, quantidade);
		Interface.mostreSorteados(sorteados, quantidade);
	}
	
	public static int[] sorteio(int faixa, int quantidade)
	{
		int[] sorteados = new int[faixa+1];
		for(int cont = 0; cont < quantidade; cont++)
		{
			int sorteado = (int)(Math.random()*(faixa+1));
			sorteados[sorteado]++;
		}
		return sorteados;
	}
}
