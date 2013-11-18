package br.lucaspereira.caingangue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import br.lucaspereira.caingangue.http.requisicao.Requisicao;
import br.lucaspereira.caingangue.http.resposta.FabricaDeResposta;
import br.lucaspereira.caingangue.http.resposta.TipoResposta;

public class Servidor {
	
	private ServerSocket socketDoServidor;
	
	private static final int TAMANHO_DO_BUFFER = 2048;
	
	public Servidor(int porta, String endereçoBase)  {
		try {
			socketDoServidor = new ServerSocket(porta, 1, InetAddress.getByName(endereçoBase));
		} catch (UnknownHostException erro) {
			RegistroDeEventos.registrarEvento("Erro ao iniciar o servidor. Endereço base não encontrado. Finalizando programa");
			System.exit(-1);
		} catch (IOException e) {
			RegistroDeEventos.registrarEvento("Erro ao iniciar o servidor. Houve um problema na criação do socket ou o servidor já está iniciado. Finalizando programa");
			System.exit(-1);
		}

		RegistroDeEventos.registrarEvento("Servidor iniciado em "+endereçoBase+":"+porta);
		aguardarRequisição();
	}
	
	private void aguardarRequisição() {
		while (true) {
			RegistroDeEventos.registrarEvento("Aguardando requisição do cliente");
			Socket socketDoCliente;
			InputStream arquivoDeEntrada;
			OutputStream arquivoDeSaída;
			try {
				socketDoCliente = socketDoServidor.accept();
				RegistroDeEventos.registrarEvento("Cliente conectado com o IP: "+socketDoCliente.getInetAddress());
				arquivoDeEntrada = socketDoCliente.getInputStream();
				arquivoDeSaída = socketDoCliente.getOutputStream();
				processarEResponderRequisição(arquivoDeEntrada, arquivoDeSaída);
				fecharConexão(socketDoCliente, arquivoDeEntrada, arquivoDeSaída);
				RegistroDeEventos.registrarEvento("Conexão com o cliente encerrada, requisição respondida");
			} catch (IOException erro) {
				RegistroDeEventos.registrarEvento("Erro ao processar e responder a requisição do cliete");
				erro.printStackTrace();
				continue;
			}
		}
	}
	
	private void processarEResponderRequisição(InputStream arquivoDeEntrada, OutputStream arquivoDeSaída) throws IOException {
		Requisicao requisição = new Requisicao(converterFluxoDeEntradaEmTexto(arquivoDeEntrada));
		TipoResposta resposta = FabricaDeResposta.fornecerInstância().fornecerResposta(requisição);
		resposta.responder(arquivoDeSaída);
	}
	
	private String converterFluxoDeEntradaEmTexto(InputStream arquivoDeEntrada) {
		String textoDeEntrada = "";
		try {
			BufferedReader leitor = new BufferedReader(new InputStreamReader(arquivoDeEntrada), TAMANHO_DO_BUFFER);
			StringWriter escritor = new StringWriter(TAMANHO_DO_BUFFER);
			while (leitor.ready()) {
				escritor.write(leitor.readLine()+"\n");
				escritor.flush();
			}
			textoDeEntrada = escritor.toString();
			escritor.close();
			RegistroDeEventos.registrarEvento("\n"+textoDeEntrada);
		} catch (IOException erro) {
			RegistroDeEventos.registrarEvento("Erro na conversão do fluxo de entrada para texto da requisição do cliente");
			erro.printStackTrace();
		}
		
		return textoDeEntrada;
	}
	
	private void fecharConexão(Socket socketDoCliente, InputStream arquivoDeEntrada, OutputStream arquivoDeSaída) throws IOException {
		socketDoCliente.close();
		arquivoDeEntrada.close();
		arquivoDeSaída.close();
	}
}