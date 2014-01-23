package br.ufsc.inf.ine5429.openIdConnect;

import br.dominioL.conexaoH.CodigoDeEstado;
import br.dominioL.conexaoH.TipoDeMidia;
import br.dominioL.conexaoH.TiposDeMidia;
import br.dominioL.estruturados.json.Json;
import br.dominioL.estruturados.json.ListaJson;
import br.dominioL.estruturados.json.ObjetoJson;
import br.dominioL.estruturados.json.ValorJson;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;


@Path("/autenticacao")
public final class RecursoAutenticacao {
	private static final String IDENTIFICADOR = "fe763eb46743aff02b78";
	private static final String SEGREDO  = "ff94db2473a0c67e73ec55a59ce75f009851af2a";
	private static final String	AUTORIZACAO = "https://github.com/login/oauth/authorize";
	private static final String ACESSO = "https://github.com/login/oauth/access_token";
	private static final String SERVICO = "https://api.github.com/user/emails";
	private static final String RETORNO = "/autenticacao/retorno";
	private static final String ESCOPO = "user:email";
	private @Context UriInfo informacaoDeUri;

	@GET
	@Produces(TiposDeMidia.HTML)
	public Response obterHtml() {
		URI retorno = UriBuilder.fromUri(informacaoDeUri.getBaseUri()).path(RETORNO).build();
		UriBuilder construtorDeUri = UriBuilder.fromUri(AUTORIZACAO);
		construtorDeUri.queryParam("client_id", IDENTIFICADOR);
		construtorDeUri.queryParam("redirect_url", retorno);
		construtorDeUri.queryParam("scope", ESCOPO);
		return Response.seeOther(construtorDeUri.build()).build();
	}

	@GET
	@Path("retorno")
	@Produces(TiposDeMidia.HTML)
	public Response obterJson(@QueryParam("code") String codigo) {
		if (codigo != null) {
			ObjetoJson tokenDeAcesso = obterTokenDeAcesso(codigo);
			Client clienteHttp = Client.create();
			UriBuilder construtorDeUri = UriBuilder.fromUri(SERVICO);
			ValorJson token = tokenDeAcesso.fornecerElemento(Json.criarIdentificador("access_token"));
			construtorDeUri.queryParam("access_token", token.fornecerComoTexto());
			WebResource recurso = clienteHttp.resource(construtorDeUri.build());
			String resposta = recurso.accept(TiposDeMidia.JSON).get(String.class);
			ListaJson respostaJson = Json.criarLista(resposta);
			ObjetoJson respostaFinal = Json.criarObjeto();
			respostaFinal.inserir(Json.criarIdentificador("tokenDeAcesso"), tokenDeAcesso);
			respostaFinal.inserir(Json.criarIdentificador("emailsDoUsuario"), respostaJson);
			return CodigoDeEstado.HTTP_200.fornecerResposta(TipoDeMidia.JSON, respostaFinal.fornecerComoJson());
		}
		return Response.seeOther(UriBuilder.fromResource(RecursoAutenticacao.class).build()).build();
	}

	private ObjetoJson obterTokenDeAcesso(String codigo) {
		Client clienteHttp = Client.create();
		UriBuilder construtorDeUri = UriBuilder.fromUri(ACESSO);
		construtorDeUri.queryParam("client_id", IDENTIFICADOR);
		construtorDeUri.queryParam("client_secret", SEGREDO);
		construtorDeUri.queryParam("code", codigo);
		WebResource recurso = clienteHttp.resource(construtorDeUri.build());
		String resposta = recurso.accept(TiposDeMidia.JSON).post(String.class);
		ObjetoJson respostaJson = Json.criarObjeto(resposta);
		return respostaJson;
	}
}
