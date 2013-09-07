package teste;

import modelo.estruturasBidimensionais.arvore.ArvoreBinariaComArray;

public class ExecutarArvoreBinariaComArray 
{
	public static void main(String[] args)
	{
		Pessoa pessoa1 = new Pessoa("37", 37);
		Pessoa pessoa2 = new Pessoa("30", 30);
		Pessoa pessoa3 = new Pessoa("70", 70);
		Pessoa pessoa4 = new Pessoa("1", 1);
		Pessoa pessoa5 = new Pessoa("35", 35);
		Pessoa pessoa6 = new Pessoa("0", 0);
		Pessoa pessoa7 = new Pessoa("14", 14);
		Pessoa pessoa8 = new Pessoa("33", 33);
		Pessoa pessoa9 = new Pessoa("36", 36);
		Pessoa pessoa10 = new Pessoa("50", 50);
		Pessoa pessoa11 = new Pessoa("40", 40);
		Pessoa pessoa12 = new Pessoa("75", 75);
		Pessoa pessoa13 = new Pessoa("60", 60);
		Pessoa pessoa14 = new Pessoa("90", 90);
		Pessoa pessoa15 = new Pessoa("71", 71);
		ArvoreBinariaComArray<Pessoa> arvore = new ArvoreBinariaComArray<Pessoa>(4);
		System.out.println(arvore.verificarSePossuiElemento(pessoa1));
		arvore.inserir(pessoa1);
		System.out.println(arvore.verificarSePossuiElemento(pessoa1));
		arvore.inserir(pessoa2);
		arvore.inserir(pessoa3);
		arvore.inserir(pessoa4);
		System.out.println(arvore.verificarSePossuiElemento(pessoa5));
		System.out.println(arvore.verificarSePossuiElemento(pessoa3));
		arvore.inserir(pessoa5);
		arvore.inserir(pessoa6);
		arvore.inserir(pessoa7);
		arvore.inserir(pessoa8);
		arvore.inserir(pessoa9);
		arvore.inserir(pessoa10);
		System.out.println(arvore.verificarSePossuiElemento(pessoa1));
		arvore.inserir(pessoa11);
		arvore.inserir(pessoa12);
		arvore.inserir(pessoa13);
		arvore.inserir(pessoa14);
		System.out.println(arvore.verificarSePossuiElemento(pessoa15));
		arvore.inserir(pessoa15);
		System.out.println(arvore.verificarSePossuiElemento(pessoa15));
	}
}
