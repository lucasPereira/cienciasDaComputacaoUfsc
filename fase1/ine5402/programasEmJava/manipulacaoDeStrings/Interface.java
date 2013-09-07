import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
		
	}
	
	public static String pecaPalavra()
	{
		String palavra = JOptionPane.showInputDialog("Insira a palavra.");
		return palavra;
	}
	
	public static char pecaCaractere()
	{
		String valorCaractere = JOptionPane.showInputDialog("Insira o caractere.");
		char caractere = valorCaractere.charAt(0);
		return caractere;
	}
	
	public static int pecaTamanho()
	{
		int tamanho;
		do
		{
			String valorTamanho = JOptionPane.showInputDialog("Insira o tamanho");
			try
			{
				tamanho = Integer.parseInt(valorTamanho);
			}
			catch(Exception e)
			{
				tamanho = 0;
			}
			if(tamanho < 1)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			}
		}
		while(tamanho < 1);
		return tamanho;
	}
	
	public static void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}

