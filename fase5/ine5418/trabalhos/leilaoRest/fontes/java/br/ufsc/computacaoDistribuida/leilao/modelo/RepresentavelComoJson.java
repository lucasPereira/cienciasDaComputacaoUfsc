package br.ufsc.computacaoDistribuida.leilao.modelo;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public interface RepresentavelComoJson {
	
	public JSONObject fornecerComoJson() throws JSONException;
}
