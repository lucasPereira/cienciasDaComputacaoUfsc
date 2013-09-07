package visao;

import aplique.ApliqueJogador;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;

public class VisaoNumerosJaSorteados 
{
	private PaginaDix paginaJogador;
	private ComponenteDix etiquetaNumeroSorteado;
	private ComponenteDix areaDeTextoNumerosJaSorteados;
		
	public VisaoNumerosJaSorteados()
	{
		paginaJogador = new ApliqueJogador().obterPaginaDix();
		etiquetaNumeroSorteado = paginaJogador.criarProcuradorDeComponente("etiquetaNumeroSorteado");
		areaDeTextoNumerosJaSorteados = paginaJogador.criarProcuradorDeComponente("areaDeTextoNumerosJaSorteados");
		
		limparNumerosJaSorteados();
	}
	
	public void mostrarNovoSorteado(int novoSorteado)
	{
		String numerosAnteriores = areaDeTextoNumerosJaSorteados.obterTexto();
		areaDeTextoNumerosJaSorteados.fixarTexto(+novoSorteado+"\n"+numerosAnteriores);	
		alterarUltimoNumeroSorteado(novoSorteado);
	}
	
	public void alterarUltimoNumeroSorteado(int novoSorteado)
	{
		etiquetaNumeroSorteado.fixarTexto("<big>"+novoSorteado+"</big>");
	}
	
	public void limparNumerosJaSorteados()
	{
		areaDeTextoNumerosJaSorteados.fixarTexto("");
	}
}
