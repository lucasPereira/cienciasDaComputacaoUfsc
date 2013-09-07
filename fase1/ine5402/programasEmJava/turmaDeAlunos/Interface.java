//Aluno: Lucas Pereira - 10100754

import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
		
	}
	
	public Alunos pecaAluno()
	{
		String nome = this.pecaNome();
		int idade = this.pecaIdade();
		char sexo = this.pecaSexo();
		
		Alunos aluno = new Alunos(nome, idade, sexo);
		
		double provaFinal = this.pecaProvaFinal();
		aluno.altereProvaFinal(provaFinal);
		int quantidadeTestes = this.pecaQuantidadeTestes();
		
		for(int cont = 1; cont <= quantidadeTestes; cont++)
		{
			double notaTeste = this.pecaNotaTeste(cont);
			aluno.insiraNotaTeste(notaTeste);
		}
		return aluno;
	}
	
	public String pecaNome()
	{
		String nome = JOptionPane.showInputDialog("Insira o nome do aluno.");
		return nome;
	}
	
	public int pecaIdade()
	{
		int idade;
		do
		{
			String valorIdade = JOptionPane.showInputDialog("Insira a idade do aluno.");
			try
			{
				idade = Integer.parseInt(valorIdade);
			}
			catch(Exception e)
			{
				idade = 0;
			}
			if(idade <= 0 || idade > 200)
			{
				JOptionPane.showMessageDialog(null, "Idade inválida.");
			}
		}
		while(idade <= 0 || idade > 200);
		return idade;
	}
	
	public char pecaSexo()
	{
		char sexo;
		do
		{
			String valorSexo = JOptionPane.showInputDialog("Insira o sexo do aluno (m/f).");
			try
			{
				sexo = valorSexo.charAt(0);
				sexo = Character.toLowerCase(sexo);
			}
			catch(Exception e)
			{
				sexo = '*';
			}
			if(sexo != 'm' && sexo != 'f')
			{
				JOptionPane.showMessageDialog(null, "Sexo inválido.");
			}
		}
		while(sexo != 'm' && sexo != 'f');
		return sexo;
	}
	
	public double pecaProvaFinal()
	{
		double provaFinal;
		do
		{
			String valorProvaFinal = JOptionPane.showInputDialog("Insira a nota da prova final.");
			try
			{
				provaFinal = Double.parseDouble(valorProvaFinal);
			}
			catch(Exception e)
			{
				provaFinal = -1;
			}
			if(provaFinal < 0 || provaFinal > 10)
			{
				JOptionPane.showMessageDialog(null, "Nota inválida.");
			}
		}
		while(provaFinal < 0 || provaFinal > 10);
		return provaFinal;	
	}
	
	public int pecaQuantidadeTestes()
	{
		int quantidadeTestes;
		do
		{
			String valorQuantidadeTestes = JOptionPane.showInputDialog("Insira a quantidade de testes.");
			try
			{
				quantidadeTestes = Integer.parseInt(valorQuantidadeTestes);
			}
			catch(Exception e)
			{
				quantidadeTestes = 0;
			}
			if(quantidadeTestes <= 0 || quantidadeTestes > 20)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			}
		}
		while(quantidadeTestes <= 0 || quantidadeTestes > 20);
		return quantidadeTestes;
	}
	
	public double pecaNotaTeste(int teste)
	{
		double notaTeste;
		do
		{
			String valorNotaTeste = JOptionPane.showInputDialog("Insira a nota do teste "+teste+".");
			try
			{
				notaTeste = Double.parseDouble(valorNotaTeste);
			}
			catch(Exception e)
			{
				notaTeste = -1;
			}
			if(notaTeste < 0 || notaTeste > 10)
			{
				JOptionPane.showMessageDialog(null, "Nota inválida.");
			}
		}
		while(notaTeste < 0 || notaTeste > 10);
		return notaTeste;	
	}
	
	public int pecaQuantidadeAlunos()
	{
		int quantidade;
		do
		{
			String valorQuantidade = JOptionPane.showInputDialog("Insira a quantidade de alunos.");
			try
			{
				quantidade = Integer.parseInt(valorQuantidade);
			}
			catch(Exception e)
			{
				quantidade = -1;
			}
			if(quantidade < 0 || quantidade > 50)
			{
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			}
		}
		while(quantidade < 0 || quantidade > 50);
		return quantidade;
	}
	
	public void mostreAlunos(Alunos aluno)
	{
		String nome = aluno.fornecaNome();
		int idade = aluno.fornecaIdade();
		char sexo = aluno.fornecaSexo();
		double provaFinal = aluno.fornecaProvaFinal();
		int numeroTeste = aluno.fornecaNumeroTeste();
		double menorNota = aluno.fornecaMenorNotaTestes();
		double mediaTestes = aluno.fornecaMediaTestes();
		double mediaFinal = aluno.fornecaMediaFinal();
	
		String situacaoAluno;
		boolean situacao = aluno.fornecaSituacao(6.0);
		if(situacao)
		{
			situacaoAluno = "Aprovado";
		}
		else
		{
			situacaoAluno = "Reprovado";
		}
		
		String notasTestes = "";
		for(int cont = 1; cont <= numeroTeste; cont++)
		{
			notasTestes += aluno.fornecaNotaTeste(cont);
			if(cont < numeroTeste)
			{
				notasTestes += ", ";
			}
		}
		
		JOptionPane.showMessageDialog(null, 
		"Aluno: "+nome
		+"\n\nIdade: "+idade
		+"\nSexo: "+sexo
		+"\n\nNota Prova Final: "+provaFinal
		+"\nNotas dos Testes: "+notasTestes
		+"\nMenor Nota nos Testes: "+menorNota
		+"\nMédia dos Testes: "+mediaTestes
		+"\n\nMédia Final: "+mediaFinal
		+"\nSituacão: "+situacaoAluno
		);
	}
	
	public void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}