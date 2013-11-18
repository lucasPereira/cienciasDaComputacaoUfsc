package br.ufsc.computacaoDistribuida.isis.recursos.cliente;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.ufsc.computacaoDistribuida.isis.Servidor;

@Path("saldo")
public class RecursoSaldo {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obter() throws JSONException {
		JSONObject saldoComoJson = new JSONObject();
		saldoComoJson.put("saldo", Servidor.fornecerInstancia().fornecerSaldo());
		return Response.ok().entity(saldoComoJson).build();
	}
}
