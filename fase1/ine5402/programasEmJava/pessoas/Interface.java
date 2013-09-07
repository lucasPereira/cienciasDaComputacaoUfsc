//Aluno: Lucas Pereira da Silva - 10100754

import javax.swing.JOptionPane;
public class Interface 
{
	public Interface()
	{
		
	}
	
	public char pecaResposta()
	{
		char resposta;
		do
		{
			String valorResposta = JOptionPane.showInputDialog("Deseja inserir uma nova pessoa (s/n)?");
			try
			{
				resposta = valorResposta.charAt(0);
				resposta = Character.toLowerCase(resposta);
			}
			catch(Exception e)
			{
				resposta = 0;
			}
			if(resposta != 's' && resposta != 'n')
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido. Digite s ou n.");
			}
		}
		while(resposta != 's' && resposta != 'n');
		return resposta;
	}
	
	public Pessoas pecaPessoa()
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
		
		Pessoas pessoa=new Pessoas(nome, idade, sexo);
		return pessoa;
	}
	
	public void mostreDadosPessoas(int mulheresMenos40, double valorIdadeMediaAdolescentes, int adolescentes)
	{
		String idadeMediaAdolescentes;
		if(adolescentes > 0)
		{
			idadeMediaAdolescentes = valorIdadeMediaAdolescentes+"";
		}
		else
		{
			idadeMediaAdolescentes = "Nenhum adolescente foi inserido";
		}
		JOptionPane.showMessageDialog(null, 
		"Mulheres com menos de 40 anos: "+mulheresMenos40
		+"\nIdade média dos adolescentes: "+idadeMediaAdolescentes
		);
	}
	
	public void mostrePessoaMaisVelha(Pessoas pessoaMaisVelha)
	{
		String nome = pessoaMaisVelha.fornecaNome();
		int idade = pessoaMaisVelha.fornecaIdade();
		char sexo = pessoaMaisVelha.fornecaSexo();
		
		JOptionPane.showMessageDialog(null, 
		"Pessoa Mais Velha\n"
		+"\nNome: "+nome
		+"\nIdade: "+idade
		+"\nSexo: "+sexo
		);
	}
	
	public void mostrePessoaMaisJovem(Pessoas pessoaMaisJovem)
	{
		String nome = pessoaMaisJovem.fornecaNome();
		int idade = pessoaMaisJovem.fornecaIdade();
		char sexo = pessoaMaisJovem.fornecaSexo();
		
		JOptionPane.showMessageDialog(null, 
		"Pessoa Mais Nova\n"
		+"\nNome: "+nome
		+"\nIdade: "+idade
		+"\nSexo: "+sexo
		);
	}
}