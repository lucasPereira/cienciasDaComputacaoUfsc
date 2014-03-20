(function (contexto) {
	"use strict";

	contexto.Pacotes = Classe.criarSingleton({
		inicializar: function () {
			this.pacotesDom = Dom.$("section.pacotes");
			this.canais = [];
			this.generos = [];
			this.precoMaximo = null;
			this.pacotesDom.selecionar("button.adicionarCanal").tratarClique(this.adicionarCanal, this);
			this.pacotesDom.selecionar("button.adicionarGenero").tratarClique(this.adicionarGenero, this);
			this.pacotesDom.selecionar("button.fixarPrecoMaximo").tratarClique(this.fixarPrecoMaximo, this);
			this.pacotesDom.selecionar("button.limpar").tratarClique(this.limparBusca, this);
			this.pacotesDom.selecionar("button.buscar").tratarClique(this.buscar, this);
		},

		adicionarCanal: function () {
			var canal = this.pacotesDom.selecionar("input.canal").valor.paraInteiro();
			this.pacotesDom.selecionar("input.canal").valor = "";
			this.canais.adicionar(canal);
			contexto.Sistema.mostrarInformacao(String.formatar("Canal %@ selecionado para a busca de pacotes.", canal));
			this.pacotesDom.selecionar("span.canais").texto = this.canais.juntarEmTexto(", ");
		},

		adicionarGenero: function () {
			var genero = this.pacotesDom.selecionar("input.genero").valor;
			var quantidadeDoGenero = this.pacotesDom.selecionar("input.quantidadeDoGenero").valor.paraInteiro();
			this.pacotesDom.selecionar("input.genero").valor = "";
			this.pacotesDom.selecionar("input.quantidadeDoGenero").valor = "";
			var novoGenero = {
				genero: genero,
				quantidade: quantidadeDoGenero
			};
			novoGenero.toString = function () {
				return String.formatar("%@ (%@)", this.genero, this.quantidade);
			};
			this.generos.adicionar(novoGenero);
			contexto.Sistema.mostrarInformacao(String.formatar("Genero %@ (%@) selecionado para a busca de pacotes.", genero, quantidadeDoGenero));
			this.pacotesDom.selecionar("span.generos").texto = this.generos.juntarEmTexto(", ");
		},

		fixarPrecoMaximo: function () {
			var precoMaximo = this.pacotesDom.selecionar("input.precoMaximo").valor.paraFlutuante();
			this.pacotesDom.selecionar("input.precoMaximo").valor = "";
			this.precoMaximo = precoMaximo;
			contexto.Sistema.mostrarInformacao(String.formatar("Preço máxomo %@ selecionado para a busca de pacotes.", precoMaximo));
			this.pacotesDom.selecionar("span.precoMaximo").texto = this.precoMaximo;
		},

		limparBusca: function () {
			this.canais = [];
			this.generos = [];
			this.precoMaximo = null;
			this.pacotesDom.selecionar("span.canais").texto = "";
			this.pacotesDom.selecionar("span.generos").texto = "";
			this.pacotesDom.selecionar("span.precoMaximo").texto = "";
			contexto.Sistema.mostrarInformacao("Critérios da busca de pacotes limpa.");
		},

		buscar: function () {
			var caminho = "/pacotes";
			var separador = "?";
			if (!this.canais.vazio()) {
				caminho = String.formatar("%@%@canais=%@", caminho, separador, this.canais.juntarEmTexto(","));
				separador = "&";
			}
			if (!this.generos.vazio()) {
				var generosComQuantidade = [];
				this.generos.paraCada(function (genero) {
					generosComQuantidade.adicionar(String.formatar("%@,%@", genero.genero, genero.quantidade));
				}, this);
				caminho = String.formatar("%@%@generos=%@", caminho, separador, generosComQuantidade.juntarEmTexto(","));
				separador = "&";
			}
			if (!Linda.nulo(this.precoMaximo)) {
				caminho = String.formatar("%@%@precoMaximo=%@", caminho, separador, this.precoMaximo);
				separador = "&";
			}
			this.buscarPacotes(caminho);
		},

		buscarPacotes: function (caminho) {
			var listaPacotes = this.pacotesDom.selecionar("ul.pacotes");
			listaPacotes.htmlInterno = "";
			contexto.Operadoras.operadoras.paraCada(function (operadora) {
				var requisicao = new RequisicaoHttp(operadora.uri + caminho);
				requisicao.fixarTempoLimite(1000);
				requisicao.aceitaJson();
				requisicao.tratarSucesso(function (resposta, codigoDeEstado) {
					contexto.Sistema.mostrarInformacao("Listagem de pacotes atualizada.");
					this.atualizarListagem(operadora, resposta.pacotes);
				}, this);
				requisicao.tratarErro(this.receberErro, this);
				requisicao.tratarErroDoCliente(this.receberErro, this);
				requisicao.tratarErroDoServidor(this.receberErro, this);
				requisicao.tratarAborto(this.receberErro, this);
				requisicao.tratarEstouroDeTempo(this.receberErro, this);
				requisicao.get();
			}, this);
		},

		atualizarListagem: function (operadora, pacotes) {
			var listaPacotes = this.pacotesDom.selecionar("ul.pacotes");
			var itemOperadora = Dom.$(documento).criarElemento("li");
			var enlaceOperadora = Dom.$(documento).criarElemento("a");
			enlaceOperadora.texto = operadora.nome;
			enlaceOperadora.fixarAtributo("href", operadora.uri);
			itemOperadora.adicionarNodo(enlaceOperadora);
			if (!Linda.nulo(pacotes) && !pacotes.vazio()) {
				var tabelaOperadora = Dom.$(documento).criarElemento("table");
				var linhaCabecalho = Dom.$(documento).criarElemento("tr");
				linhaCabecalho.htmlInterno = "<th>Preço</th><th>Canais</th>";
				tabelaOperadora.adicionarNodo(linhaCabecalho)
				pacotes.ordenar(function (pacoteA, pacoteB) {
					if (pacoteA.preco > pacoteB.preco) {
						return -1;
					} else if (pacoteA.preco < pacoteB.preco) {
						return 1;
					} else {
						return 0;
					}
				});
				pacotes.paraCada(function (pacote) {
					var linhaPacote = Dom.$(documento).criarElemento("tr");
					var colunaPreco = Dom.$(documento).criarElemento("td");
					var colunaCanais = Dom.$(documento).criarElemento("td");
					colunaPreco.texto = pacote.preco;
					colunaCanais.texto = pacote.canais.juntarEmTexto(", ");
					linhaPacote.adicionarNodo(colunaPreco);
					linhaPacote.adicionarNodo(colunaCanais);
					tabelaOperadora.adicionarNodo(linhaPacote);
				}, this);
				itemOperadora.adicionarNodo(tabelaOperadora);
			} else {
				var textoOperadora = Dom.$(documento).criarElemento("p");
				textoOperadora.texto = "Não foram encontrados pacotes com os filtros selecionados.";
				itemOperadora.adicionarNodo(textoOperadora);
			}
			listaPacotes.adicionarNodo(itemOperadora);
		},

		receberErro: function () {
			contexto.Sistema.mostrarErro("Não foi possível obter os pacotes.");
		}
	});

}(this));
