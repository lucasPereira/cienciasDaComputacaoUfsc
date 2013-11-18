package br.ufsc.computacaoDistribuida.leilao;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public class ServidorLeilao {
	
	private static final int PORTA = 7000;
	private static final String ENDERECO = "http://localhost/";
	
	public static void main(String[] argumentos) throws Exception {
		final URI URI = UriBuilder.fromUri(ENDERECO).port(PORTA).build();
        ResourceConfig configuraçãoDeRecursos = new PackagesResourceConfig("br.ufsc.computacaoDistribuida.leilao.recursos");
        HttpServer servidorHttp = GrizzlyServerFactory.createHttpServer(URI, configuraçãoDeRecursos);
        System.in.read();
        servidorHttp.start();
    }    
}
