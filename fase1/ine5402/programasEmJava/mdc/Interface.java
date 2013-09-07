import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
	
	}
	
	public int pecaX()
	{
		int x;
		do
		{
			String valorX = JOptionPane.showInputDialog("Insira o valor de x.");
			try
			{
				x = Integer.parseInt(valorX);
			}
			catch(Exception e)
			{
				x = 0;
			}
			if(x <= 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido, insira um valor maior que zero.");
			}
		}
		while(x <= 0);
		return x;
	}
	
	public int pecaY()
	{
		int y;
		do
		{
			String valorY = JOptionPane.showInputDialog("Insira o valor de y.");
			try
			{
				y = Integer.parseInt(valorY);
			}
			catch(Exception e)
			{
				y = 0;
			}
			if(y <= 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido, insira um valor maior que zero.");
			}
		}
		while(y <= 0);
		return y;
	}
	
	public void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
