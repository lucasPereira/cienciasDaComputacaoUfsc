package br.ufsc.computacaoDistribuida.isis;

import java.net.URI;
import java.util.List;

public interface LiderDeGrupo {
	
	public Integer adicionarMembro();
	
	public Boolean removerMembro(Integer porta);
	
	public List<URI> fornecerMembros();
}
