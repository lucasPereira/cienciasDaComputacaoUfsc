package br.lucaspereira.caingangue.http.resposta;

import java.io.OutputStream;

public interface TipoResposta {
	
	public int fornecerCódigoDeEstado();
	
	public int fornecerRespostaComoTexto();
	
	public void responder(OutputStream arquivoDeSaída);
}