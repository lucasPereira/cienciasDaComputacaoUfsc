package modelo;

import static edugraf.jadix.tiposPrimitivos.ElementoGenerico.LISTA;
import static edugraf.jadix.tiposPrimitivos.ElementoGenerico.TEXTO;
import static edugraf.jadix.tiposPrimitivos.ElementoGenerico.NUMERO;

import java.util.List;

import rede.EnvioDeGritoDeBingo;
import rede.EnvioDePedidoDeCartela;
import rede.RecebimentoDeCartela;
import rede.RecebimentoDeJogadorVencedorEMensagens;
import rede.RecebimentoDeNumeroSorteado;

import visao.VisaoCartela;
import visao.VisaoJogador;
import visao.VisaoNumerosJaSorteados;


import controle.IniciarTratadoresJogador;

public class FachadaJogador 
{
	private Jogador jogadorBingo;
	private VisaoCartela visaoDaCartela;
	private VisaoJogador vidaoDoJogador;
	private VisaoNumerosJaSorteados visaoDeNumerosJaSorteados;
	private String identificadorServidor;
	
	public FachadaJogador(String valorIdentificadorServidor)
	{
		System.out.println("[Fachada] Fachada Iniciada");
	
		identificadorServidor = valorIdentificadorServidor;
		jogadorBingo = new Jogador();
		visaoDaCartela = new VisaoCartela(this);
		vidaoDoJogador = new VisaoJogador(this);
		visaoDeNumerosJaSorteados = new VisaoNumerosJaSorteados();
		
		System.out.println("[Identificador do Servidor] " + identificadorServidor);
		System.out.println("[Identificador do Jogador] " + jogadorBingo.fornecerIdentificadorTextual());
		
		new IniciarTratadoresJogador(this, visaoDaCartela);
		
		vidaoDoJogador.mostrarMensagem(vidaoDoJogador.fornecerMensagemDeServidorEncontrado());
	}
	
	public void pegarCartela(String nomeJogador)
	{
		vidaoDoJogador.desabilitarCampoNomeJogador();
		vidaoDoJogador.desabilitarBotaoPegarCartela();
		vidaoDoJogador.habilitarBotaoGritarBingo();
		
		new RecebimentoDeNumeroSorteado(this, visaoDeNumerosJaSorteados).para(TEXTO, TEXTO, NUMERO);
		new RecebimentoDeJogadorVencedorEMensagens(this).para(TEXTO, TEXTO, TEXTO);
		new RecebimentoDeCartela(this).para(TEXTO, TEXTO, TEXTO, LISTA);
		new EnvioDePedidoDeCartela().enviarPedidoDeCartelar(identificadorServidor, jogadorBingo.fornecerIdentificadorTextual());
	}
	
	public void receberCartela(List<Integer> numerosDaCartela)
	{
		jogadorBingo.receberCartela(numerosDaCartela);
		visaoDaCartela.limparCartela();
		visaoDaCartela.mostrarCartela(jogadorBingo.fornecrStringComOsNumerosDaCartela());
	}
	
	public void receberMensagem(String mensagem)
	{
		vidaoDoJogador.mostrarMensagem(mensagem);
	}
	
	public void gritarBingo()
	{
		new EnvioDeGritoDeBingo().gritarBingo(identificadorServidor, jogadorBingo.fornecerIdentificadorTextual(), vidaoDoJogador.fornecerNomeJogador());
	}
	
	public void receberJogadorVencedor(String nomeDoJogador)
	{
		vidaoDoJogador.mostrarVencedor(nomeDoJogador);
		
		jogadorBingo = new Jogador();
		visaoDaCartela.limparCartela();
		visaoDeNumerosJaSorteados.limparNumerosJaSorteados();
		
		vidaoDoJogador.habilitarCampoNomeJogador();
		vidaoDoJogador.habilitarBotaoPegarCartela();
		vidaoDoJogador.desabilitarBotaoGritarBingo();
	}
	
	public boolean verificarSeOServidorEstaCorreto(String servidor)
	{
		return identificadorServidor.equals(servidor);
	}
	
	public boolean verificaSeOJogadorEstaCorreto(String jogador)
	{
		return jogadorBingo.verificarSeIdentificadorEstaCorreto(jogador);
	}
}