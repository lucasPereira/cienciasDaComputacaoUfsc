package modelo.torneio;

public class Ficha 
{
	private int quantidade;
	
	public Ficha()
	{
		quantidade = Constante.ZERO;
	}
	
	public Ficha(int quantidade)
	{
		adicionarFichas(quantidade);
	}
	
	public void alterarQuantidade(int quantidade)
	{
		if(validarQuantidadeMaiorQueZero(quantidade))
		{
			this.quantidade = quantidade; 
		}
	}
	
	public void adicionarFichas(int quantidade)
	{
		if(validarQuantidadeMaiorQueZero(quantidade))
		{
			this.quantidade += quantidade;
		}
	}
	
	public void adicionarFichas(Ficha fichas)
	{
		adicionarFichas(fichas.quantidade);
	}
	
	public void removerFichas(int quantidade)
	{
		if(validarQuantidadeMaiorQueZero(quantidade) && validarQuantidadeMaiorQueQuantidadeRemovida(quantidade))
		{
			this.quantidade -= quantidade;
		}
	}
	
	public void zerarFichas()
	{
		quantidade = Constante.ZERO;
	}
	
	private boolean validarQuantidadeMaiorQueZero(int quantidade)
	{
		return quantidade >= Constante.ZERO;
	}
	
	private boolean validarQuantidadeMaiorQueQuantidadeRemovida(int quantidade)
	{
		return this.quantidade >= quantidade;
	}
}
