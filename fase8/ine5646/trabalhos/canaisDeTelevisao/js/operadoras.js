(function (contexto) {
	"use strict";

	contexto.Operadoras = Classe.criarSingleton({
		inicializar: function () {
			this.operadoras = {};
			this.operadorasDom = Dom.$("section.operadoras");
			this.operadorasDom.selecionar("button.cadastrar").tratarClique(this.cadastrar, this);
			this.tentarCadastrarOperadora("http://tvcabooperadora.leandro.komosinski.vms.ufsc.br:9000");
			this.tentarCadastrarOperadora("http://localhost:7001");
			this.tentarCadastrarOperadora("http://localhost:7002");
		},

		tentarCadastrarOperadora: function (uri) {
			this.operadorasDom.selecionar("input.operadora").valor = uri;
			this.cadastrar();
		},

		cadastrar: function () {
			var uriDaOperadora = this.operadorasDom.selecionar("input.operadora").valor;
			var requisicao = new RequisicaoHttp(String.concatenar(uriDaOperadora, "/nome"));
			requisicao.fixarTempoLimite(1000);
			requisicao.aceitaJson();
			requisicao.tratarSucesso(function (resposta, codigoDeEstado) {
				this.operadoras[uriDaOperadora] = {
					uri: uriDaOperadora,
					nome: resposta.nome
				};
				this.operadorasDom.selecionar("input.operadora").valor = "";
				contexto.Sistema.mostrarSucesso("Operadora cadastrada.");
				this.atualizarListagem();
			}, this);
			requisicao.tratarErro(this.receberErro, this);
			requisicao.tratarErroDoCliente(this.receberErro, this);
			requisicao.tratarErroDoServidor(this.receberErro, this);
			requisicao.tratarAborto(this.receberErro, this);
			requisicao.tratarEstouroDeTempo(this.receberErro, this);
			requisicao.get();
		},

		remover: function (operadora) {
			if (this.operadoras.possuiPropriedade(operadora)) {
				delete this.operadoras[operadora];
				contexto.Sistema.mostrarSucesso("Operadora removida.");
			} else {
				contexto.Sistema.mostrarAviso("Operadora inexistente.");
			}
			this.atualizarListagem();
		},

		atualizarListagem: function() {
			var listaDeOperadoras = this.operadorasDom.selecionar("ul.operadoras");
			listaDeOperadoras.htmlInterno = "";
			this.operadoras.paraCada(function (operadora) {
				var itemOperadora = Dom.$(documento).criarElemento("li");
				var botaoRemoverOperadora = Dom.$(documento).criarElemento("button");
				var enlaceOperadora = Dom.$(documento).criarElemento("a");
				enlaceOperadora.fixarAtributo("href", operadora.uri);
				enlaceOperadora.texto = operadora.nome;
				botaoRemoverOperadora.texto = "x";
				botaoRemoverOperadora.fixarAtributo("title", "Excluir operadora");
				botaoRemoverOperadora.tratarClique(function () {
					this.remover(operadora.uri);
				}, this);
				itemOperadora.adicionarNodo(enlaceOperadora);
				itemOperadora.adicionarNodo(botaoRemoverOperadora);
				listaDeOperadoras.adicionarNodo(itemOperadora);
			}, this);
		},

		receberErro: function () {
			this.operadorasDom.selecionar("input.operadora").valor = "";
			contexto.Sistema.mostrarErro("Não foi possível cadastrar a operadora.");
		}
	});
}(this));
