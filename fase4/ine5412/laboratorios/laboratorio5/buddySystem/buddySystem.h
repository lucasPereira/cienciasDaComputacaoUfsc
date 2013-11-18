#ifndef _BUDDY_SYSTEM_H_
#define _BUDDY_SYSTEM_H_

/*Constantes*/
#ifndef UM_MEGA
#define UM_MEGA 1048576
#endif
#ifndef UM_K
#define UM_K 1024
#endif
#ifndef FALSO
#define FALSO 0
#endif
#ifndef VERDADEIRO 
#define VERDADEIRO 1
#endif
/*Constantes*/

/*Estruturas e Enuns*/
typedef enum { 
	LIVRE, 
	ALOCADO 
} EstadoDoBloco;

typedef struct Bloco {
	int tamanho;
	void *posicaoNaMemoria;
	EstadoDoBloco estadoDoBloco;
	struct Bloco *proximoBloco;
} Bloco;
/*Estruturas e Enuns*/

/*Procedimentos*/
void alocarMemoriaInicial();
void* alocar(int tamanhoDoBloco);
int liberar(int posicao);
int fornecerEspacoAlocado();
Bloco* fornecerPrimeiroBloco();
/*Procedimentos*/
#endif
