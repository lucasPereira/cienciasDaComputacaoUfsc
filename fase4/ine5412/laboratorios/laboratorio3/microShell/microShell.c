#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>

char input[1024];
char pasta[4096];
char *argv[10];

int main(void) {

	int i, j;
	char * pch;
	while(1)  {
		for(i = 0; i < 10; i++) // zera o vetor de argumentos
			argv[i] = NULL;
			
		printf("mshell> ");
		fgets(input, 1024, stdin);
		input[strlen(input)-1] = '\0';
		
		if(!strcmp(input, "exit")) // vê se é exit
			exit(0);
			
		j = 0;
		pch = strtok(input, " ");
		
		while(pch != NULL && j < 10) { // pega até 10 parâmetros
			argv[j] = pch;
			pch = strtok(NULL, " ");
			j++;
		}
		
		if(!strcmp(argv[0], "cd")){ // checa se é cd
		
			if(chdir(argv[1])!=0)
				printf("caminho inválido\n");
		
		
		}else{
			if(fork() == 0){
			
				if(!strcmp(argv[0], "ls")) // deixa o ls colorido sempre
					argv[1] = "--color=auto";
					
				if(execvp(argv[0], argv) == -1){ // executa o comando
					printf("comando inválido\n");
					exit(1);
				}
			}else
			wait(NULL);
		}
	}
}
