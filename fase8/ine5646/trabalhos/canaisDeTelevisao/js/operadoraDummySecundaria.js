var http = require("http");
var url = require("url");

var servidor = http.createServer(function (requisicao, resposta) {
	var uri = url.parse(requisicao.url);
	var respostaJson = null;
	var caminho = uri.path;
	if (caminho === "/") {
		respostaJson = {};
	} else if (caminho === "/nome") {
		respostaJson = fornecerNome();
	} else if (caminho) {
		respostaJson = fornecerPacotes();
	}
	responder(resposta, respostaJson);
});

function responder(resposta, respostaJson) {
	if (respostaJson !== null) {
		resposta.writeHeader(200, {
			"Content-Type": "application/json",
			"Access-Control-Allow-Origin": "*"
		});
		resposta.end(JSON.stringify(respostaJson));
	} else {
		resposta.writeHeader(404, {
			"Access-Control-Allow-Origin": "*"
		});
		resposta.end();
	}
}

function fornecerPacotes() {
	return {
		"pacotes": null
	};
}

function fornecerNome() {
	return {
		"nome": "Operadora Dummy NodeJS Secundária"
	};
}

servidor.listen(7002);