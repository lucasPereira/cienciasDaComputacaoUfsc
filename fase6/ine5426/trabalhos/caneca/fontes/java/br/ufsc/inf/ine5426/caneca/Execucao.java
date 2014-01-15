package br.ufsc.inf.ine5426.caneca;

import br.ufsc.inf.ine5426.caneca.antlr.CanecaArvore;
import br.ufsc.inf.ine5426.caneca.antlr.CanecaLexico;
import br.ufsc.inf.ine5426.caneca.antlr.CanecaSemantico;
import br.ufsc.inf.ine5426.caneca.antlr.CanecaSintatico;

import br.ufsc.inf.ine5426.caneca.interno.*;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.io.IOException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.RecognitionException;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class Execucao {
	private static final String ARQUIVO_DESTINO_CASM = "gerados/casm/%s.casm";
	private String nomeDoArquivoComCodigo;
	private String nomeDaClassePrincipal;
	private CommonTreeNodeStream fluxoDeNodos;
	private CommonTree arvoreSintaticaReescrita;
	
	public Execucao(String nomeDoArquivoComCodigo, String nomeDaClassePrincipal) {
		this.nomeDoArquivoComCodigo = nomeDoArquivoComCodigo;
		this.nomeDaClassePrincipal = nomeDaClassePrincipal;
	}
	
	public void executar() throws IOException {
		TabelaDeSimbolos tabelaDeSimbolos = new TabelaDeSimbolos();
		obterFluxoDeNodosEArvoreSintaticaReescrita();
		CanecaSemantico analisadorSemantico = new CanecaSemantico(fluxoDeNodos);
		analisadorSemantico.fixarTabelaDeSimbolos(tabelaDeSimbolos);
		analisadorSemantico.downup(arvoreSintaticaReescrita);
		fluxoDeNodos.reset();
		System.out.println("");
		MaquinaCaneca maquina = new MaquinaCaneca();
		LeitorEscritor leitorEscritor = new LeitorEscritor();
		ArrayList<Codigo> areaDeCodigo = maquina.gerarCodigo(tabelaDeSimbolos, nomeDaClassePrincipal);
		StringBuffer codigoDeMaquina = new StringBuffer();
		Integer contador = 0;
		for (Codigo codigo : areaDeCodigo) {
			String codigoCasm = String.format("[%03d] %s\n", contador++, codigo.comoTexto());
			System.out.print(codigoCasm);
			codigoDeMaquina.append(codigoCasm);
		}
		leitorEscritor.escreverArquivo(String.format(ARQUIVO_DESTINO_CASM, nomeDaClassePrincipal), codigoDeMaquina.toString());
		System.out.println("");
		maquina.executar();
	}
	
	private void obterFluxoDeNodosEArvoreSintaticaReescrita() throws IOException {
		try {
			CharStream fluxoDeCaracteres = new ANTLRFileStream(nomeDoArquivoComCodigo);
			CanecaLexico analisadorLexico = new CanecaLexico(fluxoDeCaracteres);
			analisadorLexico.esconderErros();
			TokenStream fluxoDeSimbolos = new CommonTokenStream(analisadorLexico);
			CanecaSintatico analisadorSintatico = new CanecaSintatico(fluxoDeSimbolos);
			analisadorSintatico.esconderErros();
			RuleReturnScope programa = analisadorSintatico.programa();
			CommonTree arvoreSintatica = (CommonTree) programa.getTree();
			fluxoDeNodos = new CommonTreeNodeStream(arvoreSintatica);
			CanecaArvore analisadorArvore = new CanecaArvore(fluxoDeNodos);
			fluxoDeNodos.setTokenStream(fluxoDeSimbolos);
			RuleReturnScope programaReescrito = analisadorArvore.programa();
			arvoreSintaticaReescrita = (CommonTree) programaReescrito.getTree();
		} catch (RecognitionException excecao) {
			excecao.printStackTrace();
			Reporter.instancia().reportarErroLexicoSintatico();
			System.exit(0);
		}
	}
}
