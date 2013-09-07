package teste;

import modelo.estruturasBidimensionais.hash.Hashavel;
import modelo.utilidades.Comparavel;

public final class Pessoa implements Comparavel<Pessoa>, Hashavel
{
	private static final int UM = 1;
	private String nome;
	private int codigo;
	
	public Pessoa(String nome, int codigo)
	{
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public boolean verificarSeÉIgual(Pessoa outro) 
	{
		return outro.verificarSeNomeÉIgual(nome);
	}
	
	public boolean verificarSeÉMaior(Pessoa outro)
	{
		if (outro.verificarSeCodigoÉMaiorMenorOuIgual(codigo) == UM) return true;
		
		return false;
	}
	
	public boolean verificarSeÉMenor(Pessoa outro)
	{
		if (outro.verificarSeCodigoÉMaiorMenorOuIgual(codigo) == -UM) return true;
		
		return false;
	}
	
	private int verificarSeCodigoÉMaiorMenorOuIgual(int codigo)
	{
		int retorno = 0;
		if (codigo > this.codigo) retorno = UM;
		if (codigo < this.codigo) retorno = -UM;
		
		return retorno;
	}
	
	private boolean verificarSeNomeÉIgual(String nome)
	{
		return this.nome.equals(nome);
	}

	public int fornecerCodigoHash() 
	{
		return codigo;
	}
	
	public String toString()
	{
		String nome = "";
		return nome+"("+codigo+")";
	}
}