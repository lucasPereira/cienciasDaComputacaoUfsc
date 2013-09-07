package modelo.estruturasBidimensionais.hash;

import modelo.estruturasLineares.lista.ListaSimplesEncadeadaComAlocacaoDinamica;
import modelo.execoes.execoesDeHash.ExececaoDeValorNuloNoHash;
import modelo.utilidades.Igualavel;

public final class HashComGruposEmListasGuardadasEmUmArray<K extends Hashavel, V extends Igualavel<V>> 
{
	private ListaSimplesEncadeadaComAlocacaoDinamica<V>[] grupos;
	
	private static final int ZERO = 0;
	
	@SuppressWarnings("unchecked")
	public HashComGruposEmListasGuardadasEmUmArray(int quantidadeDeGrupos)
	{
		if (quantidadeDeGrupos <= 0) throw new IllegalArgumentException("Quantidade de grupo deve ser maios que zero.");
		grupos = new ListaSimplesEncadeadaComAlocacaoDinamica[quantidadeDeGrupos];
		inicializarListas();
	}
	
	private void inicializarListas()
	{
		for (int cont = ZERO; cont < grupos.length; cont++)
		{
			grupos[cont] = new ListaSimplesEncadeadaComAlocacaoDinamica<V>();
		}
	}
	
	public void inserir(K chave, V valor)
	{
		if (valor == null)
		{
			throw new ExececaoDeValorNuloNoHash();
		}
		grupos[fornecerGrupo(chave)].inserirInicio(valor);
	}
	
	public boolean remover(K chave, V valor)
	{
		return grupos[fornecerGrupo(chave)].removerElemento(valor);
	}
	
	public boolean verificarSePossuiElemento(K chave, V valor)
	{	
		return grupos[fornecerGrupo(chave)].verificarSePossuiElemento(valor);
	}
	
	private int fornecerGrupo(K chave)
	{
		int codigoHash = chave.fornecerCodigoHash();
		int grupo = codigoHash%grupos.length;
		grupo = Math.abs(grupo);
		
		return grupo;
	}
}