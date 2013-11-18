#include <stdlib.h>
#include <stdio.h>
#include <math.h>

#define TAM_ARRAY 3
#define TAM_ARRAY_PRODUTO_VETORIAL 3

double norma(int vetor[], int tamanho_vetor){
	int soma = 0;
	int i;
	for(i = 0; i < tamanho_vetor; i++)
		soma += (vetor[i] * vetor[i]);

	return sqrt((double) soma);
}

void multiplicacaoPorEscalar(int escalar, int* vetor, int tamanho) {
	int i;
	for (i = 0; i < tamanho; i++) {
		vetor[i] *= escalar;
	}
}

int* soma(int* v1, int* v2, int tamanho) {
	int i;
	int* resultado = (int*) malloc(sizeof(int) * tamanho);
	for (i = 0; i < tamanho; i++) {
		resultado[i] = v1[i] + v2[i];
	}
	return resultado;
}

void produtoVetorial(int* c, int*a, int*b, int tamanho) {
	c[0] = a[1] * b[2] - b[1] * a[2];
	c[1] = -a[1] * b[2] + b[0] * a[2];
	c[2] = a[0] * b[1] - b[0] * a[1];
}

int produto_escalar(int vetor1[], int vetor2[], int tamanho_vetores) {
	int somatorio_produto = 0;
	int i;
	for (i = 0; i < tamanho_vetores; i++)
		somatorio_produto += (vetor1[i] * vetor2[i]);

	return somatorio_produto;
}

double angulo(int v1[], int v2[], int tamanho_vetores){
	double aux1;
	double aux2;
	double result;
	aux1 = produto_escalar(v1,v2,tamanho_vetores);
	aux2 = norma(v1, tamanho_vetores)*norma(v2, tamanho_vetores);
	result = aux1/aux2;
	return acos(result);
}

void testarMultiplicacaoPorEscalar() {
	int* vetor = (int*) malloc(sizeof(int) * TAM_ARRAY);
	int i;
	int escalar = 2;
	for (i = 0; i < TAM_ARRAY; i++) {
		vetor[i] = 1;
		printf("%d ", vetor[i]);
		fflush(stdout);
	}
	printf("\n");
	multiplicacaoPorEscalar(escalar, vetor, TAM_ARRAY);

	for (i = 0; i < TAM_ARRAY; i++) {
		printf("%d ", vetor[i]);
		fflush(stdout);
	}
}

void testarProdutoVetorial() {
	int* c = (int*) malloc(sizeof(int) * TAM_ARRAY_PRODUTO_VETORIAL);
	int* b = (int*) malloc(sizeof(int) * TAM_ARRAY_PRODUTO_VETORIAL);
	int* a = (int*) malloc(sizeof(int) * TAM_ARRAY_PRODUTO_VETORIAL);
	int i;
	a[0] = 1;
	a[1] = 2;
	a[2] = 3;
	b[0] = 4;
	b[1] = 5;
	b[2] = 6;
	produtoVetorial(c, a, b, TAM_ARRAY_PRODUTO_VETORIAL);
	printf("%d %d %d", c[0], c[1], c[2]);
}

void testaSoma() {
	int* v1 = (int*) malloc(sizeof(int) * 2);
	int* v2 = (int*) malloc(sizeof(int) * 2);
	v1[0] = 1;
	v1[1] = 1;
	v2[0] = 1;
	v2[1] = 1;
	int* r = (int*) malloc(sizeof(int) * 2);
	r = soma(v1, v2, 2);
	printf("%d %d", r[0], r[1]);
}

void testeNomaEProdutoEscalar(){
	int vetor1[] = {1,2,3,4};
	int vetor2[] = {1,2,3,4};
	printf("%f\n", norma(vetor1, 4));
	printf("%d\n", produto_escalar(vetor1, vetor2, 4));
}

int main() {
	return EXIT_SUCCESS;
}
