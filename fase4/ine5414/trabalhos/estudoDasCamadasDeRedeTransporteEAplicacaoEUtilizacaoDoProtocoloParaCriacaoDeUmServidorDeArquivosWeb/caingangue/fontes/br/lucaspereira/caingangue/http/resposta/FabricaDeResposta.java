package br.lucaspereira.caingangue.http.resposta;

import br.lucaspereira.caingangue.http.requisicao.Requisicao;

public class FabricaDeResposta {
	
	private static FabricaDeResposta INSTÂNCIA;
	
	private FabricaDeResposta() {
		
	}
	
	public static FabricaDeResposta fornecerInstância() {
		return (INSTÂNCIA == null) ? (INSTÂNCIA = new FabricaDeResposta()) : INSTÂNCIA;
	}
	
	public TipoResposta fornecerResposta(Requisicao requisição) {
		return new RespostaDeArquivoDeTexto(requisição);
	}
}