//"use strict";
/*global Linda*/
/*global PrototipoUnico*/
/*global TratadorDePagina*/
/*global TratadorDeMouse*/
/*global SceSimulacao*/
/*global SceModelo*/
/*global Gna*/
/*global TipoDeTrafegoDeMensagem*/
/*jshint bitwise: true, camelcase: true, curly: true, eqeqeq: true, forin: true, immed: true, latedef: true, newcap: true, noarg: true, noempty: true, nonew: false, plusplus: false, quotmark: "double", regexp: true, undef: true, unused: true, strict: true, trailing: true, indent: 4, maxparams: 3, maxdepth: 1, maxstatements: 10, maxcomplexity: 2, maxlen: 128 asi: false, boss: false, debug: false, eqnull: false, es5: false, esnext: false, evil: false, expr: false, globalstrict: true, funcscope: false, iterator: false, lastsemic: false, laxbreak: false, laxcomma: false, loopfunc: false, multistr: false, onecase: false, proto: false, regexdash: false, scripturl: false, smarttabs: false, shadow: false, sub: false, supernew: false, browser: true*/

var SceControle = new PrototipoUnico({
	inicializarUnico: function () {
		new TratadorDePagina().paraCarregada(this.iniciar.vincularEscopo(this));
		SceSimulacao.instancia.registrarInteressado(this.atualizarSimulacao.vincularEscopo(this));
		this.velocidadePadrao = 60;
		this.velocidadeMinima = 1;
		this.velocidadeMaxima = 6000;
		this.historicoMaximo = 50;
	},
	
	iniciar: function () {
		this.atualizarTabelasEConfiguracoes();
		this.adicionarTratadores();
	},
	
	adicionarTratadores: function () {
		Gna.instancia.registrarInteressado(this.atualizarTabelaGna.vincularEscopo(this));
		new TratadorDeMouse(Linda.selecionar("tbody.eventos")).paraClique(function (evento) {
			this.selecionarEvento(evento.target.parentNode, evento.currentTarget.childNodes.length - evento.target.parentNode.rowIndex);
		}.vincularEscopo(this));
		new TratadorDeMouse(Linda.obterPeloNome("velocidadeDaLuz"))
				.paraClique(function (evento) {
					if (evento.currentTarget.checked) {
						var historicoLimitado = Linda.obterPeloNome("historicoLimitado")
						if (!historicoLimitado.checked) { 
							historicoLimitado.click();
						}
						this.mostrarAviso("É recomendável que se utilize a opção <strong>Histórico limitado</strong> quando for executar na velocidade da luz. Como existirão muitas mensagens, guardar o histórico de todas elas pode consumir muita memória do seu computador. Ao utilizar a opção Velocidade da luz, o <strong>Histórico limitado</strong> é habilitado por padrão, mas você pode desabilitá-lo se quiser.");
					}
				}.vincularEscopo(this));
		new TratadorDeMouse(Linda.selecionar("button.iniciarSimulacao"))
				.paraClique(this.iniciarSimulacao.vincularEscopo(this));
		new TratadorDeMouse(Linda.selecionar("button.simularContinuamente"))
				.paraClique(this.simularContinuamente.vincularEscopo(this));
		new TratadorDeMouse(Linda.selecionar("button.simularProximo"))
				.paraClique(this.simularProximo.vincularEscopo(this));
		new TratadorDeMouse(Linda.selecionar("button.simularAteOTempo"))
				.paraClique(this.simularAteOTempo.vincularEscopo(this));
		new TratadorDeMouse(Linda.selecionar("button.pararSimulacao"))
				.paraClique(this.pararSimulacao.vincularEscopo(this));
		new TratadorDeMouse(Linda.selecionar("button.finalizarSimulacao"))
				.paraClique(this.finalizarSimulacao.vincularEscopo(this));
		new TratadorDeMouse(Linda.selecionar("button.salvarSemente"))
				.paraClique(this.salvarSemente.vincularEscopo(this));
		new TratadorDeMouse(Linda.selecionar("button.salvarEstrategiaDeGeracao"))
				.paraClique(this.salvarEstrategiaDeGeracao.vincularEscopo(this));
		new TratadorDeMouse(Linda.selecionar("button.salvarQuantidadeDeServidores"))
				.paraClique(this.salvarQuantidadeDeServidores.vincularEscopo(this));
		new TratadorDeMouse(Linda.selecionar("p.caixaDeMensagem"))
				.paraClique(this.esconderMensagem.vincularEscopo(this));
	},
	
	atualizarTabelasEConfiguracoes: function () {
		this.atualizarTabelaMonteCarloTipoDeTrafegoDeMensagem();
		this.atualizarTabelaMonteCarloTipoDeMensagemLl();
		this.atualizarTabelaMonteCarloTipoDeMensagemLr();
		this.atualizarTabelaMonteCarloTipoDeMensagemRl();
		this.atualizarTabelaMonteCarloTipoDeMensagemRr();
		this.atualizarTabelaDistribuicaoTempoEntreChegadas();
		this.atualizarTabelaDistribuicaoTempoDeRecepcao();
		this.atualizarTabelaDistribuicaoTempoDeServico();
		this.atualizarConfiguracoes();
	},
	
	esconderMensagem: function () {
		Linda.selecionar("p.caixaDeMensagem").innerHTML = "";
	},
	
	mostrar: function (mensagem, classe, campos) {
		campos = (Linda.nuloOuIndefinido(campos)) ? [] : campos;
		campos.paraCada(function (campo) {
			campo.classList.remove("sucesso");
			campo.classList.remove("informacao");
			campo.classList.remove("erro");
			campo.classList.remove("aviso");
			campo.classList.add(classe);
		});
		var caixaDeMensagem = Linda.selecionar("p.caixaDeMensagem");
		caixaDeMensagem.innerHTML = mensagem;
		caixaDeMensagem.classList.remove("sucesso");
		caixaDeMensagem.classList.remove("informacao");
		caixaDeMensagem.classList.remove("erro");
		caixaDeMensagem.classList.remove("aviso");
		caixaDeMensagem.classList.add(classe);
	},
	
	mostrarSucesso: function (mensagem, campos) {
		this.mostrar(mensagem, "sucesso", campos);
	},
	
	mostrarInformacao: function (mensagem, campos) {
		this.mostrar(mensagem, "informacao", campos);
	},
	
	mostrarErro: function (mensagem, campos) {
		this.mostrar(mensagem, "erro", campos);
	},
	
	mostrarAviso: function (mensagem, campos) {
		this.mostrar(mensagem, "aviso", campos);
	},
	
	iniciarSimulacao: function () {
		if (SceSimulacao.instancia.foiIniciada()) {
			this.mostrarAviso("Não foi possível iniciar a simulação. A simulação já foi iniciada.");
		} else {
			SceSimulacao.instancia.iniciar();
			this.mostrarSucesso("Simulação iniciada com sucesso.");
		}
	},
	
	simularProximo: function () {
		if (SceSimulacao.instancia.foiIniciada() &&
				!SceSimulacao.instancia.foiFinalizada()) {
			Linda.janela().clearTimeout(this.temporizador);
			SceSimulacao.instancia.dispararProximoEvento();
			this.mostrarSucesso("Simulação do próximo evento realizada com sucesso.");
		} else {
			this.mostrarErro(Linda
					.concatenarComEspaco("Não foi possível simular o próximo evento.",
					"Certifique-se que a simulação já foi iniciada e não foi finalizada."));
		}
	},
	
	simularContinuamente: function () {
		if (SceSimulacao.instancia.foiIniciada() &&
				!SceSimulacao.instancia.foiFinalizada()) {
			this.simularContinuamenteComTemporizador();
			this.mostrarSucesso("Simulação contínua iniciada com sucesso.");
		} else {
			this.mostrarErro(Linda
					.concatenarComEspaco("Não foi possível simular contínuamente.",
					"Certifique-se que a simulação já foi iniciada e não foi finalizada."));
		}
	},
	
	simularContinuamenteComTemporizador: function () {
		Linda.janela().clearTimeout(this.temporizador);
		SceSimulacao.instancia.dispararProximoEvento();
		if (Linda.obterPeloNome("velocidadeDaLuz").checked) {
			for (var contador = 0; contador < 99; contador++) {
				SceSimulacao.instancia.dispararProximoEvento();
			}
		}
		this.temporizador = Linda.janela().setTimeout(function () {
			this.simularContinuamenteComTemporizador();
		}.vincularEscopo(this), this.obterVelocidadeDeSimulacao());
	},
	
	simularAteOTempo: function () {
		if (SceSimulacao.instancia.foiIniciada() &&
				!SceSimulacao.instancia.foiFinalizada()) {
			var tempo = Linda.paraFlutuante(Linda.obterPeloNome("tempoFinalDaSimulacao").value);
			if (!Linda.naoNumero(tempo)) {
				this.simularAteOTempoComTemporizador(tempo);
				this.mostrarSucesso("Simulação até o tempo iniciada com sucesso.");
			} else {
				this.mostrarErro("Não foi possível simular até o tempo. Cerfitique-se que foi informado um tempo final válido.");
			}
		} else {
			this.mostrarErro(Linda
					.concatenarComEspaco("Não foi possível simular até o tempo.",
					"Certifique-se que a simulação já foi iniciada e não foi finalizada."));
		}
	},
	
	simularAteOTempoComTemporizador: function (tempoLimite) {
		Linda.janela().clearTimeout(this.temporizador);
		if (SceSimulacao.instancia.fornecerTempoNoRelogioDoProximoEvento() < tempoLimite) {
			SceSimulacao.instancia.dispararProximoEvento();
			if (Linda.obterPeloNome("velocidadeDaLuz").checked) {
				var contador = 0;
				while (contador < 99 && SceSimulacao.instancia.fornecerTempoNoRelogioDoProximoEvento() < tempoLimite) {
					SceSimulacao.instancia.dispararProximoEvento();
					contador++;
				}
			}
			this.temporizador = Linda.janela().setTimeout(function () {
				this.simularAteOTempoComTemporizador(tempoLimite);
			}.vincularEscopo(this), this.obterVelocidadeDeSimulacao());
		} else {
			this.finalizarSimulacao();
		}
	},
	
	pararSimulacao: function () {
		Linda.janela().clearTimeout(this.temporizador);
		if (SceSimulacao.instancia.foiIniciada() &&
				!SceSimulacao.instancia.foiFinalizada()) {
			this.mostrarInformacao(Linda
					.concatenarComEspaco("A simulação foi parada. Para retomar a simulação, clique em um dos seguintes botões:",
					"Simular continuamente, Simular próximo ou Simular até o tempo."));
		} else {
			this.mostrarErro(Linda
					.concatenarComEspaco("Não foi possível parar a simulação.",
					"Certifique-se que a simulação já foi iniciada e não foi finalizada."));
		}
	},
	
	finalizarSimulacao: function () {
		Linda.janela().clearTimeout(this.temporizador);
		if (SceSimulacao.instancia.foiIniciada() &&
				!SceSimulacao.instancia.foiFinalizada()) {
			SceSimulacao.instancia.finalizar();
			this.mostrarSucesso("Simulação finalizada com sucesso.");
		} else {
			this.mostrarAviso(Linda
					.concatenarComEspaco("Não foi possível finalizar a simulação.",
					"Certifique-se que a simulação já foi iniciada e não foi finalizada."));
		}
	},
	
	obterVelocidadeDeSimulacao: function () {
		if (Linda.obterPeloNome("velocidadeDaLuz").checked) {
			return 0;
		}
		var velocidade = Linda.paraInteiro(Linda.obterPeloNome("velocidadeDaSimulacao").value);
		if (Linda.instanciaDe(velocidade, Number) && !Linda.naoNumero(velocidade)) {
			if (velocidade < this.velocidadeMinima) {
				velocidade = this.velocidadeMinima;
			}
			if (velocidade > this.velocidadeMaxima) {
				velocidade = this.velocidadeMaxima;
			}
		} else {
			velocidade = this.velocidadePadrao;
		}
		return (60000 / velocidade);
	},
	
	salvarSemente: function () {
		/*jshint maxdepth: 2, maxcomplexity: 3*/
		var campoSemente = Linda.obterPeloNome("semente");
		var semente = Linda.paraInteiro(campoSemente.value);
		if (Linda.naoNumero(semente)) {
			this.mostrarErro(Linda
					.concatenarComEspaco("Não foi possível alterar a configuração <strong>semente</strong>.",
					"O valor deve ser um número."),
					[campoSemente]);
		} else {
			if (SceModelo.instancia.fixarConfiguracaoSemente(semente)) {
				this.mostrarSucesso(Linda
						.concatenarComEspaco("Configuração <strong>semente</strong> alterada com sucesso."),
						[campoSemente]);
			} else {
				this.mostrarErro(Linda
						.concatenarComEspaco("Não é possível alterar a configuração <strong>semente</strong>",
						"após já ter gerado algum número."),
						[campoSemente]);
			}
		}
	},
	
	salvarEstrategiaDeGeracao: function () {
		/*jshint maxstatements: 12, maxdepth: 2, maxcomplexity: 3*/
		var campoA = Linda.obterPeloNome("a");
		var campoB = Linda.obterPeloNome("b");
		var campoM = Linda.obterPeloNome("m");
		var a = Linda.paraInteiro(campoA.value);
		var b = Linda.paraInteiro(campoB.value);
		var m = Linda.paraInteiro(campoM.value);
		if (Linda.naoNumero(a) || Linda.naoNumero(b) || Linda.naoNumero(m)) {
			this.mostrarErro(Linda
				.concatenarComEspaco("Não foi possível alterar a configuração <strong>estretégia de geração</strong>.",
				"Os valores devem ser números."),
				[campoA, campoB, campoM]);
		} else {
			if (SceModelo.instancia.fixarConfiguracaoEstrategiaDeGeracao(campoA.value, campoM.value, campoB.value)) {
				this.mostrarSucesso(Linda
						.concatenarComEspaco("Configuração <strong>estretégia de geração</strong> alterada com sucesso."),
						[campoA, campoB, campoM]);
			} else {
				this.mostrarErro(Linda
						.concatenarComEspaco("Não é possível alterar a configuração <strong>estretégia de geração</strong>",
						"após já ter gerado algum número."),
						[campoA, campoB, campoM]);
			}
		}
	},
	
	salvarQuantidadeDeServidores: function () {
		/*jshint maxdepth: 2, maxcomplexity: 3*/
		var campoQuantidadeDeServidoresDoCds1 = Linda.obterPeloNome("quantidadeDeServidoresDoCds1");
		var campoQuantidadeDeServidoresDoCds2 = Linda.obterPeloNome("quantidadeDeServidoresDoCds2");
		var quantidadeDeServidoresDoCds1 = Linda.paraInteiro(campoQuantidadeDeServidoresDoCds1.value);
		var quantidadeDeServidoresDoCds2 = Linda.paraInteiro(campoQuantidadeDeServidoresDoCds2.value);
		if (Linda.naoNumero(quantidadeDeServidoresDoCds1) ||
					Linda.naoNumero(quantidadeDeServidoresDoCds2) ||
					quantidadeDeServidoresDoCds1 < 0 ||
					quantidadeDeServidoresDoCds2 < 0) {
			this.mostrarErro(Linda
				.concatenarComEspaco("Não foi possível alterar a configurção <strong>quantidade de servidores</strong>.",
				"Os valores devem ser números maiores ou iguais a zero."),
				[campoQuantidadeDeServidoresDoCds1, campoQuantidadeDeServidoresDoCds2]);
		} else {
			if (SceModelo.instancia
						.fixarConfiguracaoQuantidadeDeServidores(quantidadeDeServidoresDoCds1, quantidadeDeServidoresDoCds2)) {
				this.mostrarSucesso(Linda
						.concatenarComEspaco("Configuração <Strong>quantidade de servidores</strong> alterada com sucesso."),
						[campoQuantidadeDeServidoresDoCds1, campoQuantidadeDeServidoresDoCds2]);
			} else {
				this.mostrarErro(Linda
						.concatenarComEspaco("Não é possível alterar a configurção <strong>quantidade de servidores</strong>",
						"após já ter iniciado a simulação."),
						[campoQuantidadeDeServidoresDoCds1, campoQuantidadeDeServidoresDoCds2]);
			}
		}
	},
	
	atualizarSimulacao: function (eventosPassados, fotografias) {
		/*jshint maxstatements: 21*/
		this.eventosPassados = eventosPassados;
		this.fotografias = fotografias;
		var indiceDoEvento = (this.eventosPassados.length - 1);
		var indiceDaFotografia = (this.fotografias.length - 1);
		var precisaoDoRelogio = 2;
		var corpoDaTabelaEventos = Linda.selecionar("tbody.eventos");
		var linhaEvento = Linda.documento().createElement("tr");
		var colunaMensagem = Linda.documento().createElement("td");
		var colunaRelogio = Linda.documento().createElement("td");
		var colunaTipo = Linda.documento().createElement("td");
		var evento = eventosPassados[indiceDoEvento];
		if (!Linda.nuloOuIndefinido(evento.mensagem)) {
			colunaMensagem.textContent = Linda.formatar("#%$", evento.mensagem.identificador);
		}
		colunaRelogio.textContent = evento.tempoDeDisparoNoRelogio.toFixed(precisaoDoRelogio);
		colunaTipo.textContent = evento.tipo;
		linhaEvento.appendChild(colunaMensagem);
		linhaEvento.appendChild(colunaRelogio);
		linhaEvento.appendChild(colunaTipo);
		corpoDaTabelaEventos.insertBefore(linhaEvento, corpoDaTabelaEventos.firstChild);
		this.selecionarEvento(linhaEvento, indiceDaFotografia);
		if (Linda.obterPeloNome("historicoLimitado").checked) {
			while (corpoDaTabelaEventos.childNodes.length > this.historicoMaximo) {
				fotografias.shift();
				corpoDaTabelaEventos.removeChild(corpoDaTabelaEventos.lastChild);
			}
		}
	},
	
	selecionarEvento: function (linhaEvento, indiceDaFotografia) {
		/*jshint maxstatements: 40*/
		var precisaoDoRelogio = 2;
		var precisaoDeTaxa = 2;
		if (!Linda.nuloOuIndefinido(this.eventoSelecionado)) {
			this.eventoSelecionado.classList.remove("selecionado");
		}
		this.eventoSelecionado = linhaEvento;
		this.eventoSelecionado.classList.add("selecionado");
		var fotografia = this.fotografias[indiceDaFotografia];
		var mensagem = fotografia.mensagem;
		Linda.selecionar("tbody.mensagem td.identificador").textContent =
				mensagem.identificador;
		Linda.selecionar("tbody.mensagem td.tipoDeTrafego").textContent =
				mensagem.tipoDeTrafego;
		Linda.selecionar("tbody.mensagem td.tipo").textContent =
				mensagem.tipo;
		Linda.selecionar("tbody.mensagem td.adiamentos").textContent =
				mensagem.adiamentos;
		Linda.selecionar("tbody.mensagem td.tempoDeTransito").textContent =
				(Linda.instanciaDe(mensagem.tempoDeTransito, Number)) ?
				mensagem.tempoDeTransito.toFixed(precisaoDoRelogio) :
				"";
		Linda.selecionar("tbody.mensagem td.entradaNoCdr").textContent =
				(Linda.instanciaDe(mensagem.entradaNoCdr, Number)) ?
				mensagem.entradaNoCdr.toFixed(precisaoDoRelogio) :
				"";
		Linda.selecionar("tbody.mensagem td.entradaNoCds").textContent =
				(Linda.instanciaDe(mensagem.entradaNoCds, Number)) ?
				mensagem.entradaNoCds.toFixed(precisaoDoRelogio) :
				"";
		Linda.selecionar("tbody.mensagem td.entradaNoCdd").textContent =
				(Linda.instanciaDe(mensagem.entradaNoCdd, Number)) ?
				mensagem.entradaNoCdd.toFixed(precisaoDoRelogio) :
				"";
		Linda.selecionar("tbody.variaveis td.mensagensNoSistema").textContent =
				fotografia.quantidadeDeMensagensNoSistema;
		Linda.selecionar("tbody.variaveis td.mensagensRecebidas").textContent =
				fotografia.quantidadeDeMensagensRecebidas;
		Linda.selecionar("tbody.variaveis td.mensagensNoCdr").textContent =
				fotografia.quantidadeDeMensagensNoCdr;
		Linda.selecionar("tbody.variaveis td.mensagensNoCdsLocal").textContent =
				fotografia.quantidadeDeMensagensNoCdsLocal;
		Linda.selecionar("tbody.variaveis td.mensagensNoCdsRemoto").textContent =
				fotografia.quantidadeDeMensagensNoCdsRemoto;
		Linda.selecionar("tbody.variaveis td.mensagensNoCddSucesso").textContent =
				fotografia.quantidadeDeMensagensNoCddSucesso;
		Linda.selecionar("tbody.variaveis td.mensagensNoCddFracasso").textContent =
				fotografia.quantidadeDeMensagensNoCddFracasso;
		Linda.selecionar("tbody.variaveis td.mensagensComSucesso").textContent =
				fotografia.quantidadeDeMensagensComSucesso;
		Linda.selecionar("tbody.variaveis td.mensagensComFracasso").textContent =
				fotografia.quantidadeDeMensagensComFracasso;
		Linda.selecionar("tbody.variaveis td.adiamentos").textContent =
				fotografia.quantidadeDeAdiamentos;
		Linda.selecionar("tbody.variaveis td.mensagensLl").textContent =
				fotografia.quantidadeDeMensagensLl;
		Linda.selecionar("tbody.variaveis td.mensagensLr").textContent =
				fotografia.quantidadeDeMensagensLr;
		Linda.selecionar("tbody.variaveis td.mensagensRl").textContent =
				fotografia.quantidadeDeMensagensRl;
		Linda.selecionar("tbody.variaveis td.mensagensRr").textContent =
				fotografia.quantidadeDeMensagensRr;
		Linda.selecionar("tbody.variaveis td.ocupacaoDosServidoresDoCdsLocal").textContent =
				fotografia.ocupacaoDosServidoresDoCdsLocal;
		Linda.selecionar("tbody.variaveis td.ocupacaoDosServidoresDoCdsRemoto").textContent =
				fotografia.ocupacaoDosServidoresDoCdsRemoto;
		Linda.selecionar("tbody.variaveis td.taxaDeOcupacaoDosServidoresDoCdsLocal").textContent =
				(Linda.instanciaDe(fotografia.taxaDeOcupacaoDosServidoresDoCdsLocal, Number)) ?
				fotografia.taxaDeOcupacaoDosServidoresDoCdsLocal.toFixed(precisaoDeTaxa) :
				"";
		Linda.selecionar("tbody.variaveis td.taxaDeOcupacaoDosServidoresDoCdsRemoto").textContent =
				(Linda.instanciaDe(fotografia.taxaDeOcupacaoDosServidoresDoCdsRemoto, Number)) ?
				fotografia.taxaDeOcupacaoDosServidoresDoCdsRemoto.toFixed(precisaoDeTaxa) :
				"";
		Linda.selecionar("tbody.variaveis td.tempoMedioDeTransito").textContent =
				(Linda.instanciaDe(fotografia.tempoMedioDeTransito, Number)) ?
				fotografia.tempoMedioDeTransito.toFixed(precisaoDeTaxa) :
				"";
		Linda.selecionar("tbody.variaveis td.tempoMinimoDeTransito").textContent =
				(Linda.instanciaDe(fotografia.tempoMinimoDeTransito, Number)) ?
				fotografia.tempoMinimoDeTransito.toFixed(precisaoDeTaxa) :
				"";
		Linda.selecionar("tbody.variaveis td.tempoMaximoDeTransito").textContent =
				(Linda.instanciaDe(fotografia.tempoMaximoDeTransito, Number)) ?
				fotografia.tempoMaximoDeTransito.toFixed(precisaoDeTaxa) :
				"";
		Linda.selecionar("tbody.variaveis td.minimoDeMensagensNoSistema").textContent =
				(Linda.instanciaDe(fotografia.quantidadeMinimaDeMensagensNoSistema, Number)) ?
				fotografia.quantidadeMinimaDeMensagensNoSistema :
				"";
		Linda.selecionar("tbody.variaveis td.maximoDeMensagensNoSistema").textContent =
				(Linda.instanciaDe(fotografia.quantidadeMaximaDeMensagensNoSistema, Number)) ?
				fotografia.quantidadeMaximaDeMensagensNoSistema :
				"";
		Linda.selecionar("tbody.variaveis td.taxaMediaDeMensagensNoSistema").textContent =
				(!Linda.naoNumero(fotografia.taxaMediaDeMensagensNoSistema)) ?
				fotografia.taxaMediaDeMensagensNoSistema.toFixed(precisaoDeTaxa) :
				"";
	},
	
	atualizarConfiguracoes: function () {
		var configuracoes = SceModelo.instancia.configuracoes;
		Linda.obterPeloNome("semente").setAttribute("value", configuracoes.gna.semente);
		Linda.obterPeloNome("a").setAttribute("value", configuracoes.gna.a);
		Linda.obterPeloNome("b").setAttribute("value", configuracoes.gna.b);
		Linda.obterPeloNome("m").setAttribute("value", configuracoes.gna.m);
		Linda.obterPeloNome("quantidadeDeServidoresDoCds1")
				.setAttribute("value", configuracoes.centroDeServico.quantidadeDeServidoresDoCdsLocal);
		Linda.obterPeloNome("quantidadeDeServidoresDoCds2")
				.setAttribute("value", configuracoes.centroDeServico.quantidadeDeServidoresDoCdsRemoto);
	},
	
	atualizarTabelaGna: function (r, rNormalizado) {
		var precisaoDosDigitos = 10;
		var corpoDaTabela = Linda.selecionar("tbody.gna");
		var novaLinhaDaTabela = Linda.documento().createElement("tr");
		var colunaRDaTabela = Linda.documento().createElement("td");
		var colunaRNormalizadoDaTabela = Linda.documento().createElement("td");
		colunaRDaTabela.textContent = r;
		colunaRNormalizadoDaTabela.textContent = rNormalizado.toFixed(precisaoDosDigitos);
		novaLinhaDaTabela.appendChild(colunaRDaTabela);
		novaLinhaDaTabela.appendChild(colunaRNormalizadoDaTabela);
		corpoDaTabela.appendChild(novaLinhaDaTabela);
		if (Linda.obterPeloNome("historicoLimitado").checked) {
			while (corpoDaTabela.childNodes.length > this.historicoMaximo) {
				corpoDaTabela.removeChild(corpoDaTabela.lastChild);
			}
		}
	},
	
	atualizarTabelaMonteCarlo: function (monteCarlo, tabela) {
		/*jshint maxstatements: 16*/
		var precisaoDosDigitos = 3;
		var intervaloAnterior = 0;
		monteCarlo.classes.paraCada(function (classe) {
			var linhaDaTabela = Linda.documento().createElement("tr");
			var colunaClasseDaTabela = Linda.documento().createElement("td");
			var colunaFrequenciaDaTabela = Linda.documento().createElement("td");
			var colunaFrequenciaAcumuladaDaTabela = Linda.documento().createElement("td");
			var colunaIntervaloDaTabela = Linda.documento().createElement("td");
			colunaClasseDaTabela.textContent = classe.classe.comoTexto();
			colunaFrequenciaDaTabela.textContent = classe.frequencia;
			colunaFrequenciaAcumuladaDaTabela.textContent = classe.frequenciaAcumulada;
			colunaIntervaloDaTabela.innerHTML =
					intervaloAnterior.toFixed(precisaoDosDigitos) +
					" à " +
					(classe.frequenciaAcumulada / monteCarlo.frequenciaTotal).toFixed(precisaoDosDigitos);
			intervaloAnterior = (classe.frequenciaAcumulada / monteCarlo.frequenciaTotal);
			linhaDaTabela.appendChild(colunaClasseDaTabela);
			linhaDaTabela.appendChild(colunaFrequenciaDaTabela);
			linhaDaTabela.appendChild(colunaFrequenciaAcumuladaDaTabela);
			linhaDaTabela.appendChild(colunaIntervaloDaTabela);
			tabela.appendChild(linhaDaTabela);
		});
	},
	
	atualizarTabelaMonteCarloTipoDeTrafegoDeMensagem: function () {
		var monteCarlo = SceModelo.instancia.monteCarloTipoDeTrafegoDeMensagem;
		var tabela = Linda.selecionar("tbody.monteCarloTipoDeTrafegoDeMensagem");
		this.atualizarTabelaMonteCarlo(monteCarlo, tabela);
	},
	
	atualizarTabelaMonteCarloTipoDeMensagemLl: function () {
		var monteCarlo = TipoDeTrafegoDeMensagem.LL.monteCarloTipoDeMensagem;
		var tabela = Linda.selecionar("tbody.monteCarloTipoDeMensagemLl");
		this.atualizarTabelaMonteCarlo(monteCarlo, tabela);
	},
	
	atualizarTabelaMonteCarloTipoDeMensagemLr: function () {
		var monteCarlo = TipoDeTrafegoDeMensagem.LR.monteCarloTipoDeMensagem;
		var tabela = Linda.selecionar("tbody.monteCarloTipoDeMensagemLr");
		this.atualizarTabelaMonteCarlo(monteCarlo, tabela);
	},
	
	atualizarTabelaMonteCarloTipoDeMensagemRl: function () {
		var monteCarlo = TipoDeTrafegoDeMensagem.RL.monteCarloTipoDeMensagem;
		var tabela = Linda.selecionar("tbody.monteCarloTipoDeMensagemRl");
		this.atualizarTabelaMonteCarlo(monteCarlo, tabela);
	},
	
	atualizarTabelaMonteCarloTipoDeMensagemRr: function () {
		var monteCarlo = TipoDeTrafegoDeMensagem.RR.monteCarloTipoDeMensagem;
		var tabela = Linda.selecionar("tbody.monteCarloTipoDeMensagemRr");
		this.atualizarTabelaMonteCarlo(monteCarlo, tabela);
	},
	
	atualizarTabelaDistribuicaoTipoDeTrafegoDeMensagem: function (corpoDaTabela, tipoDeTrafegoDeMensagem, distribuicao) {
		var linhaDaTabela = Linda.documento().createElement("tr");
		var colunaTipoDeTrafegoDeMensagemDaTabela = Linda.documento().createElement("td");
		var colunaDistribuicaoDaTabela = Linda.documento().createElement("td");
		colunaTipoDeTrafegoDeMensagemDaTabela.textContent = tipoDeTrafegoDeMensagem.comoTexto();
		colunaDistribuicaoDaTabela.textContent = distribuicao.comoTexto();
		linhaDaTabela.appendChild(colunaTipoDeTrafegoDeMensagemDaTabela);
		linhaDaTabela.appendChild(colunaDistribuicaoDaTabela);
		corpoDaTabela.appendChild(linhaDaTabela);
	},
	
	atualizarTabelaDistribuicaoTempoEntreChegadas: function () {
		var corpoDaTabela = Linda.selecionar("tbody.distribuicaoTempoEntreChegadas");
		TipoDeTrafegoDeMensagem.paraCada(function (tipoDeTrafegoDeMensagem) {
			this.atualizarTabelaDistribuicaoTipoDeTrafegoDeMensagem(corpoDaTabela,
					tipoDeTrafegoDeMensagem, tipoDeTrafegoDeMensagem.distribuicaoTempoEntreChegadas);
		}, this);
	},
	
	atualizarTabelaDistribuicaoTempoDeRecepcao: function () {
		var corpoDaTabela = Linda.selecionar("tbody.distribuicaoTempoDeRecepcao");
		TipoDeTrafegoDeMensagem.paraCada(function (tipoDeTrafegoDeMensagem) {
			this.atualizarTabelaDistribuicaoTipoDeTrafegoDeMensagem(corpoDaTabela,
					tipoDeTrafegoDeMensagem, tipoDeTrafegoDeMensagem.distribuicaoTempoDeRecepcao);
		}, this);
	},
	
	atualizarTabelaDistribuicaoTempoDeServico: function () {
		var corpoDaTabela = Linda.selecionar("tbody.distribuicaoTempoDeServico");
		TipoDeTrafegoDeMensagem.paraCada(function (tipoDeTrafegoDeMensagem) {
			this.atualizarTabelaDistribuicaoTipoDeTrafegoDeMensagem(corpoDaTabela,
					tipoDeTrafegoDeMensagem, tipoDeTrafegoDeMensagem.distribuicaoTempoDeServico);
		}, this);
	}
});
SceControle.instancia();

