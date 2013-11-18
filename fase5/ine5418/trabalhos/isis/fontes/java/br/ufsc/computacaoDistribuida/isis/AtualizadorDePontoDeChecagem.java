package br.ufsc.computacaoDistribuida.isis;

public class AtualizadorDePontoDeChecagem implements Runnable {

	private ServidorLider servidorLider;
	private  final static Integer TEMPO_ENTRE_ATUALIZACOES = 120 * 1000;
	
	public AtualizadorDePontoDeChecagem(ServidorLider servidorLider) {
		this.servidorLider = servidorLider;
		Thread esseTerminador = new Thread(this);
		esseTerminador.start();
	}
	
	@Override
	public void run() {
		Thread alarme = new Thread(new Alarme(TEMPO_ENTRE_ATUALIZACOES));
		alarme.start();
		try {
			alarme.join();
		} catch (InterruptedException erro) {
			erro.printStackTrace();
		}
		atualizarPontoDeChecagem();
	}
	
	public void atualizarPontoDeChecagem() {
		servidorLider.atualizarPontoDeChecagem();
	}
}
