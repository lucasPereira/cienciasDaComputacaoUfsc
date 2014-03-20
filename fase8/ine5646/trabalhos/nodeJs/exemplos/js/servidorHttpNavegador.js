var http = require('http');

var servidor = http.createServer(function (requisicao, resposta) {
	resposta.writeHeader(200, { 
		'Content-Type': 'text/html',
		'Server': 'Node JS'
	});
	resposta.write('<!DOCTYPE html>');
	resposta.write('<html>');
	resposta.write('<head><meta charset="utf-8" /></head>');
	resposta.write('<body>');
	resposta.write('<h1>Resposta enviada por servidor HTTP rodando através do Node JS</h1>');
	resposta.write('</body>');
	resposta.end('</html>');
});

servidor.listen(7000);
console.log('[Node] Servidor HTTP rodando na porta 7000.');
