package br.ufsc.ine5609.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import br.ufsc.ine5609.modelo.GerenciadorDeDados;
import br.ufsc.ine5609.modelo.conjuntoDeDados.Pessoa;
import br.ufsc.ine5609.visao.FrameInicial;
import br.ufsc.ine5609.visao.atualizacao.AtualizadorDeNomesFrameInicial;
import br.ufsc.ine5609.visao.atualizacao.AtualizadorDeTabela;

public class ControleDeRemocaoDeDados implements ActionListener {
	FrameInicial frame;

	public ControleDeRemocaoDeDados(JFrame frame) {
		this.frame = (FrameInicial) frame;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		Pessoa pesssoaRemovida = frame.fornecerPessoaParaRemover();
		GerenciadorDeDados.fornecerInstancia().removerDado(pesssoaRemovida);
		AtualizadorDeTabela.getInstance().atualizarTabela();
		AtualizadorDeNomesFrameInicial.fornecerInstancia().atualizarNomes();
		frame.atualizarListaDePessoas();
	}

}