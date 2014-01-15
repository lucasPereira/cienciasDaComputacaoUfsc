package br.ufsc.inf.ine5426.caneca.interno;

import java.util.List;

public interface Simbolo extends Localizavel {
	public Escopo fornecerEscopoPai();
	
	public String comoTexto();
	
	public String fornecerNome();
}
