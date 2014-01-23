temFlecha.

!iniciar.

+!iniciar <-
	!encontrar(ouro);
	!pegar(ouro);
	!sair(caverna);
	!finalizar.

+!encontrar(ouro) :
	not vivo.

+!encontrar(ouro) :
	vivo &
	brilho <-
	.print("Encontrei ouro, estou rico!").

+!encontrar(ouro) :
	vivo &
	not brilho &
	cheiro &
	temFlecha <-
	.print("Senti um cheiro do Wumpus. Estratégia: atirar e seguir em frente mesmo que eu não ouça o grito do Wumpus. Se o Wumpus estiver na minha direção ele vai morrer. Se não estiver, então estarei indo em direção a um local seguro.");
	atirar;
	-temFlecha;
	!encontrar(ouro).

+!encontrar(ouro) :
	vivo &
	not brilho <-
	?posicao(Px, Py);
	?direcao(Dx, Dy);
	!atualizarPercepcoes(Px, Py, Dx, Dy);
	.print("Estou a procura do ouro. Irei analisar os meus destinos possíveis e ver o que eu faço.");
	!explorar;
	!encontrar(ouro).

+!explorar :
	(destino(possivel) & not destino(visitado) & not destino(possivelBuraco)) <-
	.print("O meu destino é possível, não visitado e sem possível buraco. Seguirei em frente.");
	andar.

+!explorar :
	(destino(possivel) & not destino(visitado) & destino(possivelBuraco)) &
	existeDestinoProximoPossivelNaoVisitadoSemPossivelBuraco <-
	.print("O meu destino é possível, não visitado, mas tem um possível buraco. De acordo com os caminhos que já passei, me recordo que existe um destino próximo possível, não visitado e sem possível buraco. Vou procurar esse destino que está a minha volta.");
	virar(aleatorio).

+!explorar :
	(destino(possivel) & not destino(visitado) & destino(possivelBuraco)) &
	not existeDestinoProximoPossivelNaoVisitadoSemPossivelBuraco &
	existeDestinoPossivelNaoVisitadoSemPossivelBuraco <-
	.print("O meu destino é possível, não visitado, mas tem um possível buraco. De acordo com os caminhos que já passei, me recordo que existe um destino possível, não visitado e sem possível buraco, mas esse destino não está próximo de mim. Vou ver em volta e procurar um destino que já passei e seguir por ele para ver se acho esse destino possível, não visitado e sem possível buraco.");
	virar(aleatorio).

+!explorar :
	(destino(possivel) & not destino(visitado) & destino(possivelBuraco)) &
	not existeDestinoProximoPossivelNaoVisitadoSemPossivelBuraco &
	not existeDestinoPossivelNaoVisitadoSemPossivelBuraco <-
	.print("O meu destino é possível, não visitado, mas tem um possível buraco. De acordo com os caminhos que já passei, não me recordo que exista um destino possível, não visitado e sem possível buraco. A única coisa que posso fazer é seguir em frente e torcer para que não tenha buraco.");
	andar.

+!explorar :
	(destino(possivel) & destino(visitado) & not destino(possivelBuraco)) &
	existeDestinoProximoPossivelNaoVisitadoSemPossivelBuraco <-
	.print("O meu destino já foi visitado. Eu estou a procura de um destino possível, visitado e sem possível buraco. Eu sei que existe um destino assim a minha volta. Vou virar até encontrar esse destino desejado.");
	virar(aleatorio).

+!explorar :
	(destino(possivel) & destino(visitado) & not destino(possivelBuraco)) &
	not existeDestinoProximoPossivelNaoVisitadoSemPossivelBuraco &
	existeDestinoPossivelNaoVisitadoSemPossivelBuraco <-
	.print("O meu destino já foi visitado. Eu estou a procura de um destino possível, visitado e sem possível buraco. Eu sei que existe um destino assim em algum lugar, mas esse destino desejado não está a minha volta. Vou seguir em frente e procurar pelo meu destino desejado.");
	andar.

+!explorar :
	(destino(possivel) & destino(visitado) & not destino(possivelBuraco)) &
	not existeDestinoProximoPossivelNaoVisitadoSemPossivelBuraco &
	not existeDestinoPossivelNaoVisitadoSemPossivelBuraco &
	existeDestinoProximoPossivelNaoVisitado <-
	.print("O meu destino já foi visitado. Eu estou a procura de um destino possível, visitado e sem possível buraco. Porém, infelizmente eu sei que não existe um destino assim em nenhum lugar. Entretanto, existe a minha volta um destino possível que eu ainda não visitei vou virar até encontrar esse destino.");
	virar(aleatorio).

+!explorar :
	(destino(possivel) & destino(visitado) & not destino(possivelBuraco)) &
	not existeDestinoProximoPossivelNaoVisitadoSemPossivelBuraco &
	not existeDestinoPossivelNaoVisitadoSemPossivelBuraco &
	not existeDestinoProximoPossivelNaoVisitado <-
	.print("O meu destino já foi visitado. Eu estou a procura de um destino possível, visitado e sem possível buraco. Porém, infelizmente eu sei que não existe um destino assim em nenhum lugar. Entretanto, existe em algum lugar um destino possível que eu ainda não visitei. Vou seguir em frente e procurar por esse destino possível que eu ainda não visitei (sei que ele não está a minha volta).");
	andar.

+!explorar :
	(destino(possivel) & destino(visitado) & destino(possivelBuraco)) <-
	.print("Estado inconsistente. Se eu estou nesse estado, é porque os meus programadores fizeram alguma coisa errada :-)").

+!explorar :
	not destino(possivel) <-
	.print("Estou virado para a parede. Vou virar até encontrar um destino que não seja parede.");
	virar(aleatorio).

+!pegar(ouro) :
	not vivo.

+!pegar(ouro) :
	vivo <-
	pegar(ouro);
	.print("Peguei o ouro. Agora vou tratar de fugir dessa caverna. Vou andar apenas pelos caminhos que já visitei para não correr o riso de morrer.").

+!sair(caverna) :
	not vivo.

+!sair(caverna) :
	vivo &
	posicao(0, 0) <-
	sair.

+!sair(caverna) :
	vivo &
	not posicao(0, 0) <-
	?posicao(Px, Py);
	?direcao(Dx, Dy);
	!atualizarPercepcoes(Px, Py, Dx, Dy);
	.print("Estou a procura da saída. Irei analisar os meus destinos possíveis e ver o que eu faço. Por precaução passarei apenas pelos locais que já visitei.");
	!procurar(saida);
	!sair(caverna).

+!procurar(saida) :
	(destino(possivel) & destino(visitado)) <-
	.print("Eu já passei pelo meu destino, vou seguir em frente e ver se acho a saída.");
	andar.

+!procurar(saida) :
	not destino(possivel) <-
	.print("Estou virado para a parede. Vou virar até ver um destino possível.");
	virar(aleatorio).

+!procurar(saida) :
	not destino(visitado) <-
	.print("Estou virado para um destino não visitado. Vou virar até encontrar um destino que já visitei.");
	virar(aleatorio).

+!finalizar :
	not vivo <-
	.print("Ops, fui morto :-(").

+!finalizar :
	vivo <-
	.print("Finalmente achei a saída dessa caverna. Além disso, trago comigo esta grande pepita de ouro.").

+!atualizarPercepcoes(Px, Py, Dx, Dy) <-
	!atualizarPercepcoesDePosicao(Px, Py);
	!atualizarPercepcoesDeDestino(Px, Py, Dx, Dy).

+!atualizarPercepcoesDePosicao(X, Y) <-
	+posicaoVisitada(X, Y);
	!verificarPossivelBuraco(X, Y+1);
	!verificarPossivelBuraco(X, Y-1);
	!verificarPossivelBuraco(X+1, Y);
	!verificarPossivelBuraco(X-1, Y);
	!verificarPosicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y);
	!verificarPosicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y+1);
	!verificarPosicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y-1);
	!verificarPosicaoPossivelNaoVisitadaSemPossivelBuraco(X+1, Y);
	!verificarPosicaoPossivelNaoVisitadaSemPossivelBuraco(X-1, Y);
	!verificarPosicaoPossivelNaoVisitada(X, Y);
	!verificarPosicaoPossivelNaoVisitada(X, Y+1);
	!verificarPosicaoPossivelNaoVisitada(X, Y-1);
	!verificarPosicaoPossivelNaoVisitada(X+1, Y);
	!verificarPosicaoPossivelNaoVisitada(X-1, Y).

+!atualizarPercepcoesDeDestino(Px, Py, Dx, Dy) <-
	!verificarExistenciaDeDestinoPossivelNaoVisitadoSemPossivelBuraco;
	!verificarExistenciaDeDestinoProximoPossivelNaoVisitadoSemPossivelBuraco(Px, Py);
	!verificarExistenciaDeDestinoProximoPossivelNaoVisitado(Px, Py);
	!verificarDestinoPossivel(Dx, Dy);
	!verificarDestinoVisitado(Dx, Dy);
	!verificarDestinoPossivelBuraco(Dx, Dy).

+!verificarPossivelBuraco(X, Y) :
	not posicaoVisitada(X, Y) &
	(brisa(X, Y+1) | brisa (X, Y-1) | brisa(X+1, Y) | brisa(X-1, Y)) &
	(not posicaoVisitada(X, Y+1) | brisa(X, Y+1)) &
	(not posicaoVisitada(X, Y-1) | brisa(X, Y-1)) &
	(not posicaoVisitada(X+1, Y) | brisa(X+1, Y)) &
	(not posicaoVisitada(X-1, Y) | brisa(X-1, Y)) <-
	+posicaoPossivelBuraco(X, Y).

+!verificarPossivelBuraco(X, Y) :
	posicaoVisitada(X, Y) |
	(not brisa(X, Y+1) & not brisa (X, Y-1) & not brisa(X+1, Y) & not brisa(X-1, Y)) | 
	(posicaoVisitada(X, Y+1) & not brisa(X, Y+1)) |
	(posicaoVisitada(X, Y-1) & not brisa(X, Y-1)) |
	(posicaoVisitada(X+1, Y) & not brisa(X+1, Y)) |
	(posicaoVisitada(X-1, Y) & not brisa(X-1, Y)) <-
	-posicaoPossivelBuraco(X, Y).

+!verificarPosicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y) :
	(not parede(X, Y) & not posicaoVisitada(X, Y) & not posicaoPossivelBuraco(X, Y)) <-
	+posicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y).

+!verificarPosicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y) :
	(parede(X, Y) | posicaoVisitada(X, Y) | posicaoPossivelBuraco(X, Y)) <-
	-posicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y).

+!verificarPosicaoPossivelNaoVisitada(X, Y) :
	(not parede(X, Y) & not posicaoVisitada(X, Y)) <-
	+posicaoPossivelNaoVisitada(X, Y).

+!verificarPosicaoPossivelNaoVisitada(X, Y) :
	(parede(X, Y) | posicaoVisitada(X, Y)) <-
	-posicaoPossivelNaoVisitada(X, Y).

+!verificarDestinoPossivel(X, Y) :
	not parede(X, Y) <-
	+destino(possivel).

+!verificarDestinoPossivel(X, Y) :
	parede(X, Y) <-
	-destino(possivel).

+!verificarDestinoVisitado(X, Y) :
	posicaoVisitada(X, Y) <-
	+destino(visitado).

+!verificarDestinoVisitado(X, Y) :
	not posicaoVisitada(X, Y) <-
	-destino(visitado).

+!verificarDestinoPossivelBuraco(X, Y) :
	posicaoPossivelBuraco(X, Y) <-
	+destino(possivelBuraco).

+!verificarDestinoPossivelBuraco(X, Y) :
	not posicaoPossivelBuraco(X, Y) <-
	-destino(possivelBuraco).

+!verificarExistenciaDeDestinoPossivelNaoVisitadoSemPossivelBuraco :
	posicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y) <-
	+existeDestinoPossivelNaoVisitadoSemPossivelBuraco.

+!verificarExistenciaDeDestinoPossivelNaoVisitadoSemPossivelBuraco :
	not posicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y) <-
	-existeDestinoPossivelNaoVisitadoSemPossivelBuraco.

+!verificarExistenciaDeDestinoProximoPossivelNaoVisitadoSemPossivelBuraco(X, Y) :
	posicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y+1) |
	posicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y-1) |
	posicaoPossivelNaoVisitadaSemPossivelBuraco(X+1, Y) |
	posicaoPossivelNaoVisitadaSemPossivelBuraco(X-1, Y) <-
	+existeDestinoProximoPossivelNaoVisitadoSemPossivelBuraco.

+!verificarExistenciaDeDestinoProximoPossivelNaoVisitadoSemPossivelBuraco(X, Y) :
	not posicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y+1) &
	not posicaoPossivelNaoVisitadaSemPossivelBuraco(X, Y-1) &
	not posicaoPossivelNaoVisitadaSemPossivelBuraco(X+1, Y) &
	not posicaoPossivelNaoVisitadaSemPossivelBuraco(X-1, Y) <-
	-existeDestinoProximoPossivelNaoVisitadoSemPossivelBuraco.

+!verificarExistenciaDeDestinoProximoPossivelNaoVisitado(X, Y) :
	posicaoPossivelNaoVisitada(X, Y+1) |
	posicaoPossivelNaoVisitada(X, Y-1) |
	posicaoPossivelNaoVisitada(X+1, Y) |
	posicaoPossivelNaoVisitada(X-1, Y) <-
	+existeDestinoProximoPossivelNaoVisitado.

+!verificarExistenciaDeDestinoProximoPossivelNaoVisitado(X, Y) :
	not posicaoPossivelNaoVisitada(X, Y+1) &
	not posicaoPossivelNaoVisitada(X, Y-1) &
	not posicaoPossivelNaoVisitada(X+1, Y) &
	not posicaoPossivelNaoVisitada(X-1, Y) <-
	-existeDestinoProximoPossivelNaoVisitado.
