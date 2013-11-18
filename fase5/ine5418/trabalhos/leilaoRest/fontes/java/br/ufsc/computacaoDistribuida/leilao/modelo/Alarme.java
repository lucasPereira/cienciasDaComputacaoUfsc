package br.ufsc.computacaoDistribuida.leilao.modelo;

public class Alarme implements Runnable {

	long tempoEmMiliSegundos;
	
	public Alarme(long tempoEmMiliSegundos) {
		this.tempoEmMiliSegundos = tempoEmMiliSegundos;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(tempoEmMiliSegundos);
		} catch (InterruptedException excecao) {
			excecao.printStackTrace();
		}
	}
}
