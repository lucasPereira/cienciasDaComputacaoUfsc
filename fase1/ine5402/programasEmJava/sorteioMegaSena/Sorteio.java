//Aluno: Lucas Pereira da Silva - 10100754

public class Sorteio 
{
	protected int[] sorteados = new int[6];
	public Sorteio()
	{
		boolean numeroRepetido = false;
		for(int cont = 0; cont < 6; cont++)
		{
			do
			{
				sorteados[cont] = (int)(Math.random()*60)+1;
				numeroRepetido = false;
				for(int cont1 = 0; cont1 < cont; cont1++)
				{
					if(sorteados[cont] == sorteados[cont1])
					{
						numeroRepetido = true;
					}
				}
			}
			while(numeroRepetido);
		}
	}
	
	
	public int[] fornecaSorteio()
	{
		return sorteados;
	}
	
	public int fornecaNumeroAcertos(int[] numerosApostados)
	{
		int quantidadeNumerosApostados = numerosApostados.length;
		int acertos = 0;
		for(int cont = 0; cont < 6; cont++)
		{
			for(int cont1 = 0; cont1 < quantidadeNumerosApostados; cont1++)
			{
				if(sorteados[cont] == numerosApostados[cont1])
				{
					acertos++;
				}
			}
		}
		return acertos;
	}
	
	public void ordeneSorteio()
	{
		for(int cont = 0; cont < 5; cont++)
		{
			int posicaoMenor = cont;
			int menor = sorteados[cont];
			for(int cont1 = cont; cont1 < 6; cont1++)
			{
				if(sorteados[cont1] < menor)
				{
					menor = sorteados[cont1];
					posicaoMenor = cont1;
				}
			}
			int troca = sorteados[cont];
			sorteados[cont] = sorteados[posicaoMenor];
			sorteados[posicaoMenor] = troca; 
		}
	}
}
