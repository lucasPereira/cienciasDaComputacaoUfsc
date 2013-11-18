package br.ufsc.computacaoDistribuida.leilao.recursos;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.ufsc.computacaoDistribuida.leilao.bancoDeDados.BancoDeDados;
import br.ufsc.computacaoDistribuida.leilao.modelo.Leilao;

@Path("/leilao/{nome}")
public class RecursoLeilao {
	
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response colocarJson(JSONObject leilaoJson) throws JSONException {
		Leilao leilao = new Leilao();
		leilao.fixarNome(leilaoJson.getString("nome"));
		leilao.fixarNomeDoUsuario(leilaoJson.getString("nomeDoUsuario"));
		leilao.fixarProduto(leilaoJson.getString("produto"));
		leilao.fixarDuracao(leilaoJson.getInt("duracao"));
		BancoDeDados bancoDeDados = BancoDeDados.fornecerInstância(); 
		Leilao emAndamento = bancoDeDados.obterLeilaoEmAndamento(leilao.fornecerNome());
		Leilao terminado = bancoDeDados.obterLeilaoTerminado(leilao.fornecerNome());
		JSONObject resposta;
		if (emAndamento != null || terminado != null) {
			resposta = new JSONObject();
			resposta.put("sucesso", false);
			resposta.put("erro", "Já existe um leilão com esse nome.");
			throw new WebApplicationException(Response
					.status(400)
					.entity(resposta)
					.build());
		}
		bancoDeDados.adicionarLeilãoEmAndamento(leilao);
		leilao.iniciar();
		return Response
				.status(201)
				.entity(leilao.fornecerComoJson())
				.build();
	}
}