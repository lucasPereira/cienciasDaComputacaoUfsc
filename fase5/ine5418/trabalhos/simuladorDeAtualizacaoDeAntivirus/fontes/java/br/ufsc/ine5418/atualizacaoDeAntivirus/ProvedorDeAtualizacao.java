package br.ufsc.ine5418.atualizacaoDeAntivirus;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import br.ufsc.ine5418.atualizacaoDeAntivirus.Protocolo.TipoDeAcao;

public class ProvedorDeAtualizacao {

	private final String enviarAtualização(LinkedList<Date> atualizações, int portaDeComunicaçãoTcp, Date versãoDeQuemEnviouAMensagem) {
		StringBuilder versoesAEnviar = new StringBuilder();
		Iterator<Date> iteradorDasVersões = atualizações.descendingIterator();
		while (iteradorDasVersões.hasNext()) {
			Date versão = iteradorDasVersões.next();
			if (versão.compareTo(versãoDeQuemEnviouAMensagem) >= 0) {
				versoesAEnviar.append(new Protocolo(portaDeComunicaçãoTcp, TipoDeAcao.ENVIO_DE_ATUALIZAÇÂO, versão).codificarProtocoloParaEnvio());
			}
		}
		return versoesAEnviar.toString();
	}
	
	protected final String processarRequisiçãoStream(LinkedList<Date> atualizações, int portaDeComunicaçãoTcp, String dados) {
		Protocolo mensagemRecebida = Protocolo.decodificarProtocoloRecebido(dados);
		TipoDeAcao tipoDeAção = mensagemRecebida.fornecerTipoDeAcao();
		Date versãoDeQuemEnviouAMensagem = mensagemRecebida.fornecerVersão();
		if (tipoDeAção.equals(TipoDeAcao.PEDIDO_DE_ATUALIZAÇÃO)) {
			return enviarAtualização(atualizações, portaDeComunicaçãoTcp, versãoDeQuemEnviouAMensagem);
		}
		
		return null;
	}
}
