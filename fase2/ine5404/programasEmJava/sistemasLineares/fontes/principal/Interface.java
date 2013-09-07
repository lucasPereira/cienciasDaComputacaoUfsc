package principal;
import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
		
	}
	
	public static int[][] pecaSistemaLinear()
	{
		int quantidadeEquacoes = Interface.pecaQuantidadeEquacoes();
		int[][] equacoes = new int[quantidadeEquacoes][quantidadeEquacoes+1];
		char[] coeficiente = {'x', 'y', 'z', 'w', 'a', 'b', 'c', 'd', 'e'};
		
		for(int linha = 0; linha < (quantidadeEquacoes); linha++)
		{
			for(int coluna = 0; coluna < (quantidadeEquacoes+1); coluna++)
			{
				equacoes[linha][coluna] = Interface.pecaValorInteiro("Insira "+coeficiente[coluna]+" da equacão "+(linha+1));
			}
		}
		return equacoes;
	}

	public static int pecaQuantidadeEquacoes() 
	{
		int quantidadeEquacoes;
		do
		{
			String valorQuantidadeEquacoes = JOptionPane.showInputDialog("Insira a quantidade de equacões do sistema linear.");
			try
			{
				quantidadeEquacoes = Integer.parseInt(valorQuantidadeEquacoes);
			}
			catch(Exception erro)
			{
				quantidadeEquacoes = -1;
			}
			if(quantidadeEquacoes < 0)
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido.");
			}
		}
		while(quantidadeEquacoes < 0);
		return quantidadeEquacoes;
	}
	
	public static int pecaValorInteiro(String mensagem)
	{
		int coeficiente;
		do
		{
			String valorCoeficiente = JOptionPane.showInputDialog(mensagem);
			try
			{
				coeficiente = Integer.parseInt(valorCoeficiente);
			}
			catch(Exception erro)
			{
				coeficiente = Integer.MIN_VALUE;
				JOptionPane.showMessageDialog(null, "Valor Inválido");
			}
		}
		while(coeficiente == Integer.MIN_VALUE);
		return coeficiente;
	}
	
	public static void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}