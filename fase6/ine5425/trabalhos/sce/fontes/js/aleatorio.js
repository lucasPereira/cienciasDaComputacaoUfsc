//"use strict";
/*global Linda*/
/*global Prototipo*/
/*global PrototipoUnico*/
/*jshint bitwise: true, camelcase: true, curly: true, eqeqeq: true, forin: true, immed: true, latedef: true, newcap: true, noarg: true, noempty: true, nonew: false, plusplus: false, quotmark: "double", regexp: true, undef: true, unused: true, strict: true, trailing: true, indent: 4, maxparams: 3, maxdepth: 1, maxstatements: 10, maxcomplexity: 2, maxlen: 128 asi: false, boss: false, debug: false, eqnull: false, es5: false, esnext: false, evil: false, expr: false, globalstrict: true, funcscope: false, iterator: false, lastsemic: false, laxbreak: false, laxcomma: false, loopfunc: false, multistr: false, onecase: false, proto: false, regexdash: false, scripturl: false, smarttabs: false, shadow: false, sub: false, supernew: false, browser: true*/
/*jshint unused: false*/

var CongruenteMisto = new Prototipo({
	inicializar: function (a, m, b) {
		this.a = a;
		this.m = m;
		this.b = b;
	},
	
	gerar: function (x) {
		return (((this.a * x) + this.b) % this.m);
	},
	
	normalizar: function (x) {
		return (x / this.m);
	}
});

var CongruenteMultiplicativo = new Prototipo({
	inicializar: function (a, m) {
		this.congruenteMisto = new CongruenteMisto(a, m, 0);
	},
	
	gerar: function (x) {
		return this.congruenteMisto.gerar(x);
	},
	
	normalizar: function (x) {
		return this.congruenteMisto.normalizar(x);
	}
});

var Gna = new PrototipoUnico({
	inicializarUnico: function (estrategiaDeGeracao, semente) {
		this.estrategiaDeGeracao = estrategiaDeGeracao;
		this.ultimoGerado = semente;
		this.interessados = [];
		this.gerados = 0;
	},
	
	fixarSemente: function (semente) {
		var fixado = (this.gerados === 0);
		if (fixado) {
			this.semente = semente;
		}
		return fixado;
	},
	
	fixarEstrategiaDeGeracao: function (estrategia) {
		var fixado = (this.gerados === 0);
		if (fixado) {
			this.estrategiaDeGeracao = estrategia;
		}
		return fixado;
	},
	
	gerar: function () {
		this.gerados++;
		this.ultimoGerado = this.estrategiaDeGeracao.gerar(this.ultimoGerado);
		var geradoNormalizado = this.estrategiaDeGeracao.normalizar(this.ultimoGerado);
		this.interessados.paraCada(function (interessado) {
			interessado(this.ultimoGerado, geradoNormalizado);
		}, this);
		return geradoNormalizado;
	},
	
	registrarInteressado: function (interessado) {
		this.interessados.push(interessado);
	}
});

var ClasseMonteCarlo = new Prototipo({
	inicializar: function (classe, frequencia) {
		this.classe = classe;
		this.frequencia = frequencia;
		this.frequenciaAcumulada = frequencia;
	},
	
	fixarFrequenciaAcumulada: function (frequenciaAcumulada) {
		this.frequenciaAcumulada = frequenciaAcumulada + this.frequencia;
		return this.frequenciaAcumulada;
	},
	
	pertencenteAClasse: function (numeroAleatorio, frequenciaTotal) {
		var frequenciaAcumuladaEmPorcentagem = this.frequenciaAcumulada / frequenciaTotal;
		return ((numeroAleatorio < frequenciaAcumuladaEmPorcentagem) && this.frequencia > 0);
	},
	
	maiorQue: function (outraClasseDeMonteCarlo) {
		return (this.frequencia > outraClasseDeMonteCarlo.frequencia);
	}
});

var MonteCarlo = new Prototipo({
	inicializar: function (classes) {
		this.frequenciaTotal = 0;
		this.classes = classes;
		this.classes.sort(function (classeA, classeB) {
			return classeA.maiorQue(classeB);
		});
		this.classes.reverse();
		this.classes.paraCada(function (classe) {
			this.frequenciaTotal = classe.fixarFrequenciaAcumulada(this.frequenciaTotal);
		}, this);
	},
	
	sortearClasse: function () {
		var numeroAleatorio = Gna.instancia.gerar();
		var indice = 0;
		var classeSorteada = null;
		do {
			classeSorteada = this.classes[indice];
			indice += 1;
		} while (!Linda.nuloOuIndefinido(classeSorteada) &&
				!classeSorteada.pertencenteAClasse(numeroAleatorio, this.frequenciaTotal));
		return classeSorteada.classe;
	}
});

var Uniforme = new Prototipo({
	inicializar: function (a, b) {
		this.a = a;
		this.b = b;
	},
	
	sortearValor: function () {
		var numeroAleatorio = Gna.instancia.gerar();
		return (this.a + ((this.b - this.a) * numeroAleatorio));
	},
	
	comoTexto: function () {
		return Linda.formatar("Uniforme(%$; %$)", this.a, this.b);
	}
});

var Exponencial = new Prototipo({
	inicializar: function (lambda) {
		this.lambda = lambda;
	},
	
	sortearValor: function () {
		var numeroAleatorio = Gna.instancia.gerar();
		return (-this.lambda * Math.log(1 - numeroAleatorio));
	},
	
	comoTexto: function () {
		return Linda.formatar("Exponencial(%$)", this.lambda);
	}
});

var Normal = new Prototipo({
	inicializar: function (media, desvioPadrao) {
		this.media = media;
		this.desvioPadrao = desvioPadrao;
		this.gerados = [];
	},
	
	sortearValor: function () {
		if (this.gerados.length === 0) {
			var numeroAleatorio1 = Gna.instancia.gerar();
			var numeroAleatorio2 = Gna.instancia.gerar();
			var zComum1 = Math.sqrt(-2 * Math.log(numeroAleatorio1));
			var zComum2 = (2 * Math.PI * numeroAleatorio2);
			var z1 = zComum1 * Math.cos(zComum2);
			var z2 = zComum1 * Math.sin(zComum2);
			this.gerados.push(this.media + (this.desvioPadrao * z1));
			this.gerados.push(this.media + (this.desvioPadrao * z2));
		}
		return this.gerados.shift();
	},
	
	comoTexto: function () {
		return Linda.formatar("Normal(%$; %$)", this.media, this.desvioPadrao);
	}
});

var Triangular = new Prototipo({
	inicializar: function (a, b, c) {
		this.a = a;
		this.b = b;
		this.c = c;
	},
	
	sortearValor: function () {
		var numeroAleatorio = Gna.instancia.gerar();
		if (numeroAleatorio <= (this.b - this.a) / (this.c - this.a)) {
			return (this.a + Math.sqrt(numeroAleatorio * (this.b - this.a) * (this.c - this.a)));
		}
		return (this.c - Math.sqrt((1 - numeroAleatorio) * (this.c - this.b) * (this.c - this.a)));
	},
	
	comoTexto: function () {
		return Linda.formatar("Normal(%$; %$; %$)", this.a, this.b, this.c);
	}
});

