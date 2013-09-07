package principal;

public class SistemasLineares extends Fracoes
{
	private int[][] equacoes;
	private int quantidadeEquacoes;
	public SistemasLineares(int[][] valorEquacoes)
	{
		super(valorEquacoes);
		quantidadeEquacoes = valorEquacoes.length;
		equacoes = new int[quantidadeEquacoes][quantidadeEquacoes+1];
		
		int codigo = 0;
		for(int linha = 0; linha < quantidadeEquacoes; linha++)
		{
			for(int coluna = 0; coluna < (quantidadeEquacoes+1); coluna++)
			{
				equacoes[linha][coluna] = codigo;
				codigo++;
			}
		}
	}
	
	public int[][] fornecaCodigosEquacoes()
	{
		return equacoes;
	}
	
	public String fornecaStringSistema()
	{
		if(this.matrizNula())
		{
			return "Matriz Nula.";  
		}
		String sistema = "";
		for(int linha = 0; linha < quantidadeEquacoes; linha++)
		{
			for(int coluna = 0; coluna < (quantidadeEquacoes+1); coluna++)
			{
				this.simplifique(equacoes[linha][coluna]);
				String sinal = "";
				if(numerosFracionarios[equacoes[linha][coluna]][0] >= 0)
				{
					sinal = " ";
				}
					
				if(numerosFracionarios[equacoes[linha][coluna]][1] != 1)
				{
					sistema += "[" + sinal + numerosFracionarios[equacoes[linha][coluna]][0] + "/";
					sistema += numerosFracionarios[equacoes[linha][coluna]][1] + "]";
				}
				else
				{
					sistema += "[ " + sinal + numerosFracionarios[equacoes[linha][coluna]][0] + " ]";
				}
			}
			sistema += "\n";
		}
		return sistema;
	}
	
	public void formaDeEscada()
	{
		boolean linhaTerminada = false;
		
		//Passo 1
		if(!this.matrizNula())
		{
			for(int linha = 0; linha < quantidadeEquacoes; linha++)
			{
				//Passo 2A
				int colunaPivo = this.primeiraColunaNaoNula(linha);
				if(colunaPivo < 0)
				{
					break;
				}
				
				//Passo 2B
				if(this.numeroNulo(equacoes[linha][colunaPivo]))
				{
					for(int linhaNovoPivo = linha; linhaNovoPivo < quantidadeEquacoes; linhaNovoPivo++)
					{
						if(!this.numeroNulo(equacoes[linhaNovoPivo][colunaPivo]))
						{
							this.troqueLinhas(linha, linhaNovoPivo);
							linhaTerminada = false;
							Interface.mostreMensagem("Passo 2B \n\n" + this.fornecaStringSistema());
							break;
						}
						else
						{
							linhaTerminada = true;
						}
					}
				}
				
				if(!linhaTerminada)
				{
					//Passo 3
					if(!(numerosFracionarios[equacoes[linha][colunaPivo]][0] == 1 && numerosFracionarios[equacoes[linha][colunaPivo]][1] == 1))
					{
						this.dividaLinha(linha, colunaPivo);
						Interface.mostreMensagem("Passo 3 \n\n" + this.fornecaStringSistema());
					}
					
					//Passo 4
					for(int linhasAbaixoPivo = (linha+1); linhasAbaixoPivo < quantidadeEquacoes; linhasAbaixoPivo++)
					{
						if(!this.numeroNulo(equacoes[linhasAbaixoPivo][colunaPivo]))
						{
							int[] valorQueZera = this.acheValorQueZereColunaAbaixoPivo(equacoes[linha][colunaPivo], equacoes[linhasAbaixoPivo][colunaPivo]);
							this.someLinhaAoValor(linhasAbaixoPivo, colunaPivo, linha, valorQueZera);
							Interface.mostreMensagem("Passo 4 \n\n" + this.fornecaStringSistema());
						}
					}
				}
			}
		}
	}
	
	public boolean matrizNula()
	{
		for(int linha = 0; linha < quantidadeEquacoes; linha++)
		{
			for(int coluna = 0; coluna < quantidadeEquacoes; coluna++)
			{
				if(!this.numeroNulo(equacoes[linha][coluna]))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public int primeiraColunaNaoNula(int linhaInicial)
	{
		for(int coluna = 0; coluna < quantidadeEquacoes; coluna++)
		{
			for(int linha = linhaInicial; linha < quantidadeEquacoes; linha++)
			{
				if(!this.numeroNulo(equacoes[linha][coluna]))
				{
					return coluna; 
				}
			}
		}
		return -1;
	}
	
	public void troqueLinhas(int linhaA, int linhaB)
	{
		int valorLinhaA; 
		for(int coluna = 0; coluna < (quantidadeEquacoes+1); coluna++)
		{
			valorLinhaA = equacoes[linhaA][coluna];
			equacoes[linhaA][coluna] = equacoes[linhaB][coluna];
			equacoes[linhaB][coluna] = valorLinhaA;
		}
	}
	
	public void dividaLinha(int linhaADividir, int colunaInicialADividr)
	{
		int[] valorAdividir = new int[2];
		valorAdividir[0] = numerosFracionarios[equacoes[linhaADividir][colunaInicialADividr]][0];
		valorAdividir[1] = numerosFracionarios[equacoes[linhaADividir][colunaInicialADividr]][1];
		                    
		for(int coluna = colunaInicialADividr; coluna < (quantidadeEquacoes+1); coluna++)
		{
			this.divida(equacoes[linhaADividir][coluna], valorAdividir);
		}
	}
	
	public void someLinhaAoValor(int linha, int colunaPivo, int linhaPivo, int[] valorPivoASomar)
	{
		int quantidadeDeColunas = (quantidadeEquacoes+1) - colunaPivo;
		int[][] valoresASomar = new int[quantidadeDeColunas][2];
		valoresASomar[0][0] = valorPivoASomar[0];
		valoresASomar[0][1] = valorPivoASomar[1];
		
		int contA = 0;
		for(int coluna = (colunaPivo+1); coluna < (quantidadeEquacoes+1); coluna++)
		{
			int[] valorASomar = this.multiplique(equacoes[linhaPivo][coluna], valorPivoASomar);
			valoresASomar[++contA][0] = valorASomar[0];
			valoresASomar[contA][1] = valorASomar[1];		
		}
		
		int contB = 0;
		for(int colunaASomar = colunaPivo; colunaASomar < (quantidadeEquacoes+1); colunaASomar++)
		{
			this.some(equacoes[linha][colunaASomar], valoresASomar[contB++]);
		}
	}
}