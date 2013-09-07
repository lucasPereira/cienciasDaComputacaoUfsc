//Aluno: Lucas Pereira da Silva - 10100754

public class Principal 
{
	public static void main(String[] parametro)
	{	
		Interface comunicaUsuario = new Interface();
		Pessoas pessoaMaisJovem = new Pessoas("Ninguém", 18, 'm');
		Pessoas pessoaMaisVelha = new Pessoas("Ninguém", 80, 'f');
		
		char resposta;
		int mulheresMenos40 = 0;
		int adolescentes = 0;
		int somaIdadeAdolescentes = 0;
		double idadeMediaAdolescentes = 0;
		int idadePessoaMaisJovem = 200;
		int idadePessoaMaisVelha = 1;
		
		do
		{
			Pessoas pessoa = comunicaUsuario.pecaPessoa();
			
			int idade = pessoa.fornecaIdade();
			char sexo = pessoa.fornecaSexo();
			
			if(sexo == 'f' && idade < 40)
			{
				mulheresMenos40++;
			}
			
			if(idade >= 12 && idade <= 18)
			{
				adolescentes++;
				somaIdadeAdolescentes = somaIdadeAdolescentes+idade;
			}
			
			if(idade <= idadePessoaMaisJovem)
			{
				pessoaMaisJovem = pessoa;
				idadePessoaMaisJovem = idade;
			}
			
			if(idade >= idadePessoaMaisVelha)
			{
				pessoaMaisVelha = pessoa;
				idadePessoaMaisVelha = idade;
			}
			
			resposta = comunicaUsuario.pecaResposta();
		}
		while(resposta == 's');
		
		if(adolescentes > 0)
		{	
			idadeMediaAdolescentes = somaIdadeAdolescentes*1.0/adolescentes;
		}
		comunicaUsuario.mostreDadosPessoas(mulheresMenos40, idadeMediaAdolescentes, adolescentes);
		comunicaUsuario.mostrePessoaMaisJovem(pessoaMaisJovem);
		comunicaUsuario.mostrePessoaMaisVelha(pessoaMaisVelha);
	}
}