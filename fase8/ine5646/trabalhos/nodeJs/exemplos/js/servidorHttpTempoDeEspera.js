var http = require('http');

var servidor = http.createServer(function (requisicao, resposta) {
	resposta.writeHeader(200, { 'Content-Type': 'text/plain' });
	resposta.write('Resposta enviada por Servidor HTTP...');
	setTimeout(function () {
		resposta.end('...rodando através do Node JS.');
	}, 3000);
});

servidor.listen(7000);
console.log('[Node] Servidor HTTP rodando na porta 7000.');
