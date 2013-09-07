package modelo.torneio;

public class ControleDoTorneio 
{
	private Torneio torneio;
	private ListaDeJogador jogadoresDoTorneio;
	private ListaDeJogador jogadoresNaMao;
	private ListaDeJogador jogadoresForaDaMao;
	private Dealer dealer;
	private Board board;
	private Mao mao;
	private EstadoDoTorneio estadoDoTorneio;
	private ConjuntoDeAcaoPossivel acaoPossivelDoJogador;
	private Tempo tempoMaximoParaJogar;
	private Blind smallBlinds;
	private Blind bigBlinds;
	
	public void adicionarJogadorAoTorneio(String nome)
	{
		if(torneio.verificarSeEstaAguardando())
		{
			jogadoresDoTorneio.adicionarJogador(torneio.adicionarJogador(nome));
		}
		else
		{
			//Enviar Tupla Avisando
		}
		//É eu sei, if-else fede mas não achei outra opcão
	}
	
}
