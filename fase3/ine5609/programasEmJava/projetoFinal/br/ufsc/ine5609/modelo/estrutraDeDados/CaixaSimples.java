package br.ufsc.ine5609.modelo.estrutraDeDados;

public class CaixaSimples<T> {
	private CaixaSimples<T> caixaDoProximoElemento;
	private T elemento;
	
	public CaixaSimples(T elemento) {
		this(elemento, null);
	}
	
	public CaixaSimples(T elemento, CaixaSimples<T> caixaDoProximoElemento) {
		this.elemento = elemento;
		this.caixaDoProximoElemento = caixaDoProximoElemento;
	}

	public T fornecerElemento() {
		return elemento;
	}

	public CaixaSimples<T> fornecerCaixaDoProximoElemento() {
		return caixaDoProximoElemento;
	}
	
	public void receberCaixaDoProximoElemento(CaixaSimples<T> caixaDoProximoElemento) {
		this.caixaDoProximoElemento = caixaDoProximoElemento;
	}
}