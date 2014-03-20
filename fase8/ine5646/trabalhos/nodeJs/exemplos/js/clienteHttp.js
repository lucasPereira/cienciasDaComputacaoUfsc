var http = require('http');

var cabecalhos = {
	'hostname': 'localhost',
	'port': 7000,
	'method': 'GET',
	'path': '/',
	'headers': {
		'Accept': 'text/plain',
		'User-Agent': 'Node JS'
	}
};

var requisicao = http.request(cabecalhos, function (resposta) {
	resposta.setEncoding('utf-8');
	console.log('[Node] Código de estado: ' + resposta.statusCode);
	console.log('[Node] Cabeçalhos: ' + JSON.stringify(resposta.headers));
	console.log('[Node] Resposta: ');
	resposta.on('data', function (dado) {
		console.log(dado);
	});
});
// Permite enviar dados na requisição.
// requisicao.wirte('data');
requisicao.end();
