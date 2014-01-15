package br.ufsc.inf.ine5426.caneca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

import java.lang.StringBuilder;

public class LeitorEscritor {
	private static final int TAMANHO_DO_BALDE = 1024;
	
	public String lerArquivo(String nomeDoArquivo) {
		StringBuilder arquivoLido = new StringBuilder();
		try {
			Reader leitor =  new BufferedReader(new FileReader(nomeDoArquivo));
			char[] baldeDeLeitura = new char[TAMANHO_DO_BALDE];
			int quantidadeDeCaracteresLidos = 0;
			while ((quantidadeDeCaracteresLidos = leitor.read(baldeDeLeitura)) > 0) {
				arquivoLido.append(baldeDeLeitura, 0, quantidadeDeCaracteresLidos);
			}
			leitor.close();
			return arquivoLido.toString();
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return arquivoLido.toString();
	}
	
	public void escreverArquivo(String nomeDoArquivo, String saida) {
		try {
			File arquivo = new File(nomeDoArquivo);
			arquivo.createNewFile();
			Writer escritor = new BufferedWriter(new FileWriter(arquivo));
			escritor.write(saida);
			escritor.flush();
			escritor.close();
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
	}
}

