import javax.swing.JOptionPane;
public class Interface 
{
	public Interface()
	{
		
	}
	
	public Inteiros pecaInteiro()
	{
		int inteiro;
		do
		{
			String valorInteiro = JOptionPane.showInputDialog("Insira um número inteiro positivo.");
			try
			{
				inteiro = Integer.parseInt(valorInteiro);
			}
			catch(Exception e)
			{
				inteiro = 0;
			}
			if(inteiro <= 0)
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido. Insira um inteiro positivo");
			}
		}
		while(inteiro <= 0);	
		
		Inteiros objetoInteiro = new Inteiros(inteiro);
		return objetoInteiro;
	}
	
	public int pecaParcelas()
	{
		int parcelas;
		do
		{
			String valorParcelas = JOptionPane.showInputDialog("Insira o número de parcelas para o cálculo de S2.");
			try
			{
				parcelas = Integer.parseInt(valorParcelas);
			}
			catch(Exception e)
			{
				parcelas = 0;
			}
			if(parcelas <= 0)
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido. Insira o número de parcelas.");
			}
		}
		while(parcelas <= 0);
		return parcelas;
	}
	
	public int pecaBase()
	{
		int base;
		do
		{
			String valorBase = JOptionPane.showInputDialog("Insira a base para a conversão.");
			try
			{
				base = Integer.parseInt(valorBase);
			}
			catch(Exception e)
			{
				base = 0;
			}
			if(base <= 0 || base > 16)
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido. Insira a base para conversão.");
			}
		}
		while(base <= 0 || base > 16);
		return base;
	}
	
	public void mostreInteiro(int inteiro, boolean par, int somaPares, long fatorial, int sorteio, double calculoS1, String ultimoDigito, int somaDigitos, char igualdadeObjetos, Inteiros somaObjetos, Inteiros diferencaObjetos, double calculoS2, boolean primo, String numeroConvertido, int base)
	{
		String paridade;
		if(par)
		{
			paridade = "Par";
		}
		else
		{
			paridade = "Ímpar";
		}
		
		String igualdade;
		if(igualdadeObjetos == '>' || igualdadeObjetos == '<')
		{
			igualdade = "O objeto executor é "+igualdadeObjetos+" que o outro objeto.";
		}
		else
		{
			igualdade = "O objeto executor é "+igualdadeObjetos+" ao outro objeto.";
		}
	
		String diferenca;	
		if(diferencaObjetos == null)
		{
			diferenca = "Não foi possível calcular a diferenca entre o objeto executor e o outro objeto.";
		}
		else
		{
			diferenca = ""+diferencaObjetos.fornecaInteiro();
		}
		
		String numeroPrimo;
		if(primo)
		{
			numeroPrimo = "O número é primo.";
		}
		else
		{
			numeroPrimo = "O número não é primo.";
		}
		
		JOptionPane.showMessageDialog(null, 
		"Número: "+inteiro
		+"\n\nParidade: "+paridade
		+"\nSoma dos Pares: "+somaPares
		+"\nFatorial: "+fatorial
		+"\nSorteio: "+sorteio
		+"\nCalculo S1: "+calculoS1
		+"\nÚltimo Digito: "+ultimoDigito
		+"\nSoma de Digitos: "+somaDigitos
		+"\nIgualdade de Objetos: "+igualdade
		+"\nSoma de Objetos: "+somaObjetos.fornecaInteiro()
		+"\nDiferenca entre Objetos: "+diferenca
		+"\nCalculo S2: "+calculoS2
		+"\nPrimo: "+numeroPrimo
		+"\nO número convertido para a base "+base+" é: "+numeroConvertido
		);
	}
	
	public void mostreSorteado(String sorteados, int inteiro)
	{
		JOptionPane.showMessageDialog(null, "Os números sorteados menores que "+inteiro+" são:\n\n"+sorteados);
	}
}