package modelo.jogador;

import modelo.bingo.Sorteio;
import comunicacaoEmRede.EnvioDeJogadorVencedor;  
import comunicacaoEmRede.RecebimentoDeJogadorVencedor;
import comunicacaoEmRede.RecebimentoDeNumeroSorteado; 
import controle.IniciarTratadoresJogador;
import visao.InterfaceCartela;
import visao.InterfaceJogador;
import visao.InterfaceNumerosJaSorteados;
import static edugraf.jadix.tiposPrimitivos.ElementoGenerico.NUMERO;
import static edugraf.jadix.tiposPrimitivos.ElementoGenerico.TEXTO;

public class FachadaJogador 
{
	private Jogador jogadorBingo;
	private InterfaceCartela interfaceCartela;
	private InterfaceJogador interfaceJogador;
	private InterfaceNumerosJaSorteados interfaceNumerosJaSorteados;
	private int numeroAtualSorteado;
	private int quantidadeDeNumerosSorteados;
	
	public FachadaJogador()
	{
		jogadorBingo = new Jogador("Visitante");
		interfaceCartela = new InterfaceCartela(this);
		interfaceJogador = new InterfaceJogador(this);
		interfaceNumerosJaSorteados = new InterfaceNumerosJaSorteados();
		numeroAtualSorteado = 1;
		quantidadeDeNumerosSorteados = new Sorteio().fornecerAmplitude() + 1;
		
		new RecebimentoDeNumeroSorteado(this, interfaceNumerosJaSorteados).para(NUMERO);
		new RecebimentoDeJogadorVencedor(this).para(TEXTO);
		new IniciarTratadoresJogador(this);
	}

	public void pegarCartela(String nomeJogador)
	{
		jogadorBingo.gerarCartela();
		jogadorBingo.alterarNome(nomeJogador);
		interfaceCartela.limparCartela();
		interfaceCartela.mostrarCartela(jogadorBingo.fornecerStringComOsNumerosDaCartela());
	}
	
	public void marcarCelula(String nomeDaCelula)
	{
		interfaceCartela.marcarCelula(nomeDaCelula);
	}
	
	public void desmarcarCelula(String nomeDaCelula)
	{
		interfaceCartela.desmarcarCelula(nomeDaCelula);
	}
	
	public void gritarBingo()
	{
		if(jogadorBingo.fezBingo())
		{
			String nomeDoJogador = jogadorBingo.fornecerNomeJogador();
			new EnvioDeJogadorVencedor(this, nomeDoJogador).enviarJogadorVencedor();
		}
	}
	
	public void receberJogadorVencedor(String nomeDoJogador)
	{
		interfaceJogador.mostrarVencedor(nomeDoJogador);
		
		String nome = jogadorBingo.fornecerNomeJogador();
		jogadorBingo = new Jogador(nome);
		interfaceCartela.limparCartela();
		interfaceNumerosJaSorteados.limparNumerosJaSorteados();
	}
	
	public void receberNovoNumeroSorteado(int novoSorteado)
	{
		if(numeroAtualSorteado > quantidadeDeNumerosSorteados)
		{
			interfaceNumerosJaSorteados.limparNumerosJaSorteados();
			numeroAtualSorteado = 0;
		}
		numeroAtualSorteado++;
		jogadorBingo.receberNovoNumeroSorteado(novoSorteado);
	}
}