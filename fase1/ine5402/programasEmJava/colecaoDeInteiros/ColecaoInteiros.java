public class ColecaoInteiros 
{
	private int tamanho;
	private int[] colecao;
	
	public ColecaoInteiros(int tamanhoColecao)
	{
		/*Contém um objeto que representa uma colecão vazia mas com capacidade para armazenar "tamanho" valores*/
		tamanho = 0;
		colecao = new int[tamanhoColecao];
	}
	
	public ColecaoInteiros(int[] valores)
	{
		tamanho = valores.length;
		colecao = new int[tamanho];
		for(int cont = 0; cont < tamanho; cont++)
		{
			colecao[cont] = valores[cont];
		}
	}
	
	public int fornecaTamanho()
	{
		return tamanho;
	}
	
	public String fornecaStringValores()
	{
		String valores = "";
		for(int cont = 0; cont < tamanho; cont++)
		{
			valores += colecao[cont]+" ";
		}
		return valores;
	}
	
	public double fornecaMedia()
	{
		if(tamanho > 0)
		{
			int soma = 0;
			for(int cont =0; cont < tamanho; cont++)
			{
				soma += colecao[cont];
			}
			return (double)soma/tamanho;
		}
		else
		{
			return Double.NaN;
		}
	}
	
	public int fornecaPrimeiraOcorrencia(int valor)
	{
		for(int cont = 0; cont < tamanho; cont++)
		{
			if(valor == colecao[cont])
			{
				return cont+1;
			}
		}
		return -1;
	}
	
	public int fornecaValorPosicao(int posicao)
	{
		if(posicao >= 0 && posicao <= tamanho)
		{
			return colecao[posicao-1];
		}
		else
		{
			return Integer.MIN_VALUE;
		}
	}
	
	public int fornecaQuantidadePares()
	{
		int tamanhoPares = 0;
		for(int cont = 0; cont < tamanho; cont++)
		{
			if(colecao[cont]%2 == 0)
			{
				tamanhoPares++;
			}
		}
		return tamanhoPares;
	}
	
	public int[] fornecaValoresPares()
	{
		int[] colecaoPares = new int[this.fornecaQuantidadePares()];
		int posicao = 0;
		for(int cont = 0; cont < tamanho; cont++)
		{
			if(colecao[cont] %2 == 0)
			{
				colecaoPares[posicao++] = colecao[cont];
			}
		}
		return colecaoPares;
	}
	
	public int[] fornecaUniaoColecao(ColecaoInteiros outroObjeto) 
	{
		int[] uniaoColecao = new int[(tamanho+outroObjeto.tamanho)];
		for(int cont = 0; cont < tamanho; cont++)
		{
			uniaoColecao[cont] = colecao[cont];
		}
		
		int posicao = 0;
		for(int cont = tamanho; cont < uniaoColecao.length; cont++)
		{
			uniaoColecao[cont] = outroObjeto.colecao[posicao++];
		}
		
		return uniaoColecao;
	}
	
	public void invertaSelecao()
	{
		int[] inverso = new int[tamanho];
		int posicao = 0;
		for(int cont = tamanho-1; cont >= 0; cont--)
		{
			inverso[posicao++] = colecao[cont];
		}
		colecao = inverso;                        
	}
	
	public boolean insiraValor(int valor)
	{
		if(tamanho == colecao.length)
		{
			return false;
		}
		else
		{
			colecao[tamanho++] = valor;
			return true;
		}
	}
	
	public void insiraValor2(int valor)
	{
		if(tamanho == colecao.length)
		{
			int[] novaColecao = new int[(tamanho+1)];
			for(int cont = 0; cont < tamanho; cont++)
			{
				novaColecao[cont] = colecao[cont];
			}
			novaColecao[tamanho++] = valor;
			colecao = novaColecao;
		}
		else
		{
			colecao[tamanho++] = valor;
		}
	}
	
	public boolean removaValor(int valor)
	{
		int[] novaColecao = new int[(tamanho-1)];
		int posicaoValorRetirado = this.fornecaPrimeiraOcorrencia(valor)-1;
		int posicao = 0;
		
		if(posicaoValorRetirado == -2)
		{
			return false;
		}
		
		for(int cont = 0; cont < tamanho; cont++)
		{
			if(posicaoValorRetirado != cont)
			{
				novaColecao[posicao++] = colecao[cont];
			}
		}
		colecao = novaColecao;
		tamanho--;
		return true;
	}
	
	public void ordeneColecao()
	{
		for(int cont = 0; cont < tamanho-1; cont++)
		{
			int posicao = cont;
			int menor = colecao[cont];
			for(int cont1 = cont; cont1 < tamanho; cont1++)
			{
				if(colecao[cont1] < menor)
				{
					menor = colecao[cont1];
					posicao = cont1;
				}
			}
			int troca = colecao[cont];
			colecao[cont] = colecao[posicao];
			colecao[posicao] = troca;
		}
	}
}
