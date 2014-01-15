package br.ufsc.inf.ine5426.caneca;

import br.ufsc.inf.ine5426.caneca.antlr.CanecaLexico;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;

public class AnaliseLexica {
	private String nomeDoArquivoComCodigo;
	
	public AnaliseLexica(String nomeDoArquivoComCodigo) {
		this.nomeDoArquivoComCodigo = nomeDoArquivoComCodigo;
	}
	
	public void analisar() throws IOException {
		CharStream fluxoDeCaracteres = new ANTLRFileStream(nomeDoArquivoComCodigo);
		CanecaLexico analisadorLexico = new CanecaLexico(fluxoDeCaracteres);
		while (analisadorLexico.nextToken().getType() != Token.EOF);
		
		System.out.println(String.format("Erros léxicos: %s.", analisadorLexico.fornecerErros().size()));
	}
}

