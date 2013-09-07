import javax.swing.JOptionPane;
public class Interface 
{
	public Interface()
	{
		
	}
	
	public static Pessoas pecaPessoa()
	{		
		String nome;
		int idade;
		char sexo;
		
		nome = JOptionPane.showInputDialog("Insira o nome da pessoa.");
		
		do
		{
			String valorIdade = JOptionPane.showInputDialog("Insira a idade da pessoa.");
			try
			{
				idade = Integer.parseInt(valorIdade);
			}
			catch(Exception e)
			{
				idade = -1;
			}
			if(idade < 1 || idade > 200)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido. Insira uma idade entre 1 e 200.");
			}
		}
		while(idade < 1 || idade > 200);
	
		do
		{
			String valorSexo = JOptionPane.showInputDialog("Insira o sexo da pessoa (m/f)");
			try
			{
				sexo = valorSexo.charAt(0);
				sexo = Character.toLowerCase(sexo);
			}
			catch(Exception e)
			{
				sexo = 0;
			}
			if(sexo != 'm' && sexo != 'f')
			{
				JOptionPane.showMessageDialog(null, "Valor inválido. Digite m ou f.");
			}
		}
		while(sexo != 'm' && sexo != 'f');
		
		Pessoas pessoa = new Pessoas(nome, idade, sexo);
		return pessoa;
	}
	
	public static String pecaNomePessoaBuscar()
	{		
		String nome = JOptionPane.showInputDialog("Insira o nome da pessoa que deseja buscar.");
		return nome;
	}
	
	public static int pecaPosicao()
	{
		int posicao;
		do
		{
			String valorPosicao = JOptionPane.showInputDialog("Insira a posicão que deseja verificar.");
			try
			{
				posicao = Integer.parseInt(valorPosicao); 
			}
			catch(Exception erro)
			{
				posicao = 0;
			}
			if(posicao <= 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			}
		}
		while(posicao <= 0);
		return posicao;
	}
	
	public static int mostreMenuPecaOpcao()
	{
		int opcao;
		do
		{
			String valorOpcao = JOptionPane.showInputDialog(
			"1. Inserir pessoa na fila."
			+"\n2. Atender pessoa."
			+"\n3. Buscar pessoa na fila."
			+"\n4. Buscar posicão na fila."
			+"\n5. Listar pessoas da fila."
			+"\n6. Mostrar idade média das pessoas na fila."
			+"\n7. Mostrar nome da pessoa mais idosa da fila."
			+"\n8. Sair do programa."
			+"\n\n "
			);
			try
			{
				opcao = Integer.parseInt(valorOpcao);
			}
			catch(Exception erro)
			{
				opcao = 0;
			}
			if(opcao <= 0 || opcao > 8)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			}
		}
		while(opcao <= 0 || opcao > 8);
		return opcao;
	}
	
	public static void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}