package br.ufsc.computacaoDistribuida.isis.recursos.servidor;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.ufsc.computacaoDistribuida.isis.ServidorLider;

import com.sun.jersey.api.Responses;

@Path("/membro/{porta}")
public final class RecursoMembro {
	
	@DELETE
	public Response remover(@PathParam("porta") Integer porta) {
		Boolean existe = ServidorLider.fornecerInstancia().removerMembro(porta);
		if (existe) {
			return Response.ok().build();
		}
		return Response.status(Responses.NOT_FOUND).build(); 
	}
}
