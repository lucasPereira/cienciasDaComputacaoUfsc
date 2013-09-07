public class Principal 
{
	public static void main(String[] parametro)
	{
		Interface comunicaUsuario = new Interface();
		double criterio = comunicaUsuario.pecaCriterio();
		int numAlunos = 0;
		char novoAluno = 's';
		int aprovados = 0;
		double somaN1 = 0;
		double somaN2 = 0;
		double somaN3 = 0;
		double somaAprovadosN1 = 0;
		double somaAprovadosN2 = 0;
		double somaAprovadosN3 = 0;
		double maiorMedia = -1;
		Alunos melhorAluno = new Alunos("Ninguem", 0.0, 0.0, 0.0);
		
		while((novoAluno == 'S') || (novoAluno == 's'))
		{
			numAlunos++;
			Alunos aluno = comunicaUsuario.pecaAluno();	
			//aluno.aumenteNotaN1();
			
			String nome = aluno.fornecaNome();
			double media = aluno.fornecaMedia();
			boolean situacao = aluno.fornecaSituacao(criterio);
			double menorNota = aluno.fornecaMenorNota();
			double maiorNota = aluno.fornecaMaiorNota();
			int notasAcima = aluno.fornecaNotasAcima(criterio);
			double n1 = aluno.fornecaN1();
			double n2 = aluno.fornecaN2();
			double n3 = aluno.fornecaN3();
			
			comunicaUsuario.mostreAluno(nome, media, situacao, menorNota, maiorNota, criterio, notasAcima);
			
			somaN1 = somaN1+n1;
			somaN2 = somaN2+n2;
			somaN3 = somaN3+n3;
			
			if(situacao)
			{
				aprovados++;
				somaAprovadosN1 = somaAprovadosN1+n1;
				somaAprovadosN2 = somaAprovadosN2+n2;
				somaAprovadosN3 = somaAprovadosN3+n3;
			}
			
			if(media > maiorMedia)
			{
				maiorMedia = media;
				melhorAluno = aluno;
			}	
			novoAluno = comunicaUsuario.pecaNovoAluno();
		}
	
		double mediaGeral = ((somaN1+somaN2+somaN3)/3)/numAlunos;
		comunicaUsuario.mostreMediasTurma(somaN1/numAlunos, somaN2/numAlunos, somaN3/numAlunos, mediaGeral);
		if(aprovados > 0)
		{
			double mediaAprovadosGeral = ((somaAprovadosN1+somaAprovadosN2+somaAprovadosN3)/3)/aprovados;
			comunicaUsuario.mostreMediasTurmaAprovados(somaAprovadosN1/aprovados, somaAprovadosN2/aprovados, somaAprovadosN3/aprovados, mediaAprovadosGeral);
		}
		else
		{
			comunicaUsuario.mostreSemAprovados();
		}
		
		comunicaUsuario.mostreMelhorAluno(melhorAluno, criterio);
	}
}