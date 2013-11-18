package br.lucaspereira.caingangue.http.resposta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import br.lucaspereira.caingangue.Caingangue;
import br.lucaspereira.caingangue.RegistroDeEventos;
import br.lucaspereira.caingangue.http.requisicao.TipoRequisicao;

public class RespostaDeArquivoDeTexto implements TipoResposta {
	
	private TipoRequisicao requisição;
	
	private static final int TAMANHO_DO_BUFFER = 2048;
	
	public RespostaDeArquivoDeTexto(TipoRequisicao requisição) {
		this.requisição = requisição;
	}
	
	@Override
	public int fornecerCódigoDeEstado() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fornecerRespostaComoTexto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void responder(OutputStream arquivoDeSaída) {
		try {
			File arquivoRequisitado = new File(Caingangue.NOME_DO_DIRETÓRIO_BASE+requisição.fornecerUri());
			BufferedReader leitor = new BufferedReader(new FileReader(arquivoRequisitado), TAMANHO_DO_BUFFER);
			//BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(arquivoDeSaída));
			PrintWriter escritor = new PrintWriter(arquivoDeSaída, true);
			escritor.println("HTTP/1.1 200 OK");
			escritor.println("Content-type: text/html");
			escritor.println();
			while (leitor.ready()) {
				escritor.println(leitor.readLine());
				escritor.flush();
			}
			escritor.close();
			leitor.close();
		} catch (FileNotFoundException erro) {
			RegistroDeEventos.registrarEvento("Arquivo requisitado não encontrado");
			PrintWriter escritor = new PrintWriter(arquivoDeSaída, true);
			escritor.println("HTTP/1.1 404 Not Found");
			escritor.close();
			erro.printStackTrace();
		} catch (IOException erro) {
			RegistroDeEventos.registrarEvento("Erro na leitura do arquivo requisitado");
			erro.printStackTrace();
		}
	}
}
