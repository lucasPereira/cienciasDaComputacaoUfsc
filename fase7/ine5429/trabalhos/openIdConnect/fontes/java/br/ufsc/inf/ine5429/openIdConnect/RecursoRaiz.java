package br.ufsc.inf.ine5429.openIdConnect;

import br.dominioL.conexaoH.CodigoDeEstado;
import br.dominioL.conexaoH.TipoDeMidia;
import br.dominioL.conexaoH.TiposDeMidia;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
public final class RecursoRaiz {
	@GET
	@Produces(TiposDeMidia.HTML)
	public Response obterHtml() {
		return CodigoDeEstado.HTTP_200.fornecerResposta(TipoDeMidia.HTML, Arquivo.INICIO.fornecerArquivo());
	}
}
