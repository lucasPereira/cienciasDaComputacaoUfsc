package br.ufsc.computacaoDistribuida.leilao.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.ufsc.computacaoDistribuida.leilao.bancoDeDados.BancoDeDados;
import br.ufsc.computacaoDistribuida.leilao.recursos.RecursoLances;

public class Leilao implements RepresentavelComoJson {
	
	private String nomeDoUsuario;
	private String nome;
	private String produto;
	private int duracao;
	private Date inicio;
	private List<Lance> lances;
	private Lance ultimoLance;
	
	public Leilao() {
		inicio = new Date();
		lances = new ArrayList<Lance>();
	}
	
	public boolean donoDoLeilaoDeuUmLance(String nomeDeQuemDeuOLance) {
		return nomeDoUsuario.equals(nomeDeQuemDeuOLance);
	}
	
	public void fixarNomeDoUsuario(String nomeDoUsuario) {
		this.nomeDoUsuario = nomeDoUsuario;
	}
	
	public String fornecerNome() {
		return nome;
	}
	
	public void fixarNome(String nome) {
		this.nome = nome;
	}
	
	public void fixarProduto(String produto) {
		this.produto = produto;
	}
	
	public int fornecerDuracao() {
		return duracao;
	}
	
	public void fixarDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public void darLance(Lance lance) {
		ultimoLance = lance;
		lances.add(lance);
	}
	
	public JSONObject fornecerLanceVencedor() throws JSONException {
		Lance maiorLance = null;
		if (lances.size() > 0) {
			maiorLance = lances.get(0);
		}
		for (Lance lance : lances) {
			if (lance.fornecerValor() > maiorLance.fornecerValor()) {
				maiorLance = lance;
			}
		}
		if (maiorLance != null) {
			return maiorLance.fornecerComoJson();
		}
		return null;
	}
	
	public void iniciar() {
		BancoDeDados bancoDeDados = BancoDeDados.fornecerInstância();
		bancoDeDados.adicionarLeilãoEmAndamento(this);
		new TerminadorDeLeilao(this);
	}
	
	public JSONObject fornecerComoJson() throws JSONException {
		JSONObject representaçãoJson = new JSONObject();
		representaçãoJson.put("nome", nome);
		representaçãoJson.put("nomeDoUsuario", nomeDoUsuario);
		representaçãoJson.put("produto", produto);
		representaçãoJson.put("duracao", duracao);
		String dataFormatada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(inicio);
		representaçãoJson.put("inicio", dataFormatada);
		representaçãoJson.put("lanceVencedor", fornecerLanceVencedor());
		if (ultimoLance != null) { 
			representaçãoJson.put("ultimoLance", ultimoLance.fornecerComoJson());
		}
		representaçãoJson.put("uriDosLances", UriBuilder.fromResource(RecursoLances.class).build(nome));
		return representaçãoJson;
	}
}
