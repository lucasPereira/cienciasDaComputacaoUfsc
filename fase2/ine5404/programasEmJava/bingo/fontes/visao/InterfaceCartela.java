package visao;

import apliques.ApliqueJogador;
import modelo.jogador.FachadaJogador;
import java.util.ArrayList; 
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;

public class InterfaceCartela 
{
	private PaginaDix paginaJogador;
	private int numeroDeLinhas;
	private int numeroDeColunas;
	private ArrayList<ComponenteDix> celulas = new ArrayList<ComponenteDix>();
	
	public InterfaceCartela(FachadaJogador fachada)
	{
		paginaJogador = new ApliqueJogador().obterPaginaDix();
		numeroDeLinhas = 3;
		numeroDeColunas = 5;
		
		criarCelulas();
	}
	
	public void criarCelulas()
	{
		for(int linha = 1; linha <= numeroDeLinhas; linha++)
		{
			for(int coluna = 1; coluna <= numeroDeColunas; coluna++)
			{
				ComponenteDix celula = paginaJogador.criarProcuradorDeComponente("gradeCartela_"+linha+"_"+coluna);
				celulas.add(celula);
			}
		}
	}
	
	public void mostrarCartela(ArrayList<String> numero)
	{	
		for(int cont = 0; cont < celulas.size(); cont++)
		{
			celulas.get(cont).fixarTexto("<span>"+numero.get(cont)+"</span>");
		}
	}
	
	public void limparCartela()
	{
		for(int cont = 0; cont < celulas.size(); cont++)
		{
			celulas.get(cont).fixarTexto("");
			celulas.get(cont).fixarCorDePreenchimento(205, 102, 29);
		}
	}
	
	public void marcarCelula(String nomeDaCelula)
	{
		paginaJogador.criarProcuradorDeComponente(nomeDaCelula).fixarCorDePreenchimento(200, 200, 200);
	}
	
	public void desmarcarCelula(String nomeDaCelula)
	{
		paginaJogador.criarProcuradorDeComponente(nomeDaCelula).fixarCorDePreenchimento(205, 102, 29);
	}
}