package br.ufsc.ine5609.modelo.diretorio;

import br.ufsc.ine5609.modelo.estrutraDeDados.ListaEncadeada;

public interface TipoDiretorio<K, V> {
	public void inserirDado(K chave, V valor);
	
	public boolean removerDado(K chave, V valor);
	
	public ListaEncadeada<V> fornecerParticaoDoDiretorio(K chave);
}
