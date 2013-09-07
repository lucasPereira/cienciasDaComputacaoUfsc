package modelo.servidor;

import modelo.bingo.Sorteio; 
import java.util.ArrayList;

public class NumerosSorteados 
{
	private ArrayList<Integer> numerosSorteados;
	private int quantidadeDeNumerosParaSorteio;
		
	public NumerosSorteados()
	{
		numerosSorteados = new ArrayList<Integer>();	
		quantidadeDeNumerosParaSorteio = new Sorteio().fornecerAmplitude() + 1;
	}
	
	public void sortearNumeros()
	{
		limparNumerosSorteados();
		for(int cont = 0; cont < quantidadeDeNumerosParaSorteio; cont++)
		{
			numerosSorteados.add(sortearNumero());
		}
	}
	
	public int sortearNumero()
	{
		int numeroSorteado;
		
		do
		{
			numeroSorteado = new Sorteio().sorteie();
		}
		while(numerosSorteados.contains(numeroSorteado));
		
		return numeroSorteado;
	}
	
	public void limparNumerosSorteados()
	{
		numerosSorteados.removeAll(numerosSorteados);
	}
	
	public int fornecerQuantidadeDeNumeros()
	{
		return numerosSorteados.size();
	}
	
	public int fornecerNumero(int index)
	{
		int numeroFornecido = numerosSorteados.get(index);
		return numeroFornecido;
	}
	
}
