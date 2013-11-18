"use strict";
(function() {
	var nomeDoUsuario = "";
	
	var criarLeilao = function() {
		var leilao = {
			nomeDoUsuario: nomeDoUsuario,
			nome: document.getElementById("campoNomeDoLeilao").value,
			produto: document.getElementById("campoProdutoDoLeilao").value,
			duracao: document.getElementById("campoDuracaoDoLeilao").value
		}
		var resposta = enviarRequisicaoJson("PUT", "/leilao/" + leilao.nome, leilao);
		if (resposta.sucesso !== undefined && resposta.sucesso === false) {
			alert(resposta.erro);
		}
		atualizar();
	}
	
	var atualizar = function() {
		obterLeiloesEmAndamento();
		obterLeiloesTerminados();
	}
	
	var obterLeiloesEmAndamento = function() {
		var leiloes = enviarRequisicaoJson("GET", "/leiloes", null);
		var indice;
		document.getElementById("leiloesEmAndamento").innerHTML = "<h1>Leilões em Andamento</h1>";
		leiloes.map(function(elemento, chave) {
			var leilao = document.createElement("div");
			var informacoes = document.createElement("ul");
			var nome = document.createElement("li");
			var produto = document.createElement("li");
			var usuario = document.createElement("li");
			var duracao = document.createElement("li");
			var inicio = document.createElement("li");
			var tempoRestante = document.createElement("li");
			var ultimoLance = document.createElement("li");
			var lanceVencedor = document.createElement("li");
			nome.innerHTML = "<strong>Nome: </strong>" + elemento.nome;
			produto.innerHTML = "<strong>Produto: </strong>" + elemento.produto;
			usuario.innerHTML = "<strong>Criador: </strong>" + elemento.nomeDoUsuario;
			duracao.innerHTML = "<strong>Duração: </strong>" + elemento.duracao + " segundos";
			inicio.innerHTML = "<strong>Data de início: </strong>" + elemento.inicio;
			var tempoRestanteCalculado = parseInt(elemento.duracao - (new Date().getTime() - new Date(elemento.inicio).getTime()) / 1000);
			tempoRestante.innerHTML = "<strong>Tempo Restante: </strong>" + tempoRestanteCalculado + " segundos"; 
			var intervalo = setInterval(function() {
				var tempoRestanteCalculado = parseInt(elemento.duracao - (new Date().getTime() - new Date(elemento.inicio).getTime()) / 1000);
				if (tempoRestanteCalculado == 0) {
					tempoRestanteCalculado = 0;
					window.clearInterval(intervalo);
					atualizar();
				}
				tempoRestante.innerHTML = "<strong>Tempo Restante: </strong>" + tempoRestanteCalculado + " segundos";	
			}, 1000);
			if (elemento.ultimoLance !== undefined) {
				ultimoLance.innerHTML = "<strong>Último Lance: </strong>R$ " + elemento.ultimoLance.valor + " (" + elemento.ultimoLance.nomeDoUsuario + ")";
				lanceVencedor.innerHTML = "<strong>Vencendo: </strong>R$ " + elemento.lanceVencedor.valor + " (" + elemento.lanceVencedor.nomeDoUsuario + ")";
			} else {
				ultimoLance.innerHTML = "<strong>Último Lance: </strong>Não há nenhum lance até o momento.";
				lanceVencedor.innerHTML = "<strong>Lance Vencedor: </strong>Não há nenhum lance até o momento.";
			}
			var campoDeTextoValorLance = document.createElement("input")
			campoDeTextoValorLance.setAttribute("type", "text");
			campoDeTextoValorLance.setAttribute("placeholder", "valor");
			campoDeTextoValorLance.setAttribute("name", "valorLance" + elemento.nome);
			var botaoDarLance = document.createElement("button");
			botaoDarLance.innerHTML = "Dar lance";
			botaoDarLance.onclick = function(evento) {
				var lance = {
					nomeDoUsuario: nomeDoUsuario,
					valor: document.getElementsByName("valorLance" + elemento.nome)[0].value
				}
				var resposta = enviarRequisicaoJson("POST", "/leilao/" + elemento.nome + "/lances", lance);
				if (resposta.sucesso !== undefined && resposta.sucesso === false) {
					alert(resposta.erro);
				}
				atualizar();
			}
			informacoes.appendChild(nome);
			informacoes.appendChild(produto);
			informacoes.appendChild(usuario);
			informacoes.appendChild(duracao);
			informacoes.appendChild(inicio);
			informacoes.appendChild(tempoRestante);
			informacoes.appendChild(ultimoLance);
			informacoes.appendChild(lanceVencedor);
			leilao.appendChild(informacoes);
			leilao.appendChild(campoDeTextoValorLance);
			leilao.appendChild(botaoDarLance);
			document.getElementById("leiloesEmAndamento").appendChild(leilao);
		});
	}
	
	var obterLeiloesTerminados = function() {
		var leiloes = enviarRequisicaoJson("GET", "/leiloes?terminados=true", null);
		var indice;
		document.getElementById("leiloesTerminados").innerHTML = "<h1>Leilões Terminados</h1>";
		leiloes.map(function(elemento, chave) {
			var leilao = document.createElement("div");
			var informacoes = document.createElement("ul");
			var nome = document.createElement("li");
			var produto = document.createElement("li");
			var usuario = document.createElement("li");
			var ultimoLance = document.createElement("li");
			var lanceVencedor = document.createElement("li");
			nome.innerHTML = "<strong>Nome: </strong>" + elemento.nome;
			produto.innerHTML = "<strong>Produto: </strong>" + elemento.produto;
			usuario.innerHTML = "<strong>Criador: </strong>" + elemento.nomeDoUsuario;
			if (elemento.ultimoLance !== undefined) {
				ultimoLance.innerHTML = "<strong>Último Lance dado: </strong>R$ " + elemento.ultimoLance.valor + " (" + elemento.ultimoLance.nomeDoUsuario + ")";
				lanceVencedor.innerHTML = "<strong>Lance Vencendor: </strong>R$ " + elemento.lanceVencedor.valor + " (" + elemento.lanceVencedor.nomeDoUsuario + ")";
			} else {
				ultimoLance.innerHTML = "<strong>Último Lance dado: </strong>Não houve lances.";
				lanceVencedor.innerHTML = "<strong>Lance Vencedor: </strong>Não houve um vencendor.";
			}
			informacoes.appendChild(nome);
			informacoes.appendChild(produto);
			informacoes.appendChild(usuario);
			informacoes.appendChild(ultimoLance);
			informacoes.appendChild(lanceVencedor);
			leilao.appendChild(informacoes);
			document.getElementById("leiloesTerminados").appendChild(leilao);
		});
	}
	
	var enviarRequisicaoJson = function(metodo, uri, dados) {
		var requisicao = new XMLHttpRequest();
		requisicao.open(metodo, uri, false);
		requisicao.setRequestHeader("Content-Type", "application/json");
		requisicao.setRequestHeader("Content-Encondig", "UTF-8");
		requisicao.setRequestHeader("Accept", "application/json");
		requisicao.send(JSON.stringify(dados));
		return JSON.parse(requisicao.responseText);
	}
	
	var inicializar = function() {
		var botaoEntrar = document.getElementById("botaoEntrar");
		botaoEntrar.onclick = function() {
			var campoNomeDoUsuario = document.getElementById("campoNomeDoUsuario");
			nomeDoUsuario = campoNomeDoUsuario.value;
			campoNomeDoUsuario.setAttribute("disabled", "disabled");
			botaoEntrar.setAttribute("disabled", "disabled");
			document.getElementById("leilao").style.display = "block";
		};
		document.getElementById("botaoCriarLeilao").onclick = criarLeilao;
		atualizar();
		setInterval(function() {
			atualizar(); 
		}, 10000);
	}
	
	window.onload = inicializar;
}());