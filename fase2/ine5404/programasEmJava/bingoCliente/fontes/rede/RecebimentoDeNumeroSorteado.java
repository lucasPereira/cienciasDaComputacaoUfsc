package rede;

import modelo.FachadaJogador;
import visao.VisaoNumerosJaSorteados; 
import edugraf.jadix.fachada.SeDito; 
import edugraf.jadix.interno.rede.ReceptorDeRede;

public class RecebimentoDeNumeroSorteado extends ReceptorDeRede 
{
	private FachadaJogador fachadaParaJogador;
	private VisaoNumerosJaSorteados interfaceNumerosJaSorteados;
	
	public RecebimentoDeNumeroSorteado(FachadaJogador fachada, VisaoNumerosJaSorteados interfaceSorteados)
	{
		fachadaParaJogador = fachada;
		interfaceNumerosJaSorteados = interfaceSorteados;
	}
	
	@SeDito
	public void tratarRecepcao(String identificadorServidor, String comando, int numero)
	{
		if(fachadaParaJogador.verificarSeOServidorEstaCorreto(identificadorServidor) && comando.equals("@envioDeNumeroSorteado"))
		{
			interfaceNumerosJaSorteados.mostrarNovoSorteado(numero);
			System.out.println("[Recebendo] Número Sorteado: " + numero);
		}
	}
}