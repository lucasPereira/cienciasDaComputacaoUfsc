public class ManipulaString 
{
	public static boolean contemCaractere(String palavra, char letra)
	{
		int tamanhoPalavra = palavra.length();
		for(int cont = 0; cont < tamanhoPalavra; cont++)
		{
			if(palavra.charAt(cont) == letra)
			{
				return true;
			}
		}
		return false;
	}
	
	public static int ultimaPosicaoString(String palavra, char letra)
	{
		int tamanhoPalavra = palavra.length();
		for(int cont = tamanhoPalavra -1; cont >= 0; cont--)
		{
			if(palavra.charAt(cont) == letra)
			{
				return cont;
			}
		}
		return -1;
	}
	
	public static int quantidadeLetras(String palavra)
	{
		int quantidadeLetras = 0;
		for(int cont = 0; cont < palavra.length(); cont++)
		{
			if(Character.isLetter(palavra.charAt(cont)))
			{
				quantidadeLetras++;
			}
		}
		return quantidadeLetras;
	}
	
	public static boolean vogal(char letra)
	{
		letra = Character.toLowerCase(letra);
		/*
		char[] vogais = {'a', 'e', 'i', 'o', 'u'};
		for(int cont = 0; cont < 5; cont++)
		{
			if(letra == vogais[cont])
			{
				return true;
			}
		}
		return false;
		*/
		return letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra =='u';
	}
	
	public static boolean consoante(char letra)
	{
		return !(ManipulaString.vogal(letra)) && Character.isLetter(letra);
	}
	
	public static String maiorString(String[] palavras)
	{
		int tamanho = palavras.length;
		String maiorString = palavras[0].toLowerCase();
		for(int cont = 1; cont < tamanho; cont++)
		{
			String palavra = palavras[0].toLowerCase();
			if(palavra.compareTo(maiorString) > 0)
			{
				maiorString = palavra;
			}
		}
		return maiorString;
	}

	public static char sorteioChar()
	{
		char letra;
		do
		{
			letra = (char)((int)(Math.random()*58)+'A');
		}
		while(!Character.isLetter(letra));
		return letra;
	}
	
	public static String sorteioStringMinuscula(int tamanho)
	{
		String palavra = "";
		for(int cont = 1; cont <= tamanho; cont++)
		{
			char letra = (char)((int)(Math.random()*26)+'a');
			palavra += letra;
		}
		return palavra;
	}
	
	public static String sorteioStringMinusculaConsoante(int tamanho)
	{
		String palavra = "";
		char letra;
		for(int cont = 1; cont <= tamanho; cont++)
		{
			do
			{
				letra = (char)((int)(Math.random()*26)+'a');
			}
			while(ManipulaString.vogal(letra));
			palavra += letra;
		}
		return palavra;
	}
	
	public static boolean numero(String valor)
	{
		if(valor.charAt(0) == '+')
		{
			valor = valor.substring(1, valor.length()-1);
		}
		try
		{
			Integer.parseInt(valor);
			return true;
		}
		catch(Exception erro)
		{
			return false;
		}
	}
	
	public static boolean numero2(String valor)
	{
		int tamanho = valor.length();
		if(tamanho == 0)
		{
			return false;
		}
		if(tamanho == 1)
		{
			return Character.isDigit(valor.charAt(0));
		} 
		char primeiro = valor.charAt(0);
		if(!(primeiro == '+' || primeiro == '-' || Character.isDigit(primeiro)))
		{
			return false;
		}
		for(int cont = 1; cont < tamanho; cont++)
		{
			if(!Character.isDigit(valor.charAt(cont)))
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean palindromo(String palavra)
	{
		palavra = palavra.toLowerCase();
		palavra = palavra.trim();
		int tamanho = palavra.length();
		String palavraContraria = "";
		for(int cont = tamanho-1; cont >=0; cont--)
		{
			palavraContraria += palavra.charAt(cont);
		}
		System.out.print(palavraContraria);
		return palavra.equals(palavraContraria);
	}
	
	public static int quantidadePalavras(String frase)
	{
		frase = frase.trim();
		frase += ".";
		int quantidadePalavras = 0;
		int tamanho = frase.length();
		String palavra = "";
		for(int cont = 0; cont < tamanho; cont++)
		{
			char letra = frase.charAt(cont);
			if(Character.isLetter(letra))
			{
				palavra = palavra+letra;
			}
			else
			{
				if(palavra.length() > 0)
				{
					quantidadePalavras++;
					palavra = "";
				}
			}
		}
		return quantidadePalavras;
	}	
	
	public static void ordeneStrings(String[] palavras)
	{
		int tamanho = palavras.length;
		for(int cont = 0; cont < tamanho-1; cont++)
		{
			int posicaoMenor = cont;
			String menor = palavras[cont];
			for(int cont1 = cont; cont1 < tamanho; cont1++)
			{
				if(palavras[cont1].compareTo(menor) < 0)
				{
					menor = palavras[cont1];
					posicaoMenor = cont1;
				}
			}
			String troca = palavras[cont];
			palavras[cont] = palavras[posicaoMenor];
			palavras[posicaoMenor] = troca; 
		}
	}
}
