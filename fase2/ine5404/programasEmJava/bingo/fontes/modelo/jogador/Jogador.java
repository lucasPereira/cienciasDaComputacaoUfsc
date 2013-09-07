package modelo.jogador;

import java.util.ArrayList; 

public class Jogador 
{
	private String nome;
	private Cartela cartelaBingo;
	
	public Jogador(String valorNome)
	{
		nome = valorNome;
		cartelaBingo = new Cartela();
	}
	
	public void alterarNome(String novoNome)
	{
		nome = novoNome;
	}
	
	public void gerarCartela()
	{
		cartelaBingo.gerarCartela();
	}
	
	public ArrayList<String> fornecerStringComOsNumerosDaCartela()
	{
		return cartelaBingo.fornecerStringComOsNumerosDaCartela();
	}
	
	public void receberNovoNumeroSorteado(int novoSorteado)
	{
		cartelaBingo.receberNovoNumeroSorteado(novoSorteado);
	}
	
	public boolean fezBingo()
	{
		return cartelaBingo.fezBingo();
	}
	
	public String fornecerNomeJogador()
	{
		String nomeAPassar = nome;
		return nomeAPassar;
	}
}
