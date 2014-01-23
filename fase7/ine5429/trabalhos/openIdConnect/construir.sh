#!/bin/bash

projeto=OpenIdConnect
pacoteDoProjeto=openIdConnect
pacoteGeral=br.ufsc.inf.ine5429

bibliotecas=bibliotecas
binarios=binarios
construcao=construcao
documentacao=documentacao
fontes=fontes
recursos=recursos
testes=testes

bibliotecasJava=${bibliotecas}/jar
binariosJava=${binarios}/class
binariosHtml=${binarios}/html
fontesJava=${fontes}/java
fontesHtml=${fontes}/html

arquivosFontesJava=$(find ${fontesJava} -name *.java)

limpar() {
	echo ":limpar";
	rm -rf ${binarios};
	rm -rf ${construcao};
}

criarEstrutura() {
	echo ":criarEstrutura";
	mkdir -p ${bibliotecasJava};
	mkdir -p ${binariosJava};
	mkdir -p ${binariosHtml};
	mkdir -p ${construcao};
	mkdir -p ${fontesJava};
	mkdir -p ${fontesHtml};
}

adicionarBibliotecas() {
	echo ":adicionarBibliotecas";
}

compilar() {
	limpar;
	criarEstrutura;
	adicionarBibliotecas;
	echo ":compilar";
	cp -rf ${fontesHtml}/* ${binariosHtml};
	javac -classpath ${binariosJava}:${bibliotecasJava}/* -sourcepath ${fontesJava} -d ${binariosJava} -Werror -deprecation -g ${arquivosFontesJava} -Xlint -Xmaxerrs 10 -Xmaxwarns 10;
}

construir() {
	compilar;
	echo ":construir";
}

testar() {
	construir;
	echo ":testar";
}

depurar() {
	construir;
	echo ":depurar";
	jdb -classpath ${binariosJava}:${bibliotecasJava}/* ${pacoteGeral}.${pacoteDoProjeto}.${projeto};
}

executar() {
	construir;
	echo ":executar";
	java -ea -classpath ${binariosJava}:${bibliotecasJava}/* ${pacoteGeral}.${pacoteDoProjeto}.${projeto};
}

echo :${pacoteDoProjeto}
if [ -n "$1" ]
then
	$1;
else
	construir;
fi
