package modelo.torneio;

import java.util.ArrayList;
import java.util.List;

public class ValorBlind 
{
	public static final int numeroDeMaosPorBlind = Constante.DEZ;
	private List<Integer> valorBlinds;          
	private int posicaoBlindAtual;
	private int maoAtual;
	
	public ValorBlind()
	{
		valorBlinds = new ArrayList<Integer>();
		posicaoBlindAtual = Constante.ZERO;
		maoAtual = Constante.ZERO;
	}
	
	public boolean verificarBlindFinal()
	{
		return (posicaoBlindAtual + Constante.UM) >= valorBlinds.size();
	}
	
	public int iniciarNovaMao()
	{
		maoAtual++;
		if((maoAtual - Constante.UM) % numeroDeMaosPorBlind == Constante.ZERO && !verificarBlindFinal())
		{
			posicaoBlindAtual++;
		}
		
		return valorBlinds.get(posicaoBlindAtual);
	}
	
	public int fornecerBlindAtual()
	{
		return valorBlinds.get(posicaoBlindAtual);
	}
}