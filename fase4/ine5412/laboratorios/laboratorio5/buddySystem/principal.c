#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "BuddySystem.h"

/*Procedimentos*/
void mostrarMenuDeOpcoes();
void mostrarMapaDeAlocacaoDaMemoria();
void mostrarEspacoAlocadoEEspacoLivre();
void alocarBloco();
void liberarBloco();
/*Procedimentos*/

/*Constantes*/
const char *estadosDoBloco[2] = { "Livre", "Alocado" };
/*Constantes*/

int main() {
	alocarMemoriaInicial();
	mostrarMenuDeOpcoes();
	
	return 0;
}

void mostrarMenuDeOpcoes() {
	mostrarMapaDeAlocacaoDaMemoria();
	printf("\n-------");
	printf("\nSimulador Do Algoritimo De Gerência De Memória - Buddy System");
	while (1) {
		int opcaoEscolhida;
		printf("\n[0] Mostrar Mapa De Alocação Da Memória");
		printf("\n[1] Mostrar Espaço Alocado e Espaço Livre");
		printf("\n[2] Alocar");
		printf("\n[3] Liberar");
		printf("\n[4] Sair");
		printf("\nSelecione uma opção: ");
		scanf("%d", &opcaoEscolhida);
		switch (opcaoEscolhida) {
			case 0: 
				mostrarMapaDeAlocacaoDaMemoria();
				break;
			case 1:
				mostrarEspacoAlocadoEEspacoLivre();
				break;
			case 2:
				alocarBloco();
				break;
			case 3: 
				liberarBloco();
				break;
			case 4:
				printf("-------\n\n");
				exit(0);
				break;
		}
	}
}

void mostrarMapaDeAlocacaoDaMemoria() {
	system("clear");
	Bloco *primeiroBloco = fornecerPrimeiroBloco();
	printf("[%dK (%s)]", primeiroBloco->tamanho/UM_K, estadosDoBloco[primeiroBloco->estadoDoBloco]);
	Bloco *blocoAtual;
	blocoAtual = primeiroBloco->proximoBloco;
	while (blocoAtual != NULL) {
		printf(" [%dK (%s)]", blocoAtual->tamanho/UM_K, estadosDoBloco[(*blocoAtual).estadoDoBloco]);
		blocoAtual = blocoAtual->proximoBloco;
	}
	printf("\n");
}

void mostrarEspacoAlocadoEEspacoLivre() {
	system("clear");
	int espacoAlocado = fornecerEspacoAlocado();
	int espacoLivre = UM_MEGA - espacoAlocado;
	printf("Espaço Alocado: %d", espacoAlocado/UM_K);
	printf("\nEspaço Livre: %d\n", espacoLivre/UM_K);
	
}

void alocarBloco() {
	int tamanhoDoBloco;
	printf("Digite a quantidade de memória em KBs: ");
	scanf("%d", &tamanhoDoBloco);
	tamanhoDoBloco = tamanhoDoBloco*UM_K;
	void *blocoAlocado; 
	blocoAlocado = alocar(tamanhoDoBloco);
	if (blocoAlocado == NULL) {
		printf("\n*** Não há memória disponível para alocar a quantidade desejada. ***\n");
	} else {
		mostrarMapaDeAlocacaoDaMemoria();
	}
}

void liberarBloco() {
	int posicaoDoBloco;
	printf("Digite a posição do bloco a ser liberado (posição inicial: 0): ");
	scanf("%d", &posicaoDoBloco);
	if (liberar(posicaoDoBloco)) {
		mostrarMapaDeAlocacaoDaMemoria();
	} else {
		printf("\n*** Posição inválida ***\n");
	}
}
