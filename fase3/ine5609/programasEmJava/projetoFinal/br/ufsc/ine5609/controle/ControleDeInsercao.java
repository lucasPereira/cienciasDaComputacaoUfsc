package br.ufsc.ine5609.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import br.ufsc.ine5609.modelo.GerenciadorDeDados;
import br.ufsc.ine5609.visao.FrameInserirDado;
import br.ufsc.ine5609.visao.atualizacao.AtualizadorDeNomesFrameInicial;
import br.ufsc.ine5609.visao.atualizacao.AtualizadorDeTabela;

public class ControleDeInsercao implements ActionListener {
	private FrameInserirDado frame;
	
	public ControleDeInsercao(JFrame frame) {
		this.frame = (FrameInserirDado) frame;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if (comando.equals("OK")) {
			GerenciadorDeDados.fornecerInstancia().inserirDado(frame.getPessoa());
			AtualizadorDeTabela.getInstance().atualizarTabela();
			AtualizadorDeNomesFrameInicial.fornecerInstancia().atualizarNomes();
		}
		frame.dispose();
	}
}