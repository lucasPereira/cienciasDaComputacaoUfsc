package br.ufsc.ine5609.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufsc.ine5609.visao.FrameInserirDado;

public class ControleDoFrameInserirDado implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent evento) {
		new FrameInserirDado();
	}
}