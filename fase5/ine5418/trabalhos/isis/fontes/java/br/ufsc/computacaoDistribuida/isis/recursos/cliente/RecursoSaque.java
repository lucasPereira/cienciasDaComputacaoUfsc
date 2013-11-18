package br.ufsc.computacaoDistribuida.isis.recursos.cliente;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.ufsc.computacaoDistribuida.isis.Mensagem;
import br.ufsc.computacaoDistribuida.isis.Mensagem.Operacao;
import br.ufsc.computacaoDistribuida.isis.Servidor;

@Path("/saque/{identificador}")
public final class RecursoSaque {
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postar(@PathParam("identificador") String identificador, JSONObject dados) throws JSONException {
		Servidor.fornecerInstancia().receberMensagem(new Mensagem(identificador, Operacao.SACAR, dados.getDouble("valor")));
		return Response.ok().build();
	}
}
