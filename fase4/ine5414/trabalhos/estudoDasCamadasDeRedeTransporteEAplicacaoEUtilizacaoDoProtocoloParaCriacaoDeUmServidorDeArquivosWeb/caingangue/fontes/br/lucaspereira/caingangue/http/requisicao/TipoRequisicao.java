package br.lucaspereira.caingangue.http.requisicao;

import br.lucaspereira.caingangue.http.Metodo;
import br.lucaspereira.caingangue.http.Propriedade;
import br.lucaspereira.caingangue.http.Versao;

public interface TipoRequisicao {
	
	public Versao fonrecerVersão();
	
	public Metodo fornecerMétodo();
	
	public String fornecerUri();
	
	public String fornecerPropriedade(Propriedade propriedadeDesejada);
	
	public boolean éValida();
}