package br.ufsc.ine5418.atualizacaoDeAntivirus.comunicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class ServidorStream {
	
	private ServerSocket soqueteServidorStream;
	private static final int QUANTIDADE_MÁXIMA_DE_USUÁRIOS = 10;
	private static final String CRLF = "\r\n";
	
	public ServidorStream(int porta) {
		try {
			soqueteServidorStream = new ServerSocket(porta, QUANTIDADE_MÁXIMA_DE_USUÁRIOS);
		} catch (IOException erro) {
			erro.printStackTrace();
		}
	}
	
	public final void iniciarRecebimento() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Socket soqueteClienteStream = soqueteServidorStream.accept();
						BufferedReader leitor = new BufferedReader(new InputStreamReader(soqueteClienteStream.getInputStream()));
						StringBuffer entradaLida = new StringBuffer();
						String linhaLida;
						while ((linhaLida = leitor.readLine()) != null && !linhaLida.equals("")) {
							entradaLida.append(linhaLida+CRLF);
						}
						String dadosDaResposta = processarRequisição(entradaLida.toString());
						Writer escritor = new OutputStreamWriter(soqueteClienteStream.getOutputStream());
						escritor.write(dadosDaResposta+CRLF);
						escritor.flush();
						leitor.close();
						escritor.close();
						soqueteClienteStream.close();
					} catch (IOException erro) {
						erro.printStackTrace();
					}
				}
			}
		}, "ServidorStream").start();
	}
	
	public abstract String processarRequisição(String dados);
}
