package comunicacaoEmRede;

import modelo.jogador.FachadaJogador; 
import edugraf.jadix.fachada.SeDito;  
import edugraf.jadix.interno.rede.ReceptorDeRede;

public class RecebimentoDeJogadorVencedor extends ReceptorDeRede 
{
	private FachadaJogador fachadaParaJogador;
	
	public RecebimentoDeJogadorVencedor(FachadaJogador fachada)
	{
		fachadaParaJogador = fachada;
	}
	
	@SeDito
	public void tratarRecepcao(String jogadorVencedor)
	{
		fachadaParaJogador.receberJogadorVencedor(jogadorVencedor);
		System.out.println("[Recebendo] Jogador Vencedor "+jogadorVencedor);
	}
}