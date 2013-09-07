package br.ufsc.ine5609.visao.atualizacao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;

import br.ufsc.ine5609.modelo.ListaDePessoas;
import br.ufsc.ine5609.modelo.conjuntoDeDados.Pessoa;
import br.ufsc.ine5609.modelo.estrutraDeDados.TipoIterador;
import br.ufsc.ine5609.modelo.estrutraDeDados.ListaEncadeada;

public class AtualizadorDeTabela {
	private JTable tabela;
	private static AtualizadorDeTabela INSTANCIA;
	private Object[][] dados;

	public static AtualizadorDeTabela getInstance() {
		if (INSTANCIA == null) {
			INSTANCIA = new AtualizadorDeTabela(); 
		}
		
		return INSTANCIA;
	}

	public void atualizarTabela() {
		gerarTabela();
		tabela.setFont(new Font("Arial", 0, 14));
		tabela.setForeground(Color.blue);
		tabela.setEnabled(false);
	}

	private void gerarTabela() {
		gerarDados();
		tabela.setModel(new javax.swing.table.DefaultTableModel(dados, new String[] {
				"NOME", "CPF", "ESCOLARIDADE", "SALARIO", "IDADE", "CIDADE" }));
	}

	public void gerarTabelaDeBusca(ListaEncadeada<Pessoa> lista) {
		TipoIterador<Pessoa> iterador = lista.fornecerIterador();
		dados = new Object[lista.fornecerQuantidadeDeElementos()][6];
		int i = 0;
		while (iterador.temProximo()) {
			Pessoa pessoa = iterador.fornecerProximo();
			dados[i][0] = pessoa.fornecerNome();
			dados[i][1] = pessoa.fornecerCpf();
			dados[i][2] = pessoa.fornecerEscolaridade();
			dados[i][3] = pessoa.fornecerSalario();
			dados[i][4] = pessoa.fornecerIdade();
			dados[i][5] = pessoa.fornecerCidade();
			i++;
		}
		tabela.setModel(new javax.swing.table.DefaultTableModel(dados, new String[] {
				"NOME", "CPF", "ESCOLARIDADE", "SALARIO", "IDADE", "CIDADE" }));
	}

	public void setTable(JTable t) {
		this.tabela = t;
	}

	private void gerarDados() {
		TipoIterador<Pessoa> iterador = ListaDePessoas.fornecerInstancia()
				.fornecerLista().fornecerIterador();
		int i = 0;
		dados = new Object[ListaDePessoas.fornecerInstancia().fornecerLista()
				.fornecerQuantidadeDeElementos()][6];

		while (iterador.temProximo()) {
			Pessoa pessoa = iterador.fornecerProximo();
			dados[i][0] = pessoa.fornecerNome();
			dados[i][1] = pessoa.fornecerCpf();
			dados[i][2] = pessoa.fornecerEscolaridade();
			dados[i][3] = pessoa.fornecerSalario();
			dados[i][4] = pessoa.fornecerIdade();
			dados[i][5] = pessoa.fornecerCidade();
			i++;
		}
	}
}