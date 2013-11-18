package br.ufsc.ine5418.atualizacaoDeAntivirus.comunicacao;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public abstract class ClienteMulticast {
	
	private MulticastSocket soqueteMulticast;
	private InetAddress grupo;
	private final int porta;
	private final static int TAMANHO_MAXIMO_DO_PACOTE_RECEBIDO = 2048;
	
	public ClienteMulticast(String nomeDoGrupo, int porta) {
		this.porta = porta;
		try {
			soqueteMulticast = new MulticastSocket(porta);
			grupo = InetAddress.getByName(nomeDoGrupo);
			soqueteMulticast.joinGroup(grupo);
		} catch (UnknownHostException erro) {
			erro.printStackTrace();
		} catch (IOException erro) {
			erro.printStackTrace();
		}
	}
	
	public final void iniciarRecebimento() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					DatagramPacket pacoteRecebido = new DatagramPacket(new byte[TAMANHO_MAXIMO_DO_PACOTE_RECEBIDO], TAMANHO_MAXIMO_DO_PACOTE_RECEBIDO);
					try {
						soqueteMulticast.receive(pacoteRecebido);
					} catch (IOException erro) {
						erro.printStackTrace();
					}
					receberPacote(new String(pacoteRecebido.getData()));
				}
			}
		}, "ClienteMulticast").start();
	}
	
	public final void enviarPacote(String dados) {
		byte[] dadosComoByte = dados.getBytes();
		try {
			soqueteMulticast.send(new DatagramPacket(dadosComoByte, dadosComoByte.length, grupo, porta));
		} catch (IOException erro) {
			erro.printStackTrace();
		}
	}
	
	public abstract void receberPacote(String dados);
}