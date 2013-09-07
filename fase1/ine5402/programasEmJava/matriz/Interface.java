import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
		
	}
	
	public int[][] pecaMatriz()
	{
		int numeroLinhas;
		do
		{
			String valorNumeroLinhas = JOptionPane.showInputDialog("Insira o número de linhas.");
			try
			{
				numeroLinhas = Integer.parseInt(valorNumeroLinhas);
			}
			catch(Exception e)
			{
				numeroLinhas = 0;
			}
			if(numeroLinhas <= 0)
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido.");
			}
		}
		while(numeroLinhas <= 0);
		
		int numeroColunas;
		do
		{
			String valorNumeroColunas = JOptionPane.showInputDialog("Insira o número de colunas.");
			try
			{
				numeroColunas = Integer.parseInt(valorNumeroColunas);
			}
			catch(Exception e)
			{
				numeroColunas = 0;
			}
			if(numeroLinhas <= 0)
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido.");
			}
		}
		while(numeroColunas <= 0);
		
		int[][] matriz = new int[numeroLinhas][numeroColunas];
		for(int linha = 0; linha < numeroLinhas; linha++)
		{
			for(int coluna = 0; coluna < numeroColunas; coluna++)
			{
				boolean erro;
				do
				{
					erro = false;
					String cedula = JOptionPane.showInputDialog("Insira o valor da cédula da posicão "+(linha+1)+","+(coluna+1)+" da matriz.");
					try
					{
						matriz[linha][coluna] = Integer.parseInt(cedula); 
					}
					catch(Exception e)
					{
						erro = true;
					}
					if(erro)
					{
						JOptionPane.showMessageDialog(null, "Valor inválido");
					}
				}
				while(erro);
			}
		}
		return matriz;
	}
	
	public void mostreMatriz(int[][] matriz)
	{
		int numeroLinhas = matriz.length;
		int numeroColunas = matriz[0].length;
		String printMatriz = "";
		for(int linha = 0; linha < numeroLinhas; linha++)
		{
			for(int coluna = 0; coluna < numeroColunas; coluna++)
			{
				if((coluna+1)/numeroColunas == 1)
				{
					printMatriz += matriz[linha][coluna]+"\n";
				}
				else
				{
					printMatriz += matriz[linha][coluna]+"  ";
				}
			}
		}
		JOptionPane.showMessageDialog(null, printMatriz);
	}
	
	public void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
