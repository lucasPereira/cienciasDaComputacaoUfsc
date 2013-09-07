//Aluno: Lucas Pereira - 10100754

public class Principal 
{
	public static void main(String[] parametro)
	{
		Interface comunicaUsuario = new Interface();
		int quantidadeAlunos = comunicaUsuario.pecaQuantidadeAlunos();
		Alunos[] todosAlunos = new Alunos[quantidadeAlunos];
		Alunos melhorAluno = null;
		double mediaFinalMelhorAluno = 0.0;
		double mediaFinalTodosAlunos = 0.0;;
		int alunosAcimaMediaFinal = 0;
		
		for(int cont = 0; cont < quantidadeAlunos; cont++)
		{
			todosAlunos[cont] = comunicaUsuario.pecaAluno();
			
			double mediaFinalAluno = todosAlunos[cont].fornecaMediaFinal(); 
			if(mediaFinalAluno >= mediaFinalMelhorAluno)
			{
				mediaFinalMelhorAluno = mediaFinalAluno;
				melhorAluno = todosAlunos[cont];
			}
			mediaFinalTodosAlunos += mediaFinalAluno;
		}
		
		if(quantidadeAlunos > 0)
		{
			mediaFinalTodosAlunos /= quantidadeAlunos;
		}
		
		for(int cont = 0; cont < quantidadeAlunos; cont++)
		{
			comunicaUsuario.mostreAlunos(todosAlunos[cont]);
			
			double mediaFinalAluno = todosAlunos[cont].fornecaMediaFinal(); 
			if(mediaFinalAluno >= mediaFinalTodosAlunos)
			{
				alunosAcimaMediaFinal++;
			}
		}
		
		if(quantidadeAlunos > 0)
		{
			if(alunosAcimaMediaFinal > 0)
			{
				comunicaUsuario.mostreMensagem("Média Final da Turma: "+mediaFinalTodosAlunos+"\nAlunos com média final acima da média final da turma: "+alunosAcimaMediaFinal);
			}
			else
			{
				comunicaUsuario.mostreMensagem("Não houve alunos com média final acima da média final da turma.");
			}
			comunicaUsuario.mostreAlunos(melhorAluno);
		}
	}
}