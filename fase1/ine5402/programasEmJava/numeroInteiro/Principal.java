public class Principal 
{
	public static void main(String[] parametro)
	{		
		Interface comunicaUsuario = new Interface();
		Inteiros outroInteiro = comunicaUsuario.pecaInteiro();
		Inteiros inteiroPositivo = comunicaUsuario.pecaInteiro();
		
		int inteiro = inteiroPositivo.fornecaInteiro();
		boolean paridade = inteiroPositivo.par();
		int somaPares = inteiroPositivo.somaPares();
		long fatorial = inteiroPositivo.fatorial();		
		int sorteio = inteiroPositivo.sorteio();
		double calculoS1 = inteiroPositivo.calculoS();
		String ultimoDigito = inteiroPositivo.ultimoDigito();
		int somaDigitos = inteiroPositivo.somaDigitos();
		char igualdadeObjetos = inteiroPositivo.igualdadeObjetos(outroInteiro);
		Inteiros somaObjetos = inteiroPositivo.somaObjetos(outroInteiro);
		Inteiros diferencaObjetos = inteiroPositivo.diferencaObjeots(outroInteiro);
		int parcelas = comunicaUsuario.pecaParcelas();
		double calculoS2 = inteiroPositivo.calculoS(parcelas);
		boolean primo = inteiroPositivo.primo();
		int base = comunicaUsuario.pecaBase();
		String numeroConvertido = inteiroPositivo.convercaoDecimalBase(base);
		
	
		int cont = 0;
		String sorteados = "";
		while(cont < 10)
		{
			cont++;
			int sorteado = inteiroPositivo.sorteio();
			sorteados = sorteados+sorteado+"\n"; 
		}
		comunicaUsuario.mostreSorteado(sorteados, inteiro);
			
		comunicaUsuario.mostreInteiro(inteiro, paridade, somaPares, fatorial, sorteio, calculoS1, ultimoDigito, somaDigitos, igualdadeObjetos, somaObjetos, diferencaObjetos, calculoS2, primo, numeroConvertido, base);
	}
}