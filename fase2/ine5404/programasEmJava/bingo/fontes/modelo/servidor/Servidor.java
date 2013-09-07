package modelo.servidor;

public class Servidor
{
	private FachadaServidor fachadaParaServidor;
	private NumerosSorteados numerosBingo;
	
	public Servidor(FachadaServidor fachada)
	{
		fachadaParaServidor = fachada;
		numerosBingo = new NumerosSorteados();
		numerosBingo.sortearNumeros();
		enviarNumeros();
	}
	
	public void enviarNumeros()
	{
		fachadaParaServidor.semBingo();
		int tempoDeEspera = 3000;
		int tempoDeIntervalo = 20000;
		
		for(int cont = 0; cont < numerosBingo.fornecerQuantidadeDeNumeros(); cont++)
		{		
			if(fachadaParaServidor.verificarSeJaFizeramBingo())
			{
				break;
			}
			
			fachadaParaServidor.enviarNumeroSorteado(numerosBingo.fornecerNumero(cont));
			durma(tempoDeEspera);
		}
		
		System.out.println("Tempo para Gritarem Bingo");
		durma(tempoDeIntervalo);
		
		numerosBingo.sortearNumeros();
		enviarNumeros();
	}
	
	public void durma(int tempo)
	{
		try 
		{
			Thread.sleep(tempo);
		} 
		catch (InterruptedException erro) 
		{
			erro.printStackTrace();
		}
	}
}
