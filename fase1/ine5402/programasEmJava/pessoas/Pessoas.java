//Aluno: Lucas Pereira da Silva - 10100754

public class Pessoas 
{
	protected String nome;
	protected int idade;
	protected char sexo;
	
	public Pessoas(String valorNome, int valorIdade, char valorSexo)
	{
		nome = valorNome;
		
		valorSexo = Character.toLowerCase(valorSexo);
		if(valorSexo == 'm' || valorSexo == 'f')
		{
			sexo = valorSexo;
		}
		else
		{
			sexo = '*';
		}
		
		idade = valorIdade;
		if(idade < 0)
		{
			idade = 0;
		}
		if(idade > 200)
		{
			idade = 200;
		}
	}
	
	public String fornecaNome()
	{
		return nome;
	}
	
	public int fornecaIdade()
	{
		return idade;
	}
	
	public char fornecaSexo()
	{
		return sexo;
	}
	
	public void altereNome(String valorNome)
	{
		nome = valorNome;
	}
	
	public void altereIdade(int valorIdade)
	{
		if(idade >= 0 || idade <= 200)
		{
			idade = valorIdade;
		}
	}
	
	public void altereSexo(char valorSexo)
	{
		valorSexo = Character.toLowerCase(valorSexo);
		if(valorSexo == 'm' || valorSexo == 'f')
		{
			sexo = valorSexo;
		}
	}
	
	public void aniversario()
	{
		idade++;
	}
}