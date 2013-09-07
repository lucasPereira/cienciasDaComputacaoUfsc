import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
		
	}
	
	public void mostreSorteados(int[] sorteados)
	{
		int quantidade = sorteados.length;
		String sorteio = "Números Sorteados:\n\n";
		for(int cont = 0; cont < quantidade; cont++)
		{
			if(cont == 0 || cont%5 != 0)
			{
				if((cont+1)%5 == 0)
				{
					sorteio += sorteados[cont];
				}
				else
				{
					if((cont+1) == quantidade)
					{
						sorteio += sorteados[cont];
					}
					else
					{
						sorteio += sorteados[cont]+" - ";
					}
				}
			}
			else
			{
				if((cont+1) == quantidade)
				{
					sorteio += "\n"+sorteados[cont];
				}
				else
				{
					sorteio += "\n"+sorteados[cont]+" - ";
				}
			}
		}
		JOptionPane.showMessageDialog(null, sorteio);
	}
}
