package modelo;

import java.util.List;

public class Jogador 
{
	private static final int DEZ_MIL = 10000;
	
	private int identificadorNumerico;
	private Cartela cartelaBingo;
	
	public Jogador()
	{
		cartelaBingo = new Cartela();
		gerarIdentificador();
	}
	
	public void receberCartela(List<Integer> numerosFornecidos)
	{
		cartelaBingo.receberCartela(numerosFornecidos);
	}
	
	public List<String> fornecrStringComOsNumerosDaCartela()
	{
		return cartelaBingo.fornecerStringComOsNumerosDaCartela();
	}
	
	public String fornecerIdentificadorTextual()
	{
		return "@identificadorJogador:" + identificadorNumerico;
	}
	
	public void gerarIdentificador()
	{
		identificadorNumerico = (int)(Math.random() * DEZ_MIL);
	}
	
	public boolean verificarSeIdentificadorEstaCorreto(String identificador)
	{
		String identificadorTextual = fornecerIdentificadorTextual();
		return identificadorTextual.equals(identificador);
	}
}