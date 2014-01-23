#!/bin/bash

projeto=Rsa
pacoteDoProjeto=rsa
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
fontesJava=${fontes}/java

bibliotecaMillerRabin=${bibliotecasJava}/millerRabin.jar
todasBibliotecasJava=${bibliotecaMillerRabin}

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
	mkdir -p ${construcao};
	mkdir -p ${fontesJava};
}

adicionarBibliotecas() {
	echo ":adicionarBibliotecas";
	cp -f ../millerRabin/construcao/millerRabin.jar ${bibliotecasJava};
	cp -rf ../millerRabin/binarios/class/* ${binariosJava};
}

compilar() {
	limpar;
	criarEstrutura;
	adicionarBibliotecas;
	echo ":compilar";
	javac -classpath ${binariosJava}:${todasBibliotecasJava} -sourcepath ${fontesJava} -d ${binariosJava} -Werror -deprecation -g ${arquivosFontesJava} -Xlint -Xmaxerrs 10 -Xmaxwarns 10;
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
	jdb -classpath ${binariosJava}:${todasBibliotecasJava} ${pacoteGeral}.${pacoteDoProjeto}.${projeto};
}

executar() {
	construir;
	echo ":executar";
	java -ea -classpath ${binariosJava}:${todasBibliotecasJava} ${pacoteGeral}.${pacoteDoProjeto}.${projeto};
}

echo :${pacoteDoProjeto}
if [ -n "$1" ]
then
	$1;
else
	construir;
fi
