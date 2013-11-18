package br.lucaspereira.caingangue;

import java.io.File;
import java.io.IOException;

import br.lucaspereira.caingangue.http.Versao;

public class Caingangue {
	
	protected static final String VERSÃO = "Caingangue 1.0";
	protected static final String ENDEREÇO_BASE = "localhost";
	public static final String NOME_DO_DIRETÓRIO_BASE = "publico";
	public static File DIRETÓRIO_BASE;
	protected static final int PORTA = 7070;
	protected static final Versao VERSÃO_DO_HTTP_SUPORTADA = Versao.HTTP_1_1;
	
	public static void main(String[] args) throws IOException {
		criarEstruturaDeDiretórios();
		new Servidor(PORTA, ENDEREÇO_BASE);
	}
	
	private static void criarEstruturaDeDiretórios() throws IOException {
		File diretórioBase = new File(NOME_DO_DIRETÓRIO_BASE);
		if (!diretórioBase.exists()) {
			diretórioBase.mkdir();
			DIRETÓRIO_BASE = diretórioBase;
		}
	}
}