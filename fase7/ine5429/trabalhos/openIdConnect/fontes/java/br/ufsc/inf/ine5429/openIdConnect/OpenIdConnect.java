package br.ufsc.inf.ine5429.openIdConnect;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;

public final class OpenIdConnect {
	private static final String PACOTE_DOS_RECURSOS = "br.ufsc.inf.ine5429.openIdConnect";
	private static final String URI = "http://localhost:7000";

	public static void main(String[] argumentos) throws IOException {
		URI uriBase = UriBuilder.fromUri(URI).build();
		ResourceConfig configuracaoDeRecurso = new PackagesResourceConfig(PACOTE_DOS_RECURSOS);
		HttpServer servidorHttp = GrizzlyServerFactory.createHttpServer(uriBase, configuracaoDeRecurso);
		System.out.println(String.format("Servidor iniciado em %s. Aperte enter para encerrar.", uriBase.toString()));
		System.in.read();
		servidorHttp.stop();
	}
}
