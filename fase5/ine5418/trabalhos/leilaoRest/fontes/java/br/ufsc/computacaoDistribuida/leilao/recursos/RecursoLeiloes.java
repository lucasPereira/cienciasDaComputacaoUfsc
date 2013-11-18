package br.ufsc.computacaoDistribuida.leilao.recursos;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import br.ufsc.computacaoDistribuida.leilao.bancoDeDados.BancoDeDados;
import br.ufsc.computacaoDistribuida.leilao.modelo.Leilao;

@Path("/leiloes/")
public class RecursoLeiloes {
	
	@GET
	@Produces("application/json")
	public Response obterJson(@QueryParam("terminados") boolean terminados) throws JSONException {
		BancoDeDados bancoDeDados = BancoDeDados.fornecerInstância();
		JSONArray leiloesJson = new JSONArray();
		Map<String, Leilao> leiloes;
		if (terminados) {
			leiloes = bancoDeDados.fornecerLeiloesTerminados();
			for (String nomeDoLeilao : leiloes.keySet()) {
				leiloesJson.put(bancoDeDados.obterLeilaoTerminado(nomeDoLeilao).fornecerComoJson());
			}
		} else {
			leiloes = bancoDeDados.fornecerLeiloesEmAndamento();
			for (String nomeDoLeilao : leiloes.keySet()) {
				leiloesJson.put(bancoDeDados.obterLeilaoEmAndamento(nomeDoLeilao).fornecerComoJson());
			}
		}
		return Response
				.status(200)
				.entity(leiloesJson)
				.build();
	}
}