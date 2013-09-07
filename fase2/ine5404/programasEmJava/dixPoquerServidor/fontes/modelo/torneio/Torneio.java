package modelo.torneio;

public class Torneio 
{
	public static final String identificador = criarIdentificador();
	private int numeroDeJogadores;
	private int numeroDeJogadoresInscritos;
	private Ficha stackInicialDeCadaJogador;
	private EstadoDoTorneio estado;
	
	public Torneio(int numeroDeJogadores, int stackInicialDeCadaJogador, int tempoMaximoParaJogar)
	{
		this.numeroDeJogadores = validarNumeroDeJogadores(numeroDeJogadores);
		numeroDeJogadoresInscritos = Constante.ZERO;
		this.stackInicialDeCadaJogador = new Ficha(stackInicialDeCadaJogador);
		estado = EstadoDoTorneio.AGUARDANDO;
	}
	
	private static String criarIdentificador()
	{
		return Constante.IDENTIFICADOR_TORNEIO + (int)(Math.random() *  Constante.DEZMIL);	
	}
	
	public boolean verificarSeEstaAguardando()
	{
		return (estado.verificarSeTorneioEstaAguardando(estado));
	}
	
	public Jogador adicionarJogador(String nome)
	{
		++numeroDeJogadoresInscritos;
		if(verificarSeExisteVaga())
		{
			estado = EstadoDoTorneio.ANDAMENTO;
		}
		return new Jogador(nome, numeroDeJogadoresInscritos, stackInicialDeCadaJogador);
	}
	
	private boolean verificarSeExisteVaga()
	{
		return (numeroDeJogadores <= numeroDeJogadoresInscritos);
	}
	
	private int validarNumeroDeJogadores(int valorNumeroDejogadores)
	{
		if(valorNumeroDejogadores < Constante.DOIS)
		{
			valorNumeroDejogadores = Constante.DOIS;
		}
		if(valorNumeroDejogadores > Constante.NOVE)
		{
			valorNumeroDejogadores = Constante.NOVE;
		}
		
		return valorNumeroDejogadores;
	}
}