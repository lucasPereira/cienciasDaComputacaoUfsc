package br.ufsc.inf.ine5426.caneca.interno;

import br.ufsc.inf.ine5426.caneca.maquina.Valor;
import br.ufsc.inf.ine5426.caneca.maquina.ValorBooleano;
import br.ufsc.inf.ine5426.caneca.maquina.ValorCaractere;
import br.ufsc.inf.ine5426.caneca.maquina.ValorInteiro;
import br.ufsc.inf.ine5426.caneca.maquina.ValorNulo;
import br.ufsc.inf.ine5426.caneca.maquina.ValorReal;
import br.ufsc.inf.ine5426.caneca.maquina.ValorTexto;

public final class Tipo {
	public static final Tipo INTEIRO = new Tipo("Inteiro");
	public static final Tipo REAL = new Tipo("Real");
	public static final Tipo BOOLEANO = new Tipo("Booleano");
	public static final Tipo CARACTERE = new Tipo("Caractere");
	public static final Tipo TEXTO = new Tipo("Texto");
	public static final Tipo OBJETO = new Tipo("Objeto");
	public static final Tipo NADA = new Tipo("Nada");
	private String nomeDaClasse;
	
	public Tipo(String nomeDaClasse) {
		this.nomeDaClasse = nomeDaClasse;
	}
	
	public boolean mesmoQue(Tipo outroTipo) {
		return nomeDaClasse.equals(outroTipo.nomeDaClasse);
	}
	
	public boolean mesmoQueIndireto(Tipo outroTipo) {
		return mesmoQue(outroTipo);
	}
	
	public String comoTexto() {
		return nomeDaClasse;
	}
	
	public Valor fornecerValorPadrao() {
		if (this.mesmoQue(INTEIRO)) {
			return ValorInteiro.PADRAO;
		} else if (this.mesmoQue(REAL)) {
			return ValorReal.PADRAO;
		} else if (this.mesmoQue(BOOLEANO)) {
			return ValorBooleano.PADRAO;
		} else if (this.mesmoQue(CARACTERE)) {
			return ValorCaractere.PADRAO;
		} else if (this.mesmoQue(TEXTO)) {
			return ValorTexto.PADRAO;
		} 
		return ValorNulo.PADRAO;
	}
	
	public String fornecerNomeDaClasse() {
		return nomeDaClasse;
	}
}
