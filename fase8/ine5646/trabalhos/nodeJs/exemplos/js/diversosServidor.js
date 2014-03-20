var http = require('http');

var cabecalhos = { 
	'host': 'google.com.br',
	'method': 'GET',
	'path': '/'
};

setInterval(function () {
	http.request(cabecalhos, function (resposta) {
		console.log('*** Tarefa [2] do servidor *** ' + resposta.headers.date + ' ***');
	}).end();
}, 5000);

setInterval(function () {
	var numero = Math.random();
	console.log('*** Tarefa [1] do servidor *** ' + numero + ' ***');
}, 8000);

http.createServer(function (requisicao, resposta) {
	resposta.writeHeader(200, { 'Content-Type': 'text/plain' });
	resposta.end('Resposta enviada por Servidor HTTP rodando através do Node JS.');
	console.log('*** Tarefa [3] do servidor *** ' + 'respondendo requisição HTTP ' + ' ***');
}).listen(7000);
