#!/bin/bash

projeto=Ligue4
pacoteDoProjeto=ligue4

bibliotecas=bibliotecas
binarios=binarios
construcao=construcao
documentacao=documentacao
fontes=fontes
recursos=recursos
testes=testes

bibliotecasCss=${bibliotecas}/css
bibliotecasJs=${bibliotecas}/js
binariosCss=${binarios}/css
binariosHtml=${binarios}/html
binariosJs=${binarios}/js
fontesHtml=${fontes}/html
fontesJs=${fontes}/js
testesHtml=${testes}/html

limpar() {
	echo ":limpar";
	rm -rf ${binarios};
	rm -rf ${construcao};
}

criarEstrutura() {
	echo ":criarEstrutura";
	mkdir -p ${bibliotecasCss};
	mkdir -p ${bibliotecasJs};
	mkdir -p ${binariosCss};
	mkdir -p ${binariosHtml};
	mkdir -p ${binariosJs};
	mkdir -p ${construcao};
	mkdir -p ${fontesHtml};
	mkdir -p ${fontesJs};
	mkdir -p ${testesHtml};
}

adicionarBibliotecas() {
	echo ":adicionarBibliotecas";
	cp -rf ../estilos/construcao/limpo.css ${bibliotecasCss};
	cp -rf ../verificaJs/construcao/verifica.css ${bibliotecasCss};
	cp -rf ../verificaJs/construcao/verifica.js ${bibliotecasJs};
	cp -rf ../verificaJs/construcao/jsHint.js ${bibliotecasJs};
	cp -rf ../lindaJs/construcao/linda.js ${bibliotecasJs};
}

compilar() {
	limpar;
	criarEstrutura;
	adicionarBibliotecas;
	echo ":compilar";
	cp -rf ${bibliotecasCss}/* ${binariosCss};
	cp -rf ${fontesHtml}/* ${testesHtml}/* ${binariosHtml};
	cp -rf ${bibliotecasJs}/* ${fontesJs}/* ${binariosJs};
}

construir() {
	compilar;
	echo ":construir";
}

testar() {
	construir;
	echo ":testar";
	google-chrome `find ${binariosHtml} -name teste*.html` --allow-file-access-from-files;
}

depurar() {
	construir;
	echo ":depurar";
	google-chrome ${fontesHtml}/${pacoteDoProjeto}.html;
}

executar() {
	construir;
	echo ":executar";
	google-chrome ${binariosHtml}/${pacoteDoProjeto}.html;
}

echo :${pacoteDoProjeto}
if [ -n "$1" ]
then
	$1;
else
	construir;
fi
