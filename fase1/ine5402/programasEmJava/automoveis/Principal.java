//Aluno: Lucas Pereira - 10100754

public class Principal 
{
	public static void main(String[] parametro)
	{
		int quantidadeAutomoveis = Interface.pecaQuantidadeAutomoveis();
		Automoveis[] automovel = new Automoveis[quantidadeAutomoveis];
	
		double precoAutomovelMaisCaro = 0;
		Automoveis automovelMaisCaro = new Automoveis(0, "*", 0.0);
		String[] marcas = Automoveis.fornecaMarcas();
		int quantidadeMarcas = marcas.length;
		int[] quantidadeCarrosPorMarca = new int[quantidadeMarcas];
		int[] quantidadeCarrosPorAno = new int[31];
		int[] quantidadeCarrosPorPreco = new int[51];
		
		for(int cont = 0; cont < quantidadeAutomoveis; cont++)
		{
			automovel[cont] = Interface.pecaAutomovel();
			
			//Verifica o carro mais caro
			if(automovel[cont].fornecaPreco() > precoAutomovelMaisCaro)
			{
				precoAutomovelMaisCaro = automovel[cont].fornecaPreco();
				automovelMaisCaro = automovel[cont];
			}
			
			//Classifica o número de carros por marca
			for(int cont1 = 0; cont1 < quantidadeMarcas; cont1++)
			{
				if(marcas[cont1].equals(automovel[cont].fornecaMarca()))
				{
					quantidadeCarrosPorMarca[cont1]++;
					break;
				}
			}
			
			//Classifica o número de carros por ano
			int ano = automovel[cont].fornecaAno();
			if(ano >= 1980 && ano <= 2010)
			{
				quantidadeCarrosPorAno[ano-1980]++;
			}
			
			//Classifica o número de carros por preco
			double preco = automovel[cont].fornecaPreco();
			if(preco <= 50000)
			{
				quantidadeCarrosPorPreco[(int)(preco/1000)]++;
			}
			else
			{
				quantidadeCarrosPorPreco[50]++;
			}
		}
		
		Interface.mostreMensagem("Automóvel mais caro.\n\n"+automovelMaisCaro.toString());
		Interface.mostreRelatorioMarcas(marcas, quantidadeCarrosPorMarca);
		Interface.mostreRelatorioAnos(quantidadeCarrosPorAno);
		Interface.mostreReletaorioPreco(quantidadeCarrosPorPreco);
	}
}