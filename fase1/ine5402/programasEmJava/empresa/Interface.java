import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
		
	}
	
	public int pecaNumeroFuncionarios()
	{
		int numeroFuncionarios;
		do
		{
			String valorNumeroFuncionarios = JOptionPane.showInputDialog("Insira a quantidade de funcionários.");
			try
			{
				numeroFuncionarios = Integer.parseInt(valorNumeroFuncionarios);
			}
			catch(Exception e)
			{
				numeroFuncionarios = -1;
			}
			if(numeroFuncionarios < 0)
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido.");
			}
		}
		while(numeroFuncionarios < 0);
		return numeroFuncionarios;
	}
	
	public Funcionarios pecaFuncionario()
	{			
		char resposta;
		do
		{
			String valorResposta = JOptionPane.showInputDialog("Você deseja inserir um funcionário comum (f), chefe (c) ou funcionário de apoio (a)?");
			try
			{
				resposta = valorResposta.charAt(0);
				resposta = Character.toLowerCase(resposta);
			}
			catch(Exception e)
			{
				resposta = '0';
			}
			if(resposta != 'f' && resposta != 'c' && resposta != 'a')
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido, digite f, c ou a.");
			}
		}
		while(resposta != 'f' && resposta != 'c' && resposta != 'a');
		
		String nome = JOptionPane.showInputDialog("Insira o nome.");
		
		double salarioBase;
		do
		{
			String valorSalarioBase = JOptionPane.showInputDialog("Insira o salário base.");
			try
			{
				salarioBase = Double.parseDouble(valorSalarioBase);
			}
			catch(Exception e)
			{
				salarioBase = -1;
			}
			if(salarioBase < 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			}
		}
		while(salarioBase < 0);
		
		double gratificacaoProducao;
		do
		{
			String valorGratificacaoProducao = JOptionPane.showInputDialog("Insira a gratificacão de producão.");
			try
			{
				gratificacaoProducao = Double.parseDouble(valorGratificacaoProducao);
			}
			catch(Exception e)
			{
				gratificacaoProducao = -1;
			}
			if(gratificacaoProducao < 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			}
		}
		while(gratificacaoProducao < 0);
		
		int dependentes;
		do
		{
			String valorDependentes = JOptionPane.showInputDialog("Insira o número de dependentes.");
			try
			{
				dependentes = Integer.parseInt(valorDependentes);
			}
			catch(Exception e)
			{
				dependentes = -1;
			}
			if(dependentes < 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			}
		}
		while(dependentes < 0);
		
		if(resposta == 'c')
		{
			double gratificacaoChefia;
			do
			{
				String valorGratificacaoChefia = JOptionPane.showInputDialog("Insira a gratificacão de chefia.");
				try
				{
					gratificacaoChefia = Double.parseDouble(valorGratificacaoChefia);
				}
				catch(Exception e)
				{
					gratificacaoChefia = -1;
				}
				if(gratificacaoChefia < 0)
				{
					JOptionPane.showMessageDialog(null, "Valor inválido.");
				}
			}
			while(gratificacaoChefia < 0);
			return new Chefes(nome, salarioBase, gratificacaoProducao, dependentes, gratificacaoChefia);
		}
		
		if(resposta == 'a')
		{
			return new Apoio(nome, salarioBase, gratificacaoProducao, dependentes);
		}
		else
		{
			return new Funcionarios(nome, salarioBase, gratificacaoProducao, dependentes);
		}
	}
	
	public void mostreFuncionario(Funcionarios funcionario)
	{
		String imprimirFuncionario = "Nome : "+funcionario.fornecaNome();
		
		String cargo;
		if(funcionario instanceof Chefes || funcionario instanceof Apoio)
		{
			if(funcionario instanceof Chefes)
			{
				cargo = "Chefe";
			}
			else
			{
				cargo = "Funcionário de Apoio";
			}
		}
		else
		{
			cargo = "Funcionário Comum";
		}
		
		imprimirFuncionario = imprimirFuncionario+"\nCargo: "+cargo;
		imprimirFuncionario = imprimirFuncionario+"\n"+funcionario.fornecaAtributos();
		
		if(funcionario instanceof Chefes)
		{
			imprimirFuncionario = imprimirFuncionario+"\nGratificacão Chefia: R$ "+((Chefes)funcionario).fornecaGratificacaoChefia();
		}
		
		if(funcionario instanceof Apoio)
		{
			imprimirFuncionario = imprimirFuncionario+"\nAuxilio Educacão: R$ "+((Apoio)funcionario).fornecaAuxilioEducacao();
		}
		
		imprimirFuncionario = imprimirFuncionario+"\nSalário Bruto: R$ "+funcionario.fornecaSalarioBruto();
		imprimirFuncionario = imprimirFuncionario+"\nDesconto de Imposto: R$ "+funcionario.fornecaImposto();
		imprimirFuncionario = imprimirFuncionario+"\n\nSalário Líquido: R$ "+funcionario.fornecaSalarioLiquido(); 
			
		JOptionPane.showMessageDialog(null, imprimirFuncionario);	
	}
	
	public void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
