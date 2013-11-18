/*
*      Alunos: Chrystian de Sousa Guth & Lucas Pereira da Silva
*	Disciplina: INE5412 - Sistemas Operacionais I
*	 Semestre: 2011-2
*	  Lab 6.1
*/

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <errno.h>

#define PERM_ALL (S_IRWXU | S_IRWXG | S_IRWXO)
#define RDBLOCKSZ (4*1024)

void invertbuf(char* buf, int n) {
	int i=0, j=n-1;
	char tmp;
	while( i < j ) {
		tmp = buf[i];
		buf[i] = buf[j];
		buf[j] = tmp;
		i++;
		j--;
	}
}

int main (int argc, char *argv[]) {

	// se não tem argumentos suficientes
	if(argc < 3) {
		printf("Uso: programa <arquivo fonte> <arquivo destino>\n");
		exit(0);
	}
	int infd, outfd, inputsize;
	char buffer[RDBLOCKSZ];
	
	infd = open(argv[1], O_RDONLY);
	outfd = creat(argv[2], PERM_ALL);
	
	// Confere se n é múltiplo de 4k
	inputsize = lseek(infd, 0, SEEK_END);
	int n = inputsize/RDBLOCKSZ;
	int i, rd, total=0;

	for(i = 1; i <= n; i++) {
		lseek(infd, inputsize-(i*RDBLOCKSZ), SEEK_SET);
		rd = read(infd, buffer, RDBLOCKSZ);
		if(rd != RDBLOCKSZ) {
			printf("Erro ao ler os dados!\n");
			exit(-1);
		}
		invertbuf(buffer, RDBLOCKSZ);
		write(outfd, buffer, RDBLOCKSZ);
		total += rd;
	}

	lseek(infd, 0, SEEK_SET);
	rd = read(infd, buffer, inputsize-total);
	invertbuf(buffer, inputsize-total);
	write(outfd, buffer, inputsize-total);
	close(infd);
	close(outfd);
	exit(0);	
}
