import javax.swing.JOptionPane;
public class Interface 
{
	public Interface()
	{
		
	}
	
	public char pecaNovoAluno()
	{
		String valorNovoAluno;
		char novoAluno;
		do
		{
			valorNovoAluno = JOptionPane.showInputDialog("Deseja inserir mais um aluno (s/n)?");
			try
			{
				novoAluno = valorNovoAluno.charAt(0);
			}
			catch(Exception e)
			{
				novoAluno = 0;
			}
			if((novoAluno != 'S') && (novoAluno != 's') && (novoAluno != 'N') && (novoAluno != 'n'))
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido. Digite s ou n");
			}
		}
		while((novoAluno != 'S') && (novoAluno != 's') && (novoAluno != 'N') && (novoAluno != 'n'));
		return novoAluno;
	}
	
	public Alunos pecaAluno()
	{
		String nome = JOptionPane.showInputDialog("Insira o nome do aluno.");
		
		double n1;
		String valorN1;
		do
		{
			valorN1 = JOptionPane.showInputDialog("Insira a nota 1 do aluno.");
			try
			{
				n1 = Double.parseDouble(valorN1);
			}
			catch(Exception e)
			{
				n1 = -1;
			}
			if((n1 < 0) || (n1 > 10))
			{
				JOptionPane.showMessageDialog(null, "Nota Inválida.");
			}
		}
		while((n1 < 0) || (n1 > 10));
		
		String valorN2;
		double n2;
		do
		{
			valorN2 = JOptionPane.showInputDialog("Insira a nota 2 do aluno.");
			try
			{
				n2 = Double.parseDouble(valorN2);
			}
			catch(Exception e)
			{
				n2 = -1;
			}
			if((n2 < 0) || (n2 > 10))
			{
				JOptionPane.showMessageDialog(null, "Nota Inválida.");
			}
		}
		while((n2 < 0) || (n2 > 10));		
		
		String valorN3;
		double n3;
		do
		{
			valorN3 = JOptionPane.showInputDialog("Insita a nota 3 do aluno.");
			try
			{
				n3 = Double.parseDouble(valorN3);
			}
			catch(Exception e)
			{
				n3 = -1;
			}
			if((n3 < 0) || (n3 > 10))
			{
				JOptionPane.showMessageDialog(null, "Nota Inválida.");
			}
		}
		while((n3 < 0) || (n3 > 10));	
		
		Alunos aluno = new Alunos(nome, n1, n2, n3);
		return aluno;
	}
	
	public double pecaCriterio()
	{
		double criterio;
		do
		{
			String valorCriterio = JOptionPane.showInputDialog("Insira o critério de aprovacão.");
			try
			{
				criterio = Double.parseDouble(valorCriterio);
			}
			catch(Exception e)
			{
				criterio=0; 
			}
			if((criterio < 1) || (criterio > 10))
			{
				JOptionPane.showMessageDialog(null, "Critério de Aprovacão Inválido.");
			}
		}
		while((criterio < 1) || (criterio > 10));
		return criterio;
	}
	
	public void mostreAluno(String nome, double media, boolean situacao, double menorNota, double maiorNota, double criterio, int notasAcima)
	{
		String situacaoAluno;
		if(situacao)
		{
			situacaoAluno = "Aprovado.";
		}
		else
		{
			situacaoAluno = "Reprovado."; 
		}
		String saida = "Aluno: "+nome;
		saida = saida + "\nMédia: "+media;
		saida = saida + "\nSituacão: "+situacaoAluno;
		saida = saida + "\nMenor Nota: "+menorNota;
		saida = saida + "\nMaior Nota: "+maiorNota;
		saida = saida + "\nNúmero de notas acima de "+criterio;
		saida = saida + ": "+notasAcima;
		JOptionPane.showMessageDialog(null, saida);
	} 
	
	public void mostreMelhorAluno(Alunos melhorAluno, double criterio)
	{
		String nome = melhorAluno.fornecaNome();
		double media = melhorAluno.fornecaMedia();
		boolean situacao = melhorAluno.fornecaSituacao(criterio);
		double menorNota = melhorAluno.fornecaMenorNota();
		double maiorNota = melhorAluno.fornecaMaiorNota();
		int notasAcima = melhorAluno.fornecaNotasAcima(criterio);
	
		String situacaoAluno;
		if(situacao)
		{
			situacaoAluno = "Aprovado.";
		}
		else
		{
			situacaoAluno = "Reprovado."; 
		}
		String saida = "Melhor aluno da turma\n\nAluno: "+nome;
		saida = saida + "\nMédia: "+media;
		saida = saida + "\nSituacão: "+situacaoAluno;
		saida = saida + "\nMenor Nota: "+menorNota;
		saida = saida + "\nMaior Nota: "+maiorNota;
		saida = saida + "\nNúmero de notas acima de "+criterio;
		saida = saida + ": "+notasAcima;
		JOptionPane.showMessageDialog(null, saida);
	}
	
	public void mostreMediasTurma(double mediaN1, double mediaN2, double mediaN3, double mediaGeral)
	{
		String saida =	"Média da turma com a nota 1: "+mediaN1;
		saida = saida + "\nMédia da turma com a nota 2: "+mediaN2;
		saida = saida + "\nMédia da turma com a nota 3: "+mediaN3;
		saida = saida + "\nMédia geral da turma: "+mediaGeral;
		JOptionPane.showMessageDialog(null, saida);
	}
	
	public void mostreMediasTurmaAprovados(double mediaAprovadosN1, double mediaAprovadosN2, double mediaAprovadosN3, double mediaAprovadosGeral)
	{
		String saida = "Média da turma com a nota 1 dos alunos aprovados: "+mediaAprovadosN1;
		saida = saida + "\nMédia da turma com a nota 2 dos alunos aprovados: "+mediaAprovadosN2;
		saida = saida + "\nMédia da turma com a nota 3 dos alunos aprovados: "+mediaAprovadosN3;
		saida = saida + "\nMédia geral da turma dos alunos aprovados: "+mediaAprovadosGeral;
		JOptionPane.showMessageDialog(null, saida);
	}
	
	public void mostreSemAprovados()
	{
		JOptionPane.showMessageDialog(null, "Nào houve aprovados nessa turma.");
	}
}
