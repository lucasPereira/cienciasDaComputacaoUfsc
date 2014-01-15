package br.ufsc.inf.ine5426.caneca;

import br.ufsc.inf.ine5426.caneca.antlr.CanecaLexico;
import br.ufsc.inf.ine5426.caneca.antlr.CanecaSintatico;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.TokenStream;

public class AnaliseSintatica {
	private String nomeDoArquivoComCodigo;
	
	public AnaliseSintatica(String nomeDoArquivoComCodigo) {
		this.nomeDoArquivoComCodigo = nomeDoArquivoComCodigo;
	}
	
	public void analisar() throws IOException, RecognitionException {
		CharStream fluxoDeCaracteres = new ANTLRFileStream(nomeDoArquivoComCodigo);
		CanecaLexico analisadorLexico = new CanecaLexico(fluxoDeCaracteres);
		
		TokenStream fluxoDeSimbolos = new CommonTokenStream(analisadorLexico);
		CanecaSintatico analisadorSintatico = new CanecaSintatico(fluxoDeSimbolos);
		RuleReturnScope programa = analisadorSintatico.programa();
		
		System.out.println(String.format("Erros léxicos: %s.", analisadorLexico.fornecerErros().size()));
		System.out.println(String.format("Erros sintáticos: %s.", analisadorSintatico.fornecerErros().size()));
	}
}

