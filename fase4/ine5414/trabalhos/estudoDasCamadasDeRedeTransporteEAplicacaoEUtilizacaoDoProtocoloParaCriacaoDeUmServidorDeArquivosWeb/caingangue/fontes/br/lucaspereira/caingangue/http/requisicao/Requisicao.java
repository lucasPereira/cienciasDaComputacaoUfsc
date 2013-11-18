package br.lucaspereira.caingangue.http.requisicao;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import br.lucaspereira.caingangue.RegistroDeEventos;
import br.lucaspereira.caingangue.http.Metodo;
import br.lucaspereira.caingangue.http.Propriedade;
import br.lucaspereira.caingangue.http.TipoElementoHttp;
import br.lucaspereira.caingangue.http.Versao;

public class Requisicao implements TipoRequisicao {
	
	private Versao versão;
	private Metodo método;
	private String uri;
	private Map<Propriedade, String> propriedades;
	private boolean requisiçãoInválida;
	
	private static final int QUANTIDADE_MÍNIMA_DE_LINHAS = 1;
	private static final int QUANRIDADE_DE_SÍMBOLOS_NA_PRIMEIRA_LINHA = 3;
	private static final int QUANTIDADE_DE_SÍMBOLOS_NAS_LINHAS_DE_CABEÇALHO = 2;
	private static final int POSIÇÃO_DA_PROPRIEDADE = 0;
	private static final int POSIÇÃO_DO_VALOR = 1;
	private static final String SEPARADOR_DE_LINHAS = "\n";
	private static final String SEPARADOR_DE_PROPRIEDADE_E_VALOR = ": ";
	
	public Requisicao(String requisiçãoComoTexto) {
		propriedades = new HashMap<Propriedade, String>();
		requisiçãoInválida = false;
		analisarRequisição(requisiçãoComoTexto);
		versão = (versão == null) ? Versao.DESCONHECIDA : versão;
		método = (método == null) ? Metodo.DESCONHECIDO : método;
		uri = (uri == null) ? "/" : uri;
		RegistroDeEventos.registrarEvento("Requisição "+método+" recebida em "+uri);
	}

	@Override
	public Versao fonrecerVersão() {
		return versão;
	}

	@Override
	public Metodo fornecerMétodo() {
		return método;
	}

	@Override
	public String fornecerUri() {
		return uri;
	}

	@Override
	public String fornecerPropriedade(Propriedade propriedadeDesejada) {
		return propriedades.get(propriedadeDesejada);
	}
	
	@Override
	public boolean éValida() {
		return requisiçãoInválida;
	}
	
	private void analisarRequisição(String requisiçãoComoTexto) {
		String[] linhasDaRequisição = requisiçãoComoTexto.split(SEPARADOR_DE_LINHAS);
		int linhaLida = 0;
		int quantidadeDeLinhas = linhasDaRequisição.length;
		if (quantidadeDeLinhas >= QUANTIDADE_MÍNIMA_DE_LINHAS) {
			analisarPrimeiraLinha(linhasDaRequisição[linhaLida++]);
			while (linhaLida < quantidadeDeLinhas) {
				analisarLinhaDeCabeçalho(linhasDaRequisição[linhaLida++]);
			}
		} else {
			requisiçãoInválida = true;
		}
	}
	
	private void analisarPrimeiraLinha(String primeiraLinha) {
		StringTokenizer leitorDeSímbolos = new StringTokenizer(primeiraLinha);
		if (leitorDeSímbolos.countTokens() == QUANRIDADE_DE_SÍMBOLOS_NA_PRIMEIRA_LINHA) {
			método = identificarElementoHttp(Metodo.values(), leitorDeSímbolos.nextToken());
			uri = leitorDeSímbolos.nextToken();
			versão = identificarElementoHttp(Versao.values(), leitorDeSímbolos.nextToken());
		} else {
			requisiçãoInválida = true;
		}
	}
	
	private void analisarLinhaDeCabeçalho(String linha) {
		String[] propriedadeEValor = linha.split(SEPARADOR_DE_PROPRIEDADE_E_VALOR);
		if (propriedadeEValor.length == QUANTIDADE_DE_SÍMBOLOS_NAS_LINHAS_DE_CABEÇALHO) {
			Propriedade propriedade = identificarElementoHttp(Propriedade.values(), propriedadeEValor[POSIÇÃO_DA_PROPRIEDADE]);
			String valor = propriedadeEValor[POSIÇÃO_DO_VALOR];
			propriedades.put(propriedade, valor);
		} else {
			requisiçãoInválida = true;
		}
	}
	
	private <T extends TipoElementoHttp<T>> T identificarElementoHttp(T[] elementosHttp, String elementoHttpComoTexto) {
		for (T elementoHttp : elementosHttp) {
			if (elementoHttp.éIgual(elementoHttpComoTexto)) {
				return elementoHttp;
			}
		}
		//requisiçãoInválida = true;
		
		return null;		
	}
}