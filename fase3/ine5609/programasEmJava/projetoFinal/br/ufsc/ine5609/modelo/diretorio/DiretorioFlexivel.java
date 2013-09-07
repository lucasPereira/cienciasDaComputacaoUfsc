package br.ufsc.ine5609.modelo.diretorio;

import br.ufsc.ine5609.modelo.estrutraDeDados.TipoIterador;
import br.ufsc.ine5609.modelo.estrutraDeDados.ListaEncadeada;

public class DiretorioFlexivel<K, V> implements TipoDiretorio<K, V>{
	private ListaEncadeada<ListaEncadeada<V>> particoes;
	private ListaEncadeada<K> chaves;
	
	public DiretorioFlexivel() { 
		particoes = new ListaEncadeada<ListaEncadeada<V>>();
		chaves = new ListaEncadeada<K>();
	}
	
	public void inserirDado(K chave, V valor) {
		ListaEncadeada<V> particao = fornecerParticaoDoDiretorioSeExistir(chave);
		if (particao == null) {
			particao = new ListaEncadeada<V>();
			chaves.inserirNoInicio(chave);
			particoes.inserirNoInicio(particao);
		}
		particao.inserirNoInicio(valor);
	}
	
	public boolean removerDado(K chave, V valor) {
		return fornecerParticaoDoDiretorio(chave).remover(valor);
	}
	
	private ListaEncadeada<V> fornecerParticaoDoDiretorioSeExistir(K chave) {
		TipoIterador<K> iteradorChaves = chaves.fornecerIterador();
		TipoIterador<ListaEncadeada<V>> iteradorValores = particoes.fornecerIterador();
		ListaEncadeada<V> particao = null;
		boolean possuiChave = false;
		while (iteradorChaves.temProximo() && iteradorValores.temProximo() && !possuiChave) {
			particao = iteradorValores.fornecerProximo();
			if (iteradorChaves.fornecerProximo().equals(chave)) {
				possuiChave = true;
			}
		}
		
		return possuiChave ? particao : null;
	}
	
	public ListaEncadeada<V> fornecerParticaoDoDiretorio(K chave) {
		ListaEncadeada<V> particao = fornecerParticaoDoDiretorioSeExistir(chave);
		
		return (particao != null) ? particao : new ListaEncadeada<V>();
	}
}