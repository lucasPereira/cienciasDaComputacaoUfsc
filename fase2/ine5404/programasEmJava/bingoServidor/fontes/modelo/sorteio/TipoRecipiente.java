package modelo.sorteio;

public interface TipoRecipiente 
{	
	public void guardarBolinha(int valorBolinha);
	
	public boolean verificarSeValorEstaNoRecipiente(int valor);
	
	public int fornecerQuantidadeDeBolinhas();
}
