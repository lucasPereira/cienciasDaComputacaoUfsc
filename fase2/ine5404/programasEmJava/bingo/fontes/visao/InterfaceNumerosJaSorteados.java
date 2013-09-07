package visao;

import java.util.ArrayList;

import apliques.ApliqueJogador;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;

public class InterfaceNumerosJaSorteados 
{
	private PaginaDix paginaJogador;
	private int numeroDeLinhasEColunas;
	private int posicaoNumero;
	private ArrayList<ComponenteDix> celulas = new ArrayList<ComponenteDix>();
		
	public InterfaceNumerosJaSorteados()
	{
		paginaJogador = new ApliqueJogador().obterPaginaDix();
		numeroDeLinhasEColunas = 7;
		posicaoNumero = 0;
		
		criarCelulas();
		limparNumerosJaSorteados();
	}
	
	public void criarCelulas()
	{
		for(int contA = 1; contA <= numeroDeLinhasEColunas; contA++)
		{
			for(int contB = 1; contB <= numeroDeLinhasEColunas; contB++)
			{
				ComponenteDix celula = paginaJogador.criarProcuradorDeComponente("gradeNumerosJaSorteados_"+contA+"_"+contB);
				celulas.add(celula);
			}
		}
	}
	
	public void mostrarNovoSorteado(int novoSorteado)
	{
		celulas.get(posicaoNumero++).fixarTexto("<small>"+novoSorteado+"</small>");
	}
	
	public void limparNumerosJaSorteados()
	{
		for(int cont = 0; cont < numeroDeLinhasEColunas * numeroDeLinhasEColunas; cont++)
		{
			posicaoNumero = 0;
			celulas.get(cont).fixarTexto("");
		}
	}
}
