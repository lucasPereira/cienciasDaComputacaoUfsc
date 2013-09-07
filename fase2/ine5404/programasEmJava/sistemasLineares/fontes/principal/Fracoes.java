package principal;

public class Fracoes 
{
	protected int[][] numerosFracionarios;
	protected int quantidadeNumeros;
	public Fracoes(int[][] numerosDecimais)
	{
		int quantidadeLinhas = numerosDecimais.length;
		quantidadeNumeros = quantidadeLinhas*(quantidadeLinhas+1);  
		numerosFracionarios = new int[quantidadeNumeros][2];
		int numero = 0;
		for(int linha = 0; linha < quantidadeLinhas; linha++)
		{
			for(int coluna = 0; coluna < (quantidadeLinhas+1); coluna++)
			{
				numerosFracionarios[numero][0] = numerosDecimais[linha][coluna];
				numerosFracionarios[numero][1] = 1;
				numero++;
			}
		}
	}
	
	public boolean numeroNulo(int codigo)
	{
		if(numerosFracionarios[codigo][0] == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void ajusteSinal(int codigo)
	{		
		if(numerosFracionarios[codigo][1] < 0)
		{
			numerosFracionarios[codigo][1] *= (-1);
			numerosFracionarios[codigo][0] *= (-1);
		}
	}
	
	public int[] ajusteSinal(int[] valor)
	{
		if(valor[1] < 0)
		{
			valor[1] *= (-1);
			valor[0] *= (-1);
		}
		return valor;
	}
	
	public void divida(int codigo, int[] valorADividir)
	{		
		numerosFracionarios[codigo][0] *= valorADividir[1];
		numerosFracionarios[codigo][1] *= valorADividir[0];
		this.ajusteSinal(codigo);
	}
	
	public void some(int codigo, int[] valor)
	{
		int numerador = numerosFracionarios[codigo][0];
		int denominador = numerosFracionarios[codigo][1];
		int novoDenominador;
		int novoNumerador;
		
		if(valor[1] == denominador)
		{
			numerador += valor[0];
			numerosFracionarios[codigo][0] = numerador;
		}
		else
		{
			novoDenominador = denominador * valor[1];
			novoNumerador = ((novoDenominador / denominador) * numerador) + ((novoDenominador / valor[1]) * valor[0]);
			numerosFracionarios[codigo][0] = novoNumerador;
			numerosFracionarios[codigo][1] = novoDenominador;
		}
		
		this.ajusteSinal(codigo);
	}
	
	public void simplifique(int codigo)
	{
		int numerador = numerosFracionarios[codigo][0];
		int denominador = numerosFracionarios[codigo][1];
		
		int[] primos = {2, 3, 5, 7, 11, 13, 17, 19};
		for(int cont = 0; cont < primos.length; cont++)
		{
			while((numerador % primos[cont] == 0) && (denominador % primos[cont] == 0))
			{
				numerador /= primos[cont];
				denominador /= primos[cont];
			}
		}
		
		numerosFracionarios[codigo][0] = numerador;
		numerosFracionarios[codigo][1] = denominador;
		this.ajusteSinal(codigo);
	}
	
	public int[] multiplique(int codigo, int[]valor)
	{
		int[] valorMultiplicado = new int[2];
		valorMultiplicado[0] = numerosFracionarios[codigo][0] * valor[0];
		valorMultiplicado[1] = numerosFracionarios[codigo][1] * valor[1];
		valorMultiplicado = this.ajusteSinal(valorMultiplicado);
		
		return valorMultiplicado;
	}
	
	public int[] acheValorQueZereColunaAbaixoPivo(int codigoPivo, int codigoValorAZerar)
	{
		int[] numeroFracionarioQueZera = new int[2];
		numeroFracionarioQueZera[0] = (-1) * numerosFracionarios[codigoValorAZerar][0] * numerosFracionarios[codigoPivo][1];
		numeroFracionarioQueZera[1] = numerosFracionarios[codigoValorAZerar][1] * numerosFracionarios[codigoPivo][0];
		numeroFracionarioQueZera = this.ajusteSinal(numeroFracionarioQueZera);
		
		return numeroFracionarioQueZera;
	}
}
