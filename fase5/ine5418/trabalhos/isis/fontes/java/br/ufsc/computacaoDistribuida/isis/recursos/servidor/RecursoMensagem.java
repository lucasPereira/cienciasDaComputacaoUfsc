package br.ufsc.computacaoDistribuida.isis.recursos.servidor;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;

import br.ufsc.computacaoDistribuida.isis.Mensagem;
import br.ufsc.computacaoDistribuida.isis.Servidor;

@Path("/mensagem/{identificador}")
public class RecursoMensagem {

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response colocar(JSONObject mensagem) {
		Servidor.fornecerInstancia().receberMensagem(new Mensagem(mensagem));
		return Response.ok().build();
	}
}
