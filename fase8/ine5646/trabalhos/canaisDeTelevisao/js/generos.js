(function (contexto) {
	"use strict";

	contexto.Generos = Classe.criarSingleton({
		inicializar: function () {
			this.generosDom = Dom.$("section.generos");
			this.generosDom.selecionar("button.atualizar").tratarClique(this.atualizar, this);
			this.generos = {};
			this.atualizar();
		},

		atualizar: function () {
			var requisicao = new RequisicaoHttp(contexto.Sistema.fornecerUriDoBancoDeDados("/generos"));
			requisicao.fixarTempoLimite(1000);
			requisicao.aceitaJson();
			requisicao.tratarSucesso(function (resposta, codigoDeEstado) {
				this.generos = resposta.generos;
				contexto.Sistema.mostrarInformacao("Listagem de gêneros atualizada.");
				this.atualizarListagem();
			}, this);
			requisicao.tratarErro(this.receberErro, this);
			requisicao.tratarErroDoCliente(this.receberErro, this);
			requisicao.tratarErroDoServidor(this.receberErro, this);
			requisicao.tratarAborto(this.receberErro, this);
			requisicao.tratarEstouroDeTempo(this.receberErro, this);
			requisicao.get();
		},

		atualizarListagem: function () {
			var listaGeneros = this.generosDom.selecionar("ul.generos");
			listaGeneros.htmlInterno = "";
			this.generos.paraCada(function (genero) {
				var itemGenero = Dom.$(documento).criarElemento("li");
				var enlaceGenero = Dom.$(documento).criarElemento("a");
				enlaceGenero.texto = genero;
				enlaceGenero.fixarAtributo("href", "#");
				enlaceGenero.tratarClique(function () {
					contexto.Canais.filtrarGenero(genero);
					Dom.$("section.pacotes").selecionar("input.genero").valor = genero;
				});
				itemGenero.adicionarNodo(enlaceGenero);
				listaGeneros.adicionarNodo(itemGenero);
			}, this);
		},

		receberErro: function () {
			contexto.Sistema.mostrarErro("Não foi possível obter os gêneros.");
		}
	});
}(this));
