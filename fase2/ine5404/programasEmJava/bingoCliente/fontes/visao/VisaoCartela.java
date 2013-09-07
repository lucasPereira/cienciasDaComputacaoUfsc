package visao;

import aplique.ApliqueJogador;

import java.util.ArrayList; 
import java.util.List;

import modelo.FachadaJogador;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.pichador.Cor;

public class VisaoCartela 
{
	private PaginaDix paginaJogador;
	private int numeroDeLinhas;
	private int numeroDeColunas;
	private List<ComponenteDix> celulas = new ArrayList<ComponenteDix>();
	
	public VisaoCartela(FachadaJogador fachada)
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
			percorrerColunas(linha);
		}
	}

	private void percorrerColunas(int linha) 
	{
		for(int coluna = 1; coluna <= numeroDeColunas; coluna++)
		{
			ComponenteDix celula = paginaJogador.criarProcuradorDeComponente("gradeCartela_"+linha+"_"+coluna);
			celulas.add(celula);
		}
	}
	
	public void mostrarCartela(List<String> numero)
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
	
	public void marcarEDesmarcarCelula(String nomeDaCelula)
	{
		ComponenteDix celula = paginaJogador.criarProcuradorDeComponente(nomeDaCelula);
		Cor corDaCelula = celula.obterCorDePreenchimento();
		
		if(corDaCelula.obterVermelho() == 205 && corDaCelula.obterVerde() == 102 && corDaCelula.obterAzul() == 29)
		{
			marcarCelula(nomeDaCelula);
		}
		else
		{
			desmarcarCelula(nomeDaCelula);
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