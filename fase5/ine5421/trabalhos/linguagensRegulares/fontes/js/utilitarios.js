Utilitarios = { 
	/**
	 * Função: implementar
	 * Parâmetros:
	 * 	- prototipo: prototipo que receberá as implementações
	 * 	- implementacoes: implementações que serão adicionadas ao prototipo
	 * Descrição: adiciona a um protótipo um conjunto de implementações fornecidas
	 */
	implementar: function(prototipo, implementacoes) {
		prototipo.implementar(implementacoes);
	},
	
	/**
	 * Função: instanciaDe
	 * Parâmetros:
	 * 	- objeto: objeto a ser verificado
	 * 	- tipo: tipo a ver verificado
	 * Descrição: verifica se um objeto é uma instância de um dado tipo
	 */
	instanciaDe: function(objeto, tipo) {
		return (objeto instanceof tipo);
	},
	
	/**
	 * Função: paraCada
	 * Parâmetros:
	 * 	- iteravel: elemento que será iterado
	 * 	- funcaoDeIteracao: função que será executada a cada iteração
	 * 	- escopo: escopo em que será executada a funcaoDeIteracao
	 * Descrição: itera um elemento chamando a funcoaDeIteracao fornecida
	 */
	paraCada: function(iteravel, funcaoDeIteracao, escopo) {
		if (!(this.instanciaDe(iteravel, Object) || this.instanciaDe(iteravel, String)) || !this.instanciaDe(funcaoDeIteracao, Function)) {
			throw new ExcecaoUtilitarios("Argumento inválido. Argumentos devem ser: [Objeto ou Lista] [Função].");
		}
		funcaoDeIteracao = funcaoDeIteracao.bind(escopo);
		for (var chave in iteravel) {
			funcaoDeIteracao(iteravel[chave], chave);
		}
	} 
};

Prototipo = function Prototipo(corpoDoPrototipo) {
	var novoPrototipo = function Objeto() {
		if (this.inicializar !== undefined) {
			this.inicializar.apply(this, arguments);
		}
	};
	novoPrototipo.implementar(corpoDoPrototipo);
	return novoPrototipo;
};

Function.prototype.implementar = function(implementacoes) {
	if (!Utilitarios.instanciaDe(implementacoes, Object)) {
		throw new ExcecaoUtilitarios("Argumento inválido. Argumento deve ser: [ObjetoJson].");
	}
	Utilitarios.paraCada(implementacoes, function(implementacao, chave) {
		this.prototype[chave] = implementacao;
	}, this);
};

ExcecaoUtilitarios = new Prototipo({
	/**
	 * Função: inicializar
	 * Parâmetros:
	 * 	- mensagem: mensagem que representará textualmente a exceção
	 * Descrição: inicializa a estrutura da ExcecaoUtilitarios: mensagem
	 */
	inicializar: function(mensagem) {
		this.mensagem = mensagem;
	},
	
	/**
	 * Função: fornecerComoTexto
	 * Descrição: fornece a representação textual dessa exceção
	 */
	fornecerComoTexto: function() {
		return "ExcecaoUtilitarios: " + this.mensagem;
	},
	
	/**
	 * Função: toString
	 * Descrição: fornece a representação textual dessa exceção
	 */
	toString: function() {
		return this.fornecerComoTexto();
	}
});