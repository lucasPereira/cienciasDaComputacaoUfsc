package br.ufsc.computacaoDistribuida.isis.recursos;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/js/{nome}")
public class RecursoJs {
	
	@GET
	@Produces("text/javascript")
	public Response obterHtml(@PathParam("nome") String nome) {
		File arquivo = new File("fontes/js/" + nome + ".js");
		if (!arquivo.exists()) {
			throw new WebApplicationException(404);
		}
		Response resposta = Response
				.status(200)
				.entity(arquivo)
				.build();
		return resposta;
	}
}
