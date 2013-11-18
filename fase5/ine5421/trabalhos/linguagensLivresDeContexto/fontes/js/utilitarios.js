"use strict";

/**
* Biblioteca: Utilitarios
* Descricao: fornece funções utilitárias que facilitam o uso do JavaSciprt.  
**/
var Utilitarios = { 
	tipoFuncao: "function",
	tipoObjeto: "object",
	tipoString: "string",
	tipoBoolean: "boolean",
	
	instanciaDe: function(objeto, tipo) {
		var verificacaoDeTipoPrimitivo = false;
		if (tipo === String) {
			verificacaoDeTipoPrimitivo = Utilitarios.tipoDe(objeto, Utilitarios.tipoString);
		} else if (tipo === Boolean) {
			verificacaoDeTipoPrimitivo = Utilitarios.tipoDe(objeto, Utilitarios.tipoBoolean);
		}
		return ((objeto instanceof tipo) || verificacaoDeTipoPrimitivo);
	},
	
	tipoDe: function(tipo, tipoComparado) {
		return (typeof tipo === tipoComparado);
	},
	
	checarTiposDeArgumentos: function(argumentos, tiposDesejados, mensagem) {
		if (!Utilitarios.instanciaDe(argumentos, Array) || !Utilitarios.instanciaDe(tiposDesejados, Array) || !Utilitarios.instanciaDe(mensagem, String)) {
			throw new ExcecaoUtilitarios("Tipo de argumento inválido. Argumentos devem ser: [Lista] [Lista] [Texto].");
		}
		if (argumentos.length !== tiposDesejados.length) {
			throw new ExcecaoUtilitarios("Argumentos inválidos. Argumento[0] e Argumento[1] devem ser listas do mesmo tamanho.");
		}
		for (var indice = 0; indice < argumentos.length; indice++) {
			if (!Utilitarios.instanciaDe(argumentos[indice], tiposDesejados[indice])) {
				throw new ExcecaoUtilitarios(mensagem);
			}
		}
	},
	
	checarArgumentoDentroDeIntervalo: function(argumento, inicioDeIntervalo, fimDeIntervalo, mensagem) {
		Utilitarios.checarTiposDeArgumentos([argumento, inicioDeIntervalo, fimDeIntervalo, mensagem], [Number, Number, Number, String], new ExcecaoUtilitarios("Tipo de argumento inválido. Argumentos devem ser: [Número] [Número] [Número] [Texto]."));
		if (argumento < inicioDeIntervalo || argumento > fimDeIntervalo) {
			throw new ExcecaoUtilitarios(mensagem);
		}
	},
	
	checarArgumentoDentroDeValores: function(argumento, valoresPossiveis, mensagem) {
		Utilitarios.checarTiposDeArgumentos([argumento, valoresPossiveis, mensagem], [Object, Array, String], new ExcecaoUtilitarios("Tipo de argumento inválido. Argumentos devem ser: [Objeto] [Lista] [Texto]."));
		if (!valoresPossiveis.contem(argumento)) {
			throw new ExcecaoUtilitarios(mensagem);
		} 
	},
	
	assegureQue: function(condicao) {
		Utilitarios.checarTiposDeArgumentos([condicao], [Boolean], "Tipo de argumento inválido. Argumento deve ser: [Boolean].");
		if (!condicao) {
			throw new ExcecaoUtilitarios("Asserção inválida. Quebra de contrato.");
		}
	},
	
	assegureQueNao: function(condicao) {
		Utilitarios.assegureQue(!condicao);
	},
	
	nuloOuIndefinido: function(valor) {
		return (Utilitarios.nulo(valor) || Utilitarios.indefinido(valor));
	},
	
	nulo: function(valor) {
		return (valor === null);
	},
	
	indefinido: function(valor) {
		return (valor === undefined);
	}
};

var Prototipo = function Prototipo(corpoDoPrototipo) {
	var novoPrototipo = function Objeto() {
		if (!Utilitarios.indefinido(this.inicializar)) {
			this.inicializar.apply(this, arguments);
		}
	};
	novoPrototipo.implementar(corpoDoPrototipo);
	return novoPrototipo;
};

Function.prototype.implementar = function(implementacoes) {
	Utilitarios.checarTiposDeArgumentos([implementacoes], [Object], "Tipo de argumento inválido. Argumento deve ser: [Objeto].");
	implementacoes.paraCada(function(implementacao, chave) {
		this.prototype[chave] = implementacao;
	}, this);
};

Function.prototype.vincularEscopo = function(escopo) {
	var essaFuncao = this;
	var funcaoComEscopoVinculado = function() {
		return essaFuncao.apply(escopo, arguments);
	};
	return funcaoComEscopoVinculado;
};

Array.prototype.paraCada = function(funcaoDeIteracao, escopo) {
	Utilitarios.checarTiposDeArgumentos([funcaoDeIteracao], [Function], "Tipo de argumento inválido. Argumento deve ser: [Função].");
	funcaoDeIteracao = funcaoDeIteracao.vincularEscopo(escopo);
	for (var indice = 0; indice < this.length; indice++) {
		funcaoDeIteracao(this[indice], indice);
	}
};

Array.prototype.contem = function(valor) {
	return (this.indexOf(valor) >= 0);
};

Object.prototype.paraCada = function(funcaoDeIteracao, escopo) {
	Utilitarios.checarTiposDeArgumentos([funcaoDeIteracao], [Function], "Tipo de argumento inválido. Argumento deve ser: [Função].");
	funcaoDeIteracao = funcaoDeIteracao.vincularEscopo(escopo);
	for (var chave in this) {
		funcaoDeIteracao(this[chave], chave);
	}
};

Object.defineProperty(Object.prototype, 'paraCada', {
	writable: true,
	enumerable: false,
	configurable: true
});

var ExcecaoUtilitarios = new Prototipo({
	inicializar: function(mensagem) {
		this.mensagem = mensagem;
	},
	
	comoTexto: function() {
		return "ExcecaoUtilitarios: " + this.mensagem;
	},
	
	toString: function() {
		return this.comoTexto();
	}
});