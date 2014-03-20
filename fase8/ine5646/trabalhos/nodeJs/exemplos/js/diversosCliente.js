var http = require('http');

var cabecalhos = {
	'hostname': 'localhost',
	'port': 7000,
	'method': 'GET',
	'path': '/',
};

setInterval(function () {
	http.request(cabecalhos, function (resposta) {
		resposta.setEncoding('utf-8')
		resposta.on('data', function (dado) {
			console.log(dado);
		});
	}).end();
}, 3500);
