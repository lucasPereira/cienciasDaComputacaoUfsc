'use strict';

var Gramaticas = {};

var ControleDoModelo = {
	/**
	* Função: criarGramatica
	* Parâmetros:
	* - nome: nome da gramática que será criada.
	* Descrição: cria a gramática caso não exista nenhuma outra com o mesmo nome.
	**/
	criarGramatica: function(nome) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(nome, String));
		var gramaticaFoiCriada = false;
		if (Utilitarios.nuloOuIndefinido(Gramaticas[nome])) {
			Gramaticas[nome] = new Gramatica(nome);
			gramaticaFoiCriada = true;
		}
		return gramaticaFoiCriada;
	},
	
	/**
	* Função: excluirGramatica
	* Parâmetros:
	* - nome: nome da gramática que será excluida.
	* Descrição: exclui a gramática caso exista.
	**/
	excluirGramatica: function(nome) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(nome, String));
		delete Gramaticas[nome];
	},
	
	/**
	* Função: salvarGramatica
	* Parâmetros:
	* - nome: nome da gramática que será salva.
	* - codigo: gramática no formato textual que será transformado em um objeto.
	* Descrição: tenta salvar a gramática e criar uma tabela de parsing para ela.
	* Caso a gramática textual seja inválida, então a gramática não é salva.
	**/
	salvarGramatica: function(nome, codigo) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(nome, String));
		Utilitarios.assegureQue(Utilitarios.instanciaDe(codigo, String));
		var gramaticaFoiSalva = false;
		var gramatica = Gramaticas[nome];
		if (!Utilitarios.nuloOuIndefinido(gramatica)) {
			 var gramaticaSalva = new AnalizadorDaGramatica(nome).construir(codigo);
			 if (!Utilitarios.nulo(gramaticaSalva)) {
				 delete Gramaticas[nome];
				 Gramaticas[nome] = gramaticaSalva;
				 gramaticaFoiSalva = true;
				 gramaticaSalva.analisar();
			 }
		}
		return gramaticaFoiSalva;
	},
	
	/**
	* Função: fornecerGramaticas
	* Descrição: fornecer a lista das gramáticcas existentes.
	**/
	fornecerGramaticas: function() {
		return Gramaticas;
	},
	
	/**
	* Função: fornecerGramatica
	* Parâmetros:
	* - nome: nome da gramática que se deseja obter.
	* Descrição: fornecer a gramática que possui o nome fornecido.
	**/
	fornecerGramatica: function(nome) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(nome, String));
		return Gramaticas[nome];
	},
	
	/**
	* Função: reconhecerSentenca
	* Parâmetros:
	* - nomeDaGramatica: nome da gramática que efetuará o reconhecimento.
	* - sentenca: sentença a ser reconhecida.
	* Descrição: verifica se uma sentença é reconhecida por determinada gramática.
	**/
	reconhecerSentenca: function(nomeDaGramatica, sentenca) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(nomeDaGramatica, String));
		Utilitarios.assegureQue(Utilitarios.instanciaDe(sentenca, String));
		var gramatica = Gramaticas[nomeDaGramatica];
		Utilitarios.assegureQue(!Utilitarios.nuloOuIndefinido(gramatica));
		return gramatica.reconhecer(sentenca);
	}
};

/**
* Classe: AnalizadorDaGramatica
* Descrição: Classe responsável pro fazer a análise de uma gramática em formato
* textual e converter para um objeto.
**/
var AnalizadorDaGramatica = new Prototipo({
	/**
	* Função: inicializar
	* Parâmetros:
	* - nome: nome da gramática onde será salvo o resultado da análise da gramática textual.
	* Descrição: inicializa um novo obtejo AnalizadorDeGramatica.
	**/
	inicializar: function(nome) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(nome, String));
		this.gramatica = new Gramatica(nome);
	},

	/**
	* Função: construir
	* Parâmetros:
	* - codigo: gramática em formato textual que será convertido para um objeto.
	* Descrição: tenta construir a gramática a partir da equivalente textual fornecida.
	* Caso a gramática textual seja inválida, então retorna null e caso contrário retorna a gramática construída.
	**/
	construir: function(codigo) {
		var producoes = codigo.replace(/^\s+/, "").replace(/\s+$/, "").replace(/\n/g, " -> ").split(" -> ");
		var simboloInicial = producoes[0];
		var expressaoRegularTerminais = /^([a-z]*|[0-9]|[^A-Z])$/;
		var expressaoRegularNaoTerminais = /^[A-Z]*$/;
		if ((producoes.length % 2) !== 0) {
			return null;
		}
		for (var indice = 0; indice < producoes.length; indice += 2) {
			var naoTerminal = producoes[indice];
			if (expressaoRegularNaoTerminais.test(naoTerminal)) {
				this.gramatica.adicionarNaoTerminal(naoTerminal);
			} else {
				return null;
			}
		}
		var gramaticaValida = true;
		for (var indice = 1; indice < producoes.length; indice += 2) {
			var producao = producoes[indice].split(" | ");
			producao.paraCada(function(simbolosJuntos, indiceDaProducao) {
				var simbolos = simbolosJuntos.split(" ");
				simbolos.paraCada(function(simbolo, indiceDoSimbolo) {
					if (expressaoRegularTerminais.test(simbolo)) {
						this.gramatica.adicionarTerminal(simbolo);
					} else if (Utilitarios.nuloOuIndefinido(this.gramatica.fornecerNaoTerminal(simbolo))) {
						gramaticaValida = false;
					}
				}, this);
				if (gramaticaValida) {
					this.gramatica.adicionarProducao(producoes[indice - 1], simbolos);
				}
			}, this);
			if (!gramaticaValida) {
				return null;
			}
		}
		this.gramatica.fixarSimboloInicial(simboloInicial);
		this.gramatica.fixarCodigo(codigo);
		return this.gramatica;
	}
});