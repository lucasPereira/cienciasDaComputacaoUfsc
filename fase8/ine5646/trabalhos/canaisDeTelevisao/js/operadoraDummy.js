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
		"pacotes":[
			{ "canais": [4, 6, 14, 10, 17, 42, 5, 3, 1], "preco": 66 },
			{ "canais": [4, 6, 13, 10, 17, 42, 5, 3, 1], "preco": 65 },
			{ "canais": [4, 6, 47, 10, 17, 42, 5, 3, 1], "preco": 67 },
			{ "canais": [4, 6, 13, 14, 17, 42, 5, 3, 1], "preco": 67 },
			{ "canais": [4, 6, 47, 14, 17, 42, 5, 3, 1], "preco": 69 },
			{ "canais": [4, 6, 47, 13, 17, 42, 5, 3, 1], "preco": 68 },
			{ "canais": [4, 6, 13, 10, 07, 42, 5, 3, 1], "preco": 80 },
			{ "canais": [4, 6, 14, 10, 48, 42, 5, 3, 1], "preco": 74 },
			{ "canais": [4, 6, 13, 10, 48, 42, 5, 3, 1], "preco": 73 },
			{ "canais": [4, 6, 47, 10, 48, 42, 5, 3, 1], "preco": 75 },
			{ "canais": [4, 6, 13, 14, 48, 42, 5, 3, 1], "preco": 75 },
			{ "canais": [4, 6, 47, 14, 48, 42, 5, 3, 1], "preco": 77 },
			{ "canais": [4, 6, 47, 13, 48, 42, 5, 3, 1], "preco": 76 },
			{ "canais": [4, 6, 14, 10, 18, 42, 5, 3, 1], "preco": 67 },
			{ "canais": [4, 6, 13, 10, 18, 42, 5, 3, 1], "preco": 66 },
			{ "canais": [4, 6, 47, 10, 18, 42, 5, 3, 1], "preco": 68 },
			{ "canais": [4, 6, 13, 14, 18, 42, 5, 3, 1], "preco": 68 },
			{ "canais": [4, 6, 47, 14, 18, 42, 5, 3, 1], "preco": 70 },
			{ "canais": [4, 6, 47, 13, 18, 42, 5, 3, 1], "preco": 69 },
			{ "canais": [4, 6, 14, 10, 17, 41, 5, 3, 1], "preco": 69 },
			{ "canais": [4, 6, 13, 10, 17, 41, 5, 3, 1], "preco": 68 },
			{ "canais": [4, 6, 47, 10, 17, 41, 5, 3, 1], "preco": 70 },
			{ "canais": [4, 6, 13, 14, 17, 41, 5, 3, 1], "preco": 70 },
			{ "canais": [4, 6, 47, 14, 17, 41, 5, 3, 1], "preco": 72 },
			{ "canais": [4, 6, 47, 13, 17, 41, 5, 3, 1], "preco": 71 },
			{ "canais": [4, 6, 14, 10, 48, 41, 5, 3, 1], "preco": 77 },
			{ "canais": [4, 6, 13, 10, 48, 41, 5, 3, 1], "preco": 76 },
			{ "canais": [4, 6, 47, 10, 48, 41, 5, 3, 1], "preco": 78 },
			{ "canais": [4, 6, 13, 14, 48, 41, 5, 3, 1], "preco": 78 },
			{ "canais": [4, 6, 47, 14, 48, 41, 5, 3, 1], "preco": 80 },
			{ "canais": [4, 6, 47, 13, 48, 41, 5, 3, 1], "preco": 79 },
			{ "canais": [4, 6, 14, 10, 18, 41, 5, 3, 1], "preco": 70 },
			{ "canais": [4, 6, 13, 10, 18, 41, 5, 3, 1], "preco": 69 },
			{ "canais": [4, 6, 47, 10, 18, 41, 5, 3, 1], "preco": 71 },
			{ "canais": [4, 6, 13, 14, 18, 41, 5, 3, 1], "preco": 71 },
			{ "canais": [4, 6, 47, 14, 18, 41, 5, 3, 1], "preco": 73 },
			{ "canais": [4, 6, 47, 13, 18, 41, 5, 3, 1], "preco": 72 },
			{ "canais": [4, 6, 14, 10, 17, 49, 5, 3, 1], "preco": 70 },
			{ "canais": [4, 6, 13, 10, 17, 49, 5, 3, 1], "preco": 69 },
			{ "canais": [4, 6, 47, 10, 17, 49, 5, 3, 1], "preco": 71 },
			{ "canais": [4, 6, 13, 14, 17, 49, 5, 3, 1], "preco": 71 },
			{ "canais": [4, 6, 47, 14, 17, 49, 5, 3, 1], "preco": 73 },
			{ "canais": [4, 6, 47, 13, 17, 49, 5, 3, 1], "preco": 72 },
			{ "canais": [4, 6, 14, 10, 48, 49, 5, 3, 1], "preco": 78 },
			{ "canais": [4, 6, 13, 10, 48, 49, 5, 3, 1], "preco": 77 },
			{ "canais": [4, 6, 47, 10, 48, 49, 5, 3, 1], "preco": 79 },
			{ "canais": [4, 6, 13, 14, 48, 49, 5, 3, 1], "preco": 79 },
			{ "canais": [4, 6, 47, 13, 48, 49, 5, 3, 1], "preco": 80 },
			{ "canais": [4, 6, 14, 10, 18, 49, 5, 3, 1], "preco": 71 },
			{ "canais": [4, 6, 13, 10, 18, 49, 5, 3, 1], "preco": 70 },
			{ "canais": [4, 6, 47, 10, 18, 49, 5, 3, 1], "preco": 72 },
			{ "canais": [4, 6, 13, 14, 18, 49, 5, 3, 1], "preco": 72 },
			{ "canais": [4, 6, 47, 14, 18, 49, 5, 3, 1], "preco": 74 },
			{ "canais": [4, 6, 47, 13, 18, 49, 5, 3, 1], "preco": 73 }
		]
	};
}

function fornecerNome() {
	return {
		"nome": "Operadora Dummy NodeJS"
	};
}

servidor.listen(7001);