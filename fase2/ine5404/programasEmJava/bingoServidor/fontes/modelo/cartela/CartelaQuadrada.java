package modelo.cartela;

import java.util.List;

import modelo.sorteio.TipoRecipiente;

public class CartelaQuadrada extends CartelaAbstrata 
{
	private static final int UM = 1;
	private static final int ZERO = 0;
	
	private final int ORDEM;
	private List<Integer> numeros;
	
	public CartelaQuadrada(int ordem, int numeroMaximo) throws AssertionError 
	{			
		assert(ordem * ordem <= numeroMaximo) : "O quadrado da ordem deve ser menor ou igual ao número máximo.";
		assert(ordem >= UM && numeroMaximo >= UM) : "Ordem e número máximo deve ser maior ou igua a um.";
		
		ORDEM = ordem;
		numeros = gerarCartela(ORDEM * ORDEM, numeroMaximo);
	}
	
	public final boolean verificarSeFezBingo(TipoRecipiente numerosSorteados)  
	{
		int cont = ZERO;
		int posicaoCelulaColuna = ZERO;
		int posicaoCelulaLinha = ZERO;
		boolean colunaFezBingo = false;
		boolean linhaFezBingo = false;
				
		while(cont < ORDEM && !colunaFezBingo && !linhaFezBingo)
		{
			colunaFezBingo = verificarSeLinhaOuColunaFezBingo(posicaoCelulaColuna, ORDEM, numerosSorteados);
			posicaoCelulaColuna = posicaoCelulaColuna + UM;
			
			linhaFezBingo = verificarSeLinhaOuColunaFezBingo(posicaoCelulaLinha, UM, numerosSorteados);
			posicaoCelulaLinha = posicaoCelulaLinha + ORDEM;
			
			cont++;
		}
		
		return (colunaFezBingo || linhaFezBingo);
	}
	
	private final boolean verificarSeLinhaOuColunaFezBingo(int posicaoCelula, int deslocamento, TipoRecipiente numerosSorteados)
	{
		int cont = ZERO;
		boolean valorCelulaFoiSorteado = true;
		
		while(cont < ORDEM && valorCelulaFoiSorteado)
		{
			valorCelulaFoiSorteado = numerosSorteados.verificarSeValorEstaNoRecipiente((numeros.get(posicaoCelula)));
			posicaoCelula = posicaoCelula + deslocamento;
			
			cont++;
		}
		
		return valorCelulaFoiSorteado;
	}
		
	public final List<String> fornecerListaComOsValores() 
	{
		return fornecerListaComOsValores(numeros);
	}
}