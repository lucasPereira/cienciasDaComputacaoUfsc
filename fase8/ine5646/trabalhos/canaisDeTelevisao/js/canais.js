(function (contexto) {
	"use strict";

	contexto.Canais = Classe.criarSingleton({
		inicializar: function () {
			this.canaisDom = Dom.$("section.canais");
			this.canaisDom.selecionar("button.atualizar").tratarClique(this.atualizar, this);
			this.canaisDom.selecionar("button.buscar").tratarClique(this.buscar, this);
			this.canaisDom.selecionar("input.canal").tratarTeclaSolta(null, this.buscar, this);
			this.canais = [];
			this.canaisAtuais = [];
			this.atualizar();
		},

		atualizar: function () {
			var requisicao = new RequisicaoHttp(contexto.Sistema.fornecerUriDoBancoDeDados("/canais"));
			requisicao.fixarTempoLimite(1000);
			requisicao.aceitaJson();
			requisicao.tratarSucesso(function (resposta, codigoDeEstado) {
				this.canais = resposta.canais;
				this.canaisAtuais = this.canais;
				contexto.Sistema.mostrarInformacao("Listagem de canais atualizada.");
				this.atualizarListagem();
			}, this);
			requisicao.tratarErro(this.receberErro, this);
			requisicao.tratarErroDoCliente(this.receberErro, this);
			requisicao.tratarErroDoServidor(this.receberErro, this);
			requisicao.tratarAborto(this.receberErro, this);
			requisicao.tratarEstouroDeTempo(this.receberErro, this);
			requisicao.get();
			this.canaisDom.selecionar("input.canal").valor = "";
		},

		atualizarListagem: function () {
			var listaCanais = this.canaisDom.selecionar("ul.canais");
			listaCanais.htmlInterno = "";
			this.canaisAtuais.paraCada(function (canal) {
				var itemCanal = Dom.$(documento).criarElemento("li");
				var numero = canal.id + "";
				itemCanal.texto = String.formatar("%@ (%@)", canal.nome, canal.id);
				listaCanais.adicionarNodo(itemCanal);
			}, this);
		},

		receberErro: function () {
			contexto.Sistema.mostrarErro("Não foi possível obter os canais.");
		},

		buscar: function () {
			this.canaisAtuais = [];
			var busca = this.canaisDom.selecionar("input.canal").valor;
			var buscaCaixaAlta = busca.paraCaixaAlta();
			this.canais.paraCada(function (canal) {
				var combinacoes = canal.nome.paraCaixaAlta().combinar(buscaCaixaAlta);
				if (Linda.existe(combinacoes) && combinacoes.quantidadeMaiorIgualQue(1)) {
					this.canaisAtuais.adicionar(canal);
				}
			}, this);
			contexto.Sistema.mostrarInformacao(String.formatar("Listagem de canais filtrada pela palavra: %@.", busca));
			this.atualizarListagem();
		},

		filtrarGenero: function (genero) {
			this.canaisAtuais = [];
			this.canais.paraCada(function (canal) {
				if (canal.genero === genero) {
					this.canaisAtuais.adicionar(canal);
				}
			}, this);
			contexto.Sistema.mostrarInformacao(String.formatar("Listagem de canais filtrada pelo gênero: %@.", genero));
			this.atualizarListagem();
		}
	});

}(this));
