package modelo.cartela;

public class FabricaDeCartela extends FabricaAbstrataDeCartela 
{
	private final int QUANTIDADE_DE_NUMEROS;
	private final int NUMERO_MAXIMO;
	
	public FabricaDeCartela(int quantidadeDeNumeros, int numeroMaximo)
	{
		QUANTIDADE_DE_NUMEROS = quantidadeDeNumeros;
		NUMERO_MAXIMO = numeroMaximo;
	}
	
	public TipoCartela criarCartela() 
	{
		return new Cartela(QUANTIDADE_DE_NUMEROS, NUMERO_MAXIMO);
	}
}
