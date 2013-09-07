package br.ufsc.ine5609.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import br.ufsc.ine5609.modelo.GerenciadorDeDados;
import br.ufsc.ine5609.modelo.conjuntoDeDados.Pessoa;
import br.ufsc.ine5609.modelo.estrutraDeDados.ListaEncadeada;
import br.ufsc.ine5609.modelo.estrutraDeDados.ListaEncadeadaOrdenada;
import br.ufsc.ine5609.visao.FrameInicial;
import br.ufsc.ine5609.visao.atualizacao.AtualizadorDeTabela;

public class ControleDeBuscas implements ActionListener {
	private FrameInicial frame;

	public ControleDeBuscas(JFrame frame) {
		this.frame = (FrameInicial) frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ListaEncadeadaOrdenada<ListaEncadeada<Pessoa>> particoesBuscadas = new ListaEncadeadaOrdenada<ListaEncadeada<Pessoa>>();
		if (frame.buscarEscolaridade()) {
			ListaEncadeada<Pessoa> particaoEscolariedade = GerenciadorDeDados.fornecerInstancia()
				.fornecerParticaoEscolaridade(frame.getChaveEscolaridade());
			particoesBuscadas.inserirOrdenado(particaoEscolariedade);
		}
		if (frame.buscarIdade()) {
			ListaEncadeada<Pessoa> particaoIdade = GerenciadorDeDados.fornecerInstancia()
				.fornecerParticaoIdade(frame.getChaveIdade());
			particoesBuscadas.inserirOrdenado(particaoIdade);
		}
		if (frame.buscarSalario()) {
			ListaEncadeada<Pessoa> particaoSalario = GerenciadorDeDados.fornecerInstancia()
				.fornecerParticaoSalario(frame.getChaveSalario());
			particoesBuscadas.inserirOrdenado(particaoSalario);
		}
		if (frame.buscarCidade()) {
			ListaEncadeada<Pessoa> particaoCidade = GerenciadorDeDados.fornecerInstancia()
				.fornecerParticaoCidade(frame.getChaveCidade());
			particoesBuscadas.inserirOrdenado(particaoCidade);
		}		
		ListaEncadeada<Pessoa> resultadoDaBusca = GerenciadorDeDados.fornecerInstancia().buscar(particoesBuscadas);
		AtualizadorDeTabela.getInstance().gerarTabelaDeBusca(resultadoDaBusca);
	}
}