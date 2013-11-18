package br.ufsc.computacaoDistribuida.isis;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONArray;
import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public final class ServidorLider extends Servidor implements LiderDeGrupo {
	
	private Integer proximoIdentificadorDeMembro; 
	private List<URI> membrosDoGrupo;
	private static ServidorLider INSTANCIA;
	private static final Integer PORTA = 7000;
	
	private ServidorLider() {
		super(PORTA);
		proximoIdentificadorDeMembro = 7001;
		membrosDoGrupo = new LinkedList<URI>();
		membrosDoGrupo.add(fornecerUri());
		INSTANCIA = this;
		new AtualizadorDePontoDeChecagem(this);
	}
	
	public static ServidorLider fornecerInstancia() {
		if (INSTANCIA == null) {
			new ServidorLider();
		}
		return INSTANCIA;
	}
	
	public void atualizarPontoDeChecagem() {
		mostrarMensagem("Atualizar pontos de checagem.", PORTA);
		JSONArray mensagens = new JSONArray(new LinkedList<String>(fornecerBaldeDeMensagens().keySet()));
		for (URI membro : membrosDoGrupo) {
			Client.create()
				.resource(UriBuilder
					.fromUri(membro)
					.path("/pontoDeChecagem")
					.build())
				.entity(mensagens)
				.post();
		}
		new AtualizadorDePontoDeChecagem(this);
	}
	
	@Override
	public Integer adicionarMembro() {
		Integer portaDoNovoMembro = proximoIdentificadorDeMembro;
		URI identificadorDoMembro = UriBuilder.fromUri(ENDERECO).port(proximoIdentificadorDeMembro).build();
		membrosDoGrupo.add(identificadorDoMembro);
		proximoIdentificadorDeMembro++;
		return portaDoNovoMembro;
	}
	
	@Override
	public Boolean removerMembro(Integer porta) {
		return membrosDoGrupo.remove(fornecerUri(porta));
	}
	
	@Override
	public List<URI> fornecerMembros() {
		return membrosDoGrupo;
	}
	
	public static URI fornecerUri() {
		return fornecerUri(PORTA);
	}
	
	public static void main(String[] argumentos) throws Exception {
		URI uri = fornecerUri();
		ResourceConfig configuraçãoDeRecursos = new PackagesResourceConfig("br.ufsc.computacaoDistribuida.isis.recursos");
		HttpServer servidorHttp = GrizzlyServerFactory.createHttpServer(uri, configuraçãoDeRecursos);
		ServidorLider.fornecerInstancia();
		mostrarMensagem("Líder iniciado.", PORTA);
		System.in.read();
		servidorHttp.start();
	}
}
