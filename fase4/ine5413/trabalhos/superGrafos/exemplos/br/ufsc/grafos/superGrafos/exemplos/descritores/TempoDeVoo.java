package br.ufsc.grafos.superGrafos.exemplos.descritores;

import br.ufsc.grafos.superGrafos.propriedadesDeElementos.Igualavel;

public class TempoDeVoo implements Igualavel<TempoDeVoo> {
	
	private int tempoDeVoo;
	
	public TempoDeVoo(int tempoEsperadoDeVoo) {
		this.tempoDeVoo = tempoEsperadoDeVoo;
	}
	
	@Override
	public boolean éIgual(TempoDeVoo outro) {
		return (tempoDeVoo == outro.tempoDeVoo);
	}
	
	@Override
	public String toString() {
		return tempoDeVoo+"";
	}
}