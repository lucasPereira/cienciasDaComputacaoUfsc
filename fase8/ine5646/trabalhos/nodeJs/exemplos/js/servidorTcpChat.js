var tcp = require("net");
var conexoes = [];

var servidor = tcp.createServer(function (socket) {
	conexoes.push(socket);
	socket.on('data', receberMensagem);
});
servidor.listen(7000);
console.log('[Node] Servidor TCP rodando na porta 7000.');

function receberMensagem(mensagem) {
	conexoes.forEach(function (conexao) {
		conexao.write(new Date().toLocaleTimeString());
		conexao.write(': ');
		conexao.write(mensagem)
	});
}
