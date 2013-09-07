package br.ufsc.ine5609.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufsc.ine5609.modelo.GerenciadorDeDados;
import br.ufsc.ine5609.modelo.ListaDePessoas;
import br.ufsc.ine5609.modelo.conjuntoDeDados.Escolaridade;
import br.ufsc.ine5609.modelo.conjuntoDeDados.Pessoa;
import br.ufsc.ine5609.modelo.estrutraDeDados.ListaEncadeada;
import br.ufsc.ine5609.visao.atualizacao.AtualizadorDeNomesFrameInicial;
import br.ufsc.ine5609.visao.atualizacao.AtualizadorDeTabela;

public class ControleDeCarregamentoDeDados implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent evento) {
		inserirNaLista();
		GerenciadorDeDados.fornecerInstancia().carregarDados();
		AtualizadorDeTabela.getInstance().atualizarTabela();
		AtualizadorDeNomesFrameInicial.fornecerInstancia().atualizarNomes();
	}
	
	private void inserirNaLista() {
		ListaDePessoas listaDePessoas = ListaDePessoas.fornecerInstancia();
		listaDePessoas.novaLista();
		ListaEncadeada<Pessoa> dados = listaDePessoas.fornecerLista();
		dados.inserirNoInicio(new Pessoa("Maria", 412487, Escolaridade.MEDIO, 3000, 45 , "Florianopolis"));
		dados.inserirNoInicio(new Pessoa("Joao", 29838, Escolaridade.FUNDAMENTAL, 1500, 20 , "Curitiba"));
		dados.inserirNoInicio(new Pessoa("Edmundo", 23783, Escolaridade.SUPERIOR_INCOMPLETO, 7000, 31,"Sao Paulo"));
		dados.inserirNoInicio(new Pessoa("Andre", 983983, Escolaridade.SEM_ESCOLARIDADE, 15000, 22,"Criciuma"));
		dados.inserirNoInicio(new Pessoa("Lucas", 873287, Escolaridade.FUNDAMENTAL, 9000, 15,"Florianopolis"));
		dados.inserirNoInicio(new Pessoa("Pedro", 7363673, Escolaridade.FUNDAMENTAL, 2100, 22,"Brasilia"));
		dados.inserirNoInicio(new Pessoa("Marcelo", 7343473, Escolaridade.FUNDAMENTAL, 2001, 22,"Brasilia"));
		dados.inserirNoInicio(new Pessoa("Fabiana", 2343473, Escolaridade.SUPERIOR, 10000, 31,"Sao Paulo"));
		dados.inserirNoInicio(new Pessoa("Fernando", 83748743, Escolaridade.SUPERIOR, 3200, 22,"Criciuma"));
		dados.inserirNoInicio(new Pessoa("Ana", 983984, Escolaridade.SUPERIOR, 6000, 34,"Sao Paulo"));
		dados.inserirNoInicio(new Pessoa("Josefa", 7132676, Escolaridade.MEDIO, 1700, 34,"Florianopolis"));
		dados.inserirNoInicio(new Pessoa("Gertrudes", 3128783, Escolaridade.MEDIO, 1400, 112,"Brasilia"));
		dados.inserirNoInicio(new Pessoa("Marta", 3128783, Escolaridade.FUNDAMENTAL, 1400, 22,"Brasilia"));
		dados.inserirNoInicio(new Pessoa("Tiago", 3128783, Escolaridade.FUNDAMENTAL, 1400, 22,"Brasilia"));
	}
}