package br.ufsc.grafos.superGrafos;

import br.ufsc.grafos.superGrafos.propriedadesDeElementos.IgualavelCodificavel;

/**
 * <p>Vertice do grafo.</p>
 * 
 * @param <V> é o descritor do vertice do grafo. É através de V que um vertice é identificado
 * no grafo e por isso V deve implmentar a interface {@link IgualavelCodificavel}.
 */
public final class Vertice<V extends IgualavelCodificavel<V>> implements TipoComponenteDeGrafo<Vertice<V>, V> {
	
	private V descritor;
	private boolean marcado;
	
	protected Vertice(V descritor) {
		this.descritor = descritor;
		marcado = false;
	}
	
	@Override
	public void marcar() {
		marcado = true;
	}
	
	@Override
	public void desmarcar() {
		marcado = false;
	}
	
	@Override
	public boolean estáMarcado() {
		return marcado;
	}
	
	@Override
	public V fornecerDescritor() {
		return descritor;
	}
	
	@Override
	public boolean éIgual(Vertice<V> outro) {
		return descritor.éIgual(outro.descritor);
	}
	
	@Override
	public int fornecerCódigo() {
		return descritor.fornecerCódigo();
	}
	
	@Override
	public String toString() {
		return descritor.toString();
	}
}