package br.ufsc.ine5418.atualizacaoDeAntivirus.comunicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public final class ClienteStream {
	
	private static final String CRLF = "\r\n";
	
	public String enviarRequisição(String dados, String endereço, int porta) {
		StringBuffer entradaLida = null;
		try {
			Socket soqueteStream = new Socket(InetAddress.getByName(endereço), porta);
			Writer escritor = new OutputStreamWriter(soqueteStream.getOutputStream());
			escritor.write(dados+CRLF);
			escritor.flush();
			BufferedReader leitor = new BufferedReader(new InputStreamReader(soqueteStream.getInputStream()));
			entradaLida = new StringBuffer();
			String linhaLida;
			while ((linhaLida = leitor.readLine()) != null && !linhaLida.equals("")) {
				entradaLida.append(linhaLida+CRLF);
			}
			escritor.close();
			leitor.close();
			soqueteStream.close();
		} catch (UnknownHostException erro) {
			erro.printStackTrace();
		} catch (IOException erro) {
			erro.printStackTrace();
		}
		
		return entradaLida.toString();
	}
}
