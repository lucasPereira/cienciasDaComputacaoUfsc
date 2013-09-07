package producao;	
import javax.swing.JOptionPane;

public class Interface 
{
	public Interface()
	{
		
	}
	
	public static FlipFlopJK pecaJK(int valorMaximoDelay)
	{
		boolean transicao = Interface.pecaValoresBoleanos("Insira o tipo de transicão do Flip FLop, escolhendo negativa ou positiva (0 ou 1).");
		int delay = Interface.pecaValoresInteiros("Insira o valor padrão do delay do FlipFlop. (valor entre 0 e "+valorMaximoDelay+".", valorMaximoDelay, 0);
		boolean[] j = new boolean[4];
		boolean[] k = new boolean[4];
		
		for(int cont = 0; cont < 4; cont++)
		{
			j[cont] = Interface.pecaValoresBoleanos("Insira o valor "+(cont+1)+" de J (0 ou 1).");
			k[cont] = Interface.pecaValoresBoleanos("Insira o valor "+(cont+1)+" de k (0 ou 1).");
		}
		
		return new FlipFlopJK(transicao, delay, j, k);
	}
	
	public static boolean pecaValoresBoleanos(String mensagem)
	{
		if(Interface.pecaValoresInteiros(mensagem, 1, 0) != 0)
		{
			return true;
		}
		return false;
	}
	
	public static int pecaValoresInteiros(String mensagem, int valorMaximo, int valorMinimo)
	{
		int inteiro;
		do
		{
			String valorInteiro = JOptionPane.showInputDialog(mensagem);
			try
			{
				inteiro = Integer.parseInt(valorInteiro);
			}
			catch(Exception erro)
			{
				inteiro = (valorMaximo+1);
			}
			if(inteiro < valorMinimo || inteiro > valorMaximo)
			{
				Interface.mostreMensagem("Valor inválido\n\nHahahahaha");
			}
		}
		while(inteiro < valorMinimo || inteiro > valorMaximo);
		return inteiro;
	}
	
	public static void mostreMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
