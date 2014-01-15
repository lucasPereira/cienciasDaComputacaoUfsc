package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoAtribuir implements Codigo {
	public CodigoAtribuir() {
		
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		Valor valor = maquina.pilhaDeDados.pop();
		Valor referencia = maquina.pilhaDeDados.pop();
		maquina.pilhaDeContextos.peek().atualizarSimbolo(referencia.fornecerNome(), valor);
		//maquina.pilhaDeDados.push(valor);
	}
	
	@Override
	public String comoTexto() {
		return String.format("atribuir");
	}
}
