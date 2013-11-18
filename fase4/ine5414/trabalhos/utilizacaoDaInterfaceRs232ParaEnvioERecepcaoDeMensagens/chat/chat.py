# -*- coding: cp1252 -*-

from threading import Thread
from serial import Serial

class Sender(Thread):
    def __init__(self, porta):
        Thread.__init__(self)
        self.porta = porta

    def run(self):
        mensagem = ""
        while(mensagem != "fim\n"):
            mensagem = raw_input("digite a mensagem: ") + "\n"
            self.porta.write(mensagem)
        self.encerrar()

    def fechar(self):
        self.porta.close()
        print "Finalizando o chat."

class Receiver(Thread):
    def __init__(self, porta):
        Thread.__init__(self)
        self.porta = porta

    def run(self):
        mensagem = ""
        while(mensagem != "fim\n"):
            mensagem = porta.readline()
            print mensagem,
        self.encerrar()

    def fechar(self):
        self.porta.close()
        print "Finalizando o chat."

print "Chat 1.0 - RS232\n"
porta = Serial("\\\\.\\CNCA0")
envio = Sender(porta)
recepcao = Receiver(porta)
envio.start()
recepcao.start()
