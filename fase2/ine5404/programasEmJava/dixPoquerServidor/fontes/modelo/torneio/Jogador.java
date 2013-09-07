package modelo.torneio;

public class Jogador 
{
	private String nome;
	private String identificador;
	private int numero;
	private boolean sempreMostarCartas;
	private ListaDeCarta cartas;
	private Ficha fichas;
	private EstadoDoJogador estado;
	
	public Jogador(String nome, int numero, Ficha fichas)
	{
		receberNome(nome);
		criarIdentificador(numero);
		this.numero = numero;
		sempreMostarCartas = false;
		fichas = new Ficha();
	}
	
	public void receberNome(String nome)
	{
		if(nome.length() == Constante.ZERO || nome == null)
		{
			nome = "Jogador " + numero;
		}
		
		this.nome = nome.substring(Constante.ZERO, Constante.NOVE);
	}
	
	public void receberCarta(Carta carta)
	{
		cartas.adicionarCarta(carta);
		//Enviar Carta Para a Fachada
	}
	
	public void receberFichas(Ficha fichas)
	{
		this.fichas.adicionarFichas(fichas);
	}
	
	private void criarIdentificador(int numero)
	{
		identificador = Constante.IDENTIFICADOR_JOGADOR + numero;
	}
}
