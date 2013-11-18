#include <stdlib.h>
#include <stdio.h>
#include <math.h>

void matriz_transposta(int l, int c, int matriz[l][c]) {
	int i, j, aux;

	for (i = 0; i < l; i++)
		for (j = i + 1; j < c; j++)
			if (j != i) {
				aux = matriz[i][j];
				matriz[i][j] = matriz[j][i];
				matriz[j][i] = aux;
			}
}

void multiPorEscalar(int l, int c, int matriz[l][c], int escalar) {
	int i, j, aux;

	for (i = 0; i < l; i++)
		for (j = 0; j < c; j++){
				aux = matriz[i][j];
				aux = escalar*aux;
				matriz[i][j] = aux;
		}
}

int** adicao(int l, int c, int m1[l][c], int m2[l][c]) {

	int i, j;
	int** soma = (int **)malloc(l*c*sizeof(int *));

	for (i = 0; i < l; i++)
		for (j = 0; j < c; j++){
				soma[i][j] = m1[i][j] + m2[i][j];
		}
	return soma;
}

int** multiplicacao(int l, int c, int m1[l][c], int m2[l][c]) {

	int i, j, k;
	int** m = (int **)malloc(l*c*sizeof(int *));
	for(i = 0; i <l; i++)
		for(j = 0; j <c ; j++){
			m[i][j] = 0;
			for(k = 0; k < c ; k++){
				m[i][j] += m1[i][k]*m2[k][j];
			}
		}

	return m;
}

int det(int m[3][3]) {
	int p1 = m[0][0]*m[1][1]*m[2][2] + m[0][1]*m[1][2]*m[0][2] + m[0][2]*m[1][0]*m[2][1];
	int p2 = m[0][2]*m[1][1]*m[2][0] + m[0][0]*m[1][0]*m[2][1] + m[0][1]*m[1][0]*m[2][2];
	return  p1 - p2 ;
}


int main() {

	return EXIT_SUCCESS;
}
