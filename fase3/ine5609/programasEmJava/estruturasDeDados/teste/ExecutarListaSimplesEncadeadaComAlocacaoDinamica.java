package teste;

import modelo.estruturasLineares.lista.ListaSimplesEncadeadaComAlocacaoDinamica;

public class ExecutarListaSimplesEncadeadaComAlocacaoDinamica 
{
	public static void main(String[] args)
	{
		Pessoa pessoa1 = new Pessoa("Lucas", 1);
		Pessoa pessoa6 = new Pessoa("Talia", 6);
		Pessoa pessoa2 = new Pessoa("Ricardo", 2);
		Pessoa pessoa3 = new Pessoa("Sandra", 3);
		Pessoa pessoa4 = new Pessoa("Fernando", 4);
		Pessoa pessoa5 = new Pessoa("Mateus", 5);
		System.out.println(pessoa1.verificarSeÉIgual(pessoa6));
		System.out.println(pessoa1.verificarSeÉIgual(pessoa3));
		ListaSimplesEncadeadaComAlocacaoDinamica<Pessoa> lista = new ListaSimplesEncadeadaComAlocacaoDinamica<Pessoa>();
		boolean possui = lista.verificarSePossuiElemento(pessoa5);
		lista.inserirInicio(pessoa1);
		lista.inserirInicio(pessoa2);
		possui = lista.verificarSePossuiElemento(pessoa1);
		possui = lista.verificarSePossuiElemento(pessoa2);
		possui = lista.verificarSePossuiElemento(pessoa3);
		lista.inserirInicio(pessoa4);
		possui = lista.verificarSePossuiElemento(pessoa4);
		boolean removido = lista.removerElemento(pessoa4);
		possui = lista.verificarSePossuiElemento(pessoa4);
		removido = lista.removerElemento(pessoa3);
		lista.inserirInicio(pessoa3);
		lista.inserirInicio(pessoa4);
		lista.inserirInicio(pessoa6);
		removido = lista.removerElemento(pessoa3);
		removido = lista.removerElemento(pessoa1);
		System.out.println(possui);
		System.out.println(removido);
	}
}
