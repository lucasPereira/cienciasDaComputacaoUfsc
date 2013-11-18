package br.ufsc.computacaoDistribuida.isis;

public interface DifusaoConfiavel {
	
	public void enviarMensagem(Mensagem mensagem);
	
	public void receberMensagem(Mensagem mensagem);
}
