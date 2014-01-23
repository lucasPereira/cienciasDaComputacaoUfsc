#!/bin/bash

projeto=MillerRabin
pacoteDoProjeto=millerRabin
pacoteGeral=br.ufsc.inf.ine5429

bibliotecas=bibliotecas
binarios=binarios
construcao=construcao
documentacao=documentacao
fontes=fontes
recursos=recursos
testes=testes

binariosJava=${binarios}/class
fontesJava=${fontes}/java

arquivosFontesJava=$(find ${fontesJava} -name *.java)

limpar() {
	echo ":limpar";
	rm -rf ${binarios};
	rm -rf ${construcao};
}

criarEstrutura() {
	echo ":criarEstrutura";
	mkdir -p ${binariosJava};
	mkdir -p ${construcao};
	mkdir -p ${fontesJava};
}

adicionarBibliotecas() {
	echo ":adicionarBibliotecas";
}

compilar() {
	limpar;
	criarEstrutura;
	adicionarBibliotecas;
	echo ":compilar";
	javac -classpath ${binariosJava} -sourcepath ${fontesJava} -d ${binariosJava} -Werror -deprecation -g ${arquivosFontesJava} -Xlint -Xmaxerrs 10 -Xmaxwarns 10;
}

construir() {
	compilar;
	echo ":construir";
	cp -rf ${recursos}/documentos/${pacoteDoProjeto}.pdf ${construcao};
	jar -cfe ${construcao}/${pacoteDoProjeto}.jar ${pacoteGeral}.${pacoteDoProjeto}.${projeto} -C ${binariosJava} .;
	jar -cf ${construcao}/fontes.jar -C ${fontesJava} .;
	zip -j ${construcao}/${pacoteDoProjeto}.zip ${construcao}/${pacoteDoProjeto}.pdf ${construcao}/${pacoteDoProjeto}.jar ${construcao}/fontes.jar;
}

testar() {
	construir;
	echo ":testar";
}

depurar() {
	construir;
	echo ":depurar";
	jdb -classpath ${binariosJava} ${pacoteGeral}.${pacoteDoProjeto}.${projeto};
}

executar() {
	construir;
	echo ":executar";
	java -classpath ${binariosJava} ${pacoteGeral}.${pacoteDoProjeto}.${projeto};
}

echo :${pacoteDoProjeto}
if [ -n "$1" ]
then
	$1;
else
	construir;
fi
