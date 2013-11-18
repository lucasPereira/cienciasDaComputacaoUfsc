package br.ufsc.ine5418.atualizacaoDeAntivirus;

import java.util.Date;
import java.util.LinkedList;

import br.ufsc.ine5418.atualizacaoDeAntivirus.Protocolo.TipoDeAcao;
import br.ufsc.ine5418.atualizacaoDeAntivirus.comunicacao.ClienteMulticast;
import br.ufsc.ine5418.atualizacaoDeAntivirus.comunicacao.ClienteStream;
import br.ufsc.ine5418.atualizacaoDeAntivirus.comunicacao.ServidorStream;

public final class ClienteDeAntivirus extends ProvedorDeAtualizacao {
	
	private ClienteMulticast clienteMulticast;
	private ClienteStream clienteStream;
	private ServidorStream servidorStream;
	private int portaDeComunicaçãoTcp;
	private LinkedList<Date> atualizações;
	private boolean soliciteiVersão;
	private Date maiorVersãoDisponívelConhecida;
	private int portaDeComunicaçãoTcpDoAtualizador;
	private AtualizacaoDeAntivirus fachada;
	private static int quantidadeDeClientes = 0;
	private static final String ENDEREÇO_DOS_CLIENTES = "127.0.0.1";
	private static final String GRUPO_MULTICAST = "239.0.0.1";
	private static final int PORTA_MULTICAST = 7000;
	private static final int PORTA_DE_COMINICAÇÃO_TCP_DO_SERVIDOR_CENTRAL = 7000;
	private static final int TEMPO_DE_ESPERA_POR_VERSÕES = 2000;
	private static final String CRLF = "\r\n";
	
	public ClienteDeAntivirus(AtualizacaoDeAntivirus fachada) {
		this.fachada = fachada;
		portaDeComunicaçãoTcp = ++quantidadeDeClientes+7000;
		atualizações = new LinkedList<Date>();
		atualizações.add(new Date());
		soliciteiVersão = false;
		maiorVersãoDisponívelConhecida = atualizações.getFirst();
		portaDeComunicaçãoTcpDoAtualizador = portaDeComunicaçãoTcp;
		clienteMulticast = new ClienteMulticast(GRUPO_MULTICAST, PORTA_MULTICAST) {
			@Override
			public void receberPacote(String dados) {
				receberPacoteMulticast(dados);
			}
		};
		servidorStream = new ServidorStream(portaDeComunicaçãoTcp) {
			@Override
			public String processarRequisição(String dados) {
				return processarRequisiçãoStream(atualizações, portaDeComunicaçãoTcp, dados);
			}
		};
		clienteStream = new ClienteStream();
		clienteMulticast.iniciarRecebimento();
		servidorStream.iniciarRecebimento();
	}
	
	private void enviarVersão() {
		Protocolo protocolo = new Protocolo(portaDeComunicaçãoTcp, TipoDeAcao.ENVIO_DE_VERSÃO, atualizações.getFirst());
		clienteMulticast.enviarPacote(protocolo.codificarProtocoloParaEnvio());
	}
	
	private void solicitarVersão() {
		soliciteiVersão = true;
		Protocolo protocolo = new Protocolo(portaDeComunicaçãoTcp, TipoDeAcao.PEDIDO_DE_VERSÃO, atualizações.getFirst());
		clienteMulticast.enviarPacote(protocolo.codificarProtocoloParaEnvio());
		solicitarAtualização();
	}

	private synchronized void solicitarAtualização() {
		try {
			wait(TEMPO_DE_ESPERA_POR_VERSÕES);
		} catch (InterruptedException erro) {
			erro.printStackTrace();
		}
		soliciteiVersão = false;
		if (atualizações.getFirst().compareTo(maiorVersãoDisponívelConhecida) < 0) {
			buscarAtualizações(portaDeComunicaçãoTcpDoAtualizador);
		}
		buscarAtualizações(PORTA_DE_COMINICAÇÃO_TCP_DO_SERVIDOR_CENTRAL);
	}
	
	public void buscarAtualizações(int portaDeComunicaçãoTcpDoFornecedor) {
		Protocolo mensagemDeSolicitaçãoDeAtualização = new Protocolo(portaDeComunicaçãoTcp, TipoDeAcao.PEDIDO_DE_ATUALIZAÇÃO, atualizações.getFirst());
		String dadosRecebidos = clienteStream.enviarRequisição(mensagemDeSolicitaçãoDeAtualização.codificarProtocoloParaEnvio(), ENDEREÇO_DOS_CLIENTES, portaDeComunicaçãoTcpDoFornecedor);
		String[] versõesAtualizadas = dadosRecebidos.split(CRLF);
		for (String versãoAtualizada : versõesAtualizadas) {
			if (!versãoAtualizada.equals(CRLF) && !versãoAtualizada.equals("")) {
				Protocolo mensagemComNovaVersão = Protocolo.decodificarProtocoloRecebido(versãoAtualizada);
				Date novaVersão = mensagemComNovaVersão.fornecerVersão();
				if (atualizações.getFirst().compareTo(novaVersão) < 0) {
					atualizações.addFirst(novaVersão);
					fachada.adicionarAtualizaçãoRecebida(portaDeComunicaçãoTcp, novaVersão, mensagemComNovaVersão.fornecerPortaDeComunicaçãoTcp());
					fachada.atualizarVersão(portaDeComunicaçãoTcp, novaVersão);
				}
			}
		}
		maiorVersãoDisponívelConhecida = atualizações.getFirst();
		portaDeComunicaçãoTcpDoAtualizador = portaDeComunicaçãoTcp;
	}
	
	public void forçarAtualização() {
		solicitarVersão();
	}
	
	public int fornecerPortaDeComunicaçãoTcp() {
		return portaDeComunicaçãoTcp;
	}
	
	public Date fornecerVersão() {
		return atualizações.getFirst();
	}
	
	private void receberPacoteMulticast(String dados) {
		Protocolo mensagemRecebida = Protocolo.decodificarProtocoloRecebido(dados);
		TipoDeAcao tipoDeAção = mensagemRecebida.fornecerTipoDeAcao();
		Date versãoDeQuemEnviouAMensagem = mensagemRecebida.fornecerVersão();
		int portaDeComunicãoTcpDeQuemEnviouAMesangem = mensagemRecebida.fornecerPortaDeComunicaçãoTcp();
		boolean pacoteNãoÉMeu = portaDeComunicaçãoTcp != mensagemRecebida.fornecerPortaDeComunicaçãoTcp();
		if (tipoDeAção.equals(TipoDeAcao.PEDIDO_DE_VERSÃO) && pacoteNãoÉMeu) {
			enviarVersão();
		} else {
			if (tipoDeAção.equals(TipoDeAcao.ENVIO_DE_VERSÃO) && soliciteiVersão && pacoteNãoÉMeu) {
				fachada.adicionarVersãoRecebida(portaDeComunicaçãoTcp, versãoDeQuemEnviouAMensagem, portaDeComunicãoTcpDeQuemEnviouAMesangem);
				if (versãoDeQuemEnviouAMensagem.compareTo(atualizações.getFirst()) > 0 && versãoDeQuemEnviouAMensagem.compareTo(maiorVersãoDisponívelConhecida) > 0) {
					maiorVersãoDisponívelConhecida = versãoDeQuemEnviouAMensagem;
					portaDeComunicaçãoTcpDoAtualizador = portaDeComunicãoTcpDeQuemEnviouAMesangem;
				}
			}
		}
	}
}
