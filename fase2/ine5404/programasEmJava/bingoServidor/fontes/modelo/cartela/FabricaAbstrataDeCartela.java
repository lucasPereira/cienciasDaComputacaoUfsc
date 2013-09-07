package modelo.cartela;

public abstract class FabricaAbstrataDeCartela implements TipoFabricaDeCartela 
{
	public static final TipoFabricaDeCartela fornecerFabricaDeCartelaQuadrada(int ordem, int numeroMaximo)
	{
		return new FabricaDeCartelaQuadrada(ordem, numeroMaximo);
	}

	public static final TipoFabricaDeCartela fornecerFabricaDeCartela(int quantidadeDeNumeros, int numeroMaximo) 
	{
		return new FabricaDeCartela(quantidadeDeNumeros, numeroMaximo);
	}
}
