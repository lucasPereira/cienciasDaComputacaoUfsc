package br.ufsc.ine5609.main;

import br.ufsc.ine5609.visao.FrameInicial;
import br.ufsc.ine5609.visao.atualizacao.AtualizadorDeNomesFrameInicial;

public class Main {
	
	public static void main(String[] args) {
		FrameInicial frame = new FrameInicial();
		AtualizadorDeNomesFrameInicial.fornecerInstancia().setFrameInicial(frame);
	}
}