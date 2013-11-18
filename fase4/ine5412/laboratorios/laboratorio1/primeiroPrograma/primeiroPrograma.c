#include <getopt.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void executarArgumentos(int quantidadeDeArgumentos, char *argumentos[]);
void mostrarAjuda();
void mostrarArgumentos(int quantidadeDeArgumentos, char *argumentos[]);
void mostrarVariaveisDeAmbiente();
char* mostrarVariavelDoAmbiente(char *variavelDesejada);

int main(int quantidadeDeArgumentos, char *argumentos[])
{
	if (quantidadeDeArgumentos <= 1) 
	{
		printf("Nenhum argumento foi fornecido.\n");
	}
	else
	{
		executarArgumentos(quantidadeDeArgumentos, argumentos);
	}
	
	return 0;
}

void executarArgumentos(int quantidadeDeArgumentos, char *argumentos[])
{
	printf("-----\n");
	int verboso = 0;
	char mensagemVerboso[1000] = "\nModo verboso ligado.";
	const struct option opcoesLongas[] = 
	{
		{ "verbose", 0, NULL, 'v' },
		{ "help", 0, NULL, 'h' },
		{ "args", 0, NULL, 'a' },
		{ "envi", 0, NULL, 'e' },
		{ "var", 1, NULL, 't' },
		{ NULL, 0, NULL, 0 },
	};
	const char *opcoesCurtas = "vhaet:";
	char opcao;
	do
	{
		opcao = getopt_long(quantidadeDeArgumentos, argumentos, opcoesCurtas, opcoesLongas, NULL);
		switch (opcao) 
		{
			case 'v':
				verboso = 1;
				break;
			case 'h':
				strcat(mensagemVerboso, "\nOpcão selcionada: h.");
				mostrarAjuda();
				break;
			case 'a': 
				strcat(mensagemVerboso, "\nOpcão selcionada: a.");
				mostrarArgumentos(quantidadeDeArgumentos, argumentos);
				break;
			case 'e':
				strcat(mensagemVerboso, "\nOpcão selcionada: e.");
				mostrarVariaveisDeAmbiente();
				break;
			case 't':
				strcat(mensagemVerboso, "\nOpcão selcionada: t. Parâmetro fornecido: ");
				strcat(mensagemVerboso, optarg);
				strcat(mensagemVerboso, ".\n");
				char *variavelDoAmbiente = mostrarVariavelDoAmbiente(optarg);
				strcat(mensagemVerboso, optarg);
				strcat(mensagemVerboso, " = ");
				strcat(mensagemVerboso, variavelDoAmbiente);
				strcat(mensagemVerboso, ".");
				break;
			case '?':
				abort();
		}
	}
	while (opcao != -1);
	if (verboso)
	{
		printf("\n%s", mensagemVerboso);
	}
	printf("\n\n-----\n");
}

void mostrarAjuda() 
{
	printf("\nAs opções são: ");
	printf("\n[-h] ou [--help] para exibir a ajuda.");
	printf("\n[-v] ou [--verbose] para exibir o modo verboso.");
	printf("\n[-a] ou [--args] para exibir os argumentos fornecidos.");
	printf("\n[-e] ou [--envi] para exibir as variáveis de ambiente.");
	printf("\n[-t <PARÂMETRO>] ou [--var <PARÂMETRO>] para exibir o valor da variável do ambiente descrita em <PARÂMETRO>.");
	printf("\n");
}

void mostrarArgumentos(int quantidadeDeArgumentos, char *argumentos[])
{
	printf("\nQuantidade de argumentos fornecidos: %i", quantidadeDeArgumentos);
	int cont;
 	for (cont = 0; cont < quantidadeDeArgumentos; cont++)
 	{
 		printf("\nargumento[%i] = '%s'", cont, argumentos[cont]);
 	}
 	printf("\n");
}

extern char **environ;
void mostrarVariaveisDeAmbiente()
{
	printf("\nTodas variáveis de ambiente: ");
	for ( ; *environ; ++environ) 
	{
		printf("\n%s", *environ);
	}
 	printf("\n");
}

char* mostrarVariavelDoAmbiente(char *variavelDesejada)
{
	char *variavelDoAmbiente = getenv(variavelDesejada);
	if (variavelDoAmbiente == NULL) 
	{ 
		variavelDoAmbiente = "Não encontrada";
	}
	printf("\nVariável de ambiente %s = %s.", variavelDesejada, variavelDoAmbiente);
	
	return variavelDoAmbiente;
}
