package br.ufsc.computacaoDistribuida.isis.recursos.servidor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import br.ufsc.computacaoDistribuida.isis.ServidorLider;

@Path("/membros")
public final class RecursoMembros {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obter() {
		return Response
					.ok()
					.header("Access-Control-Allow-Origin", "*")
					.entity(new JSONArray(ServidorLider.fornecerInstancia().fornecerMembros()))
					.build();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response postar() {
		return Response
					.ok()
					.header("Access-Control-Allow-Origin", "*")
					.entity(ServidorLider.fornecerInstancia().adicionarMembro().toString())
					.build();
	}
}
