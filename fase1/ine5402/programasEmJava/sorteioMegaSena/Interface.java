//Aluno: Lucas Pereira da Silva - 10100754

import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
		
	}

	public char pecaInserirApostador()
	{
		char inserir;
		do
		{
			inserir = '*';
			String valorInserir = JOptionPane.showInputDialog("Deseja inserir um novo apostador (s/n?");
			try
			{
				inserir = valorInserir.charAt(0);
				inserir = Character.toLowerCase(inserir);
			}
			catch(Exception e)
			{
				inserir = '*';
			}
			if(inserir != 's' && inserir != 'n')
			{
				JOptionPane.showMessageDialog(null, "Valor inválido, digite s ou n.");
			}
		}
		while(inserir != 's' && inserir != 'n');
		return inserir;
	}
	
	public int pecaQuantidadeNumerosApostados()
	{
		int quantidadeNumerosApostados;
		do
		{
			String valorQuantidadeNumerosApostados = JOptionPane.showInputDialog("Insira a quantidade de números que deseja apostar.");
			try
			{
				quantidadeNumerosApostados = Integer.parseInt(valorQuantidadeNumerosApostados);
			}
			catch(Exception e)
			{
				quantidadeNumerosApostados = 1;
			}
			if(quantidadeNumerosApostados < 6 || quantidadeNumerosApostados > 10)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido, insira um número entre 6 e 10.");
			}
		}
		while(quantidadeNumerosApostados < 6 || quantidadeNumerosApostados >10);
		return quantidadeNumerosApostados;
	}
	
	public Apostadores pecaApostador()
	{
		String nome = JOptionPane.showInputDialog("Insira o nome do apostador.");
	
		int quantidadeNumerosApostados = this.pecaQuantidadeNumerosApostados();
		int[] numerosApostados = new int[quantidadeNumerosApostados];
		boolean numeroRepetido;
		
		for(int cont = 0; cont < quantidadeNumerosApostados; cont++)
		{			
			do
			{
				numeroRepetido = false;
				String valorNumeroApostado = JOptionPane.showInputDialog("Insira o número "+(cont+1)+".");	
				try
				{
					numerosApostados[cont] = Integer.parseInt(valorNumeroApostado);					
				}
				catch(Exception e)
				{
					numerosApostados[cont] = 0;
				}
				for(int cont1 = 0; cont1 < cont; cont1++)	
				{
					if((cont != cont1) && (numerosApostados[cont] == numerosApostados[cont1]))
					{
						numeroRepetido = true;
					}
				}	
				if(numerosApostados[cont] < 1 || numerosApostados[cont] > 60 || numeroRepetido)
				{
					JOptionPane.showMessageDialog(null, "Valor inválido ou repetido.");
				}
			}
			while(numerosApostados[cont] < 1 || numerosApostados[cont] > 60 || numeroRepetido);
		}
		return new Apostadores(nome, numerosApostados);
	}
	
	public String numerosMegaSena(int[] numeros)
	{
		String valorNumeros = "";
		for(int cont = 0; cont < numeros.length; cont++)
		{
			valorNumeros += numeros[cont]+" ";
		}
		return valorNumeros;
	}
	
	public void mostreApostadorMegaSena(int[] numerosApostados, int[] numerosSorteados, int acertos, String nome)
	{		
		String valorAposta = "";
		int quantidadeNumerosApostados = numerosApostados.length;
		switch(quantidadeNumerosApostados)
		{
			case 6: valorAposta = "R$ 1.00";
			break;
			case 7: valorAposta = "R$ 7.00";
			break;
			case 8: valorAposta = "R$ 28.00";
			break;
			case 9: valorAposta = "R$ 168.00";
			break;
			case 10: valorAposta = "R$ 1260.00";
		}
		
		
		JOptionPane.showMessageDialog(null, 
		"Apostador: "+nome
		+"\n\nNúmeros Apostados: \n"+this.numerosMegaSena(numerosApostados)
		+"\n\nNúmeros Sorteados: \n"+this.numerosMegaSena(numerosSorteados)
		+"\n\nGasto com aposta: "+valorAposta
		+"\nPontos feitos: "+acertos
		);
	}
	
	public void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}