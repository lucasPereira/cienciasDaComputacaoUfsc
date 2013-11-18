#include <signal.h>
#include <stdio.h>
#include <unistd.h>
void timeout_function()
{
    printf("Tempo esgotado (timeout)!\n");
    exit(1);
}
int main(int argc, char* argv[]){
	char a[100];
	int tempo;
	
	if(argv[1]==NULL)
		timeout_function();
		
	tempo = atoi(argv[1]);
	
	if(tempo == 0)
		timeout_function();
	
	signal(SIGALRM, timeout_function);
	
	while(1)  {
		alarm(tempo);
		printf("Digite uma entrada: \n");
		scanf("%s", &a);
		alarm(0);
	}
	
	return 0;
}
