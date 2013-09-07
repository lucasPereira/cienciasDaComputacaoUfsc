package modelo;

import java.util.ArrayList;
import java.util.List; 

public class Cartela 
{
	private static final int ZERO = 0;
	
	private List<Integer> numerosDaCartela;
	
	public Cartela()
	{
		numerosDaCartela = new ArrayList<Integer>();
	}
	
	public void receberCartela(List<Integer> numerosFornecidos)
	{
		numerosDaCartela = numerosFornecidos;
	}
	
	public List<String> fornecerStringComOsNumerosDaCartela()
	{
		List<String> stringComNumerosDaCartela = new ArrayList<String>();
		
		for(int cont = ZERO; cont < numerosDaCartela.size(); cont++)
		{
			String numero = numerosDaCartela.get(cont) + "";
			double numeroDouble = Double.parseDouble(numero);
			int numeroInteiro = (int)numeroDouble;
			
			stringComNumerosDaCartela.add(numeroInteiro+"");
		}
		return stringComNumerosDaCartela;
	}
}
