//"use strict";
/*global Linda*/
/*global PrototipoUnico*/
/*global Prototipo*/
/*global EnumeracaoDeConstantes*/
/*global SceModelo*/
/*global TipoDeMensagem*/
/*global TipoDeTrafegoDeMensagem*/
/*jshint
	bitwise: true,
	camelcase: true,
	curly: true,
	eqeqeq: true,
	forin: true,
	immed: true,
	latedef: true,
	newcap: true,
	noarg: true,
	noempty: true,
	nonew: false,
	plusplus: false,
	quotmark: "double",
	regexp: true,
	undef: true,
	unused: true,
	strict: true,
	trailing: true,
	indent: 4,
	maxparams: 3,
	maxdepth: 1,
	maxstatements: 10,
	maxcomplexity: 2,
	maxlen: 128
	asi: false,
	boss: false,
	debug: false,
	eqnull: false,
	es5: false,
	esnext: false,
	evil: false,
	expr: false,
	globalstrict: true,
	funcscope: false,
	iterator: false,
	lastsemic: false,
	laxbreak: false,
	laxcomma: false,
	loopfunc: false,
	multistr: false,
	onecase: false,
	proto: false,
	regexdash: false,
	scripturl: false,
	smarttabs: false,
	shadow: false,
	sub: false,
	supernew: false,
	browser: true
*/
/*jshint latedef: false*/

var EventoDeSimulacao = new Prototipo({
	inicializar: function (tempoDeDisparoNoRelogio, tipo, funcaoDeExecucao) {
		this.tempoDeDisparoNoRelogio = tempoDeDisparoNoRelogio;
		this.tipo = tipo;
		this.disparar = funcaoDeExecucao;
	},
	
	maisRecente: function (outroEvento) {
		return (this.tempoDeDisparoNoRelogio < outroEvento.tempoDeDisparoNoRelogio);
	},
	
	fornecerTempoDeDisparoNoRelogio: function () {
		return this.tempoDeDisparoNoRelogio;
	},
	
	fornecerTipo: function () {
		return this.tipo;
	},
	
	fixarMensagem: function (mensagem) {
		this.mensagem = mensagem;
	}
});

var TipoDeEventoDeSimulacao = new EnumeracaoDeConstantes({
	INICIO: "Início",
	CHEGADA_DE_MENSAGEM_NO_CDR: "Chegada no CDR",
	CHEGADA_DE_MENSAGEM_NO_CDS_LOCAL: "Chegada no CDS local",
	CHEGADA_DE_MENSAGEM_NO_CDS_REMOTO: "Chegada no CDS remoto",
	ADIAMENTO_DE_MENSAGEM_NO_CDS: "Adiamento no CDS",
	CHEGADA_DE_MENSAGEM_NO_CDD_FRACASSO: "Chegada no CDD fracasso",
	CHEGADA_DE_MENSAGEM_NO_CDD_SUCESSO: "Chegada no CDD sucesso",
	FIM: "Fim"
});

var CentroDeRecepcao = new Prototipo({
	inicializar: function (cdsLocal, cdsRemoto) {
		this.cdsLocal = cdsLocal;
		this.cdsRemoto = cdsRemoto;
		this.quantidadeDeMensagens = 0;
	},
	
	receberMensagem: function (mensagem) {
		SceSimulacao.instancia.receberEntradaDeMensagemNoSistema();
		this.quantidadeDeMensagens++;
		var tempoDeRecepcao = mensagem.sortearTempoDeRecepcao();
		var tempoNoRelogio = SceSimulacao.instancia.calcularTempoFuturoNoRelogio(tempoDeRecepcao);
		var evento = this.processarMensagem(tempoNoRelogio, mensagem);
		SceSimulacao.instancia.gerarMensagem();
		SceSimulacao.instancia.adicionarEventoFuturo(evento);
	},
	
	despacharMensagem: function (cds, mensagem) {
		this.quantidadeDeMensagens--;
		mensagem.entrarNoCds(SceSimulacao.instancia.fornecerTempoNoRelogio());
		cds.receberMensagem(mensagem);
	},
	
	processarMensagem: function (tempoNoRelogio, mensagem) {
		/*jshint maxcomplexity: 3*/
		var cds;
		var tipoDeEventoDeSimulacao;
		if (mensagem.destinoLocal()) {
			cds = this.cdsLocal;
			tipoDeEventoDeSimulacao = TipoDeEventoDeSimulacao.CHEGADA_DE_MENSAGEM_NO_CDS_LOCAL;
		} else if (mensagem.destinoRemoto()) {
			cds = this.cdsRemoto;
			tipoDeEventoDeSimulacao = TipoDeEventoDeSimulacao.CHEGADA_DE_MENSAGEM_NO_CDS_REMOTO;
		}
		var evento = new EventoDeSimulacao(tempoNoRelogio, tipoDeEventoDeSimulacao, function () {
			this.despacharMensagem(cds, mensagem);
		}.vincularEscopo(this));
		evento.fixarMensagem(mensagem);
		return evento;
	},
	
	fornecerQuantidadeDeMensagens: function () {
		return this.quantidadeDeMensagens;
	}
});

var CentroDeServico = new Prototipo({
	inicializar: function (cddSucesso, cddFracasso, quantidadeDeServidores) {
		this.cddSucesso = cddSucesso;
		this.cddFracasso = cddFracasso;
		this.quantidadeDeServidores = quantidadeDeServidores;
		this.quantidadeDeServidoresOcupados = 0;
		this.quantidadeDeMensagens = 0;
		this.mensagens = [];
		this.ultimoTempoNoRelogio = 0;
		this.somatorioDasTaxasDeOcupacao = 0;
	},
	
	receberMensagem: function (mensagem) {
		this.quantidadeDeMensagens++;
		this.mensagens.push(mensagem);
		if (this.existemServidoresLivres() && this.existemMensagensPendentes()) {
			this.ocuparServidor(SceSimulacao.instancia.fornecerTempoNoRelogio());
			mensagem = this.mensagens.shift();
			var tempoDeServico = mensagem.sortearTempoDeServico();
			var tempoNoRelogio = SceSimulacao.instancia.calcularTempoFuturoNoRelogio(tempoDeServico);
			var evento = this.processarMensagem(tempoNoRelogio, mensagem);
			SceSimulacao.instancia.adicionarEventoFuturo(evento);
		}
	},
	
	despacharMensagem: function (cdx, mensagem) {
		var tempoNoRelogio = SceSimulacao.instancia.fornecerTempoNoRelogio();
		this.quantidadeDeMensagens--;
		this.liberarServidor(tempoNoRelogio);
		mensagem.entrarNoCdx(tempoNoRelogio);
		cdx.receberMensagem(mensagem);
		if (cdx !== this && this.existemMensagensPendentes()) {
			this.quantidadeDeMensagens--;
			this.receberMensagem(this.mensagens.pop());
		}
	},
	
	processarMensagem: function (tempoNoRelogio, mensagem) {
		/*jshint maxcomplexity: 4, maxstatements: 12*/
		var cdx;
		var tipoDeEventoDeSimulacao;
		if (mensagem.sucesso()) {
			cdx = this.cddSucesso;
			tipoDeEventoDeSimulacao = TipoDeEventoDeSimulacao.CHEGADA_DE_MENSAGEM_NO_CDD_SUCESSO;
		} else if (mensagem.fracasso()) {
			cdx = this.cddFracasso;
			tipoDeEventoDeSimulacao = TipoDeEventoDeSimulacao.CHEGADA_DE_MENSAGEM_NO_CDD_FRACASSO;
		} else if (mensagem.adiamento()) {
			cdx = this;
			tipoDeEventoDeSimulacao = TipoDeEventoDeSimulacao.ADIAMENTO_DE_MENSAGEM_NO_CDS;
		}
		var evento = new EventoDeSimulacao(tempoNoRelogio, tipoDeEventoDeSimulacao, function () {
			this.despacharMensagem(cdx, mensagem);
		}.vincularEscopo(this));
		evento.fixarMensagem(mensagem);
		return evento;
	},
	
	existemMensagensPendentes: function () {
		return (this.mensagens.length > 0);
	},
	
	existemServidoresLivres: function () {
		return (this.quantidadeDeServidores > this.quantidadeDeServidoresOcupados);
	},
	
	ocuparServidor: function (tempoNoRelogio) {
		var diferencaNoTempo = (tempoNoRelogio - this.ultimoTempoNoRelogio);
		this.ultimoTempoNoRelogio = tempoNoRelogio;
		this.somatorioDasTaxasDeOcupacao +=
				(diferencaNoTempo * (this.quantidadeDeServidoresOcupados / this.quantidadeDeServidores));
		this.quantidadeDeServidoresOcupados++;
	},
	
	liberarServidor: function (tempoNoRelogio) {
		var diferencaNoTempo = (tempoNoRelogio - this.ultimoTempoNoRelogio);
		this.ultimoTempoNoRelogio = tempoNoRelogio;
		this.somatorioDasTaxasDeOcupacao +=
				(diferencaNoTempo * (this.quantidadeDeServidoresOcupados / this.quantidadeDeServidores));
		this.quantidadeDeServidoresOcupados--;
	},
	
	fornecerQuantidadeDeMensagens: function () {
		return this.quantidadeDeMensagens;
	},
	
	fornecerOcupacaoDosServidores: function () {
		return Linda.formatar("%$/%$", this.quantidadeDeServidoresOcupados, this.quantidadeDeServidores);
	},
	
	calcularTaxaDeOcupacaoDosServidores: function () {
		return (this.somatorioDasTaxasDeOcupacao / this.ultimoTempoNoRelogio);
	}
});

var CentroDeDespacho = new Prototipo({
	inicializar: function () {
		//performance
		//this.mensagens = [];
		this.quantidadeDeMensagens = 0;
		this.mensagemComTempoMinimoDeTransito = null;
		this.mensagemComTempoMaximoDeTransito = null;
		this.tempoTotalDeTransito = 0;
	},
	
	receberMensagem: function (mensagem) {
		SceSimulacao.instancia.receberSaidaDeMensagemNoSistema();
		//performance
		//this.mensagens.push(mensagem);
		this.quantidadeDeMensagens++;
		this.tempoTotalDeTransito += mensagem.calcularTempoDeTransito();
		this.atualizarMensagemComTempoMinimoDeTransito(mensagem);
		this.atualizarMensagemComTempoMaximoDeTransito(mensagem);
	},
	
	atualizarMensagemComTempoMinimoDeTransito: function (mensagem) {
		if (Linda.nulo(this.mensagemComTempoMinimoDeTransito) ||
				mensagem.menorTempoDeTransito(this.mensagemComTempoMinimoDeTransito)) {
			this.mensagemComTempoMinimoDeTransito = mensagem;
		}
	},
	
	atualizarMensagemComTempoMaximoDeTransito: function (mensagem) {
		if (Linda.nulo(this.mensagemComTempoMaximoDeTransito) ||
				mensagem.maiorTempoDeTransito(this.mensagemComTempoMaximoDeTransito)) {
			this.mensagemComTempoMaximoDeTransito = mensagem;
		}
	},
	
	coletarEstatisticas: function (estatistico) {
		estatistico.adicionarTempoDeTransito(this.tempoTotalDeTransito);
		estatistico.adicionarQuantidadeDeMensagens(this.quantidadeDeMensagens);
		estatistico.adicionarMensagemComTempoMinimoDeTransito(this.mensagemComTempoMinimoDeTransito);
		estatistico.adicionarMensagemComTempoMaximoDeTransito(this.mensagemComTempoMaximoDeTransito);
	},
	
	fornecerQuantidadeDeMensagens: function () {
		return this.quantidadeDeMensagens;
	}
});

var Mensagem = new Prototipo({
	contador: 0,
	
	inicializar: function (tipoDeTrafego) {
		this.identificador = ++Mensagem.prototype.contador;
		this.tipoDeTrafego = tipoDeTrafego;
		this.adiamentos = -1;
	},
	
	entrarNoCdr: function (tempoDeEntradaNoCdrNoRelogio) {
		this.tempoDeEntradaNoCdrNoRelogio = tempoDeEntradaNoCdrNoRelogio;
	},
	
	entrarNoCds: function (tempoDeEntradaNoCdsNoRelogio) {
		this.tempoDeEntradaNoCdsNoRelogio = tempoDeEntradaNoCdsNoRelogio;
	},
	
	entrarNoCdx: function (tempoDeEntradaNoCdxNoRelogio) {
		this.tempoDeEntradaNoCdxNoRelogio = tempoDeEntradaNoCdxNoRelogio;
		this.tempoDeTransito = (this.tempoDeEntradaNoCdxNoRelogio - this.tempoDeEntradaNoCdsNoRelogio);
	},
	
	sortearTempoDeRecepcao: function () {
		this.tipoDeTrafego.contar();
		return this.tipoDeTrafego.sortearTempoDeRecepcao();
	},
	
	sortearTempoDeServico: function () {
		this.adiamentos++;
		this.tipo = this.tipoDeTrafego.sortearTipoDeMensagem();
		this.tipo.contar();
		return this.tipoDeTrafego.sortearTempoDeServico();
	},
	
	destinoLocal: function () {
		return this.tipoDeTrafego.destinoLocal();
	},
	
	destinoRemoto: function () {
		return this.tipoDeTrafego.destinoRemoto();
	},
	
	sucesso: function () {
		return this.tipo.sucesso();
	},
	
	fracasso: function () {
		return this.tipo.fracasso();
	},
	
	adiamento: function () {
		return this.tipo.adiamento();
	},
	
	calcularTempoDeTransito: function () {
		return this.tempoDeTransito;
	},
	
	maiorTempoDeTransito: function (outraMensagem) {
		return (this.tempoDeTransito > outraMensagem.calcularTempoDeTransito());
	},
	
	menorTempoDeTransito: function (outraMensagem) {
		return (this.tempoDeTransito < outraMensagem.calcularTempoDeTransito());
	}
});

var Fotografia = new Prototipo({
	inicializar: function () {
		
	}
});

var Estatistico = new Prototipo({
	inicializar: function () {
		this.tempoTotalDeTransito = 0;
		this.quantidadeDeMensagens =  0;
		this.mensagemComTempoMinimoDeTransito = null;
		this.mensagemComTempoMaximoDeTransito = null;
	},
	
	adicionarTempoDeTransito: function (incrementoNoTempoTotalDeTransito) {
		this.tempoTotalDeTransito += incrementoNoTempoTotalDeTransito;
	},
	
	adicionarQuantidadeDeMensagens: function (incrementoNaQuantidadeDeMensagens) {
		this.quantidadeDeMensagens += incrementoNaQuantidadeDeMensagens;
	},
	
	adicionarMensagemComTempoMinimoDeTransito: function (mensagem) {
		if (!Linda.nulo(mensagem) && (Linda.nulo(this.mensagemComTempoMinimoDeTransito) ||
				mensagem.menorTempoDeTransito(this.mensagemComTempoMinimoDeTransito))) {
			this.mensagemComTempoMinimoDeTransito = mensagem;
		}
	},
	
	adicionarMensagemComTempoMaximoDeTransito: function (mensagem) {
		if (!Linda.nulo(mensagem) && (Linda.nulo(this.mensagemComTempoMaximoDeTransito) ||
				mensagem.maiorTempoDeTransito(this.mensagemComTempoMaximoDeTransito))) {
			this.mensagemComTempoMaximoDeTransito = mensagem;
		}
	},
	
	calcularTempoMedioDeTransito: function () {
		return (this.tempoTotalDeTransito / this.quantidadeDeMensagens);
	},
	
	calcularTempoMinimoDeTransito: function () {
		return ((Linda.nulo(this.mensagemComTempoMinimoDeTransito)) ?
				Number.NaN :
				this.mensagemComTempoMinimoDeTransito.calcularTempoDeTransito());
	},
	
	calcularTempoMaximoDeTransito: function () {
		return ((Linda.nulo(this.mensagemComTempoMaximoDeTransito)) ?
				Number.NaN :
				this.mensagemComTempoMaximoDeTransito.calcularTempoDeTransito());
	}
});

var SceSimulacao = new PrototipoUnico({
	inicializarUnico: function () {
		/*jshint maxstatements: 13*/
		this.iniciada = false;
		this.finalizada = false;
		this.relogio = 0;
		this.eventosFuturos = [];
		this.eventosPassados = [];
		this.fotografias = [];
		this.interessados = [];
		this.ultimoTempoNoRelogioDeMudancaNasMensagensDoSistema = 0;
		this.quantidadeDeMensagensNoSistema = 0;
		this.quantidadeMinimaDeMensagensNoSistema = null;
		this.quantidadeMaximaDeMensagensNoSistema = null;
		this.somatoriaDaTaxaMediaDeMensagensNoSistema = 0;
	},
	
	iniciar: function () {
		this.iniciada = true;
		var quantidadeDeServidoresDoCdsLocal = SceModelo.instancia.fornecerQuantidadeDeServidoresDoCdsLocal();
		var quantidadeDeServidoresDoCdsRemoto = SceModelo.instancia.fornecerQuantidadeDeServidoresDoCdsRemoto();
		this.cddSucesso = new CentroDeDespacho();
		this.cddFracasso = new CentroDeDespacho();
		this.cdsLocal = new CentroDeServico(this.cddSucesso, this.cddFracasso, quantidadeDeServidoresDoCdsLocal);
		this.cdsRemoto = new CentroDeServico(this.cddSucesso, this.cddFracasso, quantidadeDeServidoresDoCdsRemoto);
		this.cdr = new CentroDeRecepcao(this.cdsLocal, this.cdsRemoto);
		this.adicionarEventoFuturo(new EventoDeSimulacao(this.relogio, TipoDeEventoDeSimulacao.INICIO, function () {
			this.gerarMensagem();
		}.vincularEscopo(this)));
	},
	
	finalizar: function () {
		this.eventosFuturos = [];
		this.adicionarEventoFuturo(new EventoDeSimulacao(this.relogio, TipoDeEventoDeSimulacao.FIM, function () {
			this.gerarMensagem();
		}.vincularEscopo(this)));
		this.dispararProximoEvento();
		this.finalizada = true;
	},
	
	dispararProximoEvento: function () {
		this.ordenarEventosFuturos();
		if (this.eventosFuturos.length > 0 && this.iniciada && !this.parada && !this.finalizada) {
			var proximoEvento = this.eventosFuturos.pop();
			this.eventosPassados.push(proximoEvento);
			this.relogio = proximoEvento.fornecerTempoDeDisparoNoRelogio();
			proximoEvento.disparar();
			this.tirarFotografiaDoSistema();
			this.interessados.paraCada(function (interessado) {
				interessado(this.eventosPassados, this.fotografias);
			}, this);
			//performance
			this.eventosPassados.pop();
		}
	},
	
	receberEntradaDeMensagemNoSistema: function () {
		var diferencaNoTempo = (this.relogio - this.ultimoTempoNoRelogioDeMudancaNasMensagensDoSistema);
		this.ultimoTempoNoRelogioDeMudancaNasMensagensDoSistema = this.relogio;
		this.somatoriaDaTaxaMediaDeMensagensNoSistema += (diferencaNoTempo * this.quantidadeDeMensagensNoSistema);
		this.quantidadeDeMensagensNoSistema++;
		this.calcularQuantidadeMinimaDeMensagensNoSistema();
		this.calcularQuantidadeMaximaDeMensagensNoSistema();
	},
	
	receberSaidaDeMensagemNoSistema: function () {
		var diferencaNoTempo = (this.relogio - this.ultimoTempoNoRelogioDeMudancaNasMensagensDoSistema);
		this.ultimoTempoNoRelogioDeMudancaNasMensagensDoSistema = this.relogio;
		this.somatoriaDaTaxaMediaDeMensagensNoSistema += (diferencaNoTempo * this.quantidadeDeMensagensNoSistema);
		this.quantidadeDeMensagensNoSistema--;
		this.calcularQuantidadeMinimaDeMensagensNoSistema();
		this.calcularQuantidadeMaximaDeMensagensNoSistema();
	},
	
	calcularTaxaMediaDeMensagensNoSistema: function () {
		return (this.somatoriaDaTaxaMediaDeMensagensNoSistema / this.ultimoTempoNoRelogioDeMudancaNasMensagensDoSistema);
	},
	
	calcularQuantidadeDeMensagensNoSistema: function () {
		return this.quantidadeDeMensagensNoSistema;
	},
	
	calcularQuantidadeMinimaDeMensagensNoSistema: function () {
		if (Linda.nulo(this.quantidadeMaximaDeMensagensNoSistema) ||
				this.quantidadeDeMensagensNoSistema > this.quantidadeMaximaDeMensagensNoSistema) {
			this.quantidadeMaximaDeMensagensNoSistema = this.quantidadeDeMensagensNoSistema;
		}
	},
	
	calcularQuantidadeMaximaDeMensagensNoSistema: function () {
		if (Linda.nulo(this.quantidadeMinimaDeMensagensNoSistema) ||
				this.quantidadeDeMensagensNoSistema < this.quantidadeMinimaDeMensagensNoSistema) {
			this.quantidadeMinimaDeMensagensNoSistema = this.quantidadeDeMensagensNoSistema;
		}
	},
	
	calcularTempoFuturoNoRelogio: function (incrementoNoTempo) {
		return (this.relogio + incrementoNoTempo);
	},
	
	fornecerTempoNoRelogio: function () {
		return this.relogio;
	},
	
	fornecerTempoNoRelogioDoProximoEvento: function () {
		this.ordenarEventosFuturos();
		return this.eventosFuturos[this.eventosFuturos.length - 1].fornecerTempoDeDisparoNoRelogio();
	},
	
	adicionarEventoFuturo: function (evento) {
		this.eventosFuturos.push(evento);
	},
	
	ordenarEventosFuturos: function () {
		this.eventosFuturos.sort(function (eventoA, eventoB) {
			return eventoA.maisRecente(eventoB);
		});
	},
	
	tirarFotografiaDoSistema: function () {
		/*jshint maxstatements: 41*/
		var fotografia = new Fotografia();
		var estatistico = new Estatistico();
		var mensagem = this.eventosPassados[this.eventosPassados.length - 1].mensagem;
		var mensagemDefinida = !Linda.nuloOuIndefinido(mensagem);
		var dadoNaoDisponivel = "";
		this.cddSucesso.coletarEstatisticas(estatistico);
		this.cddFracasso.coletarEstatisticas(estatistico);
		fotografia.quantidadeDeMensagensNoCdr = this.cdr.fornecerQuantidadeDeMensagens();
		fotografia.quantidadeDeMensagensNoCdsLocal = this.cdsLocal.fornecerQuantidadeDeMensagens();
		fotografia.quantidadeDeMensagensNoCdsRemoto = this.cdsRemoto.fornecerQuantidadeDeMensagens();
		fotografia.quantidadeDeMensagensNoCddSucesso = this.cddSucesso.fornecerQuantidadeDeMensagens();
		fotografia.quantidadeDeMensagensNoCddFracasso = this.cddFracasso.fornecerQuantidadeDeMensagens();
		fotografia.quantidadeDeMensagensComSucesso = TipoDeMensagem.SUCESSO.fornecerQuantidade();
		fotografia.quantidadeDeMensagensComFracasso = TipoDeMensagem.FRACASSO.fornecerQuantidade();
		fotografia.quantidadeDeAdiamentos = TipoDeMensagem.ADIAMENTO.fornecerQuantidade();
		fotografia.quantidadeDeMensagensLl = TipoDeTrafegoDeMensagem.LL.fornecerQuantidade();
		fotografia.quantidadeDeMensagensLr = TipoDeTrafegoDeMensagem.LR.fornecerQuantidade();
		fotografia.quantidadeDeMensagensRl = TipoDeTrafegoDeMensagem.RL.fornecerQuantidade();
		fotografia.quantidadeDeMensagensRr = TipoDeTrafegoDeMensagem.RR.fornecerQuantidade();
		fotografia.quantidadeDeMensagensRecebidas =
				fotografia.quantidadeDeMensagensLl +
				fotografia.quantidadeDeMensagensLr +
				fotografia.quantidadeDeMensagensRl +
				fotografia.quantidadeDeMensagensRr;
		fotografia.quantidadeDeMensagensNoSistema = this.calcularQuantidadeDeMensagensNoSistema();
		fotografia.quantidadeMinimaDeMensagensNoSistema =
				(!Linda.nulo(this.quantidadeMinimaDeMensagensNoSistema)) ?
				this.quantidadeMinimaDeMensagensNoSistema :
				dadoNaoDisponivel;
		fotografia.quantidadeMaximaDeMensagensNoSistema =
				(!Linda.nulo(this.quantidadeMaximaDeMensagensNoSistema)) ?
				this.quantidadeMaximaDeMensagensNoSistema :
				dadoNaoDisponivel;
		fotografia.taxaMediaDeMensagensNoSistema = this.calcularTaxaMediaDeMensagensNoSistema();
		fotografia.mensagem =  {};
		fotografia.mensagem.identificador = (mensagemDefinida) ? mensagem.identificador : dadoNaoDisponivel;
		fotografia.mensagem.tipoDeTrafego =
				(mensagemDefinida && !Linda.nuloOuIndefinido(mensagem.tipoDeTrafego)) ?
				mensagem.tipoDeTrafego.comoTexto() :
				dadoNaoDisponivel;
		fotografia.mensagem.tipo =
				(mensagemDefinida && !Linda.nuloOuIndefinido(mensagem.tipo)) ?
				mensagem.tipo.comoTexto() :
				dadoNaoDisponivel;
		fotografia.mensagem.adiamentos =
				(mensagemDefinida && mensagem.adiamentos >= 0) ?
					mensagem.adiamentos :
				dadoNaoDisponivel;
		fotografia.mensagem.tempoDeTransito =
				(mensagemDefinida && !Linda.nuloOuIndefinido(mensagem.tipo) && (mensagem.sucesso() || mensagem.fracasso())) ?
				mensagem.calcularTempoDeTransito() :
				dadoNaoDisponivel;
		fotografia.mensagem.entradaNoCdr =
				(mensagemDefinida && !Linda.nuloOuIndefinido(mensagem.tempoDeEntradaNoCdrNoRelogio)) ?
				mensagem.tempoDeEntradaNoCdrNoRelogio :
				dadoNaoDisponivel;
		fotografia.mensagem.entradaNoCds =
				(mensagemDefinida && !Linda.nuloOuIndefinido(mensagem.tempoDeEntradaNoCdsNoRelogio)) ?
				mensagem.tempoDeEntradaNoCdsNoRelogio :
				dadoNaoDisponivel;
		fotografia.mensagem.entradaNoCdd =
				(mensagemDefinida && !Linda.nuloOuIndefinido(mensagem.tipo) && (mensagem.sucesso() || mensagem.fracasso())) ?
				mensagem.tempoDeEntradaNoCdxNoRelogio :
				dadoNaoDisponivel;
		fotografia.ocupacaoDosServidoresDoCdsLocal = this.cdsLocal.fornecerOcupacaoDosServidores();
		fotografia.ocupacaoDosServidoresDoCdsRemoto = this.cdsRemoto.fornecerOcupacaoDosServidores();
		fotografia.taxaDeOcupacaoDosServidoresDoCdsLocal =
				(!Linda.naoNumero(this.cdsLocal.calcularTaxaDeOcupacaoDosServidores())) ?
				this.cdsLocal.calcularTaxaDeOcupacaoDosServidores() :
				dadoNaoDisponivel;
		fotografia.taxaDeOcupacaoDosServidoresDoCdsRemoto =
				(!Linda.naoNumero(this.cdsRemoto.calcularTaxaDeOcupacaoDosServidores())) ?
				this.cdsRemoto.calcularTaxaDeOcupacaoDosServidores() :
				dadoNaoDisponivel;
		fotografia.tempoMedioDeTransito =
				(!Linda.naoNumero(estatistico.calcularTempoMedioDeTransito())) ?
				estatistico.calcularTempoMedioDeTransito() :
				dadoNaoDisponivel;
		fotografia.tempoMinimoDeTransito =
				(!Linda.naoNumero(estatistico.calcularTempoMinimoDeTransito())) ?
				estatistico.calcularTempoMinimoDeTransito() :
				dadoNaoDisponivel;
		fotografia.tempoMaximoDeTransito =
				(!Linda.naoNumero(estatistico.calcularTempoMaximoDeTransito())) ?
				estatistico.calcularTempoMaximoDeTransito() :
				dadoNaoDisponivel;
		this.fotografias.push(fotografia);
	},
	
	gerarMensagem: function () {
		var tipoDeTrafegoDeMensagem = SceModelo.instancia.sortearTipoDeTrafegoDeMensagem();
		var tempoEntreChegadas = tipoDeTrafegoDeMensagem.sortearTempoEntreChegadas();
		var tempoNoRelogio = this.calcularTempoFuturoNoRelogio(tempoEntreChegadas);
		var mensagem = new Mensagem(tipoDeTrafegoDeMensagem);
		var evento = new EventoDeSimulacao(tempoNoRelogio, TipoDeEventoDeSimulacao.CHEGADA_DE_MENSAGEM_NO_CDR, function () {
			this.despacharMensagem(mensagem);
		}.vincularEscopo(this));
		evento.fixarMensagem(mensagem);
		this.adicionarEventoFuturo(evento);
	},
	
	despacharMensagem: function (mensagem) {
		mensagem.entrarNoCdr(this.relogio);
		this.cdr.receberMensagem(mensagem);
	},
	
	foiIniciada: function () {
		return this.iniciada;
	},
	
	foiFinalizada: function () {
		return this.finalizada;
	},
	
	registrarInteressado: function (interessado) {
		this.interessados.push(interessado);
	}
});
SceSimulacao.instancia();

