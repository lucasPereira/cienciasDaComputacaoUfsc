package modelo.cartela;

public class FabricaDeCartelaQuadrada extends FabricaAbstrataDeCartela
{
	private final int ORDEM;
	private final int NUMERO_MAXIMO;
	
	public FabricaDeCartelaQuadrada(int ordem, int numeroMaximo)
	{
		ORDEM = ordem;
		NUMERO_MAXIMO = numeroMaximo;
	}
	
	public final TipoCartela criarCartela() 
	{
		return new CartelaQuadrada(ORDEM, NUMERO_MAXIMO);
	}
}