public abstract class PosicionavelAbstrato implements Posicionavel {
	@Override
	public void perceberAgente(Agente agente, Celula celula) {
		
	}

	protected final Boolean agenteEstaProximo(Agente agente, Celula celulaDoAgente, Celula celula) {
		return celulaDoAgente.aoNorteDe(celula) ||
			celulaDoAgente.aoSulDe(celula) ||
			celulaDoAgente.aoLesteDe(celula) ||
			celulaDoAgente.aoOesteDe(celula);
	}

	protected final Boolean agenteEstaProximoOuNoMesmoLocal(Agente agente, Celula celulaDoAgente, Celula celula) {
		return (agenteEstaProximo(agente, celulaDoAgente, celula) || agenteEstaNoMesmoLocal(celulaDoAgente,celula));
	}

	protected final Boolean agenteEstaNoMesmoLocal(Celula celulaDoAgente, Celula celula) {
		return celulaDoAgente.mesmoLocal(celula);
	}

	@Override
	public boolean equals(Object outro) {
		if (outro instanceof Posicionavel) {
			TipoDePosicionavel meuTipo = fornecerTipoDePosicionavel();
			TipoDePosicionavel tipoDoOutro = ((Posicionavel) outro).fornecerTipoDePosicionavel();
			return tipoDoOutro.equals(meuTipo);
		}
		return false;
	}
}
