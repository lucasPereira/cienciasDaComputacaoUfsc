public class Fila 
{
	private int tamanho;
	private Pessoas[] pessoasNaFila;
	public Fila()
	{
		//Constrói uma fila vazia
		tamanho = 0;
		pessoasNaFila = new Pessoas[10];
	}
	
	public int fornecaTamanhoDaFila()
	{
		return tamanho;
	}
	
	public boolean filaVazia()
	{
		return tamanho == 0;
	}
	
	public boolean filacheia()
	{
		return tamanho == pessoasNaFila.length;
	}
	
	public String[] fornecaNomes()
	{
		if(this.filaVazia())
		{
			return null;
		}
		else
		{
			String[] nomes = new String[tamanho];
			for(int cont = 0; cont < tamanho; cont++)
			{
				nomes[cont] = pessoasNaFila[cont].fornecaNome();
			}
			return nomes;
		}		
	}
	
	public int fornecaIdade(int posicaoPessoa)
	{
		return pessoasNaFila[posicaoPessoa].fornecaIdade();
	}
	
	public Pessoas fornecaPessoaNaPosicao(int posicao)
	{
		if(posicao < tamanho)
		{
			return pessoasNaFila[posicao];
		}
		else
		{
			return null;
		}
	}
	
	public void insiraPessoa(Pessoas pessoa)
	{
		if(this.filacheia())
		{
			Pessoas[] novaFila = new Pessoas[tamanho+10];
			for(int cont = 0; cont < tamanho; cont++)
			{
				novaFila[cont] = pessoasNaFila[cont];
			}
			pessoasNaFila = novaFila;
		}
		pessoasNaFila[tamanho++] = pessoa;
	}
	
	public Pessoas removaPessoa()
	{
		if(this.filaVazia())
		{
			return null;
		}
		else
		{
			Pessoas pessoaRetirada = pessoasNaFila[0];
			for(int cont = 0; cont < tamanho-1; cont++)
			{
				pessoasNaFila[cont] = pessoasNaFila[cont+1];
			}
			tamanho--;
			return pessoaRetirada;
		}
	}
	
	public boolean estaNaFila(String nome)
	{
		nome = nome.toLowerCase();
		nome = nome.trim();
		for(int cont = 0; cont < tamanho; cont++)
		{
			String nomePessoaFila = pessoasNaFila[cont].fornecaNome().toLowerCase();
			if(nomePessoaFila.equals(nome))
			{
				return true;
			}
		}
		return false;
	}
}