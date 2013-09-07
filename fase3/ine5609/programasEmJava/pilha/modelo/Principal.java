package modelo;

import visao.InterfaceGrafica;


public class Principal 
{
	public static void main(String[] args)
	{
		Pilha pilha = new Pilha(10);
		InterfaceGrafica interfaceGrafica = new InterfaceGrafica();
		interfaceGrafica.adicionarElementoAoMenu("Mostrar Menu");
		interfaceGrafica.adicionarElementoAoMenu("Push");
		interfaceGrafica.adicionarElementoAoMenu("Pop");
		interfaceGrafica.adicionarElementoAoMenu("Top");
		interfaceGrafica.adicionarElementoAoMenu("Mostrar Pilha");
		interfaceGrafica.adicionarElementoAoMenu("Sair");
		
		int opcao;
		boolean sair = false;
		do
		{
			interfaceGrafica.mostrarMensagem("Digite uma opção para a Pilha (mostrar menu [0]):");
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
					pilha.push(interfaceGrafica.capturarNumero());
					break;
				}
				case 2:
				{
					pilha.pop();
					break;
				}
				case 3:
				{
					interfaceGrafica.mostrarMensagem("Primeiro elemento da pilha: " + pilha.top());
					break;
				}
				case 4:
				{
					interfaceGrafica.mostrarMensagem(pilha.fornecerElementosNaPilha());
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