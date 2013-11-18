package br.ufsc.computacaoDistribuida.leilao.modelo;

import java.text.DecimalFormat;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Lance implements RepresentavelComoJson {

	private String nomeDoUsuario;
	private double valor;
	
	public Lance(String nomeDoUsuário, double valor) {
		this.nomeDoUsuario = nomeDoUsuário;
		this.valor = valor;
	}
	
	public String fornecerNomeDoUsuario() {
		return nomeDoUsuario;
	}
	
	public double fornecerValor() {
		return valor;
	}
	
	@Override
	public JSONObject fornecerComoJson() throws JSONException {
		JSONObject representaçãoJson = new JSONObject();
		representaçãoJson.put("nomeDoUsuario", nomeDoUsuario);
		representaçãoJson.put("valor", new DecimalFormat("#.##").format(valor));
		return representaçãoJson;
	}
}
