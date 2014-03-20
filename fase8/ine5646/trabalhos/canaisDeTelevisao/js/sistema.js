(function (contexto) {
	"use strict";

	contexto.Sistema = Classe.criarSingleton({
		inicializar: function () {
			this.uriDoBancoDeDados = "http://tvcabobd.leandro.komosinski.vms.ufsc.br:9000"
			this.sistemaDom = Dom.$("section.sistema");
			var requisicao = new RequisicaoHttp(this.uriDoBancoDeDados);
			requisicao.fixarTempoLimite(1000);
			requisicao.tratarSucesso(this.inicializarModulos, this);
			requisicao.tratarErro(this.usarBancoDeDadosDummy, this);
			requisicao.tratarErroDoCliente(this.usarBancoDeDadosDummy, this);
			requisicao.tratarErroDoServidor(this.usarBancoDeDadosDummy, this);
			requisicao.tratarAborto(this.usarBancoDeDadosDummy, this);
			requisicao.tratarEstouroDeTempo(this.usarBancoDeDadosDummy, this);
			requisicao.get();
		},

		inicializarModulos: function () {
			contexto.Operadoras = contexto.Operadoras.instancia();
			contexto.Generos = contexto.Generos.instancia();
			contexto.Canais = contexto.Canais.instancia();
			contexto.Pacotes = contexto.Pacotes.instancia();
		},

		usarBancoDeDadosDummy: function () {
			contexto.Sistema.mostrarErro("Não foi possível utilizar o Banco de dados. Será tentado utilizar o banco de dados dummy.");
			this.uriDoBancoDeDados = "http://localhost:7003";
			this.inicializarModulos();
		},

		fornecerUriDoBancoDeDados: function (caminho) {
			return String.concatenar(this.uriDoBancoDeDados, caminho);
		},

		mostrarErro: function (mensagem) {
			this.sistemaDom.texto = mensagem;
			this.removerClasses();
			this.sistemaDom.adicionarClasse("erro");
			console.log(String.formatar("[%@] %@", "erro", mensagem));
		},

		mostrarSucesso: function (mensagem) {
			this.sistemaDom.texto = mensagem;
			this.removerClasses();
			this.sistemaDom.adicionarClasse("sucesso");
			console.log(String.formatar("[%@] %@", "sucesso", mensagem));
		},

		mostrarAviso: function (mensagem) {
			this.sistemaDom.texto = mensagem;
			this.removerClasses();
			this.sistemaDom.adicionarClasse("aviso");
			console.log(String.formatar("[%@] %@", "aviso", mensagem));
		},

		mostrarInformacao: function (mensagem) {
			this.sistemaDom.texto = mensagem;
			this.removerClasses();
			this.sistemaDom.adicionarClasse("informacao");
			console.log(String.formatar("[%@] %@", "informacao", mensagem));
		},

		removerClasses: function () {
			this.sistemaDom.removerClasse("sucesso");
			this.sistemaDom.removerClasse("informacao");
			this.sistemaDom.removerClasse("aviso");
			this.sistemaDom.removerClasse("erro");
		}
	});
}(this));
