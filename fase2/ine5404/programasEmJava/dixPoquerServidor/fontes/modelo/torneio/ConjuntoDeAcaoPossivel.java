package modelo.torneio;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoDeAcaoPossivel 
{
	private Set<AcaoPossivel> acoes;
	
	public ConjuntoDeAcaoPossivel()
	{
		acoes = new HashSet<AcaoPossivel>();
	}
	
	public void adicionarAcaoPossivel(AcaoPossivel acao)
	{
		acoes.add(acao);
	}
	
	public void removerAcaoPossivel(AcaoPossivel acao)
	{
		acoes.remove(acao);
	}
	
	public boolean verificarSeColecaoPossuiAcao(AcaoPossivel acao)
	{
		return acoes.contains(acao);
	}
}
