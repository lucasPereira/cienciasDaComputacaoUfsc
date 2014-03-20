var tcp = require('net');

var servidor = tcp.createServer(function (socket) {
	socket.write('Mensagem enviada pelo servidor TCP executabdo através do Node JS.\n');
	socket.on('data', function (dados) {
		socket.write('Eco: ' + dados);
	});
});
servidor.listen(7000);
console.log('[Node] Servidor TCP rodando na porta 7000.');
