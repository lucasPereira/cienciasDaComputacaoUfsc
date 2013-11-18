package br.ufsc.computacaoDistribuida.isis;

import java.io.Serializable;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public final class Mensagem implements Serializable {
	
	private static final long serialVersionUID = -8962686373067449868L;

	public enum Operacao {
		DEPOSITAR {
			public void executar(Conta conta, double valor) {
				conta.depositar(valor);
			}
		}, 
		SACAR {
			public void executar(Conta conta, double valor) {
				conta.sacar(valor);
			}
		}, 
		CORRIGIR {
			public void executar(Conta conta, double correcao) {
				conta.corrigir(correcao);
			}
		};
		
		public abstract void executar(Conta conta, double correcao);
	}
	
	private String identificador;
	private Double valor;
	private Operacao operacao;
	
	public Mensagem(JSONObject comoJson) {
		String operacaoComoTexto;
		try {
			this.identificador = comoJson.getString("identificador");
			this.valor = comoJson.getDouble("valor");
			operacaoComoTexto = comoJson.getString("operacao");
			if (operacaoComoTexto.equals("DEPOSITAR")) {
				operacao = Operacao.DEPOSITAR;
			} else if (operacaoComoTexto.equals("SACAR")) {
				operacao = Operacao.SACAR;
			} else if (operacaoComoTexto.equals("CORRIGIR")) {
				operacao = Operacao.CORRIGIR;
			}
		} catch (JSONException excecao) {
			excecao.printStackTrace();
		}
	}
	
	public Mensagem(String identificador, Operacao operacao, Double valor) {
		this.identificador = identificador;
		this.valor = valor;
		this.operacao = operacao;
	}
	
	public void executar(Conta conta) {
		operacao.executar(conta, valor);
	}
	
	@Override
	public boolean equals(Object outro) {
		if (outro instanceof Mensagem) {
			return identificador.equals(outro);
		}
		return false;
	}
	
	public String fornecerIdentificador() {
		return identificador;
	}
	
	public JSONObject fornecerComoJson() {
		JSONObject comoJson = new JSONObject();
		try {
			comoJson.put("identificador", identificador);
			comoJson.put("valor", valor);
			comoJson.put("operacao", operacao.toString());
		} catch (JSONException excecao) {
			excecao.printStackTrace();
		}
		return comoJson;
	}
}
