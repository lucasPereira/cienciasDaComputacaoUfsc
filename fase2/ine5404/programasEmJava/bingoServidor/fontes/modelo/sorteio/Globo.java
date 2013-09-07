package modelo.sorteio;

import java.util.ArrayList;
import java.util.List;

public class Globo implements TipoGlobo 
{
	private static final int UM = 1;
	private static final int ZERO = 0;
	
	private List<Integer> bolinhas; 
	
	public Globo(int quantidadeDeBolinhas)
	{
		assert (quantidadeDeBolinhas > ZERO) : "Quantidade de bolinhas deve ser maior que zero.";
		
		bolinhas = new ArrayList<Integer>();
		for(int cont = UM; cont <= quantidadeDeBolinhas; cont++)
		{
			bolinhas.add(cont);
		}
	}
	
	public final int fornecerQuantidadeDeBolinhas()
	{
		return bolinhas.size();
	} 
	
	public final int sortear()
	{
		assert (bolinhas.size() > ZERO) : "Não existem mais bolinhas para sortear.";
		
		int posicaoBolinhaSorteada = sortearPosicao();
		int bolinhaSorteada = bolinhas.get(posicaoBolinhaSorteada);
		
		bolinhas.remove(posicaoBolinhaSorteada);
		
		return bolinhaSorteada;
	}
	
	private final int sortearPosicao()
	{
		return (int)(Math.random() * bolinhas.size());
	}
}