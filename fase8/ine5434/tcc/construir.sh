#!/bin/bash

projeto=Webis
pacoteDoProjeto=webis

estilos=estilos
finais=finais
propostas=propostas
artigos=artigos
tccs=tccs
dissertacoes=dissertacoes
teses=teses
padroes=padroes


limpar() {
	echo ":limpar";
}

criarEstrutura() {
	echo ":criarEstrutura";
	# mkdir -p ${estilos};
	# mkdir -p ${finais};
	# mkdir -p ${propostas};
	# mkdir -p ${artigos};
	# mkdir -p ${tccs};
	# mkdir -p ${dissertacoes};
	# mkdir -p ${teses};
	# mkdir -p ${padroes};
}

adicionarBibliotecas() {
	echo ":adicionarBibliotecas";
	cp -rf ../estilos/construcao/limpo.css ${estilos};
	cp -rf ../estilos/construcao/documento.css ${estilos};
}

compilar() {
	limpar;
	criarEstrutura;
	adicionarBibliotecas;
	echo ":compilar";
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
}

executar() {
	construir;
	echo ":executar";
	chromium-browser relatorio.html;
}

echo :${pacoteDoProjeto}
if [ -n "$1" ]
then
	$1;
else
	construir;
fi
