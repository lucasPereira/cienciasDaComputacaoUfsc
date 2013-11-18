package br.ufsc.grafos.superGrafos;

import br.ufsc.grafos.superGrafos.propriedadesDeElementos.IgualavelCodificavel;

/**
 * <p>Representa um componente do grafo. Aqui estão agrupadas as operações comuns
 * aos {@link Vertice}s e {@link Aresta}s.</p>
 * 
 * @param <C> é o componente, {@link Vertice} ou {@link Aresta}.
 * @param <D> é o descritor do componente.
 */
public interface TipoComponenteDeGrafo<C, D> extends IgualavelCodificavel<C> {
	
	public void marcar();
	
	public void desmarcar();
	
	public boolean estáMarcado();
	
	public D fornecerDescritor();
}