'use strict';

var ControleDaVisao = {
	temporizadorDaCaixaDeMensagens: null,
	gramaticaSelecionada: "",
	
	/**
	* Função: criarGramatica
	* Descrição: cria um nova gramática vazia.
	**/
	criarGramatica: function() {
		var listaDeGramaticas = ControleDaVisao.elemento("listaGramaticas");
		var itemDeListaDaGramatica = document.createElement("li");
		var campoDeTextoNomeDaGramatica = document.createElement("input");
		itemDeListaDaGramatica.appendChild(campoDeTextoNomeDaGramatica);
		listaDeGramaticas.insertBefore(itemDeListaDaGramatica, listaDeGramaticas.firstChild);
		campoDeTextoNomeDaGramatica.setAttribute("value", "novaGramatica");
		campoDeTextoNomeDaGramatica.select();
		ControleDaVisao.desabilitarBotoes();
		/**
		* Função: concluirCriacao
		* Descrição: conclui a criação da gramática caso não exista uma gramática com o mesmo nome.
		**/
		var concluirCriacao = function() {
			var nomeDaGramatica = campoDeTextoNomeDaGramatica.value;
			var criou = ControleDoModelo.criarGramatica(nomeDaGramatica);
			if (!criou) {
				ControleDaVisao.mostrarMensagem("fracasso", "Já existe uma gramática com o nome <strong>" + nomeDaGramatica + "</strong>, por favor, escolha outro.");
				campoDeTextoNomeDaGramatica.select();
			} else {
				ControleDaVisao.mostrarMensagem("sucesso", "Gramática <strong>" + nomeDaGramatica + "</strong> criada.");
				ControleDaVisao.habilitarBotoes();
				ControleDaVisao.gramaticaSelecionada = nomeDaGramatica;
				ControleDaVisao.mostrarGramaticas();
			}
		};
		campoDeTextoNomeDaGramatica.onkeypress = function(evento) {
			if (evento.keyCode === 13) {
				concluirCriacao();
			}
		};
	},
	
	/**
	* Função: excluirGramatica
	* Descrição: excluir a gramática selecionada.
	**/
	excluirGramatica: function() {
		ControleDoModelo.excluirGramatica(ControleDaVisao.gramaticaSelecionada);
		if (ControleDaVisao.gramaticaSelecionada == "minhaGramatica") {
			ControleDaVisao.mostrarMensagem("informativo", "A gramática <strong>minhaGramatica</strong> não pode ser excluída. Ela foi apenas limpa.");
			ControleDoModelo.criarGramatica("minhaGramatica");
		} else {
			ControleDaVisao.mostrarMensagem("sucesso", "Gramática <strong>" + ControleDaVisao.gramaticaSelecionada + "</strong> excluída.");
		}
		ControleDaVisao.mostrarGramaticas();
	},

	/**
	* Função: salvarGramatica
	* Descrição: salva a gramática selecionada e tenta construir a tabela de parsing.
	* Caso não consiga criar a tabela de parsing, então mostra uma mensagem informando o problema.
	**/
	salvarGramatica: function() {
		var nomeDaGramatica = ControleDaVisao.gramaticaSelecionada;
		var gramaticaFoiSalva = ControleDoModelo.salvarGramatica(nomeDaGramatica, ControleDaVisao.elemento("areaDeTextoCodigoDaGramatica").value);
		if (gramaticaFoiSalva) {
			ControleDaVisao.mostrarMensagem("sucesso", "Gramática <strong>" + nomeDaGramatica + "</strong> salva.");
			ControleDaVisao.mostrarGramatica(nomeDaGramatica);
		} else {
			ControleDaVisao.mostrarMensagem("fracasso", "Houve um erro ao salvar a gramática <strong>" + nomeDaGramatica + "</strong>. Certifique-se que a gramática foi escrita corretamente.");
		}
	},
	
	/**
	* Função: reconhecerSentenca
	* Descrição: verifica se uma dada gramática reconhece uma determinada sentença.
	**/
	reconhecerSentenca: function() {
		var sentenca = ControleDaVisao.elemento("campoDeTextoSentencaAReconhecer").value;
		var resposta = ControleDoModelo.reconhecerSentenca(ControleDaVisao.gramaticaSelecionada, sentenca);
		var resultadoDoReconhecimento = ControleDaVisao.elemento("textoReconhecimento");
		if (sentenca === "") {
			sentenca = "ε";
		}
		if (resposta.reconheceu) {
			resultadoDoReconhecimento.setAttribute("class", "sucesso");
			resultadoDoReconhecimento.innerHTML = "A sentenca <strong>" + sentenca + "</strong> foi reconhecida.";
		} else {
			resultadoDoReconhecimento.setAttribute("class", "fracasso");
			if (resposta.tabelaDeParsingDeterministica) {
				resultadoDoReconhecimento.innerHTML = "A sentença <strong>" + sentenca + 
					"</strong> não foi reconhecida. Era esperado o símbolo <strong>" + resposta.simboloEsperado + 
					"</strong>, mas o símbolo recebido foi <strong>" + resposta.simboloRecebido + 
					"</strong>.";
			} else {
				resultadoDoReconhecimento.setAttribute("class", "informativo");
				resultadoDoReconhecimento.innerHTML = "Não é possível efetuar o reconhecimento da sentença pois a gramática não pode ser análisada pela técnica LL(1).";
			}
		}
		resultadoDoReconhecimento.scrollIntoView();
	},
	
	/**
	* Função: mostrarGramaticas
	* Descrição: mostra todas as gramáticas na lista de gramáticas.
	**/
	mostrarGramaticas: function() {
		var listaDeGramaticas = ControleDaVisao.elemento("listaGramaticas");
		listaDeGramaticas.innerHTML = "";
		var gramaticas = ControleDoModelo.fornecerGramaticas();
		gramaticas.paraCada(function(gramatica, nomeDaGramatica) {
			var itemDeListaDaGramatica = document.createElement("li");
			itemDeListaDaGramatica.setAttribute("id", nomeDaGramatica);
			itemDeListaDaGramatica.innerHTML = nomeDaGramatica;
			/**
			* Função: selecionarGramatica
			* Descrição: tratador de envento para selecionar uma determinada gramática.
			**/
			var selecionarGramatica = function() {
				ControleDaVisao.mostrarGramatica(nomeDaGramatica);
			};
			itemDeListaDaGramatica.onclick = selecionarGramatica;
			listaDeGramaticas.insertBefore(itemDeListaDaGramatica, listaDeGramaticas.firstChild);
		});
		if (Utilitarios.nuloOuIndefinido(ControleDaVisao.gramaticaSelecionada) || Utilitarios.nuloOuIndefinido(gramaticas[ControleDaVisao.gramaticaSelecionada])) {
			ControleDaVisao.mostrarGramatica("minhaGramatica");
		} else {
			ControleDaVisao.mostrarGramatica(ControleDaVisao.gramaticaSelecionada);
		}
	},
	
	/**
	* Função: mostrarGramatica
	* Parâmetros:
	* - nomeDaGramatica: nome da gramática que será mostrada.
	* Descrição: mostra a gramática e seus detalhes.
	**/
	mostrarGramatica: function(nomeDaGramatica) {
		ControleDaVisao.elemento("campoDeTextoSentencaAReconhecer").value = "";
		ControleDaVisao.elemento("campoDeTextoSentencaAReconhecer").setAttribute("value", "");
		ControleDaVisao.elemento("textoReconhecimento").setAttribute("class", "");
		ControleDaVisao.elemento("textoReconhecimento").innerHTML = "Resultado do reconhecimento da sentença.";
		var itemDeListaDaGramaticaAntiga = ControleDaVisao.elemento(ControleDaVisao.gramaticaSelecionada);
		if (!Utilitarios.nuloOuIndefinido(itemDeListaDaGramaticaAntiga)) {
			itemDeListaDaGramaticaAntiga.setAttribute("class", "");
		}
		var itemDeListaDaGramatica = ControleDaVisao.elemento(nomeDaGramatica);
		if (Utilitarios.nuloOuIndefinido(itemDeListaDaGramatica)) {
			itemDeListaDaGramatica = ControleDaVisao.elemento("listaGramaticas").firstChild;
		}
		if (!Utilitarios.nuloOuIndefinido(itemDeListaDaGramatica)) {
			itemDeListaDaGramatica.setAttribute("class", "selecionado");
			var gramatica = ControleDoModelo.fornecerGramaticas()[nomeDaGramatica];
			ControleDaVisao.gramaticaSelecionada = itemDeListaDaGramatica.innerHTML;
			ControleDaVisao.elemento("tituloNomeDaGramatica").innerHTML = gramatica.fornecerNome();
			ControleDaVisao.elemento("areaDeTextoCodigoDaGramatica").setAttribute("value", gramatica.fornecerCodigo());
			ControleDaVisao.elemento("areaDeTextoCodigoDaGramatica").value = gramatica.fornecerCodigo();
			ControleDaVisao.mostrarFirsts(gramatica);
			ControleDaVisao.mostrarFollows(gramatica);
			ControleDaVisao.mostrarDetalhesDaGramatica(gramatica);
			ControleDaVisao.mostrarInformacaoDaConstrucaoDaTabelaDeParsing(gramatica);
			ControleDaVisao.mostrarTabelaDeParsing(gramatica);
		}
	},
	
	/**
	* Função: mostrarTabelaDeParsing
	* Parâmetros:
	* - gramatica: gramática com a tabela de parsing que será mostrada.
	* Descrição: mostra a tabela de parsing da gramática fornecida.
	**/
	mostrarTabelaDeParsing: function(gramatica) {
		var tabelaDeParsing;
		if (ControleDaVisao.elemento("caixaDeMarcacaoMostrarIndicesDasProducoes").checked) {
			tabelaDeParsing = gramatica.fornecerTabelaDeParsingComIndices();
		} else {
			tabelaDeParsing = gramatica.fornecerTabelaDeParsing();
		}
		var tabela = ControleDaVisao.elemento("tabelaTabelaDeParsing");
		tabela.innerHTML = "";
		var cabecalho = document.createElement("thead");
		var corpo = document.createElement("tbody");
		var linhaDeCabecalho = document.createElement("tr");
		var terminais = {};
		tabelaDeParsing.paraCada(function(linhaTopoDaPilhaNaoTerminal, chaveDoTopoDaPilha) {
			var linhaDoTopoDaPilha = document.createElement("tr");
			var colunhaDoTopoDaPilha = document.createElement("th");
			colunhaDoTopoDaPilha.innerHTML = chaveDoTopoDaPilha;
			linhaDoTopoDaPilha.appendChild(colunhaDoTopoDaPilha);
			linhaTopoDaPilhaNaoTerminal.paraCada(function(colunaSimboloTerminal, chaveDoSimbolo) {
				terminais[chaveDoSimbolo] = chaveDoSimbolo;
				var colunaDoSimbolo = document.createElement("td");
				colunaDoSimbolo.innerHTML = colunaSimboloTerminal.join(" | ");
				linhaDoTopoDaPilha.appendChild(colunaDoSimbolo);
			});
			corpo.appendChild(linhaDoTopoDaPilha);
		});
		var colunhaDeCabecalho = document.createElement("th");
		colunhaDeCabecalho.innerHTML = "TP";
		linhaDeCabecalho.appendChild(colunhaDeCabecalho);
		terminais.paraCada(function(terminal, simboloDoTerminal) {
			colunhaDeCabecalho = document.createElement("th");
			colunhaDeCabecalho.innerHTML = simboloDoTerminal;
			linhaDeCabecalho.appendChild(colunhaDeCabecalho);
		});
		cabecalho.appendChild(linhaDeCabecalho);
		tabela.appendChild(cabecalho);
		tabela.appendChild(corpo);
	},
	
	/**
	* Função: mostrarInformacaoDaConstrucaoDaTabelaDeParsing
	* Parâmetros:
	* - gramatica: gramática com as informações da tabela de parsing que serão mostradas.
	* Descrição: mostra informações da tabela de parsing, dizendo se foi possível ou não
	* criar a tabela sem não determinismos.
	**/
	mostrarInformacaoDaConstrucaoDaTabelaDeParsing: function(gramatica) {
		if (gramatica.codigoVazio()) {
			ControleDaVisao.elemento("textoTabelaDeParsing").setAttribute("class", "");
			ControleDaVisao.elemento("textoTabelaDeParsing").innerHTML = "Resultado da construção da tabela de parsing.";
		} else {
			var mensagemFatorada = (gramatica.fatorada) ? "" : "não está fatorada";
			var mensagemRecursivaAEsquerda = (gramatica.recursivaAEsquerda) ? "possui recursão à esquerda" : "";
			var mensagemInterseccaoDosFirstsEFollowsVazia = (gramatica.interseccaoDosFirstsEFollowsVazia) ? "" : "a intersecção dos firsts e follows de algum símbolo que deriva ε em zero ou mais passos não é vazia";
			if (!gramatica.fatorada && gramatica.recursivaAEsquerda) {
				if (gramatica.interseccaoDosFirstsEFollowsVazia) {
					mensagemRecursivaAEsquerda = " e " + mensagemRecursivaAEsquerda;
				} else {
					mensagemRecursivaAEsquerda = ", " + mensagemRecursivaAEsquerda;
				}
			}
			if ((!gramatica.fatorada || gramatica.recursivaAEsquerda) && !gramatica.interseccaoDosFirstsEFollowsVazia) {
				mensagemInterseccaoDosFirstsEFollowsVazia = " e " + mensagemInterseccaoDosFirstsEFollowsVazia;
			}
			var mensagemSobreATabelaDeParsing = "";
			if (!gramatica.fatorada || gramatica.recursivaAEsquerda || !gramatica.interseccaoDosFirstsEFollowsVazia) {
				mensagemSobreATabelaDeParsing += "Não foi possível construir a tabela de parsing sem não determinismos. ";
				mensagemSobreATabelaDeParsing += "A gramática não pode ser análisada pela técnica LL(1) pois, ";
				mensagemSobreATabelaDeParsing += mensagemFatorada + mensagemRecursivaAEsquerda + mensagemInterseccaoDosFirstsEFollowsVazia + ".";
				ControleDaVisao.elemento("textoTabelaDeParsing").setAttribute("class", "rejeita");
			} else {
				mensagemSobreATabelaDeParsing = "A tabela de parsing foi construída com sucesso.";
				ControleDaVisao.elemento("textoTabelaDeParsing").setAttribute("class", "aceita");
			}
			ControleDaVisao.elemento("textoTabelaDeParsing").innerHTML = mensagemSobreATabelaDeParsing;
		}
	},
	
	/**
	* Função: mostrarDetalhesDaGramatica
	* Parâmetros:
	* - gramatica: gramática com os detalhes que serão mostrados.
	* Descrição: mostra os detalhes da gramática.
	**/
	mostrarDetalhesDaGramatica: function(gramatica) {
		var mensagemFatorada = (gramatica.fatorada) ? "Sim" : "Não";
		var mensagemRecursivaAEsquerda = (gramatica.recursivaAEsquerda) ? "Sim" : "Não";
		var mensagemInterseccaoDosFirstsEFollowsVazia = (gramatica.interseccaoDosFirstsEFollowsVazia) ? "Sim" : "Não";
		ControleDaVisao.elemento("colunaGramaticaFatorada").innerHTML = mensagemFatorada;
		ControleDaVisao.elemento("colunaGramaticaComRecursaoAEsquerda").innerHTML = mensagemRecursivaAEsquerda;
		ControleDaVisao.elemento("colunaGramaticaComInterseccaoDeFirstsEFollowsVazia").innerHTML = mensagemInterseccaoDosFirstsEFollowsVazia;
	},
	
	/**
	* Função: mostrarFirsts
	* Parâmetros:
	* - gramatica: gramática que possui os firts que serão mostrados.
	* Descrição: mostra os frists da gramática.
	**/
	mostrarFirsts: function(gramatica) {
		var listaDeFirsts = document.createElement("table");
		listaDeFirsts.innerHTML = "<caption>Frists</caption>";
		ControleDaVisao.elemento("conteinerFirstsEFollows").replaceChild(listaDeFirsts, ControleDaVisao.elemento("tabelaFirstsDaGramatica"));
		listaDeFirsts.setAttribute("id", "tabelaFirstsDaGramatica");
		var firsts = gramatica.fornecerFirsts();
		firsts.paraCada(function(firstsDoSimbolo, chaveDoSimbolo) {
			var linhaDoFirst = document.createElement("tr");
			var tituloSimbolo = document.createElement("th");
			var descricaoFirsts = document.createElement("td");
			tituloSimbolo.innerHTML = chaveDoSimbolo;
			var firstsComoTexto = "";
			firstsDoSimbolo.paraCada(function(simboloFirst, chaveDoSimboloFirst) {
				firstsComoTexto += ("<strong>" + chaveDoSimboloFirst + "</strong>" + ", ");
			});
			firstsComoTexto = "{ " + firstsComoTexto.substring(0, firstsComoTexto.length - 2) + " }";
			descricaoFirsts.innerHTML = firstsComoTexto;
			linhaDoFirst.appendChild(tituloSimbolo);
			linhaDoFirst.appendChild(descricaoFirsts);
			listaDeFirsts.appendChild(linhaDoFirst);
		});
	},
	
	/**
	* Função: mostrarFollows
	* Parâmetros:
	* - gramatica: gramática que possui os follows que serão mostrados.
	* Descrição: mostra os follows da gramática.
	**/
	mostrarFollows: function(gramatica) {
		var listaDeFollows = document.createElement("table");
		listaDeFollows.innerHTML = "<caption>Follows</caption>";
		ControleDaVisao.elemento("conteinerFirstsEFollows").replaceChild(listaDeFollows, ControleDaVisao.elemento("tabelaFollowsDaGramatica"));
		listaDeFollows.setAttribute("id", "tabelaFollowsDaGramatica");
		var follows = gramatica.fornecerFollows();
		follows.paraCada(function(followsDoSimbolo, chaveDoSimbolo) {
			var linhaDoFollow = document.createElement("tr");
			var tituloSimbolo = document.createElement("th");
			var descricaoFollows = document.createElement("td");
			tituloSimbolo.innerHTML = chaveDoSimbolo;
			var followsComoTexto = "";
			followsDoSimbolo.paraCada(function(simboloFollow, chaveDoSimboloFollow) {
				followsComoTexto += ("<strong>" + chaveDoSimboloFollow + "</strong>" + ", ");
			});
			followsComoTexto = "{ " + followsComoTexto.substring(0, followsComoTexto.length - 2) + " }";
			descricaoFollows.innerHTML = followsComoTexto;
			linhaDoFollow.appendChild(tituloSimbolo);
			linhaDoFollow.appendChild(descricaoFollows);
			listaDeFollows.appendChild(linhaDoFollow);
		});
	},
	
	/**
	* Função: desabilitarBotoes
	* Descrição: desabilita os botões da interface gráfica.
	**/
	desabilitarBotoes: function() {
		ControleDaVisao.elemento("botaoCriarGramatica").setAttribute("disabled", "disabled");
		ControleDaVisao.elemento("botaoSalvarGramatica").setAttribute("disabled", "disabled");
		ControleDaVisao.elemento("botaoExcluirGramatica").setAttribute("disabled", "disabled");
		ControleDaVisao.elemento("botaoReconhecerSentenca").setAttribute("disabled", "disabled");
	},
	
	/**
	* Função: habilitarBotoes
	* Descrição: habilita os botões da interface gráfica.
	**/
	habilitarBotoes: function() {
		ControleDaVisao.elemento("botaoCriarGramatica").removeAttribute("disabled");
		ControleDaVisao.elemento("botaoSalvarGramatica").removeAttribute("disabled");
		ControleDaVisao.elemento("botaoExcluirGramatica").removeAttribute("disabled");
		ControleDaVisao.elemento("botaoReconhecerSentenca").removeAttribute("disabled");
	},
	
	/**
	* Função: mostrarMensagem
	* Parâmetros:
	* - tipoDeMensagem: tipo da mensagem a ser mostrada.
	* - mensagem: texto da mensagem a ser mostrada.
	* Descrição: mostra na tela a mensagem especificada pelo parâmetro mensagem.
	**/
	mostrarMensagem: function(tipoDeMensagem, mensagem) {
		var caixaDeMensagens = ControleDaVisao.elemento("textoMensagemDoSistema");
		window.clearTimeout(ControleDaVisao.temporizadorDaCaixaDeMensagens);
		ControleDaVisao.temporizadorDaCaixaDeMensagens = window.setTimeout(ControleDaVisao.limparMensagem, 8000);
		caixaDeMensagens.setAttribute("class", tipoDeMensagem);
		caixaDeMensagens.innerHTML = mensagem;
		caixaDeMensagens.scrollIntoView();
	},

	/**
	* Função: limparMensagem
	* Descrição: limpa o campo de exibição de mensagens.
	**/
	limparMensagem: function() {
		ControleDaVisao.elemento("textoMensagemDoSistema").setAttribute("class", "");
		ControleDaVisao.elemento("textoMensagemDoSistema").innerHTML = "";
		window.clearTimeout(ControleDaVisao.temporizadorDaCaixaDeMensagens);
	},
	
	/**
	* Função: elemento
	* Descrição: fornecer o elemento dado o seu identificador.
	**/
	elemento: function(identificador) {
		return document.getElementById(identificador);
	},
	
	/**
	* Função: adicionarTratadores
	* Descrição: adiciona os tratadores para os eventos que serão disparados em decorrência da interação do usuário.
	**/
	adicionarTratadores: function() {
		ControleDaVisao.elemento("botaoSalvarGramatica").onclick = ControleDaVisao.salvarGramatica;
		ControleDaVisao.elemento("botaoCriarGramatica").onclick = ControleDaVisao.criarGramatica;
		ControleDaVisao.elemento("botaoExcluirGramatica").onclick = ControleDaVisao.excluirGramatica;
		ControleDaVisao.elemento("botaoReconhecerSentenca").onclick = ControleDaVisao.reconhecerSentenca;
		ControleDaVisao.elemento("caixaDeMarcacaoMostrarIndicesDasProducoes").onclick = function() {
			ControleDaVisao.mostrarTabelaDeParsing(ControleDoModelo.fornecerGramatica(ControleDaVisao.gramaticaSelecionada));
		};
		ControleDaVisao.elemento("textoMensagemDoSistema").onclick = ControleDaVisao.limparMensagem;
		if (ControleDoModelo.criarGramatica("minhaGramatica")) {
			ControleDaVisao.gramaticaSelecionada = "minhaGramatica";
			ControleDaVisao.mostrarGramaticas();
		}
	},
};