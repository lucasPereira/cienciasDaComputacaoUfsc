package modelo.torneio;

public enum EstadoDoTorneio 
{
	AGUARDANDO, ANDAMENTO, FINALIZADO;
	
	public boolean verificarSeTorneioEstaAguardando(EstadoDoTorneio estado)
	{
		return AGUARDANDO.equals(estado);
	}
	
	public boolean verificarSeTorneioEstaEmAndamento(EstadoDoTorneio estado)
	{
		return ANDAMENTO.equals(estado);
	}
	
	public boolean verificarSeTorneioEstaFinalizado(EstadoDoTorneio estado)
	{
		return FINALIZADO.equals(estado);
	}
}
