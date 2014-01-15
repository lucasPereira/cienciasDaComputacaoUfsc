#!/bin/bash

fontes=fontes
fontesCaneca=${fontes}/caneca
fontesGramaticas=${fontes}/g
fontesJava=${fontes}/java
fontesJavaAntlr=${fontesJava}/br/ufsc/inf/ine5426/caneca/antlr

binarios=binarios
binariosJava=${binarios}/class

bibliotecas=bibliotecas
bibliotecasJava=${bibliotecas}/jar
bibliotecasCss=${bibliotecas}/css
bibliotecaCssEstilos=${bibliotecasCss}/estilos
bibliotecaJavaAntlr=${bibliotecasJava}/antlr.jar

construcao=construcao
relatorios=${construcao}/relatorios
relatorioAnaliseLexica=${relatorios}/analiseLexica.txt
relatorioAnaliseSintatica=${relatorios}/analiseSintatica.txt
relatorioErroExecucao=${relatorios}/erroExecucao.txt
relatorioSaidaExecucao=${relatorios}/saidaExecucao.txt

recursos=recursos
recursoEspecificacaoDoGEdit=${recursos}/outros/especificacaoDoGEdit.xml

nomeDoAnalisadorLexico=CanecaLexico
nomeDoAnalisadorSintatico=CanecaSintatico
gLexico=${fontesGramaticas}/${nomeDoAnalisadorLexico}.g
javaLexico=${fontesJavaAntlr}/${nomeDoAnalisadorLexico}.java
tokensLexico=${fontesJavaAntlr}/${nomeDoAnalisadorLexico}.tokens
gSintatico=${fontesGramaticas}/${nomeDoAnalisadorSintatico}.g
javaSintatico=${fontesJavaAntlr}/${nomeDoAnalisadorSintatico}.java

classePrincipal=br.ufsc.inf.ine5426.caneca.Compilador

construir() {
	./construir.sh;
}

executar() {
	echo ":executar";
	echo "";
	java -classpath ${binariosJava}:${bibliotecaJavaAntlr} ${classePrincipal} $1 $2 $3;
	echo "";
}

executar $1 $2 $3;
