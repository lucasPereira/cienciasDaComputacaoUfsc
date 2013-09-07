package comunicacaoEmRede;

import modelo.jogador.FachadaJogador; 
import visao.InterfaceNumerosJaSorteados; 
import edugraf.jadix.fachada.SeDito; 
import edugraf.jadix.interno.rede.ReceptorDeRede;

public class RecebimentoDeNumeroSorteado extends ReceptorDeRede 
{
	private InterfaceNumerosJaSorteados interfaceNumerosJaSorteados;
	private FachadaJogador fachadaParaJogador;
	
	public RecebimentoDeNumeroSorteado(FachadaJogador fachada, InterfaceNumerosJaSorteados interfaceSorteados)
	{
		interfaceNumerosJaSorteados = interfaceSorteados;
		fachadaParaJogador = fachada;
	}
	
	@SeDito
	public void tratarRecepcao(int numero)
	{
		interfaceNumerosJaSorteados.mostrarNovoSorteado(numero);
		fachadaParaJogador.receberNovoNumeroSorteado(numero);
		System.out.println("[Recebendo] Número Sorteado: " + numero);
	}
}