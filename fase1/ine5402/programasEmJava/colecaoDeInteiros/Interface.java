import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
		
	}
	
	public int[] pecaValores()
	{
		int quantidade;
		do
		{
			String valorQuantidade = JOptionPane.showInputDialog("Insira a quandidade da colecão.");
			try
			{
				quantidade = Integer.parseInt(valorQuantidade);
			}
			catch(Exception e)
			{
				quantidade = 0;
			}
			if(quantidade <= 0 || quantidade > 50)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			}
		}
		while(quantidade <= 0 || quantidade > 50);

		int[] valores = new int[quantidade];
		boolean erro;
		for(int cont = 0; cont < quantidade; cont++)
		{
			do
			{
				erro = false;
				String valorValor = JOptionPane.showInputDialog("Insira o valor "+(cont+1)+" da colecão.");
				try
				{
					valores[cont] = Integer.parseInt(valorValor);
				}
				catch(Exception e)
				{
					erro = true;
				}
				if(erro)
				{
					JOptionPane.showMessageDialog(null, "Valor inválido.");
				}
			}
			while(erro == true);
		}
		return valores;
	}
	 
	public int pecaOcorrencia()
	{
		int ocorrencia = 0;
		boolean erro;
		do
		{
			erro = false;
			String valorOcorrencia = JOptionPane.showInputDialog("Insira a Ocorrência que deseja achar na colecão.");
			try
			{
				ocorrencia = Integer.parseInt(valorOcorrencia);
			}
			catch(Exception e)
			{
				erro = true;
			}
			if(erro)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			}
		}
		while(erro);
		return ocorrencia;
	}
	
	public int pecaPosicao()
	{
		int posicao;
		do
		{
			String valorPosicao = JOptionPane.showInputDialog("Insira a posicão do valor que deseja mostrar.");
			try
			{
				posicao= Integer.parseInt(valorPosicao);
			}
			catch(Exception e)
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
	
	public int pecavalorInserirRemover(boolean operacao)
	{
		int valor = 0;
		boolean erro;
		String adicionarOuRemover;
		if(operacao)
		{
			adicionarOuRemover = "adicionar á";
		}
		else
		{
			adicionarOuRemover = "remover da";
		}
		
		do
		{
			erro = false;
			String valorOcorrencia = JOptionPane.showInputDialog("Insira a Ocorrência que deseja "+adicionarOuRemover+" colecão.");
			try
			{
				valor = Integer.parseInt(valorOcorrencia);
			}
			catch(Exception e)
			{
				erro = true;
			}
			if(erro)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			}
		}
		while(erro);
		return valor;
	}
	
	public void mostreColecao(String valores, double media, int posicaoPrimeiraOcorrencia, int ocorrencia, int valorPosicao, int posicao, int quantidadePares, int[]pares)
	{
		String mensagem = "";
		mensagem += "Valores da Colecão: "+valores;
		mensagem += "\nMédia dos Valores: "+media;
		
		if(posicaoPrimeiraOcorrencia != -1)
		{
			mensagem += "\nA posicao do primeiro "+ocorrencia+" na colecão é: "+posicaoPrimeiraOcorrencia;
		}
		else
		{
			mensagem += "\nO número "+ocorrencia+" não está na colecão";
		}
		
		if(valorPosicao != Integer.MIN_VALUE)
		{
			mensagem += "\nA posicao "+posicao+" contém o valor: "+valorPosicao;
		}
		else
		{
			mensagem += "\nA posicão "+posicao+" não existe";
		}
		
		mensagem += "\nQuantidade de pares na colecao: "+quantidadePares;
		mensagem += "\nValores pares da colecão: ";
		
		if(quantidadePares > 0)
		{
			for(int cont = 0; cont < quantidadePares; cont++)
			{
				mensagem += pares[cont]+" ";
			}
		}
		else
		{
			mensagem += "Não há pares na colecão.";
		}
		
		this.mostreMensagem(mensagem);
	}
	
	public void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
