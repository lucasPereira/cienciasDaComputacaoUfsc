var http = require("http");
var sistemaDeArquivos = require("fs");
var url = require("url");

function responderRequisicao(requisicao, resposta) {
	var metodo = requisicao.method;
	if (metodo === "GET") {
		responderGet(requisicao, resposta);
	} else {
		responder405(resposta, metodo);
	}
}

function responderGet(requisicao, resposta) {
	var uri = url.parse(requisicao.url, true);
	var caminho = ("." + uri.pathname);
	sistemaDeArquivos.exists(caminho, function (existe) {
		if (existe) {
			responderRecurso(resposta, caminho);
		} else {
			responder404(resposta, caminho);
		}
	});
}

function responderRecurso(resposta, caminho) {
	sistemaDeArquivos.stat(caminho, function (erro, estado) {
		if (!erro && estado.isFile()) {
			responderArquivo(resposta, caminho);
		} else {
			responder404(resposta, caminho);
		}
	});
}

function responderArquivo(resposta, caminho) {
	sistemaDeArquivos.readFile(caminho, function (erro, arquivo) {
		if (erro) {
			responder500();
		} else {
			var extensao = caminho.split(".").pop();
			var tipoDeMidia = tiposDeMidiaPorExtensao[extensao];
			if (tipoDeMidia === null) {
				tipoDeMidia = "text/plain";
			}
			responder200(resposta, arquivo, tipoDeMidia);
		}
	});
}

function responder200(resposta, arquivo, tipoDeMidia) {
		resposta.statusCode = 200;
		resposta.setHeader("Content-Type", tipoDeMidia);
		resposta.end(arquivo);
}

function responder404(resposta, caminho) {
	resposta.statusCode = 404;
	resposta.setHeader("Content-Type", "text/plain");
	resposta.end(caminho);
}

function responder405(resposta, metodo) {
	resposta.statusCode = 405;
	resposta.setHeader("Content-Type", "text/plain");
	resposta.end(metodo);
}

function responderComoErroDoServidor(resposta) {
	resposta.statusCode = 500;
	resposta.end();
}

var tiposDeMidiaPorExtensao = {
	"js": "application/javascript",
	"json": "application/json",
	"css": "text/css",
	"html": "text/html",
	"txt": "text/plain",
	"png": "image/png"
}

http.createServer(function (requisicao, resposta) {
	responderRequisicao(requisicao, resposta);
}).listen(7000);
