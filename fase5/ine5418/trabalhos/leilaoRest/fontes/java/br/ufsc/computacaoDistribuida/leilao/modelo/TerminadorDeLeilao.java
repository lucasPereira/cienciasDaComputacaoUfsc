package br.ufsc.computacaoDistribuida.leilao.modelo;

import br.ufsc.computacaoDistribuida.leilao.bancoDeDados.BancoDeDados;

public class TerminadorDeLeilao implements Runnable {

	private Leilao leilao;
	
	public TerminadorDeLeilao(Leilao leilao) {
		this.leilao = leilao;
		Thread esseTerminador = new Thread(this);
		esseTerminador.start();
	}
	
	@Override
	public void run() {
		Thread alarme = new Thread(new Alarme(leilao.fornecerDuracao() * 1000));
		alarme.start();
		try {
			alarme.join();
		} catch (InterruptedException erro) {
			erro.printStackTrace();
		}
		terminarLeilão();
	}
	
	public void terminarLeilão() {
		BancoDeDados bancoDeDados = BancoDeDados.fornecerInstância();
		bancoDeDados.removerLeilãoEmAndamento(leilao.fornecerNome());
		bancoDeDados.adicionarLeilãoTerminado(leilao);
	}
}
