package comunicacaoEmRede;

import modelo.servidor.FachadaServidor;
import edugraf.jadix.fachada.SeDito;  
import edugraf.jadix.interno.rede.ReceptorDeRede;

public class RecebimentoNovoBingo extends ReceptorDeRede 
{
	private FachadaServidor fachadaParaServidor;
	
	public RecebimentoNovoBingo(FachadaServidor fachada)
	{
		fachadaParaServidor = fachada;
	}
	
	@SeDito
	public void tratarRecepcao(String jogadorVencedor)
	{
		System.out.println("[Servidor] Iniciando Novo Bingo. Jogador Vencedor: "+jogadorVencedor);
		fachadaParaServidor.bingo();
	}
}