package br.ufsc.inf.ine5426.caneca.interno;

public final class Reporter {
	private static Reporter INSTANCIA;
	private int errosDeDefinicao;
	
	public static Reporter instancia() {
		return (INSTANCIA == null) ? (INSTANCIA = new Reporter()) : INSTANCIA;
	}
	
	private Reporter() {
		errosDeDefinicao = 0;
	}
	
	public void reportarDefinicaoDeClasse(Classe classe) {
		mostrarMensagemDeSucesoDeDefinicao(classe.comoTexto(),
				classe.fornecerLinha(), classe.fornecerColuna(),
				classe.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarDefinicaoDeAtributo(Atributo atributo) {
		mostrarMensagemDeSucesoDeDefinicao(atributo.comoTexto(),
				atributo.fornecerLinha(), atributo.fornecerColuna(),
				atributo.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarDefinicaoDeMetodo(Metodo metodo) {
		mostrarMensagemDeSucesoDeDefinicao(metodo.comoTexto(),
				metodo.fornecerLinha(), metodo.fornecerColuna(),
				metodo.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarDefinicaoDeConstrutor(Construtor construtor) {
		mostrarMensagemDeSucesoDeDefinicao(construtor.comoTexto(),
				construtor.fornecerLinha(), construtor.fornecerColuna(),
				construtor.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarDefinicaoDeDestrutor(Destrutor destrutor) {
		mostrarMensagemDeSucesoDeDefinicao(destrutor.comoTexto(),
				destrutor.fornecerLinha(), destrutor.fornecerColuna(),
				destrutor.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarDefinicaoDeVariavel(Variavel variavel) {
		mostrarMensagemDeSucesoDeDefinicao(variavel.comoTexto(),
				variavel.fornecerLinha(), variavel.fornecerColuna(),
				variavel.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarDefinicaoDeBloco(Bloco bloco) {
		mostrarMensagemDeSucesoDeDefinicao(bloco.comoTexto(), bloco.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarDefinicaoDeInstrucao(Instrucao instrucao) {
		mostrarMensagemDeSucesoDeDefinicao(instrucao.comoTexto(), instrucao.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarDefinicaoDeExpressao(Expressao expressao) {
		mostrarMensagemDeSucesoDeDefinicao(expressao.comoTexto(), expressao.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarErroDeDefinicaoRepetidaDeClasse(Classe classe) {
		errosDeDefinicao++;
		mostrarMensagemDeErroDeDefinicao("definição repetida de classe.",
				classe.comoTexto(), classe.fornecerLinha(), classe.fornecerColuna(),
				classe.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarErroDeDefinicaoRepetidaDeAtributo(Atributo atributo) {
		errosDeDefinicao++;
		mostrarMensagemDeErroDeDefinicao("definição repetida de atributo.",
				atributo.comoTexto(), atributo.fornecerLinha(), atributo.fornecerColuna(),
				atributo.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarErroDeDefinicaoRepetidaDeMetodo(Metodo metodo) {
		errosDeDefinicao++;
		mostrarMensagemDeErroDeDefinicao("definição repetida de método.",
				metodo.comoTexto(), metodo.fornecerLinha(), metodo.fornecerColuna(),
				metodo.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarErroDeDefinicaoRepetidaDeConstrutor(Construtor construtor) {
		errosDeDefinicao++;
		mostrarMensagemDeErroDeDefinicao("definição repetida de construtor.",
				construtor.comoTexto(), construtor.fornecerLinha(), construtor.fornecerColuna(),
				construtor.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarErroDeDefinicaoRepetidaDeVariavel(Variavel variavel) {
		errosDeDefinicao++;
		mostrarMensagemDeErroDeDefinicao("definição repetida de variável.",
				variavel.comoTexto(), variavel.fornecerLinha(), variavel.fornecerColuna(),
				variavel.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarErroDeDefinicaoDeNomeErradoDeConstrutor(Construtor construtor) {
		errosDeDefinicao++;
		mostrarMensagemDeErroDeDefinicao("definição de nome errado do construtor.",
				construtor.comoTexto(), construtor.fornecerLinha(), construtor.fornecerColuna(),
				construtor.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarErroDeDefinicaoDeNomeErradoDeDestrutor(Destrutor destrutor) {
		errosDeDefinicao++;
		mostrarMensagemDeErroDeDefinicao("definição de nome errado do destrutor.",
				destrutor.comoTexto(), destrutor.fornecerLinha(), destrutor.fornecerColuna(),
				destrutor.fornecerEscopoPai().comoTexto());
	}
	
	public void reportarErroLexicoSintatico() {
		mostrarMensagemDeErro("Existem erros léxicos e/ou sintáticos. Corrija os erros antes de continuar a análise semântica.");
	}
	
	private void mostrarMensagemDeErro(String mensagem) {
		System.out.println(String.format("[Erro] %s", mensagem));
	}
	
	private void mostrarMensagemDeErroDeDefinicao(String mensagem, String nome, int linha, int coluna, String escopo) {
		System.out.println(String.format("[Erro] [%s, %s] Definição de [%s] em [%s]. Problema: %s",
				linha, coluna, nome, escopo, mensagem));
	}
	
	private void mostrarMensagemDeSucesoDeDefinicao(String nome, int linha, int coluna, String escopo) {
		System.out.println(String.format("[Sucesso] [%s, %s] Definição de [%s] em [%s]",
				linha, coluna, nome, escopo));
	}
	
	private void mostrarMensagemDeSucesoDeDefinicao(String nome, String escopo) {
		System.out.println(String.format("[Sucesso] Definição de [%s] em [%s]",
				nome, escopo));
	}
}
