READ 0 //Número de notas
STORECONST 0 1 //Soma das Notas
LOAD 0
STORE 2 //Váriavel de Decremento 
STORECONST 1 3 //Decrementar 1
JUMP 3 6
READ 4 //Inseri Nota
ADD 1 4
STORE 1
SUB 2 3
STORE 2
JUMP 2 -5
JUMP 3 4 //Serve para caso não inserir nenhuma nota não dividir,pois asism não divide por 0
DIV 1 0
STORE 5
WRITE 5
JUMP 2 -3 //Serve para caso não inserir nenhuma nota não dividir,pois asism não divide por 0
