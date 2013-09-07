public class Principal 
{
	public static void main(String[] parametro)
	{
		Interface comunicaUsuario = new Interface();
		
		int[] valores = comunicaUsuario.pecaValores();
		int soma = 0;
		double media;
		int valoresAcimaMedia = 0;
		String todosValores = "Valores Digitados:\n\n";
		
		for(int cont = 0; cont < 10; cont++)
		{
			soma += valores[cont];
		}
		
		media = (double)soma/10;
		for(int cont = 0; cont < 10; cont++)
		{
			if(valores[cont] > media)
			{
				valoresAcimaMedia++;
			}
		}
		
		comunicaUsuario.mostreMensagem(
		"Soma dos valores: "+soma
		+"\nQuantidade de valores acima da média: "+valoresAcimaMedia
		);	
		
		for(int cont = 0; cont < 10; cont++)
		{
			todosValores += valores[cont]+"\n";
		}
		comunicaUsuario.mostreMensagem(todosValores);
	}
}
