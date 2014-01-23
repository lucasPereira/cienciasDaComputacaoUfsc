public final class CelulaExterna extends CelulaAbstrata {
	public CelulaExterna(MundoWumpus mundoWumpus, Integer linha, Integer coluna) {
		super(mundoWumpus, linha, coluna);
	}

	@Override
	public TipoDeCelula fornecerTipoDeCelula() {
		return TipoDeCelula.EXTERNA;
	}

	@Override
	public void receberAgente(Agente agente) {
		agente.perceberBatida();
	}
}
