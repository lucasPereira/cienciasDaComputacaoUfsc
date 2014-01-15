package br.ufsc.inf.ine5426.caneca;

import br.ufsc.inf.ine5426.caneca.antlr.CanecaArvore;
import br.ufsc.inf.ine5426.caneca.antlr.CanecaLexico;
import br.ufsc.inf.ine5426.caneca.antlr.CanecaSintatico;

import java.io.IOException;

import java.util.List;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.TokenStream;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class ApresentacaoDeArvore {
	private static final String ARQUIVO_ORIGEM_ARVORE_SINTATICA_HTML = "fontes/html/arvoreSintatica.html";
	private static final String ARQUIVO_DESTINO_ARVORE_SINTATICA_HTML = "gerados/html/arvoreSintatica.html";
	private static final String MARCA_DE_TEMPLATE_ARVORE_SINTATICA = "<!-- arvoreSintatica -->";
	private static final String MARCA_DE_TEMPLATE_CODIGO = "<!-- codigo -->";
	private LeitorEscritor leitorEscritor;
	private String nomeDoArquivoComCodigo;
	
	public ApresentacaoDeArvore(String nomeDoArquivoComCodigo) {
		this.nomeDoArquivoComCodigo = nomeDoArquivoComCodigo;
		leitorEscritor = new LeitorEscritor();
	}
	
	public void apresentar() throws IOException, RecognitionException {
		String template = leitorEscritor.lerArquivo(ARQUIVO_ORIGEM_ARVORE_SINTATICA_HTML);
		String codigo = leitorEscritor.lerArquivo(nomeDoArquivoComCodigo);
		String arvoreSintaticaHtml = obterArvoreSintaticaHtml();
		template = template.replace(MARCA_DE_TEMPLATE_CODIGO, codigo);
		template = template.replace(MARCA_DE_TEMPLATE_ARVORE_SINTATICA, arvoreSintaticaHtml);
		leitorEscritor.escreverArquivo(ARQUIVO_DESTINO_ARVORE_SINTATICA_HTML, template);
	}

	private String obterArvoreSintaticaHtml() throws IOException, RecognitionException {
		StringBuilder arvoreSintaticaHtml = new StringBuilder();
		arvoreSintaticaHtml.append("<ul>");
		obterArvoreSintaticaHtml(obterArvoreSintaticaReescrita(), arvoreSintaticaHtml);
		arvoreSintaticaHtml.append("</ul>");
		return arvoreSintaticaHtml.toString();
	}
	
	private CommonTree obterArvoreSintaticaReescrita() throws IOException, RecognitionException {
		CharStream fluxoDeCaracteres = new ANTLRFileStream(nomeDoArquivoComCodigo);	
		CanecaLexico analisadorLexico = new CanecaLexico(fluxoDeCaracteres);
		TokenStream fluxoDeSimbolos = new CommonTokenStream(analisadorLexico);
		CanecaSintatico analisadorSintatico = new CanecaSintatico(fluxoDeSimbolos);
		RuleReturnScope programa = analisadorSintatico.programa();
		CommonTree arvoreSintatica = (CommonTree) programa.getTree();
		CommonTreeNodeStream fluxoDeNodos = new CommonTreeNodeStream(arvoreSintatica);
		CanecaArvore analisadorArvore = new CanecaArvore(fluxoDeNodos);
		fluxoDeNodos.setTokenStream(fluxoDeSimbolos);
		RuleReturnScope programaReescrito = analisadorArvore.programa();
		CommonTree arvoreSintaticaReescrita = (CommonTree) programaReescrito.getTree();
		return arvoreSintaticaReescrita;
	}
	
	private void obterArvoreSintaticaHtml(CommonTree arvore, StringBuilder arvoreSintaticaHtml) {
		arvoreSintaticaHtml.append("<li>");
		arvoreSintaticaHtml.append("<h1>");
		arvoreSintaticaHtml.append(arvore.getText());
		arvoreSintaticaHtml.append("</h1>");
		List filhos = arvore.getChildren();
		if (filhos != null && filhos.size() > 0) {
			arvoreSintaticaHtml.append("<ul>");
			for (Object filho : filhos) {
				obterArvoreSintaticaHtml((CommonTree) filho, arvoreSintaticaHtml);
			}
			arvoreSintaticaHtml.append("</ul>");
		}
		arvoreSintaticaHtml.append("</li>");
	}
}

