#!/bin/bash

projeto=Canais
pacoteDoProjeto=canais

css=css
html=html
js=js

limpar() {
	echo ":limpar"
}

criarEstrutura() {
	echo ":criarEstrutura"
	mkdir -p $css
	mkdir -p $html
	mkdir -p $js
}

adicionarBibliotecas() {
	echo ":adicionarBibliotecas"
	cp -rf ../../estilos/construcao/limpo.css $css
	cp -rf ../../lindaJs/construcao/linda.js $js
	cp -rf ../../nodoWeb/construcao/nodoWeb.js $js
}

compilar() {
	limpar
	criarEstrutura
	adicionarBibliotecas
	echo ":compilar"
}

construir() {
	compilar
	echo ":construir"
}

testar() {
	construir
	echo ":testar"
}

depurar() {
	construir
	echo ":depurar"
}

executar() {
	construir
	echo ":executar"
	node $js/nodoWeb.js &
	node $js/operadoraDummy.js &
	node $js/operadoraDummySecundaria.js &
	node $js/bancoDeDadosDummy.js
}

integrar() {
	construir
	echo ":integrar"
}

echo :$pacoteDoProjeto
if [ -n "$1" ]
then
	$1
else
	construir
fi
