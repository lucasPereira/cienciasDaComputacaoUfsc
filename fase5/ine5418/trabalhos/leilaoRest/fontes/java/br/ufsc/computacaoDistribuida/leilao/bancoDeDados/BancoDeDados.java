package br.ufsc.computacaoDistribuida.leilao.bancoDeDados;

import java.util.HashMap;
import java.util.Map;

import br.ufsc.computacaoDistribuida.leilao.modelo.Leilao;

public class BancoDeDados {
	
	private Map<String, Leilao> leiloesEmAndamento;
	private Map<String, Leilao> leiloesTerminados;
	private static BancoDeDados INSTÂNCIA;
	
	private BancoDeDados() {
		leiloesEmAndamento = new HashMap<String, Leilao>();
		leiloesTerminados = new HashMap<String, Leilao>();
	}
	
	public static BancoDeDados fornecerInstância() {
		return (INSTÂNCIA == null) ? (INSTÂNCIA = new BancoDeDados()) : INSTÂNCIA;
	}
	
	public void adicionarLeilãoEmAndamento(Leilao leilão) {
		leiloesEmAndamento.put(leilão.fornecerNome(), leilão);
	}
	
	public Leilao obterLeilaoEmAndamento(String nome) {
		return leiloesEmAndamento.get(nome);
	}
	
	public void removerLeilãoEmAndamento(String nome) {
		leiloesEmAndamento.remove(nome);
	}
	
	public void adicionarLeilãoTerminado(Leilao leilão) {
		leiloesTerminados.put(leilão.fornecerNome(), leilão);
	}
	
	public Leilao obterLeilaoTerminado(String nome) {
		return leiloesTerminados.get(nome);
	}
	
	public void removerLeilãoTerminado(String nome) {
		leiloesTerminados.remove(nome);
	}
	
	public Map<String, Leilao> fornecerLeiloesEmAndamento() {
		return leiloesEmAndamento;
	}
	
	public Map<String, Leilao> fornecerLeiloesTerminados() {
		return leiloesTerminados;
	}
}
