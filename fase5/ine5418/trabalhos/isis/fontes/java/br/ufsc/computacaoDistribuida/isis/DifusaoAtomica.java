package br.ufsc.computacaoDistribuida.isis;

import java.util.List;

public interface DifusaoAtomica {
	
	public void executarMensagens(List<String> identificadores);
}
