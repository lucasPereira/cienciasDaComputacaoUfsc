package br.ufsc.inf.ine5426.caneca;

import br.ufsc.inf.ine5426.caneca.antlr.CanecaLexico;
import br.ufsc.inf.ine5426.caneca.antlr.CanecaSintatico;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;

public class ApresentacaoDeSimbolos {
	private static final String ARQUIVO_ORIGEM_SIMBOLOS_HTML = "fontes/html/simbolos.html";
	private static final String ARQUIVO_DESTINO_SIMBOLOS_HTML = "gerados/html/simbolos.html";
	private static final String MARCA_DE_TEMPLATE_SIMBOLOS = "<!-- simbolos -->";
	private static final String MARCA_DE_TEMPLATE_CODIGO = "<!-- codigo -->";
	private LeitorEscritor leitorEscritor;
	private String nomeDoArquivoComCodigo;
	
	public ApresentacaoDeSimbolos(String nomeDoArquivoComCodigo) {
		this.nomeDoArquivoComCodigo = nomeDoArquivoComCodigo;
		leitorEscritor = new LeitorEscritor();
	}
	
	public void apresentar() throws IOException {
		String template = leitorEscritor.lerArquivo(ARQUIVO_ORIGEM_SIMBOLOS_HTML);
		String codigo = leitorEscritor.lerArquivo(nomeDoArquivoComCodigo);
		String simbolos = obterSimbolos();
		template = template.replace(MARCA_DE_TEMPLATE_CODIGO, codigo);
		template = template.replace(MARCA_DE_TEMPLATE_SIMBOLOS, simbolos);
		leitorEscritor.escreverArquivo(ARQUIVO_DESTINO_SIMBOLOS_HTML, template);
	}
	
	private String obterSimbolos() throws IOException {
		CanecaLexico analisadorLexico = obterAnalisadorLexico();
		Token simbolo;
		String[] nomesDosSimbolos = CanecaSintatico.tokenNames;
		StringBuilder simbolos = new StringBuilder();
		while ((simbolo = analisadorLexico.nextToken()).getType() != Token.EOF) {
			simbolos.append("<section>");
			simbolos.append("<h1>");
			simbolos.append(nomesDosSimbolos[simbolo.getType()]);
			simbolos.append("</h1>");
			simbolos.append("<p>");
			simbolos.append(String.format("Linha: %s. Coluna: %s.", simbolo.getLine(), simbolo.getCharPositionInLine()));
			simbolos.append("</p>");
			simbolos.append("<p class=\"codigo\">");
			simbolos.append(simbolo.getText());
			simbolos.append("</p>");
			simbolos.append("</section>");
		}
		return simbolos.toString();
	}
	
	private CanecaLexico obterAnalisadorLexico() throws IOException {
		CharStream fluxoDeCaracteres = new ANTLRFileStream(nomeDoArquivoComCodigo);
		CanecaLexico analisadorLexico = new CanecaLexico(fluxoDeCaracteres);
		return analisadorLexico;
	}
}

