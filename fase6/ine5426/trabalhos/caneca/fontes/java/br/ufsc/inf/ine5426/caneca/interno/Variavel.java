package br.ufsc.inf.ine5426.caneca.interno;

import java.util.List;

public final class Variavel extends SimboloAbstrato {
	public Variavel(Escopo escopoPai, Tipo tipo, String nome, int linha, int coluna) {
		super(escopoPai, tipo, nome, linha, coluna);
	}
}
