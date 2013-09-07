package br.ufsc.ine5609.visao.atualizacao;

import br.ufsc.ine5609.visao.FrameInicial;

public class AtualizadorDeNomesFrameInicial {
	private static AtualizadorDeNomesFrameInicial atualizador = null;
	
	private FrameInicial frame;
	
	public static AtualizadorDeNomesFrameInicial fornecerInstancia(){
		if(atualizador == null)
			atualizador = new AtualizadorDeNomesFrameInicial();
		return atualizador;
	}
	
	public void setFrameInicial(FrameInicial frame){
		this.frame = frame;
	}
	
	public void atualizarNomes(){
		frame.atualizarListaDePessoas();
	}
}
