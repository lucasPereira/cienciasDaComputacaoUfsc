package br.lucaspereira.caingangue;

public class RegistroDeEventos {
	
	public static void registrarEvento(String mensagem) {
		System.out.printf("\n[%s] %s.", Caingangue.VERSÃO, mensagem);
	}
}