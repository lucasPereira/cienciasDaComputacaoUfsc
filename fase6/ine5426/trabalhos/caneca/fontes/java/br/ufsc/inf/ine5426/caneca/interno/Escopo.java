package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.*;

import java.util.List;

public interface Escopo {
	public void gerarCodigo(List<Codigo> areaDeCodigo, Contexto areaDeDados);
	
	public boolean definirClasse(Classe classe);
	
	public boolean definirAtributo(Atributo atributo);
	
	public boolean definirConstrutor(Construtor construtor);
	
	public boolean definirDestrutor(Destrutor destrutor);
	
	public boolean definirMetodo(Metodo metodo);
	
	public boolean definirVariavel(Variavel variavel);
	
	public boolean definirBloco(Bloco bloco);
	
	public boolean definirInstrucao(Instrucao instrucao);
	
	public boolean definirExpressao(Expressao expressao);
	
	public Escopo fornecerEscopoPai();
	
	public String comoTexto();
}
