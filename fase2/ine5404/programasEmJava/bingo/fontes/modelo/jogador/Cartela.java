package modelo.jogador;

import modelo.bingo.Sorteio;
import java.util.ArrayList; 

public class Cartela 
{
	private ArrayList<Integer> numerosDaCartela;
	private ArrayList<Integer> numerosJaSorteados;
	private int quantidadeDeNumerosPorCartela;
	
	public Cartela()
	{
		numerosDaCartela = new ArrayList<Integer>();
		numerosJaSorteados = new ArrayList<Integer>();
		quantidadeDeNumerosPorCartela = 15;
	}
	
	public void gerarCartela()
	{
		limparCartela();
		for(int cont = 0; cont < quantidadeDeNumerosPorCartela; cont++)
		{
			numerosDaCartela.add(sortearNumero());
		}
	}
	
	public int sortearNumero()
	{
		int numeroSorteado;
		
		do
		{
			numeroSorteado = new Sorteio().sorteie();
		}
		while(numerosDaCartela.contains(numeroSorteado));
		
		return numeroSorteado;
	}
	
	public void limparCartela()
	{
		numerosDaCartela.removeAll(numerosDaCartela);
	}
	
	public ArrayList<String> fornecerStringComOsNumerosDaCartela()
	{
		ArrayList<String> stringNumerosDaCartela = new ArrayList<String>();
		for(int cont = 0; cont < quantidadeDeNumerosPorCartela; cont++)
		{
			stringNumerosDaCartela.add(numerosDaCartela.get(cont)+"");
		}
		return stringNumerosDaCartela;
	}
	
	public void receberNovoNumeroSorteado(int novoSorteado)
	{
		if(numerosDaCartela.contains(novoSorteado))
		{
			numerosJaSorteados.add(novoSorteado);
			numerosDaCartela.remove(numerosDaCartela.indexOf(novoSorteado));
		}
	}
	
	public boolean fezBingo()
	{
		return (numerosDaCartela.isEmpty() && numerosJaSorteados.size() == quantidadeDeNumerosPorCartela);
	}
}
