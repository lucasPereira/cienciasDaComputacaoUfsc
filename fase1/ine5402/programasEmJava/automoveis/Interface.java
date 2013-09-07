//Aluno: Lucas Pereira - 10100754

import javax.swing.JOptionPane;

public class Interface 
{
	public Interface ()
	{
		
	}
	
	public static Automoveis pecaAutomovel()
	{
		int ano = Interface.pecaAno();
		String marca = Interface.pecaMarca();
		double preco = Interface.pecaPreco();
		Automoveis automovel = new Automoveis(ano, marca, preco);
		return automovel;
	}
	
	public static int pecaAno()
	{
		int ano;
		do
		{
			String valorAno = JOptionPane.showInputDialog("Insira o ano do automóvel");
			try
			{
				ano = Integer.parseInt(valorAno);
			}
			catch(Exception erro)
			{
				ano = 0;
			}
			if(ano <= 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			}
		}
		while(ano <= 0 || ano > 2011);
		return ano;
	}
	
	public static String pecaMarca()
	{
		return JOptionPane.showInputDialog("Insira a marca do automóvel.");
	}
	
	public static double pecaPreco()
	{
		double preco;
		do
		{
			String valorPreco = JOptionPane.showInputDialog("Insira o preco do automóvel.");
			try
			{
				preco = Double.parseDouble(valorPreco);
			}
			catch(Exception erro)
			{
				preco = 0;
			}
			if(preco <= 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido");
			}
		}
		while(preco <= 0  || preco > 2000000);
		return preco;
	}
	
	public static int pecaQuantidadeAutomoveis()
	{
		int quantidadeAutomoveis;
		do
		{
			String valorQuantidadeAutomoveis = JOptionPane.showInputDialog("Insira a quantidade de automóveis.");
			try
			{
				quantidadeAutomoveis = Integer.parseInt(valorQuantidadeAutomoveis);
			}
			catch(Exception erro)
			{
				quantidadeAutomoveis = 0;
			}
			if(quantidadeAutomoveis <= 0)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido");
			}
		}
		while(quantidadeAutomoveis <= 0 || quantidadeAutomoveis > 100);
		return quantidadeAutomoveis;
	}
	
	public static void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public static void mostreRelatorioMarcas(String[] marcas, int[] quantidadeCarrosPorMarca)
	{
		String relatorio = "Relatório de Marcas:\n\n";
		for(int cont = 0; cont < marcas.length; cont++)
		{
			relatorio += marcas[cont]+": "+quantidadeCarrosPorMarca[cont]+"\n";
		}
		JOptionPane.showMessageDialog(null, relatorio);
	}
	
	public static void mostreRelatorioAnos(int[] quantidadeCarrosPorAno)
	{
		String relatorio = "Relatório de Anos:\n\n";
		for(int cont = 0; cont < quantidadeCarrosPorAno.length; cont++)
		{
			int ano = cont+1980;
			relatorio += ano+": "+quantidadeCarrosPorAno[cont]+"\n";
		}
		JOptionPane.showMessageDialog(null, relatorio);
	}
	
	public static void mostreReletaorioPreco(int[] quantidadeCarrosPorPreco)
	{
		String relatorio = "Relatório de Precos:\n\n";
		String relatorio1 = "Relatório de Precos: \n\n";
		int tamanho = quantidadeCarrosPorPreco.length;
		for(int cont = 0; cont < tamanho; cont++)
		{
			if(cont+1 < (int)(tamanho/2))
			{
				relatorio += "R$ "+(cont*1000)+" a R$ "+((cont+1)*1000-1)+": "+quantidadeCarrosPorPreco[cont]+"\n";
			}
			else
			{
				if(cont != tamanho-1)
				{
					relatorio1 += "R$ "+(cont*1000)+" a R$ "+((cont+1)*1000-1)+": "+quantidadeCarrosPorPreco[cont]+"\n";
				}
				else
				{
					relatorio1 += "Mais de R$"+cont*1000+": "+quantidadeCarrosPorPreco[cont];
				}
			}
		}
		JOptionPane.showMessageDialog(null, relatorio);
		JOptionPane.showMessageDialog(null, relatorio1);
	}
}
