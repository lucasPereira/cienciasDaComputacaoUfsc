//"use strict";
/*global PrototipoUnico*/
/*global EnumeracaoDePrototipos*/
/*global SceSimulacao*/
/*global Gna*/
/*global MonteCarlo*/
/*global ClasseMonteCarlo*/
/*global CongruenteMisto*/
/*global Uniforme*/
/*global Exponencial*/
/*global Triangular*/
/*global Normal*/
/*jshint bitwise: true, camelcase: true, curly: true, eqeqeq: true, forin: true, immed: true, latedef: true, newcap: true, noarg: true, noempty: true, nonew: false, plusplus: false, quotmark: "double", regexp: true, undef: true, unused: true, strict: true, trailing: true, indent: 4, maxparams: 3, maxdepth: 1, maxstatements: 10, maxcomplexity: 2, maxlen: 128 asi: false, boss: false, debug: false, eqnull: false, es5: false, esnext: false, evil: false, expr: false, globalstrict: true, funcscope: false, iterator: false, lastsemic: false, laxbreak: false, laxcomma: false, loopfunc: false, multistr: false, onecase: false, proto: false, regexdash: false, scripturl: false, smarttabs: false, shadow: false, sub: false, supernew: false, browser: true*/

var TipoDeMensagem = new EnumeracaoDePrototipos({
	SUCESSO: ["Sucesso"],
	FRACASSO: ["Fracasso"],
	ADIAMENTO: ["Adiamento"]
}, {
	inicializarEnumeracao: function (chave) {
		this.utilizacoes = 0;
		this.chave = chave;
	},
	
	contar: function () {
		this.utilizacoes++;
	},
	
	fornecerQuantidade: function () {
		return this.utilizacoes;
	},
	
	sucesso: function () {
		return (this === TipoDeMensagem.SUCESSO);
	},
	
	fracasso: function () {
		return (this === TipoDeMensagem.FRACASSO);
	},
	
	adiamento: function () {
		return (this === TipoDeMensagem.ADIAMENTO);
	},
	
	comoTexto: function () {
		return this.chave;
	}
});

var TipoDeTrafegoDeMensagem = new EnumeracaoDePrototipos({
	LL: ["LL", new Exponencial(0.5), new Uniforme(0.12, 0.15), new Normal(0.55, 0.05), 87, 0.5, 12.5],
	LR: ["LR", new Exponencial(0.5), new Uniforme(0.11, 0.15), new Normal(0.65, 0.04), 96, 1.5, 2.5],
	RL: ["RL", new Exponencial(0.5), new Uniforme(0.10, 0.15), new Triangular(0.14, 0.25, 0.55), 96, 3, 1],
	RR: ["RR", new Exponencial(0.5), new Uniforme(0.13, 0.15), new Uniforme(0.09, 0.18), 90, 1, 9]
}, {
	/*jshint maxparams: 7 */
	inicializarEnumeracao: function (chave,
				distribuicaoTempoEntreChegadas, distribuicaoTempoDeRecepcao, distribuicaoTempoDeServico,
				frequenciaMonteCarloSucesso, frequenciaMonteCarloFracasso, frequenciaMonteCarloAdiamento) {
		this.utilizacoes = 0;
		this.chave = chave;
		this.distribuicaoTempoEntreChegadas = distribuicaoTempoEntreChegadas;
		this.distribuicaoTempoDeRecepcao = distribuicaoTempoDeRecepcao;
		this.distribuicaoTempoDeServico = distribuicaoTempoDeServico;
		this.monteCarloTipoDeMensagem = new MonteCarlo([
			new ClasseMonteCarlo(TipoDeMensagem.SUCESSO, frequenciaMonteCarloSucesso),
			new ClasseMonteCarlo(TipoDeMensagem.FRACASSO, frequenciaMonteCarloFracasso),
			new ClasseMonteCarlo(TipoDeMensagem.ADIAMENTO, frequenciaMonteCarloAdiamento)
		]);
	},
	
	sortearTipoDeMensagem: function () {
		return this.monteCarloTipoDeMensagem.sortearClasse();
	},
	
	sortearTempoEntreChegadas: function () {
		return this.distribuicaoTempoEntreChegadas.sortearValor();
	},
	
	sortearTempoDeRecepcao: function () {
		return this.distribuicaoTempoDeRecepcao.sortearValor();
	},
	
	sortearTempoDeServico: function () {
		return this.distribuicaoTempoDeServico.sortearValor();
	},
	
	contar: function () {
		this.utilizacoes++;
	},
	
	fornecerQuantidade: function () {
		return this.utilizacoes;
	},
	
	destinoLocal: function () {
		return (this.localParaLocal() || this.remotoParaLocal());
	},
	
	destinoRemoto: function () {
		return (this.localParaRemoto() || this.remotoParaRemoto());
	},
	
	localParaLocal: function () {
		return (this === TipoDeTrafegoDeMensagem.LL);
	},
	
	localParaRemoto: function () {
		return (this === TipoDeTrafegoDeMensagem.LR);
	},
	
	remotoParaLocal: function () {
		return (this === TipoDeTrafegoDeMensagem.RL);
	},
	
	remotoParaRemoto: function () {
		return (this === TipoDeTrafegoDeMensagem.RR);
	},
	
	comoTexto: function () {
		return this.chave;
	}
});

var SceModelo = new PrototipoUnico({
	inicializarUnico: function () {
		this.configuracoes = {
			gna: {
				semente: Math.pow(2, 19) - 1,
				m: Math.pow(2, 31),
				a: 8 * 99999 + 5,
				b: 0
			},
			
			centroDeServico: {
				quantidadeDeServidoresDoCdsLocal: 2,
				quantidadeDeServidoresDoCdsRemoto: 1
			}
		};
		this.inicializarGna();
	},
	
	inicializarGna: function () {
		var configuracoes = this.configuracoes.gna;
		var estrategiaGna = new CongruenteMisto(configuracoes.a, configuracoes.m, configuracoes.b);
		Gna.instancia(estrategiaGna, configuracoes.semente);
	},
	
	inicializarMonteCarlo: function () {
		this.monteCarloTipoDeTrafegoDeMensagem = new MonteCarlo([
			new ClasseMonteCarlo(TipoDeTrafegoDeMensagem.LL, 50),
			new ClasseMonteCarlo(TipoDeTrafegoDeMensagem.LR, 25),
			new ClasseMonteCarlo(TipoDeTrafegoDeMensagem.RL, 15),
			new ClasseMonteCarlo(TipoDeTrafegoDeMensagem.RR, 10)
		]);
	},
	
	sortearTipoDeTrafegoDeMensagem: function () {
		return this.monteCarloTipoDeTrafegoDeMensagem.sortearClasse();
	},
	
	fixarConfiguracaoSemente: function (semente) {
		var fixado = Gna.instancia.fixarSemente(semente);
		if (fixado) {
			this.configuracoes.gna.semente = semente;
		}
		return fixado;
	},
	
	fixarConfiguracaoEstrategiaDeGeracao: function (a, m, b) {
		var fixado = Gna.instancia.fixarEstrategiaDeGeracao(new CongruenteMisto(a, m, b));
		if (fixado) {
			this.configuracoes.gna.a = a;
			this.configuracoes.gna.b = b;
			this.configuracoes.gna.m = m;
		}
		return fixado;
	},
	
	fixarConfiguracaoQuantidadeDeServidores: function (quantidadeDeServidoresDoCdsLocal, quantidadeDeServidoresDoCdsRemoto) {
		var simulacaoIniciada = SceSimulacao.instancia.foiIniciada();
		if (!simulacaoIniciada) {
			this.configuracoes.centroDeServico.quantidadeDeServidoresDoCdsLocal = quantidadeDeServidoresDoCdsLocal;
			this.configuracoes.centroDeServico.quantidadeDeServidoresDoCdsRemoto = quantidadeDeServidoresDoCdsRemoto;
		}
		return !simulacaoIniciada;
	},
	
	fornecerQuantidadeDeServidoresDoCdsLocal: function () {
		return this.configuracoes.centroDeServico.quantidadeDeServidoresDoCdsLocal;
	},
	
	fornecerQuantidadeDeServidoresDoCdsRemoto: function () {
		return this.configuracoes.centroDeServico.quantidadeDeServidoresDoCdsRemoto;
	}
});
SceModelo.instancia().inicializarMonteCarlo();

