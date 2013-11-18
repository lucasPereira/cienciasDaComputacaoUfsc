/*
*      Alunos: Chrystian de Sousa Guth & Lucas Pereira da Silva
*	Disciplina: INE5412 - Sistemas Operacionais I
*	 Semestre: 2011-2
*	  Lab 6.2
*/

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <dirent.h>
#include <string.h>

int main(int argc, char *argv[]) {

	// se não tem argumentos suficientes
	if(argc != 2) {
		printf("Usage: programa <diretorio>\n");
		exit(0);
	}

	DIR* dir;
	struct dirent* entry;
	struct stat buf;
	dir = opendir(argv[1]);
	if(!dir) {
		printf("Erro ao abrir diretório\n");
		exit(0);
	}

	char nome[256+strlen(argv[1])];
	char maisantigo[256];
	time_t dataantigo = 0;
	char maisnovo[256];
	time_t datanovo = 0;
	int qtdLinks = 0;
	int qtdArq = 0;
	unsigned long long tamanhototal = 0;
	int qtdTotal = 0;

	while((entry = readdir(dir)) != NULL) {
		sprintf(nome, "%s/%s", argv[1], entry->d_name);
		stat(nome, &buf);
		if(!S_ISDIR(buf.st_mode)) {
			if(dataantigo) {
				if(dataantigo > buf.st_mtim.tv_sec) {
					dataantigo = buf.st_mtim.tv_sec;
					strcpy(maisantigo, entry->d_name);
				}
			
				if(datanovo < buf.st_mtim.tv_sec) {
					datanovo = buf.st_mtim.tv_sec;
					strcpy(maisnovo, entry->d_name);
				}
			} else {
				dataantigo = buf.st_mtim.tv_sec;
				datanovo = buf.st_mtim.tv_sec;
				strcpy(maisnovo, entry->d_name);
				strcpy(maisantigo, entry->d_name);
			}
		}
		if(S_ISREG(buf.st_mode))
			qtdArq++;
		if(S_ISLNK(buf.st_mode))
			qtdLinks++;
		qtdTotal++;
		tamanhototal += buf.st_size;
	}
	system("clear");
	printf("## INE5412 - SOI ## ( Chrystian Guth & Lucas Pereira ) ##\n");
	printf("## Número de links: %d ##\n", qtdLinks);
	printf("## Tamanho médio: %d bytes ##\n", tamanhototal/qtdTotal);
	printf("## Tamanho total: %d bytes ##\n", tamanhototal);
	printf("## Mais novo: %s ##\n", maisnovo);
	printf("## Mais antigo: %s ##\n", maisantigo);
	printf("## Número de arquivos: %d ##\n", qtdArq);

} 
