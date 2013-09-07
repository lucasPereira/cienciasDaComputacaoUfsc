package visao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceGrafica 
{
	private final List<String> menu;
	private final Scanner scan;
	
	private static final int ZERO = 0;
	private static final int UM = 1;
	
	public InterfaceGrafica()
	{
		menu = new ArrayList<String>();
		scan = new Scanner(System.in);
	}
	
	public int capturarOpcao()
	{
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
				numero = -UM;
			}
		}
		while (numero < ZERO || numero > menu.size());
		
		return numero;
	}
	
	public String capturarTexto()
	{
		return scan.next();
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
