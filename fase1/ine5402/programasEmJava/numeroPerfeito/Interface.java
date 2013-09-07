import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
		
	}
	
	public Perfeito pecaNumero()
	{
		int numero;
		do
		{
			String valorNumero = JOptionPane.showInputDialog("Insira um número.");
			try
			{
				numero = Integer.parseInt(valorNumero);
			}
			catch(Exception e)
			{
				numero = 0;
			}
			if(numero <= 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido, insira um valor maior que zero.");
			}
		}
		while(numero <= 0);
		return new Perfeito(numero);
	}
	
	public void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}