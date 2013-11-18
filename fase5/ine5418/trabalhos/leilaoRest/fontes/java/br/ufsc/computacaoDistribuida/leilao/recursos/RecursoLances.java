package br.ufsc.computacaoDistribuida.leilao.recursos;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.ufsc.computacaoDistribuida.leilao.bancoDeDados.BancoDeDados;
import br.ufsc.computacaoDistribuida.leilao.modelo.Lance;
import br.ufsc.computacaoDistribuida.leilao.modelo.Leilao;

@Path("/leilao/{nome}/lances")
public class RecursoLances {

	@POST
	@Consumes("application/json")
	public Response postarJson(@PathParam("nome") String nomeDoLeilao, JSONObject dados) throws JSONException {
		BancoDeDados bancoDeDados = BancoDeDados.fornecerInstância();
		Leilao leilao = bancoDeDados.obterLeilaoEmAndamento(nomeDoLeilao);
		if (leilao == null) {
			JSONObject erro = new JSONObject();
			erro.put("sucesso", false);
			erro.put("erro", "Não foi possível dar o lançe no leilão, pois ele não está em andamento.");
			throw new WebApplicationException(Response
					.status(400)
					.entity(erro)
					.build());
		}
		Lance lance = new Lance(dados.getString("nomeDoUsuario"), dados.getDouble("valor"));
		if (leilao.donoDoLeilaoDeuUmLance(lance.fornecerNomeDoUsuario())) {
			JSONObject erro = new JSONObject();
			erro.put("sucesso", false);
			erro.put("erro", "Não é possível dar um lance no próprio leilão.");
			throw new WebApplicationException(Response
					.status(400)
					.entity(erro)
					.build());
		}
		leilao.darLance(lance);
		return Response
				.status(200)
				.entity(lance.fornecerComoJson())
				.build();
	}
}
