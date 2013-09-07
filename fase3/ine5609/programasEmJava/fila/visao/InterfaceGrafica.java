package visao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceGrafica 
{
	private List<String> menu;
	
	private static final int ZERO = 0;
	private static final int UM = 1;
	
	public InterfaceGrafica()
	{
		menu = new ArrayList<String>();
	}
	
	public int capturarOpcao()
	{
		return capturarInteiro(ZERO, (menu.size()-UM));
	}
	
	public int capturarNumero()
	{
		return capturarInteiro(Integer.MIN_VALUE+UM, Integer.MAX_VALUE);
	}
	
	private int capturarInteiro(int valorMinimo, int valorMaximo)
	{
		Scanner scan = new Scanner(System.in);
		String numeroDigitado;
		int numero;
		
		do 
		{
			numeroDigitado = scan.next();
			try
			{
				numero = Integer.parseInt(numeroDigitado);	
			}
			catch (NumberFormatException erro)
			{
				numero = valorMinimo-UM;
			}
		}
		while (numero < valorMinimo || numero > valorMaximo);
		
		return numero;
	}
	
	public void adicionarElementoAoMenu(String descricao)
	{
		menu.add(descricao);
	}
	
	public void mostrarOpcoesDoMenu()
	{
		String opcoes = "Escolha uma opção:";
		for (int cont = ZERO; cont < menu.size(); cont++)
		{
			opcoes += "\n[" + cont + "] " + menu.get(cont);
		}
		System.out.println(opcoes);
	}

	public void mostrarMensagem(String mensagem) 
	{
		System.out.println(mensagem);
	}
}
