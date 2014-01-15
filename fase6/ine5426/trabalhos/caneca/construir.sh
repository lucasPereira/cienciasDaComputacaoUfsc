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
relatorioAnaliseArvore=${relatorios}/analiseArvore.txt
relatorioAnaliseSemantica=${relatorios}/analiseSemantica.txt
relatorioErroExecucao=${relatorios}/erroExecucao.txt
relatorioSaidaExecucao=${relatorios}/saidaExecucao.txt

recursos=recursos
recursoEspecificacaoDoGEdit=${recursos}/outros/especificacaoDoGEdit.xml

nomeDoAnalisadorLexico=CanecaLexico
gLexico=${fontesGramaticas}/${nomeDoAnalisadorLexico}.g
javaLexico=${fontesJavaAntlr}/${nomeDoAnalisadorLexico}.java
tokensLexico=${fontesJavaAntlr}/${nomeDoAnalisadorLexico}.tokens

nomeDoAnalisadorSintatico=CanecaSintatico
gSintatico=${fontesGramaticas}/${nomeDoAnalisadorSintatico}.g
javaSintatico=${fontesJavaAntlr}/${nomeDoAnalisadorSintatico}.java
tokensSintatico=${fontesJavaAntlr}/${nomeDoAnalisadorSintatico}.tokens

nomeDoAnalisadorArvore=CanecaArvore
gArvore=${fontesGramaticas}/${nomeDoAnalisadorArvore}.g
javaArvore=${fontesJavaAntlr}/${nomeDoAnalisadorArvore}.java
tokensArvore=${fontesJavaAntlr}/${nomeDoAnalisadorArvore}.tokens

nomeDoAnalisadorSemantico=CanecaSemantico
gSemantico=${fontesGramaticas}/${nomeDoAnalisadorSemantico}.g
javaSemantico=${fontesJavaAntlr}/${nomeDoAnalisadorSemantico}.java
tokensSemantico=${fontesJavaAntlr}/${nomeDoAnalisadorSemantico}.tokens

gerados=gerados
geradosHtml=${gerados}/html
geradosCasm=${gerados}/casm

limpar() {
	echo ":limpar";
	rm -rf ${binarios};
	rm -rf ${construcao};
	rm -rf ${javaLexico};
	rm -rf ${tokensLexico};
	rm -rf ${javaSintatico};
	rm -rf ${fontesJavaAntlr}/*;
	rm -rf ${gerados};
}

criarDiretorios() {
	echo ":criarDiretorios";
	mkdir -p ${fontes};
	mkdir -p ${fontesCaneca};
	mkdir -p ${fontesGramaticas};
	mkdir -p ${fontesJava};
	mkdir -p ${fontesJavaAntlr};
	mkdir -p ${binarios};
	mkdir -p ${binariosJava};
	mkdir -p ${bibliotecas};
	mkdir -p ${bibliotecasJava};
	mkdir -p ${bibliotecasCss};
	mkdir -p ${bibliotecaCssEstilos};
	mkdir -p ${construcao};
	mkdir -p ${relatorios};
	mkdir -p ${recursos};
	mkdir -p ${gerados};
	mkdir -p ${geradosHtml};
	mkdir -p ${geradosCasm};
}

gerarAnalisadores() {
	echo ":gerarAnalisadores";
	java -classpath ${bibliotecaJavaAntlr} org.antlr.Tool ${gLexico} -fo ${fontesJavaAntlr} -report -print >> ${relatorioAnaliseLexica};
	java -classpath ${bibliotecaJavaAntlr} org.antlr.Tool ${gSintatico} -fo ${fontesJavaAntlr} -report -print > ${relatorioAnaliseSintatica};
	java -classpath ${bibliotecaJavaAntlr} org.antlr.Tool ${gArvore} -fo ${fontesJavaAntlr} -report -print > ${relatorioAnaliseArvore};
	java -classpath ${bibliotecaJavaAntlr} org.antlr.Tool ${gSemantico} -fo ${fontesJavaAntlr} -report -print > ${relatorioAnaliseSemantica};
}

compilarFontesJava() {
	echo ":compilarFontesJava";
	javac -g -deprecation -Werror -classpath ${bibliotecaJavaAntlr}:${binariosJava} -sourcepath ${fontesJava} -d ${binariosJava} `find ${fontesJava} -name *.java`;
}

adicionarCanecaAoGEdit() {
	echo ":adicionarCanecaAoGEdit";
	mkdir -p ~/.local/share/gtksourceview-3.0/language-specs;
	rm -f ~/.local/share/gtksourceview-3.0/language-specs/caneca.lang;
	cp ${recursoEspecificacaoDoGEdit} ~/.local/share/gtksourceview-3.0/language-specs/caneca.lang;
}

construir() {
	limpar;
	criarDiretorios;
	gerarAnalisadores;
	compilarFontesJava;
	adicionarCanecaAoGEdit;
}

if [ -n "$1" ]
then
	$1
else
	construir
fi

