package modelo.torneio;

import java.util.ArrayList;
import java.util.List;

public class Blind 
{
	private List<Integer> blinds;
	private int numeroDeMaosPorBlind;
	private int maoAtual;
	private int posicaoBlindAtual;
	
	public Blind()
	{
		blinds = new ArrayList<Integer>();
		numeroDeMaosPorBlind = Constante.DEZ;
		maoAtual = Constante.ZERO;
		posicaoBlindAtual = Constante.ZERO;
	}
	
	public int iniciarNovaMao()
	{
		calcularPosicaoBlindAtual();
				
		return blinds.get(posicaoBlindAtual);
	}
	
	
	private void calcularPosicaoBlindAtual()
	{
		if(!verificarSeEstaNoBlindFinal() && ++maoAtual % numeroDeMaosPorBlind == 0)
		{
			posicaoBlindAtual++;
		}
	}
	
	private boolean verificarSeEstaNoBlindFinal()
	{
		return (maoAtual >= blinds.size());
	}
}
