package modelo.cartela;

import java.util.List;

import modelo.sorteio.TipoRecipiente;

public interface TipoCartela 
{
	public boolean verificarSeFezBingo(TipoRecipiente numerosSorteados);
	
	public List<String> fornecerListaComOsValores();
}