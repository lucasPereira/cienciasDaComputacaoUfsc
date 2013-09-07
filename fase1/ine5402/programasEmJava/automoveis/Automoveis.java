//Aluno: Lucas Pereira - 10100754

public class Automoveis 
{
	private int ano;
	private String marca;
	private double preco;
	public Automoveis(int valorAno, String valorMarca, double valorPreco)
	{
		ano = valorAno;
		if(ano < 1950)
		{
			ano = 1950;
		}
		if(ano > 2011)
		{
			ano = 2011;
		}
		
		valorMarca = valorMarca.toLowerCase();
		String[] marcas = Automoveis.fornecaMarcas();
		boolean temMarca = false;
		int posicao = 0;
		for(int cont = 0; cont < marcas.length; cont++)
		{
			if(valorMarca.equals(marcas[cont].toLowerCase()))
			{
				posicao = cont;
				temMarca = true;
				break;
			}
		}
		
		if(temMarca)
		{
			marca = marcas[posicao];
		}
		else
		{
			marca = marcas[marcas.length-1];
		}
		
		preco = valorPreco;
		if(preco < 0)
		{
			preco = 0;
		}
	}
	
	public static String[] fornecaMarcas()
	{
		String[] marcas = {"Fiat", "Ford", "VW", "Chevrolet", "GM", "Honda", "Peugeot", "Audi", "Toyota", "BMW", "Indefinida"};
		return marcas;
	}
	
	public int fornecaAno()
	{
		return ano;
	}
	
	public String fornecaMarca()
	{
		return marca;
	}
	
	public double fornecaPreco()
	{
		return preco;
	}
	
	public String toString()
	{
		return "Ano: "+ano+"\nMarca: "+marca+"\nPreco: R$ "+preco;
	}
}
