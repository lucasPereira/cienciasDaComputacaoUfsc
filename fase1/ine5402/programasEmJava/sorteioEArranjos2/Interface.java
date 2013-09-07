import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
		
	}
	
	public static int pecaQuantidade()
	{
		int quantidade;
		do
		{
			String valorQuantidade = JOptionPane.showInputDialog("Insira a quantidade de números que deseja sortear.");
			try
			{
				quantidade = Integer.parseInt(valorQuantidade);
			}
			catch(Exception e)
			{
				quantidade = -1;
			}
			if(quantidade < 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido");
			}
		}
		while(quantidade < 0);
		return quantidade;
	}
	
	public static int pecaFaixa()
	{
		int faixa;
		do
		{
			String valorFaixa = JOptionPane.showInputDialog("Insira o valor máximo que pode ser sorteado.");
			try
			{
				faixa = Integer.parseInt(valorFaixa);
			}
			catch(Exception e)
			{
				faixa = 0;
			}
			if(faixa <= 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido");
			}
		}
		while(faixa <= 0);
		return faixa;
	}
	
	public static void mostreSorteados(int[] sorteados, int quantidade)
	{
		int faixa = sorteados.length;
		String sorteio = "Quantidade de números a serem sorteados: "+quantidade+"\n\n";
		for(int cont = 0; cont < faixa; cont++)
		{
			sorteio += cont+"         "+sorteados[cont]+"\n";
		}
		JOptionPane.showMessageDialog(null, sorteio);
	}
}