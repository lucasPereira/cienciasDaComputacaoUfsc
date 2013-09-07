package br.ufsc.ine5609.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufsc.ine5609.visao.atualizacao.AtualizadorDeTabela;

public class ControleDoAtualizadorDeTabela implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent evento) {
		AtualizadorDeTabela.getInstance().atualizarTabela();
	}
}
