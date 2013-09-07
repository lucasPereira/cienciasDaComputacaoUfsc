package comunicacaoEmRede;

import edugraf.jadix.fachada.TratadorDixAbstrato;  
import static edugraf.jadix.primitivas.Primitiva.tupla; 

public class EnvioDeNumeroSorteado extends TratadorDixAbstrato 
{
	public void enviarNumeroSorteado(int numero)
	{
		tupla(numero).dizer();
		System.out.println("[Enviando] Número Sorteado: "+numero);
	}
}
