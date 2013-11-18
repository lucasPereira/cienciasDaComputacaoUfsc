package br.ufsc.ine5418.atualizacaoDeAntivirus;

import java.util.Date;
import java.util.LinkedList;

import br.ufsc.ine5418.atualizacaoDeAntivirus.comunicacao.ServidorStream;

public final class ServidorDeAntivirus extends ProvedorDeAtualizacao {
	
	private ServidorStream servidorStream;
	private LinkedList<Date> atualizações;
	private AtualizacaoDeAntivirus fachada;
	private static final int PORTA_DO_SERVIDOR = 7000;
	private static final int TEMPO_PARA_ATUALIZAÇÃO_DO_SERVIDOR = 10000;
	
	public ServidorDeAntivirus(AtualizacaoDeAntivirus fachada) {
		this.fachada = fachada;
		atualizações = new LinkedList<Date>();
		atualizações.add(new Date());
		this.fachada.atualizarVersão(PORTA_DO_SERVIDOR, atualizações.getFirst());
		servidorStream = new ServidorStream(PORTA_DO_SERVIDOR) {
			@Override
			public String processarRequisição(String dados) {
				return processarRequisiçãoStream(atualizações, PORTA_DO_SERVIDOR, dados);
			}
		};
		servidorStream.iniciarRecebimento();
		atualizarVersãoPeriódicamente();
	}
	
	public int fornecerPortaDeComunicaçãoTcp() {
		return PORTA_DO_SERVIDOR;
	}
	
	private void atualizarVersão() {
		Date últimaVersão = atualizações.getFirst();
		Date novaVersão = new Date(últimaVersão.getTime()+86400000);
		atualizações.addFirst(novaVersão);
		fachada.atualizarVersão(PORTA_DO_SERVIDOR, novaVersão);
	}
	
	private void atualizarVersãoPeriódicamente() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(TEMPO_PARA_ATUALIZAÇÃO_DO_SERVIDOR);
					} catch (InterruptedException erro) {
						erro.printStackTrace();
					}
					atualizarVersão();
				}
			}
		}).start();
	}
}
