package modelo.torneio;

public class Tempo  extends Thread
{
	private int tempoEmSegundos;
	
	public Tempo (int tempoEmSegundos)
	{
		this.tempoEmSegundos = validarTempo(tempoEmSegundos);
	}
	
	public void esperarTempo() throws InterruptedException
	{
		Thread.sleep(calcularTempoEmMilesimos());
	}
	
	private int calcularTempoEmMilesimos()
	{
		return tempoEmSegundos * Constante.MIL;
	}
	
	private int validarTempo(int tempoEmSegundos)
	{
		if(tempoEmSegundos < Constante.DEZ)
		{
			tempoEmSegundos = Constante.DEZ;
		}
		if(tempoEmSegundos > Constante.SEISCENTOS)
		{
			tempoEmSegundos = Constante.SEISCENTOS;
		}
		
		return tempoEmSegundos;
	}
}
