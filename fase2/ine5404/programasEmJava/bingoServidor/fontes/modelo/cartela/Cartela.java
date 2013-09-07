package modelo.cartela;

import java.util.List;

import modelo.sorteio.TipoRecipiente;

public class Cartela extends CartelaAbstrata
{
	private static final int UM = 1;
	private static final int ZERO = 0;
	
	private List<Integer> numeros;
	
	public Cartela(int quantidadeDeNumeros, int numeroMaximo)
	{
		assert(quantidadeDeNumeros <= numeroMaximo) : "Quantidade de números deve ser menor ou igual ao número máximo."; 
		assert(quantidadeDeNumeros >= UM && numeroMaximo >= UM) : "Quantidade de números e número máximo devem ser maior ou igual a um.";
		
		numeros = gerarCartela(quantidadeDeNumeros, numeroMaximo);
	}

	public final boolean verificarSeFezBingo(TipoRecipiente numerosSorteados) 
	{
		int quantidadeDeNumerosSorteados = ZERO;
		
		for(Integer numero : numeros)
		{
			quantidadeDeNumerosSorteados = contarSeNumeroFoiSorteado(numero, quantidadeDeNumerosSorteados, numerosSorteados);
		}
		
		return (quantidadeDeNumerosSorteados == numeros.size());
	}
	
	private final int contarSeNumeroFoiSorteado(int numero, int cont, TipoRecipiente numerosSorteados)
	{
		if(numerosSorteados.verificarSeValorEstaNoRecipiente(numero))
		{
			cont++;
		}
		
		return cont;
	}
	
	public final List<String> fornecerListaComOsValores() 
	{
		return fornecerListaComOsValores(numeros);		
	}
}