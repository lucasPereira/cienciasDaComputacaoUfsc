var http = require('http');
var requisicoes = 0;

var servidor = http.createServer(function (requisicao, resposta) {
	resposta.writeHeader(200, { 'Content-Type': 'text/plain' });
	resposta.end('Resposta enviada por Servidor HTTP rodando através do Node JS.');
	requisicoes++;
});
servidor.listen(7000);

process.on('SIGINT', function () {
	console.log('');
	console.log('[Node] Servidor finalizado.');
	console.log('[Node] Total de requisições recebidas: ' + requisicoes + '.');
	process.exit(0);
});

console.log('[Node] Servidor HTTP rodando na porta 7000.');
