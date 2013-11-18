package br.ufsc.computacaoDistribuida.isis.recursos.servidor;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import br.ufsc.computacaoDistribuida.isis.Servidor;

@Path("/pontoDeChecagem")
public class RecursoPontoDeChecagem {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postar(JSONArray mensagensOrdenadasComoJson) throws JSONException {
		List<String> mensagensOrdenadas = new ArrayList<String>();
		Integer quantidadeDeMensagens = mensagensOrdenadasComoJson.length();
		for (Integer indice = 0; indice < quantidadeDeMensagens; indice++) {
			mensagensOrdenadas.add(indice, mensagensOrdenadasComoJson.getString(indice));
		}
		Servidor.fornecerInstancia().executarMensagens(mensagensOrdenadas);
		return Response.ok().build();
	}
}
