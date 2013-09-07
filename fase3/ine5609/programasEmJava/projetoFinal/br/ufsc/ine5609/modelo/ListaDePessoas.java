package br.ufsc.ine5609.modelo;

import br.ufsc.ine5609.modelo.conjuntoDeDados.Pessoa;
import br.ufsc.ine5609.modelo.estrutraDeDados.TipoIterador;
import br.ufsc.ine5609.modelo.estrutraDeDados.ListaEncadeada;

public class ListaDePessoas {
	private static ListaDePessoas INSTANCIA;
	private ListaEncadeada<Pessoa> lista;
	
	private static final int ZERO = 0;

	private ListaDePessoas() {
		lista = new ListaEncadeada<Pessoa>();
	}
	
	public static ListaDePessoas fornecerInstancia() {
		if (INSTANCIA == null) {
			INSTANCIA = new ListaDePessoas();
		}

		return INSTANCIA;
	}

	public void novaLista() {
		lista = new ListaEncadeada<Pessoa>();
	}
	
	public Pessoa[] fornecerArrayComAsPessoas() {
		Pessoa[] pessoas = new Pessoa[lista.fornecerQuantidadeDeElementos()];
		TipoIterador<Pessoa> iterador = lista.fornecerIterador();
		int cont = ZERO;
		while (iterador.temProximo()) {
			pessoas[cont] = iterador.fornecerProximo();
			cont++;
		}
		
		return pessoas;
	}
	
	public ListaEncadeada<Pessoa> fornecerLista() {
		return lista;
	}
}