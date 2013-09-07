//Aluno: Lucas Pereira da Silva

import javax.swing.JOptionPane;
public class Interface 
{
	public Interface()
	{
		
	}
	
	public int pecaOperacao()
	{
		int operacao;
		do
		{
			String valorOperacao=JOptionPane.showInputDialog("Escola uma das operacões a seguir:\n\n1 - Efetuar Depósito\n2 - Efetuar Saque\n3 - Consultar Saldo\n4 - Sair\n\n");
			try
			{
				operacao = Integer.parseInt(valorOperacao);
			}
			catch(Exception e)
			{
				operacao = 0;
			}
			if(operacao <= 0 || operacao > 4)
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido. Escolha uma opcão correta.");
			}
		}
		while(operacao <= 0 || operacao > 4);
		return operacao;
	}

	public double pecaValorDeposito()
	{
		double deposito;
		do
		{
			String valorDeposito = JOptionPane.showInputDialog("Insira o valor do depósito.");
			try
			{
				deposito = Double.parseDouble(valorDeposito);
			}
			catch(Exception e)
			{
				deposito = -1;
			}
			if(deposito < 0)
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido. Insira um valor positivo.");
			}
		}
		while(deposito < 0);
		return deposito;
	}
	
	public double pecaValorSaque()
	{
		double saque;
		do
		{
			String valorSaque = JOptionPane.showInputDialog("Insira o valor do saque.");
			try
			{
				saque = Double.parseDouble(valorSaque);
			}
			catch(Exception e)
			{
				saque = -1;
			}
			if(saque < 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido. Insira um valor positivo.");
			}
		}
		while(saque < 0);
		return saque;
	}
	
	public void mostreDeposito(boolean deposito)
	{
		if(deposito)
		{
			JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Erro ao depositar, tente novamente.");
		}
	}
	
	public void mostreSaque(double saque)
	{
		JOptionPane.showMessageDialog(null, "O valor sacado foi: R$ "+saque);
	}
	
	public void mostreSaldo(double saldo, double limiteSaqueNegativo)
	{
		JOptionPane.showMessageDialog(null, "Saldo: R$ "+saldo+"\nLimite Negativo: R$ "+limiteSaqueNegativo);
	}
	
	public void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}