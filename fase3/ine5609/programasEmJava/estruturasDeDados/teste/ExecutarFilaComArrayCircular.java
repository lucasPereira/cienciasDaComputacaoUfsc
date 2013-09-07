package teste;

import modelo.estruturasLineares.fila.FilaComArrayCircular;

public class ExecutarFilaComArrayCircular 
{
	public static void main(String[] args)
	{
		FilaComArrayCircular<String> fila = new FilaComArrayCircular<String>(5);
		
		fila.entrar("Uva");
		fila.entrar("Maça");
		System.out.println(fila.sair());
		fila.entrar("Melão");
		fila.entrar("Goiaba");
		System.out.println(fila.fornecerPrimeiro());
		fila.entrar("Acerola");
		fila.entrar("Abacaxi");
		System.out.println(fila.sair());
		fila.entrar("Pêra");
		fila.entrar("Jaca");
	}
}