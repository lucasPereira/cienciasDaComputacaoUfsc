package modelo;

import visao.InterfaceGrafica;

public class Principal 
{
	public static void main(String[] args)
	{
		Fila fila = new Fila(10);
		InterfaceGrafica interfaceGrafica = new InterfaceGrafica();
		interfaceGrafica.adicionarElementoAoMenu("Mostrar Menu");
		interfaceGrafica.adicionarElementoAoMenu("Entrar");
		interfaceGrafica.adicionarElementoAoMenu("Sair");
		interfaceGrafica.adicionarElementoAoMenu("Top");
		interfaceGrafica.adicionarElementoAoMenu("Mostrar Fila");
		interfaceGrafica.adicionarElementoAoMenu("Sair");
		
		int opcao;
		boolean sair = false;
		do
		{
			interfaceGrafica.mostrarMensagem("Digite uma opção para a Fila (mostrar menu [0]):");
			opcao = interfaceGrafica.capturarOpcao();
			
			switch (opcao)
			{
				case 0:
				{
					interfaceGrafica.mostrarOpcoesDoMenu();
					break;
				}
				case 1:
				{
					fila.entrar(interfaceGrafica.capturarNumero());
					break;
				}
				case 2:
				{
					fila.sair();
					break;
				}
				case 3:
				{
					interfaceGrafica.mostrarMensagem("Primeiro elemento da fila: " + fila.primeiro());
					break;
				}
				case 4:
				{
					interfaceGrafica.mostrarMensagem(fila.fornecerElementosNaFila());
					break;
				}
				
				case 5:
				{
					sair = true;
					break;
				}
			}	
		}
		while (!sair);		
		
		FilaEncadeadaComAlocacaoDinamica filaEncadeada = new FilaEncadeadaComAlocacaoDinamica();
		
		sair = false;
		do
		{
			interfaceGrafica.mostrarMensagem("Digite uma opção para a FilaEncadeada (mostrar menu [0]):");
			opcao = interfaceGrafica.capturarOpcao();
			
			switch (opcao)
			{
				case 0:
				{
					interfaceGrafica.mostrarOpcoesDoMenu();
					break;
				}
				case 1:
				{
					filaEncadeada.entrar(interfaceGrafica.capturarNumero());
					break;
				}
				case 2:
				{
					filaEncadeada.sair();
					break;
				}
				case 3:
				{
					//interfaceGrafica.mostrarMensagem("Primeiro elemento da fila: " + fila.primeiro());
					break;
				}
				case 4:
				{
					interfaceGrafica.mostrarMensagem(filaEncadeada.fornecerElementosNaFila());
					break;
				}
				
				case 5:
				{
					sair = true;
					break;
				}
			}	
		}
		while (!sair);
	}
}