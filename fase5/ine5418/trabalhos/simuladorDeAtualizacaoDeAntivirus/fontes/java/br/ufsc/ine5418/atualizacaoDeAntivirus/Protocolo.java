package br.ufsc.ine5418.atualizacaoDeAntivirus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Protocolo {
	
	enum TipoDeAcao {
		PEDIDO_DE_VERSÃO,
		ENVIO_DE_VERSÃO,
		PEDIDO_DE_ATUALIZAÇÃO,
		ENVIO_DE_ATUALIZAÇÂO
	}
	
	private final int portaDeComunicaçãoStream;
	private final TipoDeAcao tipoDeAção;
	private final Date versão;
	private final SimpleDateFormat formatadorDaData;
	private static final String FORMATO_DA_DATA = "dd-MM-yyyy";
	private static final String SEPARADOR_DE_ATRIBUTOS = "::";
	private static final int NUMERO_DE_ATRIBUTOS_DE_UMA_MENSAGEM = 3;
	private static final int POSICAO_DO_ATRIBUTO_IDENTIFICADOR_DO_CLIENTE = 0;
	private static final int POSICAO_DO_ATRIBUTO_TIPO_DE_AÇÃO = 1;
	private static final int POSICAO_DO_ATRIBUTO_VERSÃO = 2;
	
	public Protocolo(int identificadorDoCliente, TipoDeAcao tipoDeAção, Date versão) {
		this.portaDeComunicaçãoStream = identificadorDoCliente;
		this.tipoDeAção = tipoDeAção;
		this.versão = versão;
		formatadorDaData = new SimpleDateFormat(FORMATO_DA_DATA);
	}
	
	public static Protocolo decodificarProtocoloRecebido(String mensagem) {
		String[] simbolos = new String(mensagem).split(SEPARADOR_DE_ATRIBUTOS);
		if (simbolos.length == NUMERO_DE_ATRIBUTOS_DE_UMA_MENSAGEM) {
			for (TipoDeAcao ação : TipoDeAcao.values()) {
				if (simbolos[POSICAO_DO_ATRIBUTO_TIPO_DE_AÇÃO].equals(ação.toString())) {
					int portaDeComunicaçãoStream = Integer.parseInt(simbolos[POSICAO_DO_ATRIBUTO_IDENTIFICADOR_DO_CLIENTE]);
					Date versão = null;
					try {
						versão = new SimpleDateFormat(FORMATO_DA_DATA).parse(simbolos[POSICAO_DO_ATRIBUTO_VERSÃO]);
					} catch (ParseException erro) {
						erro.printStackTrace();
					}
					return new Protocolo(portaDeComunicaçãoStream, ação, versão);
				}
			}
		}
		
		return null;		
	} 
	
	public String codificarProtocoloParaEnvio() {
		return String.format("%s%s%s%s%s\r\n",
				portaDeComunicaçãoStream,
				SEPARADOR_DE_ATRIBUTOS,
				tipoDeAção.toString(),
				SEPARADOR_DE_ATRIBUTOS,
				formatadorDaData.format(versão).toString());
	}
	
	public TipoDeAcao fornecerTipoDeAcao() {
		return tipoDeAção;
	}
	
	public Date fornecerVersão() {
		return versão;
	}
	
	public int fornecerPortaDeComunicaçãoTcp() {
		return portaDeComunicaçãoStream;
	}
}
