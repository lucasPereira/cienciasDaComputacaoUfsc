var tcp = require("net");
var conexoes = [];

var servidor = tcp.createServer(function (socket) {
	conexoes.push(socket);

	socket.on('data', function receberMensagem(mensagem) {
		conexoes.forEach(function (conexao) {
			conexao.write(new Date().toLocaleTimeString());
			conexao.write(': ');
			conexao.write(mensagem)
		});
	});

	socket.on('close', function () {
		var indice = conexoes.indexOf(socket);
		conexoes.splice(indice, 1);
	});
});
servidor.listen(7000);
console.log('[Node] Servidor TCP rodando na porta 7000.');
