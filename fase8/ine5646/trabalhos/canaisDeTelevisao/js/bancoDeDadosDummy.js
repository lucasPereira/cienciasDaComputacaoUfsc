var http = require("http");
var url = require("url");

var servidor = http.createServer(function (requisicao, resposta) {
	var uri = url.parse(requisicao.url);
	var respostaJson = null;
	var caminho = uri.path
	if (caminho === "/generos") {
		respostaJson = fornecerGeneros();
	} else if (caminho === "/canais") {
		respostaJson = fornecerCanais();
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

function fornecerGeneros() {
	return {
		"generos": [
			"Noticia",
			"Filme",
			"Esportivo",
			"Infantil",
			"Documentario",
			"Variedade",
			"Aberto"
		]
	};
}

function fornecerCanais() {
	return {
		"canais": [
			{ "id": 05, "nome": "Disney", "genero": "Infantil" },
			{ "id": 10, "nome": "TNT", "genero": "Filme" },
			{ "id": 42, "nome": "SporTV3", "genero": "Esportivo" },
			{ "id": 24, "nome": "TLC", "genero": "Variedade" },
			{ "id": 37, "nome": "Off", "genero": "Variedade" },
			{ "id": 25, "nome": "History", "genero": "Documentario" },
			{ "id": 14, "nome": "TCM", "genero": "Filme" },
			{ "id": 20, "nome": "ESPN", "genero": "Esportivo" },
			{ "id": 46, "nome": "RecordNews", "genero": "Noticia" },
			{ "id": 29, "nome": "FX", "genero": "Filme" },
			{ "id": 01, "nome": "Fox", "genero": "Variedade" },
			{ "id": 06, "nome": "Gloob", "genero": "Infantil" },
			{ "id": 28, "nome": "WB", "genero": "Filme" },
			{ "id": 38, "nome": "Arte1", "genero": "Variedade" },
			{ "id": 21, "nome": "SporTV", "genero": "Esportivo" },
			{ "id": 33, "nome": "SyFy", "genero": "Variedade" },
			{ "id": 09, "nome": "GNT", "genero": "Variedade" },
			{ "id": 13, "nome": "HBO", "genero": "Filme" },
			{ "id": 41, "nome": "SporTV2", "genero": "Esportivo" },
			{ "id": 02, "nome": "Animal Plane t","gener o":"Documentario" },
			{ "id": 32, "nome": "Boomerang", "genero": "Infantil" },
			{ "id": 34, "nome": "DisneyJúnior", "genero": "Infantil" },
			{ "id": 45, "nome": "BBC", "genero": "Noticia" },
			{ "id": 17, "nome": "Band", "genero": "Aberto" },
			{ "id": 22, "nome": "ESPNBrasil", "genero": "Esportivo" },
			{ "id": 44, "nome": "DiscoveryCivilisation", "genero": "Documentario" },
			{ "id": 27, "nome": "Space", "genero": "Filme" },
			{ "id": 12, "nome": "NatGeo", "genero": "Documentario" },
			{ "id": 49, "nome": "FoxSports", "genero": "Esportivo" },
			{ "id": 07, "nome": "Futura", "genero": "Aberto" },
			{ "id": 39, "nome": "BemSimples", "genero": "Variedade" },
			{ "id": 03, "nome": "Cartoon", "genero": "Infantil" },
			{ "id": 35, "nome": "Viva", "genero": "Variedade" },
			{ "id": 48, "nome": "TVSenado", "genero": "Aberto" },
			{ "id": 18, "nome": "Globo", "genero": "Aberto" },
			{ "id": 50, "nome": "E!", "genero": "Variedade" },
			{ "id": 16, "nome": "BandNews", "genero": "Noticia" },
			{ "id": 31, "nome": "Max", "genero": "Filme" },
			{ "id": 11, "nome": "CNN", "genero": "Noticia" },
			{ "id": 43, "nome": "DiscoveryScience", "genero": "Documentario" },
			{ "id": 40, "nome": "A& E","gener o":"Variedade" },
			{ "id": 26, "nome": "AXN", "genero": "Filme" },
			{ "id": 23, "nome": "Cultura", "genero": "Aberto" },
			{ "id": 08, "nome": "GloboNews", "genero": "Noticia" },
			{ "id": 36, "nome": "Multishow", "genero": "Variedade" },
			{ "id": 30, "nome": "Universal", "genero": "Filme" },
			{ "id": 19, "nome": "Record", "genero": "Aberto" },
			{ "id": 04, "nome": "Nick", "genero": "Infantil" },
			{ "id": 47, "nome": "MGM", "genero": "Filme" },
			{ "id": 15, "nome": "Discovery", "genero": "Documentario"}
		]
	};
}

servidor.listen(7003);
