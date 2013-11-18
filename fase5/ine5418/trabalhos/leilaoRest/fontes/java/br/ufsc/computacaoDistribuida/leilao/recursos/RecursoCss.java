package br.ufsc.computacaoDistribuida.leilao.recursos;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/css/{nome}")
public class RecursoCss {
	
	@GET
	@Produces("text/css")
	public Response obterHtml(@PathParam("nome") String nome) {
		File arquivo = new File("fontes/css/" + nome + ".css");
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
