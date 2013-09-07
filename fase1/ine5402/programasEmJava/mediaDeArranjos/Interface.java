import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
	}

	public int[] pecaValores()
	{
		int[] valor = new int[10];
		boolean erro;
		
		for(int cont = 0; cont < 10; cont++)
		{
			do
			{
				erro = false;
				String valorValor = JOptionPane.showInputDialog("Insira o valor "+cont);	
				try
				{
					valor[cont] = Integer.parseInt(valorValor);
				}
				catch(Exception e)
				{
					erro = true;
				}
				if(erro)
				{
					JOptionPane.showMessageDialog(null, "Valor Inválido.");
				}
			}
			while(erro);
		}
		return valor;
	}
	
	public void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
