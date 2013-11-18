#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "BuddySystem.h"

/*Variáveis Globais*/
Bloco *primeiroBloco = NULL;
int espacoAlocado = 0;
/*Variáveis Globais*/

/*Procedimentos*/
void juntarBlocosLivres();
void* quebrarBlocoAoMaximoEAlocar(Bloco *blocoDeMenorTamanhoPossivel, int tamanhoDoBlocoDesejado);
Bloco* encontrarBlocoDeMenorTamanhoPossivel(int tamanhoDoBlocoDesejado);
Bloco* inicializarBloco(int quantidadeDeMemoria, void *posicaoNaMemoria);
/*Procedimentos*/

int fornecerEspacoAlocado() {
	return espacoAlocado;
}

Bloco* fornecerPrimeiroBloco() {
	return primeiroBloco;
}

int liberar(int posicao) {
	int contador = 0;
	Bloco *blocoAtual;
	blocoAtual = primeiroBloco;
	while (contador < posicao && blocoAtual != NULL) {
		blocoAtual = blocoAtual->proximoBloco;	
		contador++;
	}
	if (blocoAtual == NULL) {
		return FALSO;
	}
	if (blocoAtual->estadoDoBloco != LIVRE) {
		espacoAlocado -= blocoAtual->tamanho;
	}
	blocoAtual->estadoDoBloco = LIVRE;
	juntarBlocosLivres();

	return VERDADEIRO;
}

void juntarBlocosLivres() {
	Bloco *blocoAtual = primeiroBloco;
	Bloco *proximoBloco;
	int juntou = FALSO;
	int tamanhoTotalDosBlcosAEsquerda = 0;
	while (blocoAtual != NULL) {
		if (blocoAtual->estadoDoBloco == LIVRE) {
			proximoBloco = blocoAtual->proximoBloco;
			if (proximoBloco != NULL && 
					proximoBloco->estadoDoBloco == LIVRE &&
					blocoAtual->tamanho == proximoBloco->tamanho &&
					(tamanhoTotalDosBlcosAEsquerda >= blocoAtual->tamanho*2 || blocoAtual == primeiroBloco)) {
				blocoAtual->tamanho = blocoAtual->tamanho*2;
				blocoAtual->proximoBloco = proximoBloco->proximoBloco;
				free(proximoBloco);			
				juntou = VERDADEIRO;
				blocoAtual = primeiroBloco;
				tamanhoTotalDosBlcosAEsquerda = 0;
			} 
		} 
		tamanhoTotalDosBlcosAEsquerda += blocoAtual->tamanho;
		if (!juntou) {
			blocoAtual = blocoAtual->proximoBloco;
		}
		juntou = FALSO;
	}
}

void alocarMemoriaInicial() {
	primeiroBloco = inicializarBloco(UM_MEGA, malloc(UM_MEGA));
}

void* alocar(int tamanhoDoBloco) {
	Bloco *blocoDeMenorTamanhoPossivel; 
	blocoDeMenorTamanhoPossivel = encontrarBlocoDeMenorTamanhoPossivel(tamanhoDoBloco);
	if (blocoDeMenorTamanhoPossivel == NULL) {
		return NULL;
	} else {
		return quebrarBlocoAoMaximoEAlocar(blocoDeMenorTamanhoPossivel, tamanhoDoBloco);
	}
}

void* quebrarBlocoAoMaximoEAlocar(Bloco *blocoDeMenorTamanhoPossivel, int tamanhoDoBloco) {
	while (blocoDeMenorTamanhoPossivel->tamanho/2 >= tamanhoDoBloco) {
		int tamanhoDoBlocoDeMenorTamanhoPossivel = blocoDeMenorTamanhoPossivel->tamanho/2;
		blocoDeMenorTamanhoPossivel->tamanho = tamanhoDoBlocoDeMenorTamanhoPossivel;
		Bloco *novoProximoBloco;
		novoProximoBloco = blocoDeMenorTamanhoPossivel->proximoBloco;
		void *posicaoNaMemoriaDoNovoBloco;
		posicaoNaMemoriaDoNovoBloco = blocoDeMenorTamanhoPossivel->posicaoNaMemoria;
		posicaoNaMemoriaDoNovoBloco += tamanhoDoBlocoDeMenorTamanhoPossivel;
		blocoDeMenorTamanhoPossivel->proximoBloco = inicializarBloco(tamanhoDoBlocoDeMenorTamanhoPossivel, posicaoNaMemoriaDoNovoBloco);
		(blocoDeMenorTamanhoPossivel->proximoBloco)->proximoBloco = novoProximoBloco;
	}
	blocoDeMenorTamanhoPossivel->estadoDoBloco = ALOCADO;
	espacoAlocado += blocoDeMenorTamanhoPossivel->tamanho;

	return blocoDeMenorTamanhoPossivel->posicaoNaMemoria;
}

Bloco* encontrarBlocoDeMenorTamanhoPossivel(int tamanhoDoBloco) {
	Bloco *blocoAtual;
	blocoAtual = primeiroBloco;
	Bloco *blocoDeMenorTamanhoPossivel; 
	blocoDeMenorTamanhoPossivel = NULL;
	int tamanhoDoBlocoDeMenorTamanhoPossivel = UM_MEGA;
	while (blocoAtual != NULL) {
		int tamanhoDoBlocoAtual = blocoAtual->tamanho;
		if (blocoAtual->estadoDoBloco == LIVRE && 
			tamanhoDoBlocoAtual >= tamanhoDoBloco &&
			tamanhoDoBlocoAtual <= tamanhoDoBlocoDeMenorTamanhoPossivel) {
				blocoDeMenorTamanhoPossivel = blocoAtual;
				tamanhoDoBlocoDeMenorTamanhoPossivel = blocoDeMenorTamanhoPossivel->tamanho;
		}
		blocoAtual = blocoAtual->proximoBloco;
	}
	
	return blocoDeMenorTamanhoPossivel;
}

Bloco* inicializarBloco(int tamanhoDoBloco, void *posicaoNaMemoria) {
	Bloco *bloco = malloc(sizeof(Bloco));
	bloco->tamanho = tamanhoDoBloco;
	bloco->posicaoNaMemoria = posicaoNaMemoria;
	bloco->estadoDoBloco = LIVRE;
	bloco->proximoBloco = NULL;
	
	return bloco;
}
