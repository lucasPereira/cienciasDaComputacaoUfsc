package br.ufsc.inf.ine5426.caneca.maquina;

import java.util.Map;

public final class CodigoInstanciar implements Codigo {
	String nomeDaClasse;
	
	public CodigoInstanciar(String nomeDaClasse) {
		this.nomeDaClasse = nomeDaClasse;
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		Contexto contextoDaClasse = maquina.pilhaDeContextos.peek().resolverContexto(nomeDaClasse);
		Contexto contextoDoObjeto = new Contexto(contextoDaClasse);
		for (Map.Entry<String, Valor> atributo : contextoDaClasse.fornecerSimbolos().entrySet()) {
			contextoDoObjeto.definirSimbolo(atributo.getKey(), atributo.getValue());
		}
		ValorReferencia objeto = new ValorReferencia(contextoDoObjeto);
		contextoDoObjeto.definirSimbolo("esse", objeto);
		contextoDoObjeto.definirSimbolo("essa", objeto);
		maquina.pilhaDeDados.push(objeto);
	}
	
	@Override
	public String comoTexto() {
		return String.format("instanciar %s", nomeDaClasse);
	}
}
