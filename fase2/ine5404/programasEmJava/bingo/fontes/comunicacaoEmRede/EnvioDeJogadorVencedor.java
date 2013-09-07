package comunicacaoEmRede;

import modelo.jogador.FachadaJogador; 
import edugraf.jadix.fachada.TratadorDixAbstrato;  
import static edugraf.jadix.primitivas.Primitiva.tupla; 

public class EnvioDeJogadorVencedor extends TratadorDixAbstrato 
{
	private String jogadorVencedor;
	private FachadaJogador fachadaParaJogador;
	
	public EnvioDeJogadorVencedor(FachadaJogador fachada, String nomeDoJogadorVencedor)
	{
		jogadorVencedor = nomeDoJogadorVencedor;
		fachadaParaJogador = fachada;
	}
	
	public void enviarJogadorVencedor()
	{
		fachadaParaJogador.receberJogadorVencedor(jogadorVencedor);
		tupla(jogadorVencedor).dizer();
		System.out.println("[Enviando] Jogador Vencedor: "+jogadorVencedor);
	}
}
