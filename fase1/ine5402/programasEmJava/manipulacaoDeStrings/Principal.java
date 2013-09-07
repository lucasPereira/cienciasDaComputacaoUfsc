public class Principal 
{
	public static void main(String[] parametro)
	{
		String palavra = Interface.pecaPalavra();
		char letra = Interface.pecaCaractere();
		
		boolean contemCaractere = ManipulaString.contemCaractere(palavra, letra);
		if(contemCaractere)
		{
			Interface.mostreMensagem("A palavra "+palavra+" contém o caractere "+letra);
		}
		else
		{
			Interface.mostreMensagem("A palavra "+palavra+" não contém o caractere "+letra);
		}
		
		int posicaoUltimaOcorrencia = ManipulaString.ultimaPosicaoString(palavra, letra);
		if(posicaoUltimaOcorrencia >= 0)
		{
			Interface.mostreMensagem("A posicão da última ocorrência da letra "+letra+" na palavra "+palavra+" é: "+posicaoUltimaOcorrencia);
		}
		else
		{
			Interface.mostreMensagem("A palavra "+palavra+" não contém o caractere "+letra);
		}
		
		int quantidadeLetras = ManipulaString.quantidadeLetras(palavra);
		Interface.mostreMensagem("A quantidade de letras da string "+palavra+" é: "+quantidadeLetras); 
		
		boolean vogal = ManipulaString.vogal(letra);
		if(vogal)
		{
			Interface.mostreMensagem("O caractere "+letra+" é uma vogal"); 
		}
		else
		{
			Interface.mostreMensagem("O caractere "+letra+" não é uma vogal"); 
		}
		
		boolean consoante = ManipulaString.consoante(letra);
		if(consoante)
		{
			Interface.mostreMensagem("O caractere "+letra+" é uma consoante"); 
		}
		else
		{
			Interface.mostreMensagem("O caractere "+letra+" não é uma consoante"); 
		}
		
		String[] palavras = new String[Interface.pecaTamanho()];
		String palavrasNormal = "";
		for(int cont = 0; cont < palavras.length; cont++)
		{
			palavras[cont] = Interface.pecaPalavra();
			palavras[cont] = palavras[cont].toLowerCase();
			palavrasNormal += palavras[cont]+"\n";
		}
		
		ManipulaString.ordeneStrings(palavras);
		String palavrasOdernadas = "";
		for(int cont = 0; cont < palavras.length; cont++)
		{
			palavrasOdernadas += palavras[cont]+"\n";
		}
		
		Interface.mostreMensagem(palavrasNormal+"\n\n"+palavrasOdernadas);
		
		String maiorPalavra = ManipulaString.maiorString(palavras);
		Interface.mostreMensagem("A maior palavra do arranjo é: "+maiorPalavra);
		
		String palavraMinusculaSorteada = ManipulaString.sorteioStringMinuscula(Interface.pecaTamanho());
		Interface.mostreMensagem("A palavra minúscula sorteada é: "+palavraMinusculaSorteada);
		
		String palavraMinusculaConsoanteSorteada = ManipulaString.sorteioStringMinusculaConsoante(Interface.pecaTamanho());
		Interface.mostreMensagem("A palavra minúscula consoante sorteada é: "+palavraMinusculaConsoanteSorteada);
		
		char sorteioLetra = ManipulaString.sorteioChar();
		Interface.mostreMensagem("A letra sorteada é: "+sorteioLetra);
		
		boolean numero = ManipulaString.numero(palavra);
		if(numero)
		{
			Interface.mostreMensagem("O número é um inteiro.");
		}
		else
		{
			Interface.mostreMensagem("O número não é um inteiro.");
		}
		
		boolean palindromo = ManipulaString.palindromo(palavra);
		if(palindromo)
		{
			Interface.mostreMensagem("A palavra é um palíndromo.");
		}
		else
		{
			Interface.mostreMensagem("A palavra não é um palíndromo.");
		}
		
		int quantidadePalavras = ManipulaString.quantidadePalavras(palavra);
		Interface.mostreMensagem("A quantidade de palavras da frase "+palavra+" é: "+quantidadePalavras);
	}
}
