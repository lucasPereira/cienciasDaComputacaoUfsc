package br.ufsc.inf.ine5426.caneca.maquina;

public final class CodigoChamar implements Codigo {
	private String nomeDoProcedimento;
	private Integer pontoDeRetorno;
	
	public CodigoChamar(String nomeDoProcedimento, Integer pontoDeRetorno) {
		this.nomeDoProcedimento = nomeDoProcedimento;
		this.pontoDeRetorno = pontoDeRetorno;
	}
	
	@Override
	public void executar(MaquinaCaneca maquina) {
		maquina.pilhaDeExecucao.push(pontoDeRetorno);
		maquina.contadorDePrograma = maquina.pilhaDeContextos.peek().resolverPontoDeEntrada(nomeDoProcedimento);
	}
	
	@Override
	public String comoTexto() {
		return String.format("chamar %s %s", nomeDoProcedimento, pontoDeRetorno);
	}
}
