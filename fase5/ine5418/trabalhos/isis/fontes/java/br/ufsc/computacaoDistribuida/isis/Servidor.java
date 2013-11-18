package br.ufsc.computacaoDistribuida.isis;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public class Servidor implements DifusaoAtomica, DifusaoConfiavel {
	
	private Map<String,Mensagem> baldeDeMensagens;
	private Conta conta;
	private static Servidor INSTANCIA;
	private static Integer PORTA = null;
	protected static final String ENDERECO = "http://localhost/";
	
	public Servidor(Integer porta) {
		baldeDeMensagens = new HashMap<String, Mensagem>();
		conta = new Conta();
		PORTA = porta;
		INSTANCIA = this;
	}
	
	public static Servidor fornecerInstancia() {
		if (INSTANCIA == null) {
			new Servidor(PORTA);
		}
		return INSTANCIA;
	}
	
	public final Map<String, Mensagem> fornecerBaldeDeMensagens() {
		return this.baldeDeMensagens;
	}
	
	@Override
	public final void enviarMensagem(Mensagem mensagem) {
		List<String> membros = obterListaDeMembros();
		for (String membro : membros) {
			Client.create()
				.resource(UriBuilder
					.fromUri(membro)
					.path("/mensagem/{identificador}")
					.build(mensagem.fornecerIdentificador()))
				.entity(mensagem.fornecerComoJson())
				.put();
		}
	}
	
	@Override
	public final void receberMensagem(Mensagem mensagem) {
		String identificadorDaMensagem = mensagem.fornecerIdentificador();
		if (!baldeDeMensagens.containsKey(identificadorDaMensagem)) {
			baldeDeMensagens.put(identificadorDaMensagem, mensagem);
			enviarMensagem(mensagem);
		}
	}
	
	@Override
	public final void executarMensagens(List<String> identificadores) {
		for(String identificador : identificadores){
			baldeDeMensagens.get(identificador).executar(conta);
			baldeDeMensagens.remove(identificador);
		}
		mostrarMensagem("Ponto de checagem atualizado. O Saldo é: " + fornecerSaldo(), PORTA);
	}
	
	public final Double fornecerSaldo() {
		return conta.fornecerSaldo();
	}
	
	private final List<String> obterListaDeMembros() {
		JSONArray membrosComoJson = Client.create()
			.resource(UriBuilder
				.fromUri(ServidorLider.fornecerUri())
				.path("/membros")
				.build())
			.get(JSONArray.class);
		List<String> membros = new ArrayList<String>();
		Integer quantidadeDeMembros = membrosComoJson.length();
		for (Integer indice = 0; indice < quantidadeDeMembros; indice++) {
			try {
				membros.add(indice, membrosComoJson.getString(indice));
			} catch (JSONException excecao) {
				excecao.printStackTrace();
			}
		}
		return membros;
	}
	
	public static URI fornecerUri(Integer porta) {
		return UriBuilder.fromUri(ENDERECO).port(porta).build();
	}
	
	protected static void mostrarMensagem(String mensagem, Integer porta) {
		System.out.println(String.format("[Servidor %d] " + mensagem, porta));
	}
	
	public static void main(String[] argumentos) throws Exception {
		URI uriDoLider = ServidorLider.fornecerUri();
		Integer porta = null;
		try {
			String portaComoTexto = Client.create().resource(UriBuilder.fromUri(uriDoLider).path("/membros").build()).post(String.class);
			porta = Integer.parseInt(portaComoTexto);
		} catch (Exception execao) {
			mostrarMensagem("O ServidorLider não está em execução.", 0);
			System.exit(0);
		}
		new Servidor(porta);
		ResourceConfig configuraçãoDeRecursos = new PackagesResourceConfig("br.ufsc.computacaoDistribuida.isis.recursos");
		HttpServer servidorHttp = GrizzlyServerFactory.createHttpServer(fornecerUri(porta), configuraçãoDeRecursos);
		mostrarMensagem("Iniciado.", porta);
		System.in.read();
		servidorHttp.start();
	}
}
