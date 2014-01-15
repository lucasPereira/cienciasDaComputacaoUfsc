// "use strict";

var Linda = { 
	propriedadesDeFuncoes: {
		configuravel: false,
		enumeravel: false, 
		gravavel: false, 
		funcaoFornecer: undefined,
		funcaoFixar: undefined,
		valor: undefined
	},
	
	fornecerPrototipoDe: function (objeto) {
		return Object.getPrototypeOf(objeto);
	},
	
	instanciaDe: function (objeto, tipo) {
		if (!Linda.tipoDe(tipo, Function)) {
			return false;
		}
		if (Linda.tipoDe(objeto, String) || Linda.tipoDe(objeto, Number) || Linda.tipoDe(objeto, Boolean) || Linda.tipoDe(objeto, undefined)) {
			return Linda.tipoDe(objeto, tipo);
		}
		while (objeto !== null) {
			if (objeto === tipo.prototype) {
				return true;
			}
			objeto = Linda.fornecerPrototipoDe(objeto);
		}
		return false;
	},
	
	tipoDe: function (tipo, tipoComparado) {
		var tipoComparadoTextual = "";
		if (tipoComparado == Object) {
			tipoComparadoTextual = Tipos.OBJETO;
		} else if (tipoComparado == Function) {
			tipoComparadoTextual = Tipos.FUNCAO;
		} else if (tipoComparado == String) {
			tipoComparadoTextual = Tipos.TEXTO;
		} else if (tipoComparado == Number) {
			tipoComparadoTextual = Tipos.NUMERO;
		} else if (tipoComparado == Boolean) {
			tipoComparadoTextual = Tipos.BOOLEANO;
		} else if (tipoComparado == undefined) {
			tipoComparadoTextual = Tipos.INDEFINIDO;
		}
		return (typeof tipo === tipoComparadoTextual);
	},
	
	nuloOuIndefinido: function (valor) {
		return (Linda.nulo(valor) || Linda.indefinido(valor));
	},
	
	nulo: function (valor) {
		return (valor === null);
	},
	
	indefinido: function (valor) {
		return (valor === undefined);
	},
	
	assegureQue: function (condicao) {
		if (!condicao) {
			throw new ExcecaoLinda("Asserção inválida. Quebra de contrato.");
		}
	},
	
	assegureQueNao: function (condicao) {
		Linda.assegureQue(!condicao);
	},
	
	checarTiposDeParametros: function (parametros, tiposDesejados) {
		for (var indice = 0; indice < parametros.length; indice++) {
			if (!Linda.instanciaDe(parametros[indice], tiposDesejados[indice])) {
				throw new ExcecaoLinda("Parâmetro inválido. Tipos dos parâmetros devem ser: [" + tiposDesejados.join(",") + "].");
			}
		}
	},
	
	checarParametroDentroDeIntervalo: function (parametros, inicioDeIntervalo, fimDeIntervalo) {
		if (parametros < inicioDeIntervalo || parametros > fimDeIntervalo) {
			throw new ExcecaoLinda("Parâmetro inválido. Valor do parâmetro deve estar entre: [" + inicioDeIntervalo + ", " + fimDeIntervalo + "].");
		}
	},
	
	checarParametroDentroDeValores: function (argumento, valoresPossiveis) {
		if (!valoresPossiveis.contem(argumento)) {
			throw new ExcecaoLinda("Parâmetro inválido. Valor do parâmetro deve pertencer à: [" + valoresPossiveis.join(", ") + "].");
		} 
	},
	
	selecionar: function (selecao) {
		return document.querySelector(selecao);
	},
	
	selecionarTodos: function (selecao) {
		return document.querySelectorAll(selecao);
	},
	
	obterPelaClasse: function (classe) {
		return document.getElementsByClassName(classe)[0];
	},
	
	obterTodosPelaClasse: function (classe) {
		return document.getElementsByClassName(classe);
	},
	
	obterPeloNome: function (nome) {
		return document.getElementsByName(nome)[0];
	},
	
	obterTodosPeloNome: function (nome) {
		return document.getElementsByName(nome);
	},
	
	obterPeloIdentificador: function (identificador) {
		return document.getElementById(identificador);
	},
	
	habilitarTelaCheia: function () {
		if (document.documentElement.requestFullScreen) {
			document.documentElement.requestFullScreen();
		} else if (document.documentElement.mozRequestFullScreen) {
			document.documentElement.mozRequestFullScreen();
		} else if (document.documentElement.webkitRequestFullScreen) {
			document.documentElement.webkitRequestFullScreen();
		}
	},
	
	desabilitarTelaCheia: function () {
		if (document.cancelFullScreen) {
			document.cancelFullScreen();
		} else if (document.mozCancelFullScreen) {
			document.mozCancelFullScreen();
		} else if (document.webkitCancelFullScreen) {
			document.webkitCancelFullScreen();
		}
	},
	
	documento: function () {
		return document;
	},
	
	janela: function () {
		return window;
	},
	
	historico: function () {
		return window.history;
	},
	
	localizacao: function () {
		return window.location
	},
	
	naoNumero: function (valor) {
		return (valor !== valor);
	},
	
	paraInteiro: function (naoInteiro) {
		return parseInt(naoInteiro);
	},
	
	paraFlutuante: function (naoFlutuante) {
		return parseFloat(naoFlutuante);
	},
	
	concatenar: function () {
		var texto = "";
		for (var indice in arguments) {
			texto = texto + arguments[indice];
		}
		return texto;
	},
	
	formatar: function (mensagem) {
		var identificador = "%$";
		var indice;
		for (indice = 1; indice < arguments.length; indice++) {
			mensagem = mensagem.replace(identificador, arguments[indice]);
		}
		return mensagem;
	},
	
	concatenarComEspaco: function () {
		var texto = "";
		for (var indice in arguments) {
			texto = texto + " " + arguments[indice];
		}
		return (arguments.length > 0) ? texto.substr(1, texto.length - 1) : " ";
	}
};

var ExcecaoLinda = function (mensagem) {
	this.mensagem = mensagem;
	this.message = mensagem;
};

ExcecaoLinda.prototype.comoTexto = function () {
	return "ExcecaoLinda: " + this.mensagem;
};

ExcecaoLinda.prototype.toString = function () {
	return this.comoTexto();
};

var Tipos = {
	OBJETO: "object",
	FUNCAO: "function",
	TEXTO: "string",
	NUMERO: "number",
	BOOLEANO: "boolean",
	INDEFINIDO: "undefined"
};

(function () {
	// "use strict";
	
	Function.prototype.implementar = function (implementacoes) {
		Linda.checarTiposDeParametros([implementacoes], [Object]);
		for (var implementacao in implementacoes) {
			this.prototype[implementacao] = implementacoes[implementacao];
		}
	};
	
	Function.implementar({
		vincularEscopo: function (escopo) {
			var essaFuncao = this;
			var funcaoComEscopoVinculado = function () {
				return essaFuncao.aplicarComEscopo(escopo, arguments);
			};
			return funcaoComEscopoVinculado;
		},
		
		aplicarComEscopo: function (escopo, argumentos) {
			return this.apply(escopo, argumentos);
		},
		
		chamarComEscopo: function (escopo) {
			return this.aplicarComEscopo(escopo, arguments.removerPosicao(0));
		}
	});
} ());

//"use strict";

var Prototipo = function Prototipo(corpoDoPrototipo) {
	var inicializar = corpoDoPrototipo.inicializar;
	var inicializa = Linda.instanciaDe(corpoDoPrototipo.inicializar, Function);
	var novoPrototipo = function Objeto() {
		if (inicializa) {
			inicializar.aplicarComEscopo(this, arguments);
		}
	};
	delete corpoDoPrototipo.inicializar;
	novoPrototipo.implementar(corpoDoPrototipo);
	return novoPrototipo;
};

var PrototipoUnico = function PrototipoUnico(corpoDoPrototipo) {
	var novoPrototipoUnico = {
		instanciaUnica: null,
		
		instancia: function () {
			var NovoPrototipo = new Prototipo(corpoDoPrototipo);
			this.instanciaUnica = new NovoPrototipo();
			this.instanciaUnica.inicializarUnico.aplicarComEscopo(this.instanciaUnica, arguments);
			novoPrototipoUnico.definirPropriedade("instanciaUnica", Linda.propriedadesDeFuncoes);
			novoPrototipoUnico.definirPropriedade("instancia", {
				configuravel: false,
				enumeravel: false,
				funcaoFornecer: function () {
					return this.instanciaUnica;
				}
			});
			return this.instanciaUnica;
		}
	};
	return novoPrototipoUnico;
};

var EnumeracaoDePrototipos = new Prototipo({
	inicializar: function (enumeracoes, corpoDoPrototipo) {
		var PrototipoDaEnumeracao = new Prototipo(corpoDoPrototipo);
		enumeracoes.paraCada(function (argumentos, enumeracao) {
			this[enumeracao] = new PrototipoDaEnumeracao();
			this[enumeracao].inicializarEnumeracao.aplicarComEscopo(this[enumeracao], argumentos);
		}, this);
	},
	
	mapear: function (chave) {
		var enumeracaoEncontrada = null;
		this.paraCada(function (enumeracao) {
			if (enumeracao.chave === chave) {
				enumeracaoEncontrada = enumeracao;
				return;
			}
		}, this);
		return enumeracaoEncontrada;
	},
	
	comoLista: function () {
		var lista = [];
		this.paraCada(function (enumeracao) {
			if (!Linda.nuloOuIndefinido(enumeracao.chave)) {
				lista.push(enumeracao);
			}
		}, this);
		return lista;
	}
});

var EnumeracaoDeConstantes = new Prototipo({
	inicializar: function (enumeracoes) {
		enumeracoes.paraCada(function (valor, enumeracao) {
			this[enumeracao] = valor;
		}, this);
	},
	
	mapear: function (chave) {
		var enumeracaoEncontrada = null;
		this.paraCada(function (enumeracao) {
			if (enumeracao === chave) {
				enumeracaoEncontrada = enumeracao;
				return;
			}
		}, this);
		return enumeracaoEncontrada;
	},
	
	comoLista: function () {
		var lista = [];
		this.paraCada(function (enumeracao) {
			lista.push(enumeracao);
		}, this);
		return lista;
	}
});

(function () {
	//"use strict";
	
	Object.implementar({
		definirPropriedade: function (atributo, definicao) {
			Linda.checarTiposDeParametros([atributo, definicao], [String, Object]);
			var propriedades = {};
			if (!Linda.indefinido(definicao.valor)) { propriedades.value = definicao.valor; }
			if (!Linda.indefinido(definicao.funcaoFornecer)) { propriedades.get = definicao.funcaoFornecer; }
			if (!Linda.indefinido(definicao.funcaoFixar)) { propriedades.set = definicao.funcaoFixar; }
			if (!Linda.indefinido(definicao.gravavel)) { propriedades.writable = definicao.gravavel; }
			if (!Linda.indefinido(definicao.enumeravel)) { propriedades.enumerable = definicao.enumeravel; }
			if (!Linda.indefinido(definicao.configuravel)) { propriedades.configurable = definicao.configuravel; }
			try {
				Object.defineProperty(this, atributo, propriedades);
			} catch (excecao) {
				throw new ExcecaoLinda("Parametro inválido. Parametro[1] deve possuir propriedades válidas para o atributo (valor, funcaoFornecer, funcaoFixar, gravavel, enumeravel e configuravel).");
			}
		},
		
		fornecerPropriedades: function () {
			return Object.getOwnPropertyNames(this);
		},
		
		fornecerPropriedadesEnumeraveis: function () {
			return Object.keys(this);
		},
		
		paraCada: function (funcaoDeIteracao, escopo) {
			Linda.checarTiposDeParametros([funcaoDeIteracao], [Function]);
			funcaoDeIteracao = funcaoDeIteracao.vincularEscopo(escopo);
			for (var chave in this) {
				funcaoDeIteracao(this[chave], chave);
			}
		},
		
		possuiPropriedade: function (propriedade) {
			Linda.checarTiposDeParametros([propriedade], [String]);
			return (propriedade in this);
		},
		
		prototipoDe: function (prototipado) {
			Linda.checarTiposDeParametros([prototipado], [Object]);
			return this.isPrototypeOf(prototipado);
		}
	});
	
	Object.prototype.definirPropriedade("definirPropriedade", Linda.propriedadesDeFuncoes);
	Object.prototype.definirPropriedade("fornecerPropriedades", Linda.propriedadesDeFuncoes);
	Object.prototype.definirPropriedade("fornecerPropriedadesEnumeraveis", Linda.propriedadesDeFuncoes);
	Object.prototype.definirPropriedade("paraCada", Linda.propriedadesDeFuncoes);
	Object.prototype.definirPropriedade("possuiPropriedade", Linda.propriedadesDeFuncoes);
	Object.prototype.definirPropriedade("prototipoDe", Linda.propriedadesDeFuncoes);
	Function.prototype.definirPropriedade("implementar", Linda.propriedadesDeFuncoes);
	Function.prototype.definirPropriedade("vincularEscopo", Linda.propriedadesDeFuncoes);
	Function.prototype.definirPropriedade("aplicarComEscopo", Linda.propriedadesDeFuncoes);
	Function.prototype.definirPropriedade("chamarComEscopo", Linda.propriedadesDeFuncoes);
	EnumeracaoDePrototipos.prototype.definirPropriedade("mapear", Linda.propriedadesDeFuncoes);
	EnumeracaoDePrototipos.prototype.definirPropriedade("comoLista", Linda.propriedadesDeFuncoes);
	EnumeracaoDeConstantes.prototype.definirPropriedade("mapear", Linda.propriedadesDeFuncoes);
	EnumeracaoDeConstantes.prototype.definirPropriedade("comoLista", Linda.propriedadesDeFuncoes);
} ());

(function () {
	// "use strict";
	
	Array.implementar({
		paraCada: function (funcaoDeIteracao, escopo) {
			Linda.checarTiposDeParametros([funcaoDeIteracao], [Function]);
			funcaoDeIteracao = funcaoDeIteracao.vincularEscopo(escopo);
			for (var indice = 0; indice < this.length; indice++) {
				funcaoDeIteracao(this[indice], indice);
			}
		},
		
		contem: function (valor) {
			return (this.indexOf(valor) >= 0);
		},
		
		removerPosicao: function (posicao) {
			this.splice(posicao, 1);
		},
		
		removerElemento: function (elemento) {
			this.removerPosicao(this.fornecerIndice(elemento));
		},
		
		fornecerIndice: function (elemento) {
			return this.indexOf(elemento);
		}
	});
	
	//Array.prototype.definirPropriedade("paraCada", Linda.propriedadesDeFuncoes);
	Array.prototype.definirPropriedade("contem", Linda.propriedadesDeFuncoes);
	Array.prototype.definirPropriedade("removerPosicao", Linda.propriedadesDeFuncoes);
	Array.prototype.definirPropriedade("removerElemento", Linda.propriedadesDeFuncoes);
	Array.prototype.definirPropriedade("fornecerIndice", Linda.propriedadesDeFuncoes);
} ());

//"use strict";

var Tipo = new EnumeracaoDeConstantes(Tipos);

var Evento = new EnumeracaoDeConstantes({
	TECLA_PRESSIONADA: "keydown",
	TECLA_SOLTA: "keyup",
	CARREGADO: "load",
	CLIQUE: "click",
	DUPLO_CLIQUE: "dbclick"
});

var Tecla = new EnumeracaoDeConstantes({
	CIMA: 38,
	BAIXO: 40,
	ESQUERDA: 37,
	DIREITA: 39
});

var AtributoHttp = new EnumeracaoDeConstantes({
	CONTENT_TYPE: "Content-Type",
	ACCEPT_CHARSET: "Accept-Charset",
	ACCEPT_ENCODING: "Accept-Encoding",
	ACCESS_CONTROL_REQUEST_HEADERS: "Access-Control-Request-Headers",
	ACCESS_CONTROL_REQUEST_METHOD: "Access-Control-Request-Method",
	CONNECTION: "Connection",
	CONTENT_LENGTH: "Content-Length",
	COOKIE: "Cookie",
	COOKIE_2: "Cookie2",
	CONTENT_TRANSFER_ENCODING: "Content-Transfer-Encoding",
	DATE: "Date",
	EXPECT: "Expect",
	HOST: "Host",
	KEEP_ALIVE: "Keep-Alive",
	ORIGIN: "Origin",
	REFERER: "Referer",
	TE: "TE",
	TRAILER: "Trailer",
	TRANSFER_ENCODING: "Transfer-Encoding",
	UPGRADE: "Upgrade",
	USER_AGENT: "User-Agent",
	VIA: "Via"
});

var MetodoHttp = new EnumeracaoDeConstantes({
	GET: "GET",
	PUT: "PUT",
	POST: "POST",
	DELETE: "DELETE",
	HEAD: "HEAD",
	OPTIONS: "OPTIONS"
});

var CodigoHttp = new EnumeracaoDePrototipos({
	HTTP_100: [100, "Continuar", "Continue"],
	HTTP_101: [101, "Trocando protocolos", "Switching Protocols"],
	HTTP_200: [200, "Certo", "OK"],
	HTTP_201: [201, "Criado", "Created"],
	HTTP_202: [202, "Aceito", "Accepted"],
	HTTP_203: [203, "Informações não autorizadas", "Non-Authoritative Information"],
	HTTP_204: [204, "Sem conteúdo", "No Content"],
	HTTP_205: [205, "Conteúdo reiniciado", "Reset Content"],
	HTTP_206: [206, "Conteúdo parcial", "Partial Content"],
	HTTP_300: [300, "Múltiplas escolhas", "Multiple Choices"],
	HTTP_301: [301, "Movido permanentemente", "Moved Permanently"],
	HTTP_302: [302, "Encontrado", "Found"],
	HTTP_303: [303, "Olhar outro", "See Other"],
	HTTP_304: [304, "Não modificado", "Not Modified"],
	HTTP_305: [305, "Usar procurador", "Use Proxy"],
	HTTP_306: [306, "", ""],
	HTTP_307: [307, "Redirecionado temporariamente", "Temporary Redirect"],
	HTTP_400: [400, "Requisição ruim", "Bad Request"],
	HTTP_401: [401, "Não autorizado", "Unauthorized"],
	HTTP_402: [402, "Pagamento requerido", "Payment Required"],
	HTTP_403: [403, "Proibido", "Forbidden"],
	HTTP_404: [404, "Não encontrado", "Not Found"],
	HTTP_405: [405, "Método não permitido", "Method Not Allowed"],
	HTTP_406: [406, "Não aceitável", "Not Acceptable"],
	HTTP_407: [407, "Autenticação do procurador requerida", "Proxy Authentication Required"],
	HTTP_408: [408, "Estouro de tempo", "Request Time-out"],
	HTTP_409: [409, "Conflito", "Conflict"],
	HTTP_410: [410, "Desaparecido", "Gone"],
	HTTP_411: [411, "Tamanho requerido", "Length Required"],
	HTTP_412: [412, "Pré-condição não satisfeita", "Precondition Failed"],
	HTTP_413: [413, "Entidade muito grande", "Request Entity Too Large"],
	HTTP_414: [414, "URI muito longa", "Request-URI Too Large"],
	HTTP_415: [415, "Tipo de mídia não suportado", "Unsupported Media Type"],
	HTTP_416: [416, "Intervalo não satisfatório", "Requested range not satisfiable"],
	HTTP_417: [417, "Expectativa não satisfeita", "Expectation Failed"],
	HTTP_500: [500, "Erro interno no servidor", "Internal Server Error"],
	HTTP_501: [501, "Não implementado", "Not Implemented"],
	HTTP_502: [502, "Portão de acesso ruim", "Bad Gateway"],
	HTTP_503: [503, "Serviço indisponível", "Service Unavailable"],
	HTTP_504: [504, "Estouro de tempo do portão de acesso", "Gateway Time-out"],
	HTTP_505: [505, "Versão do protocolo não suportada", "HTTP Version not supported"],
}, {
	inicializarEnumeracao: function (chave, texto, textoIngles) {
		this.chave = chave;
		this.texto = texto;
		this.textoIngles = textoIngles;
	},
	
	comoNumero: function () {
		return this.chave;
	},
	
	comoTexto: function () {
		return this.texto;
	},
	
	comoTextoIngles: function () {
		return this.textoIngles;
	},
	
	informacional: function () {
		return (this.chave >= 100 && this.chave < 200);
	},
	
	sucesso: function () {
		return (this.chave >= 200 && this.chave < 300);
	},
	
	redirecionamento: function () {
		return (this.chave >= 300 && this.chave < 400);
	},
	
	erroDoCliente: function () {
		return (this.chave >= 400 && this.chave < 500);
	},
	
	erroDoServidor: function () {
		return (this.chave >= 500 && this.chave < 600);
	}
});

//"use strict";

var RequisicaoJson = new Prototipo({
	inicializar: function (uri) {
		Linda.checarTiposDeParametros([uri], [String]);
		this.requisicaoXml = new XMLHttpRequest();
		this.uri = uri;
		this.usuario = null;
		this.senha = null;
		this.adicionarTratadoresDeEventos();
		this.cabecalho = [];
	},
	
	adicionarTratadoresDeEventos: function () {
		this.requisicaoXml.onloadstart = function (evento) {
			this.tratarInicio(evento.loaded, evento.total, evento.timeStamp);
		}.vincularEscopo(this);
		this.requisicaoXml.onprogress = function (evento) {
			this.tratarProgresso(evento.loaded, evento.total, evento.timeStamp);
		}.vincularEscopo(this);
		this.requisicaoXml.onloadend = function (evento) {
			this.tratarTermino(evento.loaded, evento.total, evento.timeStamp);
		}.vincularEscopo(this);
		this.requisicaoXml.onabort = function (evento) {
			this.tratarAborto(evento.loaded, evento.total, evento.timeStamp);
		}.vincularEscopo(this);
		this.requisicaoXml.onerror = function (evento) {
			this.tratarErro(evento.loaded, evento.total, evento.timeStamp);
		}.vincularEscopo(this);
		this.requisicaoXml.ontimeout = function (evento) {
			this.tratarEstouroDeTempo(evento.loaded, evento.total, evento.timeStamp);
		}.vincularEscopo(this);
		this.requisicaoXml.onload = function (evento) {
			var resposta = this.fornecerResposta();
			var codigoDeEstado = CodigoHttp.mapear(this.requisicaoXml.status);
			var carregado = evento.loaded;
			var total = evento.total;
			var estampaDeTempo = evento.timeStamp;
			if (codigoDeEstado.sucesso()) {
				this.tratarSucesso(resposta, codigoDeEstado, carregado, total, estampaDeTempo);
			} else if (codigoDeEstado.redirecionamento()) {
				this.tratarRedirecionamento(resposta, codigoDeEstado, carregado, total, estampaDeTempo);
			} else if (codigoDeEstado.erroDoCliente()) {
				this.tratarErroDoCliente(resposta, codigoDeEstado, carregado, total, estampaDeTempo);
			} else if (codigoDeEstado.erroDoServidor()) {
				this.tratarErroDoServidor(resposta, codigoDeEstado, carregado, total, estampaDeTempo);
			}
			this.tratarResposta(resposta, codigoDeEstado, carregado, total, estampaDeTempo);
		}.vincularEscopo(this);
	},
	
	enviar: function (metodo, dados, assincrono) {
		var metodosSuportados = MetodoHttp.comoLista();
		assincrono = !!assincrono;
		metodo = MetodoHttp.mapear(metodo);
		Linda.checarTiposDeParametros([metodo, dados, assincrono], [String, Object, Boolean]);
		Linda.checarParametroDentroDeValores(metodo, metodosSuportados);
		this.requisicaoXml.open(metodo, this.uri, assincrono, this.usuario, this.senha);
		this.cabecalho.paraCada(function (atributo) {
			this.requisicaoXml.setRequestHeader(atributo.nome, atributo.valor);
		}, this);
		//this.requisicaoXml.responseType = "json";
		try {
			dados = JSON.stringify(dados);
		} catch (excecao) {
			
		}
		try {
			this.requisicaoXml.send(dados);
		} catch (excecao) {
			throw new ExcecaoLinda("Erro ao efeturar a requsição. Certifique-se de que o tipo de resposta é adequado e não há problemas com restrições de origem única ou restrições de origem nula.");
		}
		if (!assincrono) {
			return this.fornecerResposta();
		}
	},
	
	enviarGet: function (assincrono) {
		return this.enviar(MetodoHttp.GET, {}, assincrono);
	},
	
	enviarPut: function (dados, assincrono) {
		return this.enviar(MetodoHttp.PUT, dados, assincrono);
	},
	
	enviarPost: function (dados, assincrono) {
		return this.enviar(MetodoHttp.POST, dados, assincrono);
	},
	
	envirDelete: function (assincrono) {
		return this.enviar(MetodoHttp.DELETE, {}, assincrono);
	},
	
	tratarInicio: function (carregado, total, estampaDeTempo) {
		
	},
	
	tratarProgresso: function (carregado, total, estampaDeTempo) {
		
	},
	
	tratarTermino: function (carregado, total, estampaDeTempo) {
		
	},
	
	tratarErro: function (carregado, total, estampaDeTempo) {
		
	},
	
	tratarAborto: function (carregado, total, estampaDeTempo) {
		
	},
	
	tratarEstouroDeTempo: function (carregado, total, estampaDeTempo) {
		
	},
	
	tratarResposta: function (resposta, codigoDeEstado, carregado, total, estampaDeTempo) {
		
	},
	
	tratarRedirecionamento: function (resposta, codigoDeEstado, carregado, total, estampaDeTempo) {
		
	},
	
	tratarSucesso: function (resposta, codigoDeEstado, carregado, total, estampaDeTempo) {
		
	},
	
	tratarErroDoCliente: function (resposta, codigoDeEstado, carregado, total, estampaDeTempo) {
		
	},
	
	tratarErroDoServidor: function (resposta, codigoDeEstado, carregado, total, estampaDeTempo) {
		
	},
	
	abortar: function () {
		this.requisicaoXml.abort();
		return this;
	},
	
	fixarAtributoDeCabecalho: function (nome, valor) {
		var atributosPossiveis = AtributoHttp.comoLista();
		nome = AtributoHttp.mapear(nome);
		Linda.checarTiposDeParametros([nome, valor], [String, String]);
		Linda.checarParametroDentroDeValores(nome, atributosPossiveis);
		this.cabecalho.push({nome: nome, valor: valor});
		return this;
	},
	
	fixarAutenticacao: function (usuario, senha) {
		Linda.checarTiposDeParametros([usuario, senha], [String, String]);
		this.usuario = usuario;
		this.senha = senha;
		return this;
	},
	
	fixarTempoLimite: function (tempoLimite) {
		Linda.checarTiposDeParametros([tempoLimite], [Number]);
		this.requisicaoXml.timeout = tempoLimite
		return this;
	},
	
	fornecerResposta: function () {
		try {
			return JSON.parse(this.requisicaoXml.response);
		} catch (excecao) {
			return this.requisicaoXml.response;
		}
	}
});

var Tratador = new Prototipo({
	inicializar: function (elemento) {
		this.elemento = (Linda.nuloOuIndefinido(elemento)) ? Linda.janela() : elemento;
	},
	
	adicionar: function (evento, tratador) {
		Linda.checarTiposDeParametros([evento, tratador], [String, Function]);
		this.elemento.addEventListener(evento, tratador);
	},
	
	remover: function (evento) {
		Linda.checarTiposDeParametros([evento], [String]);
		this.elemento.removeEventListener(evento);
	}
});

var TratadorDeTeclado = new Prototipo({
	inicializar: function (tecla, elemento) {
		Linda.checarTiposDeParametros([tecla], [Number]);
		this.tecla = tecla;
		this.tratador = new Tratador(elemento);
	},
	
	paraTeclaPressionada: function (tratador) {
		this.tratador.adicionar(Evento.TECLA_PRESSIONADA, this.adicionarTratadorDeTeclado(tratador));
		return this;
	},
	
	paraTeclaSolta: function (tratador) {
		this.tratador.adicionar(Evento.TECLA_SOLTA, this.adicionarTratadorDeTeclado(tratador));
		return this;
	},
	
	adicionarTratadorDeTeclado: function (tratador) {
		Linda.checarTiposDeParametros([tratador], [Function]);
		return function (evento) {
			if (this.tecla === evento.keyCode) {
				tratador();
			}
		}.bind(this);
	}
});

var TratadorDeMouse = new Prototipo({
	inicializar: function (elemento) {
		this.tratador = new Tratador(elemento);
	},
	
	paraClique: function (tratador) {
		Linda.checarTiposDeParametros([tratador], [Function]);
		this.tratador.adicionar(Evento.CLIQUE, tratador);
		return this;
	}
});

var TratadorDePagina = new Prototipo({
	inicializar: function () {
		this.tratador = new Tratador();
	},
	
	paraCarregada: function (tratador) {
		Linda.checarTiposDeParametros([tratador], [Function]);
		this.tratador.adicionar(Evento.CARREGADO, tratador);
		return this;
	}
});

