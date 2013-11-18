package br.ufsc.ine5418.atualizacaoDeAntivirus;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AtualizacaoDeAntivirus {
	
	private Map<Integer, ClienteDeAntivirus> clientes;
	private Map<Integer, JLabel> portasTcps;
	private Map<Integer, JLabel> versõesAtuais;
	private Map<Integer, JTextArea> versõesRecebidas;
	private Map<Integer, JTextArea> atualizaçõesRecebidas;
	private static final int QUANTIDADE_DE_CLIENTES = 3;
	
	public AtualizacaoDeAntivirus() {
		clientes = new HashMap<Integer, ClienteDeAntivirus>(QUANTIDADE_DE_CLIENTES);
		portasTcps = new HashMap<Integer, JLabel>(QUANTIDADE_DE_CLIENTES);
		versõesAtuais = new HashMap<Integer, JLabel>(QUANTIDADE_DE_CLIENTES);
		versõesRecebidas = new HashMap<Integer, JTextArea>(QUANTIDADE_DE_CLIENTES);
		atualizaçõesRecebidas = new HashMap<Integer, JTextArea>(QUANTIDADE_DE_CLIENTES);
		for (int contador = 0; contador < QUANTIDADE_DE_CLIENTES; contador++) {
			ClienteDeAntivirus cliente = new ClienteDeAntivirus(this);
			int portaTcpDoCliente = cliente.fornecerPortaDeComunicaçãoTcp();
			JLabel textoPortaTcp = new JLabel("Porta TCP: " +portaTcpDoCliente);
			JLabel textoVersão = new JLabel("Versão: " +new SimpleDateFormat("dd-MM-yyyy").format(cliente.fornecerVersão()));
			JTextArea areaDeTextoVersõesRecebidas = new JTextArea("Versões recebidas:");
			JTextArea areaDeTextoAtualizaçõesRecebidas = new JTextArea("Atualizações recebidas:");
			clientes.put(portaTcpDoCliente, cliente);
			portasTcps.put(portaTcpDoCliente, textoPortaTcp);
			versõesAtuais.put(portaTcpDoCliente, textoVersão);
			versõesRecebidas.put(portaTcpDoCliente, areaDeTextoVersõesRecebidas);
			atualizaçõesRecebidas.put(portaTcpDoCliente, areaDeTextoAtualizaçõesRecebidas);
			criarJanelaDoCliente(portaTcpDoCliente, textoPortaTcp, textoVersão, areaDeTextoVersõesRecebidas, areaDeTextoAtualizaçõesRecebidas);
		}
		JFrame janelaDoServidor = criarJanela(300, 150);
		JLabel textoPortaTcpDoServidor = new JLabel("Porta TCP do servidor: " +7000);
		JLabel versãoDoServidor = new JLabel("Versão do servidor:");
		Container contâinerDeServidor = janelaDoServidor.getContentPane();
		contâinerDeServidor.setLayout(new BoxLayout(contâinerDeServidor, BoxLayout.Y_AXIS));
		contâinerDeServidor.add(textoPortaTcpDoServidor);
		contâinerDeServidor.add(versãoDoServidor);
		janelaDoServidor.setVisible(true);
		versõesAtuais.put(7000, versãoDoServidor);
		new ServidorDeAntivirus(this);
	}
	
	public void atualizarVersão(int portaDeComunicaçãoTcp, Date versão) {
		versõesAtuais.get(portaDeComunicaçãoTcp).setText("Versão: "+new SimpleDateFormat("dd-MM-yyyy").format(versão).toString());
	}
	
	public void adicionarVersãoRecebida(int portaDeComunicaçãoTcp, Date versãoRecebida, int portaDeComunicaçãoTcpDeQuemEnviouAVersão) {
		JTextArea áreaComVersõesRecebidas = versõesRecebidas.get(portaDeComunicaçãoTcp);
		áreaComVersõesRecebidas.append(String.format("\n%s [%s]", 
				new SimpleDateFormat("dd-MM-yyyy").format(versãoRecebida).toString(),
				portaDeComunicaçãoTcpDeQuemEnviouAVersão));
	}
	
	public void adicionarAtualizaçãoRecebida(int portaDeComunicaçãoTcp, Date versãoRecebida, int portaDeComunicaçãoTcpDeQuemEnviouAVersão) {
		JTextArea áreaComVersõesRecebidas = atualizaçõesRecebidas.get(portaDeComunicaçãoTcp);
		áreaComVersõesRecebidas.append(String.format("\n%s [%s]", 
				new SimpleDateFormat("dd-MM-yyyy").format(versãoRecebida).toString(),
				portaDeComunicaçãoTcpDeQuemEnviouAVersão));
	}
	
	public static void main(String[] args) throws InterruptedException {
		new AtualizacaoDeAntivirus();
	}
	
	private void criarJanelaDoCliente(int portaTcpDoCliente, JLabel textoPortaTcp, JLabel textoVersão, JTextArea areaDeTextoVersõesRecebidas, JTextArea areaDeTextoAtualizaçõesRecebidas) {
		JFrame janelaDoCliente = criarJanela(300, 600);
		Container contâinerDoCliente = janelaDoCliente.getContentPane();
		contâinerDoCliente.add(textoPortaTcp);
		contâinerDoCliente.add(textoVersão);
		contâinerDoCliente.add(new JScrollPane(areaDeTextoVersõesRecebidas));
		contâinerDoCliente.add(new JScrollPane(areaDeTextoAtualizaçõesRecebidas));
		contâinerDoCliente.add(criarEAdicionarTratadorDoBotãoAtualizar(portaTcpDoCliente));
		janelaDoCliente.setVisible(true);
	}
	
	private JFrame criarJanela(int largura, int altura) {
		JFrame janela = new JFrame();
		janela.setSize(largura, altura);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contâiner = janela.getContentPane();
		contâiner.setLayout(new BoxLayout(contâiner, BoxLayout.Y_AXIS));
		
		return janela;
	}
	
	private JButton criarEAdicionarTratadorDoBotãoAtualizar(int portaTcpDoCliente) {
		JButton botãoAtualizar = new JButton("Forçar Atualização");
		botãoAtualizar.setName(portaTcpDoCliente+"");
		botãoAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evento) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						int identificador = Integer.parseInt(((JButton) evento.getSource()).getName());
						clientes.get(identificador).forçarAtualização();					
					}
				}).start();
			}
		});
		
		return botãoAtualizar;
	}
}
